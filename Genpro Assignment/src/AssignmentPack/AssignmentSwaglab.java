package AssignmentPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentSwaglab {
  @Test
  public void swaglab() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium Webdriver\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  
	  String expectedTitle="Swag Labs";
	  String actualTitle=driver.getTitle();
	  Assert.assertEquals(actualTitle,expectedTitle);
	  
	  // login
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	  
	  WebElement dropdown=driver.findElement(By.className("product_sort_container"));
	  Select sort=new Select(dropdown);
	  sort.selectByValue("lohi");
	  
	  //adding products to cart
	  driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	  driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	  
	  driver.findElement(By.className("shopping_cart_link")).click();
	  Thread.sleep(3000);
	  
	  //Removing product that have a price <$15
	  driver.findElement(By.id("remove-sauce-labs-onesie")).click();
	  driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
	  Thread.sleep(3000);
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,100)");
	  
	  driver.findElement(By.id("checkout")).click();
	  
	  //entering checkout details
	  driver.findElement(By.id("first-name")).sendKeys("Nanda");
	  driver.findElement(By.id("last-name")).sendKeys("Kumar");
	  driver.findElement(By.id("postal-code")).sendKeys("695555");
	  Thread.sleep(3000);
	  driver.findElement(By.id("continue")).click();
	  
	  js.executeScript("window.scrollBy(0,100)");
	  driver.findElement(By.id("finish")).click();
	  driver.findElement(By.id("back-to-products")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("react-burger-menu-btn")).click();
	  driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
  }	
}
