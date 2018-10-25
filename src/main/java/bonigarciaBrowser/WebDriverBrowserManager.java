package bonigarciaBrowser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import configuration.PropertiesFiles;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverBrowserManager 
{
	public static WebDriver driver;
	
	static PropertiesFiles Property = new PropertiesFiles();
	
	/*@BeforeClass
    public static void setupClass() {
        
    }*/

    @BeforeClass
    public static void setupTest() {
    	//ChromeDriverManager.getInstance().setup();
        //driver = new ChromeDriver();
    	
    	String browser = Property.getBrowser();
    	System.out.println(browser);
    	if(browser.equalsIgnoreCase("chrome")){
    		ChromeDriverManager.getInstance().setup();
    		driver = new ChromeDriver();
    		}
        else if(browser.equalsIgnoreCase("firefox")){
        	FirefoxDriverManager.getInstance().setup();
        	driver = new FirefoxDriver();
        	}
        else if(browser.equalsIgnoreCase("IE")){
        	InternetExplorerDriverManager.getInstance().setup();
        	driver = new InternetExplorerDriver();
        	}
        else if(browser.equalsIgnoreCase("safari")){
        	EdgeDriverManager.getInstance().setup();
        	driver = new EdgeDriver();
        	}
        else if(browser.equalsIgnoreCase("headless")){
        	//WebDriver driver = new PhantomJSDriver();
        	PhantomJsDriverManager.phantomjs().setup();
        	//PhantomJsDriverManager.getInstance().setup();
        	driver = new PhantomJSDriver();
        	
        	System.out.println("Executed");
        	}
    	
    	//Property.getBrowser();
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
    	driver.get(Property.getCrmUrl());
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[@id='rcmloginuser']")).sendKeys(Property.getUserName());
    	Thread.sleep(1000);
    	System.out.println("UserName");
    	driver.findElement(By.xpath("//input[@id='rcmloginpwd']")).sendKeys(Property.getPassword());
    	Thread.sleep(1000);
    	System.out.println("passWord");
    	driver.findElement(By.xpath("//input[@id='rcmloginsubmit']")).click(); 
    	Thread.sleep(1000);
    	System.out.println("Submit");
    	/*driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click(); 
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"_to\"]")).sendKeys("automation2018.QA@gmail.com");
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id='composebody']")).sendKeys("Test Automation Mail"); 
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id='compose-subject']")).sendKeys("Test Automation Mail"); 
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//*[@id=\"rcmbtn107\"]")).click();*/ 
    	
    }
}
