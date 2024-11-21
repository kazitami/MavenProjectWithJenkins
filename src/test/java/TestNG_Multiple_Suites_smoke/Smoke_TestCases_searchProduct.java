package TestNG_Multiple_Suites_smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;

public class Smoke_TestCases_searchProduct extends TestBase {

	public Smoke_TestCases_searchProduct() throws Exception {
		super();
	}

	@BeforeMethod
	public void registerassertions() {
		driver = initializeBrowserAndOpenApplication("Chrome");
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		driver.findElement(By.name("Search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {

		driver.findElement(By.name("Search")).sendKeys("Dell");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']"))
						.isDisplayed());
	}

	@Test(priority = 3)
	public void verifySearchWithNoProduct() {

		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']"))
						.isDisplayed());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
