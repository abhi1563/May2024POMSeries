package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConst;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Epic("Epic 1: Test Abhi Automation")
@Feature("Feature is for Enrollement")
@Story("AN-120 Login Page Open cart")
public class LoginPageTest extends BaseTest {
	
	
	@Severity(SeverityLevel.MINOR)
	@Description("Login page Title verification")
	@Owner("Abhijeet Singh New")
	@Issue("AN-1235")
	
	@Test
	public void loginPageTestTitle()
	{
		String actTitle=lognpage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConst.LOGIN_PAGE_TITLE);
		
	}
}
