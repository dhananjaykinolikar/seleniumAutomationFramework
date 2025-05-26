package test;

import org.testng.annotations.Test;

import base.BaseTest;
import page.LoginPage;

public class LoginTest extends BaseTest {
	
		@Test
		public void testValidLogin() {
			LoginPage loginPage = new LoginPage(driver);
			
			loginPage.enterUsername("admin@yourstore.com");
			loginPage.enterPassword("admin");
			loginPage.clicklogin();
			
			System.out.println("Title of page" +driver.getTitle());
			
		}
}
