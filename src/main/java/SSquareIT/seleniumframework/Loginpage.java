package SSquareIT.seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

//	driver.findElement(By.id("input-email")).sendKeys("demo012@gmail.com");
//	driver.findElement(By.id("input-password")).sendKeys("1234");
//	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	@FindBy(id="input-email")
	private WebElement username;
	
	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;

   public Loginpage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   } 
	   public void LoginAction(String userEmail ,String userPassword) {
		    username.sendKeys(userEmail);
		    password.sendKeys(userPassword);
		    submitButton.click();
   }
   

}