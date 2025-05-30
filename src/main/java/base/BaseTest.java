package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtils;
import utils.ExtentReportManager;
import utils.Log;



public class BaseTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReports() {
		extent.flush();
		String reportPath = ExtentReportManager.reportPath;
		EmailUtils.sendTestReport(reportPath);
	}
	
	
	@BeforeMethod
	public void setup() {
		
		Log.info("Starting webdriver--");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		Log.info("NAvigating url--");
		driver.get("https://admin-demo.nopcommerce.com/login");
	
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			
			String screenshotpath = ExtentReportManager.captureScreenshot(driver, "LoginFailure");
			System.out.println("ScreenSHot capture, PATH:" +screenshotpath);
			test.fail("Test Failed. ScreenShot attched.", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		}
		
		
		
		
		if (driver !=null) {
			Log.info("closing the webpage");
			driver.quit();
		}
	}
}
