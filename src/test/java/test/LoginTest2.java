package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import page.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest2 extends BaseTest {
	
		@Test
		public void testValidLogin() {
			LoginPage loginPage = new LoginPage(driver);
			
			Log.info("Starting login test--");
			
			test = ExtentReportManager.createTest("Login Test");
			
			loginPage.enterUsername("admin@yourstore.com");
			loginPage.enterPassword("admin");
			
			
			
			loginPage.clicklogin();
			test.pass("click button successfully");
			
			System.out.println("Title of page" +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Just a moment...");
			
			Log.info("Login Test completed");
			
			test.pass("Login Successfully");
			
		}
		@Test
		public void testinValidLogin() {
			LoginPage loginPage = new LoginPage(driver);
			
			Log.info("Starting login test--");
			
			test = ExtentReportManager.createTest("Login Test invalid credential");
			
			loginPage.enterUsername("admin@yourstore.com");
			loginPage.enterPassword("admin");
			
			
			
			loginPage.clicklogin();
			test.pass("click button successfully");
			
			System.out.println("Title of page" +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Just a moment...1");
			
			Log.info("Login Test completed");
			
			test.pass("Login Successfully");
			
		}
}
