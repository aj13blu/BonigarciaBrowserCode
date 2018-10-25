package bonigarciaBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import configuration.PropertiesFiles;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;


public class phantomJS 
{
	public static WebDriver driver;
	static PropertiesFiles Property = new PropertiesFiles();
	
	public static void main(String args[])
	{
		String browser = Property.getBrowser();
		if(browser.equalsIgnoreCase("headless"))
		{
		System.out.println(browser);
		
		//WebDriver driver = new PhantomJSDriver();
    	//PhantomJsDriverManager.phantomjs().setup();
    	PhantomJsDriverManager.getInstance().setup();
    	driver = new PhantomJSDriver();
    	driver.get("https://bitbucket.org/ariya/phantomjs/downloads/");
		
		
    	System.out.println("Executed");
		}
}

}
