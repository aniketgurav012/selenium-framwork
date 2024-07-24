package SSquareIT.seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingpage {
//private WebElement myAccount;
//	private WebElement loginButton;
	
//	public landingpage(WebDriver driver) {
		
	//	myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
	//	loginButton = driver.findElement(By.xpath("//li//a[text()='Login']"));
		
//	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath="//li//a[text()='Login']")
	private WebElement LoginButton;
	
	public landingpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void NavigateToLoginPage() {
		myAccount.click();
		LoginButton.click();
		
	}

}
