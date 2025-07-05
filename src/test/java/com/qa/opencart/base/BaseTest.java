package com.qa.opencart.base;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	Properties prop;
	public LoginPage lognpage;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		df=new DriverFactory();
		try {
			prop=df.initProp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(browserName!=null)
		{
			prop.setProperty("browser", browserName);
		}
		
		driver=df.initDriver(prop);
		lognpage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
