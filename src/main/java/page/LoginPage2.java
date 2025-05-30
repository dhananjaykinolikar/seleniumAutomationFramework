package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 {
	
	private WebDriver driver;
	
	private By usernameTextBox = By.id("Email");
	private By passwordTextBox = By.id("Password");
	private By LoginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	

	public LoginPage2(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).clear();
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(LoginButton).click();
	}
}
