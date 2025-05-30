package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement Usernametextbox;
	
	@FindBy(id="Password")
	WebElement passwordtxtbox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginbutton;
	
	
	//private By usernameTextBox = By.id("Email");
	//private By passwordTextBox = By.id("Password");
	//private By LoginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUsername(String username) {
		Usernametextbox.clear();
		Usernametextbox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordtxtbox.clear();
		passwordtxtbox.sendKeys(password);
	}
	
	public void clicklogin() {
		loginbutton.click();
		
	}
}
