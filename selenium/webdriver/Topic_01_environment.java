package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic_01_environment {
  WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
	  }
	@Test
  public void TC_01_ValidatePageTitle() {
		String Pageurl = driver.getCurrentUrl();
		Assert.assertEquals(Pageurl, "Guru99 Bank Home Page");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
