package com.irawan.wijanarko.test;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"C:/geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "http://roomsy-staging.azurewebsites.net/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testSignUp() throws Exception {
		driver.get(baseUrl + "/auth/login");
		driver.findElement(
				By.linkText("Don't have an account? Sign-up with us!")).click();
		driver.findElement(
				By.linkText("Don't have an account? Sign-up with us!")).click();
		driver.findElement(By.xpath("//input[@value='Request for a Demo']"))
				.click();
		driver.findElement(By.xpath("//input[@value='Request for a Demo']"))
				.click();
		/*driver.findElement(By.cssSelector("button.close")).click();*/
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys("test");
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys("test");
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys("sign");
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys("sign");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("testsign10@gmail.com");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("testsign10@gmail.com");
		driver.findElement(By.name("company_name")).clear();
		driver.findElement(By.name("company_name")).sendKeys("pro");
		driver.findElement(By.name("company_name")).clear();
		driver.findElement(By.name("company_name")).sendKeys("pro");
		new Select(driver.findElement(By.name("country")))
				.selectByVisibleText("Indonesia");
		new Select(driver.findElement(By.name("country")))
				.selectByVisibleText("Indonesia");
		driver.findElement(By.name("number_of_rooms")).clear();
		driver.findElement(By.name("number_of_rooms")).sendKeys("5");
		driver.findElement(By.name("number_of_rooms")).clear();
		driver.findElement(By.name("number_of_rooms")).sendKeys("5");
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("+6277734378234");
		driver.findElement(By.name("phone")).clear();
		driver.findElement(By.name("phone")).sendKeys("+6277734378234");
		driver.findElement(By.xpath("//input[@value='Request for a Demo']"))
				.click();
		driver.findElement(By.xpath("//input[@value='Request for a Demo']"))
				.click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	
	
}
