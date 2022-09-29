package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css_BT_find_element {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.techpanda.org/index.php/customer/account/login/");
  }
  
  @Test
  public void TC_01_Login_Empty_Email_and_Password() {
	  //Click on Login button btnLogin
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  //check error message
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");
	  
  }
  
  @Test
  public void TC_02_Login_Invalid_Email() {
		  //Input Email and password
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123@abc");
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345678");
		  //Click on Login button
		  driver.findElement(By.xpath("//button[@id='send2']")).click();
		  //check error message when invalid email
		  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
  }
  
  @Test
  public void TC_03_Login_Invalid_Password() {
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='pass']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("johny@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  //Click on Login button
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  //check error message when invalid email
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	  
  }
  
  @Test
  public void TC_04_Login_Incorrect_Email_Or_Password() {
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='pass']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("johny@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
	  
	  //Click on Login button
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  //check error message when invalid email
	  Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
	  
  }
  
  //@AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
