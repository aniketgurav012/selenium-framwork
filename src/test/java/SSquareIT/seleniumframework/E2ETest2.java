package SSquareIT.seleniumframework;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class E2ETest2 {
	@Test
	public void endtoendtest () throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
		//landing page
				landingpage lp = new landingpage(driver);
				lp.NavigateToLoginPage();
				
		//login page
				Loginpage login = new Loginpage(driver);
				login.LoginAction("demo012@gmail.com"," 1234");
				
		
		//Homepage
		driver.findElement(By.xpath("//li//a[text()='Cameras']")).click();		
		
		//Product page
		
	 List<WebElement> products = driver.findElements(By.cssSelector("div.product-grid"));
	 
	 for (WebElement product: products) {
		 WebElement targetProduct = product.findElement(By.cssSelector("div h4"));
		 String productName = targetProduct.getText();
		 System.out.println(productName);
		 if(productName.equalsIgnoreCase("Nikon D300")) {
			 targetProduct.findElement(By.cssSelector("a")).click();
		 }
	 }
	 
	 //product Details Page
	 
	 String price = driver.findElement(By.xpath("//h1[text()='Nikon D300']/..//"
	 		+ " following-sibling::ul[@class='list-unstyled'][2]//h2")).getText();
	 System.out.println("Product price: "+ price);
	 
	 //first validation
	 
	 Assert.assertEquals(price,"$98.00");
	 
	 driver.findElement(By.xpath("//input[@name='quantity']")).clear();
	 driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
	 
	 driver.findElement(By.id("input-quantity")).click();
	 driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
	 String totalPrice = driver .findElement(By.xpath("//strong[text()='Total']/../following-sibling::td")).getText();
	 System.out.println("TotalPrice" + totalPrice);
	 
	 Assert.assertEquals(totalPrice, "$196.00");
	 
	 driver.findElement(By.xpath("//strong[text()='Checkout']")).click();
	 
	 //checkout page
	 driver.findElement(By.xpath("//strong[text()='Checkout']"));
      
	 driver.findElement(By.cssSelector("button.close")).click();
	 String successMessage = driver.findElement(By.xpath("(//a[text()='Nikon D300'])[2]/../span")).getText();
	  
	 System.out.println("Success Message:"+ successMessage);
	 
	 boolean isSuccess = successMessage.equalsIgnoreCase("***");
	 Assert.assertTrue(isSuccess);
	 
	 driver.close();
	 
		}
}



