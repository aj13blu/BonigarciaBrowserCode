package configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.common.base.Strings;

public class PropertiesFiles {

	public Properties properties;
	public String propfile="C:\\Users\\ajinkya.bhobad\\eclipse-workspace\\TestFramework\\src\\main\\java\\configuration\\Configuration.properties";
	public WebDriver driver;
	
	 public PropertiesFiles() {
	        try {
	            InputStream inputStream;
	            inputStream = new FileInputStream(this.propfile);
	            //Load the input stream of the property file to the property object
				this.properties = new java.util.Properties();
				this.properties.load(inputStream);

	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	
	 public String getBrowser() {
	        String browser = System.getProperty("browser");
	        if(Strings.isNullOrEmpty(browser)) {
	            browser = properties.getProperty("browser");
	        }
	        return browser;
	    }
	 
	 public String getCrmUrl() {
	        return properties.getProperty("baseUrl");
	    }
	 
	 public String getUserName() {
	        return properties.getProperty("username");
	    }
	 
	 public String getPassword() {
	        return properties.getProperty("password");
	    }
	 
	
	
}
