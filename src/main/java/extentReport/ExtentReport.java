package extentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class ExtentReport 
{
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("C:\\Users\\ajinkya.bhobad\\Desktop\\ExtentReport\\Report.html");
	 
	logger=report.startTest("VerifyBlogTitle");
	 
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajinkya.bhobad\\Desktop\\jars\\chromedriver.exe");
	driver = new ChromeDriver();
	logger.log(LogStatus.INFO, "Browser started ");
	driver.manage().window().maximize();
	driver.get("http://www.learn-automation.com");
	logger.log(LogStatus.INFO, "Application is up and running");
	String title=driver.getTitle();
	Assert.assertTrue(title.contains("Google")); 
	logger.log(LogStatus.PASS, "Title verified");
	}
	 
	 
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException   
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	 
	//String screenshot_path=Utility.captureScreenshot(driver, result.getName());
	//String image= logger.addScreenCapture(screenshot_path);
	
	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\ajinkya.bhobad\\Desktop\\ExtentReport\\image.png"));
	//String image= logger.addScreenCapture(src);
	logger.log(LogStatus.FAIL, "Title verification");
	 
	 
	}
	 
	report.endTest(logger);
	report.flush();
	 
	driver.get("C:\\Users\\ajinkya.bhobad\\Desktop\\ExtentReport");
	}
	 
	 
	}
	
	/*@BeforeTest 
	public void startReport()
	{
		extent = new ExtentReports("C:\\Users\\ajinkya.bhobad\\Desktop\\ExtentReport",true);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial")
		      .addSystemInfo("Environment", "Automation Testing")
		      .addSystemInfo("User Name", "Rajkumar SM");
		extent.loadConfig(new File(System.getProperty("C:\\Users\\ajinkya.bhobad\\eclipse-workspace\\TestFramework\\extent-config.xml")));
		 
	}
	
	@Test
	public void passTest()
	{		
		 //Starting test
		 logger = extent.startTest("passTest");
		 Assert.assertTrue(true);
		 //To generate the log when the test case is passed
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	}
	
	@Test
	public void failTest()
	{
		 logger = extent.startTest("failTest");
		 Assert.assertTrue(false);
		 logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}
	
	@Test
	public void skipTest()
	{
		logger = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	 public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
		extent.endTest(logger);
	}
	
	@AfterTest 
	public void endReport()
	{
		 extent.flush();
		 extent.close();
	}
*/

