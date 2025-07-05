package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.exceptions.BrowserExceptions;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(Properties prop)
	
	
	{
		String browserName=prop.getProperty("browser");
		switch(browserName.trim().toLowerCase()) {
		case "chrome" :
//			driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox" :
			tlDriver.set(new FirefoxDriver());
			break;	
		default:
			System.out.println("Pls pass correct browser");
			throw new BrowserExceptions("Invalid browser");
		}	
		
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties initProp() throws FileNotFoundException {
		prop=new Properties();
		FileInputStream ip=null;
		String env=System.getProperty("env");
		System.out.println("running on " + env);
		
		if(env==null)
		{
			 ip=new FileInputStream("./src/test/resources/config/config.properties");
		}
		else
		{
			switch(env.trim().toLowerCase())
			{
			case "qa" :
			 ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
			break;
			
			case "dev" :
			 ip=new FileInputStream("./src/test/resources/config/dev.config.properties");
			 break;
			 
			 default :
				 System.out.println("Pls pass right enviroenment");
			}
		}
		try {
			 ip=new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	

}
