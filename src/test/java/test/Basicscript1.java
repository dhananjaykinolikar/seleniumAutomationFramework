package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basicscript1 {
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		//driver.get("https://www.selenium.dev/documentation/");
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		String title= driver.getTitle();
		System.out.println("Title is" +title);
		
		WebElement emailbox =driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
		
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		String buttonname= emailbox.getText();
		System.out.println("Button text is"+ buttonname);
		emailbox.click();
		
		//driver.close();
		//driver.quit();
	}

}
