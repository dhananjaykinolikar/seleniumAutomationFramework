package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;

import page.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@DataProvider(name="Logindata")
	public Object[][] getLoginData() throws IOException {
		String filepath = System.getProperty("user.dir")+"/Testdata\\testdata.xlsx";
		ExcelUtils.loadExcel(filepath, "Sheet1");
		int rowcount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowcount-1][2];
		
		for(int i=1; i<rowcount; i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0); //username
			data[i-1][1] = ExcelUtils.getCellData(i, 1); //password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	@DataProvider(name="Logindata2")
	public Object[][] getData() {
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"admin@yourstore.com","admin"}
		};
	}
	
	
	
	
		//@Test(dataProvider ="Logindata2")
	@Test
	//@Parameters({"username","password"})
	
	//public void testValidLogin(String username, String password) {
			public void testValidLogin() {
			test = ExtentReportManager.createTest("Login Test - ");
			test.info("Navigating to URL");
			
		LoginPage loginPage = new LoginPage(driver);
			
			Log.info("Starting login test--");
			
			//test = ExtentReportManager.createTest("Login Test"+username);
			
			loginPage.enterUsername("admin@yourstore.com");
			loginPage.enterPassword("admin");
			//loginPage.enterUsername(username);
			//loginPage.enterPassword(password);
			
			
			
			loginPage.clicklogin();
			
			//test.pass("click button successfully");
			
			System.out.println("Title of page" +driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Just a moment...");
			
			Log.info("Login Test completed");
			
			//test.pass("Login Successfully");
			
		}
		/*
		 * @Test public void testinValidLogin() { LoginPage loginPage = new
		 * LoginPage(driver);
		 * 
		 * Log.info("Starting login test--");
		 * 
		 * test = ExtentReportManager.createTest("Login Test invalid credential");
		 * 
		 * loginPage.enterUsername("admin@yourstore.com");
		 * loginPage.enterPassword("admin");
		 * 
		 * 
		 * 
		 * loginPage.clicklogin(); test.pass("click button successfully");
		 * 
		 * System.out.println("Title of page" +driver.getTitle());
		 * Assert.assertEquals(driver.getTitle(), "Just a moment...1");
		 * 
		 * Log.info("Login Test completed");
		 * 
		 * test.pass("Login Successfully");
		 * 
		 * }
		 */
}
