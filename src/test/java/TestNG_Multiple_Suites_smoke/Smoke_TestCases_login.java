package TestNG_Multiple_Suites_smoke;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import TestNG_Multiple_Suites_regression.TestBase;
import org.testng.Assert;
import org.openqa.selenium.By;


public class Smoke_TestCases_login extends TestBase{
	public Smoke_TestCases_login() throws Exception {
		super();
	}

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("Chrome");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
	}
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda123@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium123@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
	}
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailandInvalidPassword() {
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium123@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailandValidPassword() {
		
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda345@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
	}
	
	@Test(priority=5)
	public void verifyLoginWithNoCredentials() {
		

		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Warning: No match for E-Mail Address and/or Password.']")).isDisplayed());
		
	}
  

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
