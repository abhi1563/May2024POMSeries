package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private By username=By.id("input-email");
	private By password=By.id("input-password");
	private By btnLogin=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getLoginPageTitle()
	{
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	@Step("Loggin in using email and password")
	public void doLogin(String user, String pass) {
	    driver.findElement(username).sendKeys("armit1563@gmail.com");
	    driver.findElement(password).sendKeys("admin1234");
	    driver.findElement(btnLogin).click();
	    
	}
	
	
}
