package salesforce.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.base.BaseTests;
import salesforce.utility.CommonUtilities;

public class SFDCLogin extends BaseTests
{
	@Test
	public static void loginErrorMsg() throws IOException
	{
		CommonUtilities utility = new CommonUtilities();
		getDriver();
		gotoUrl(utility.getApplicationProperty("url"));
		WebElement username = driver.findElement(By.id("username"));
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		username.clear();
		username.sendKeys("sugan@enexus.com");
		login.click();
		WebElement errorMsg = driver.findElement(By.id("error"));
		String actualErrMsg = errorMsg.getText();
		String expectedErrMsg = "Please enter your password.";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		System.out.println("TC 1 : Test Completed");
		driver.close();
	}
	
	@Test
	public static void checkRememberMe() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("sugan@enexus.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("myTest@2022");
		WebElement rememberme = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		rememberme.click();
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		Thread.sleep(5000);
		WebElement idcard = driver.findElement(By.id("idcard-identity"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(idcard));
		String actualID = idcard.getText();
		String expectedID = "sugan@enexus.com";
		Assert.assertEquals(actualID, expectedID);
		System.out.println("TC 3 : Test Completed");
		driver.close();
		
	}
	
	@Test
	public static void forgotPasswd()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		WebElement forgotPW = driver.findElement(By.id("forgot_password_link"));
		forgotPW.click();
		WebElement uname = driver.findElement(By.id("un"));
		String user = "sugan@enexus.com";
		uname.sendKeys(user);
		Assert.assertEquals(user, "sugan@enexus.com");
		WebElement cont = driver.findElement(By.id("continue"));
		cont.click();
		System.out.println("TC 4A : Test Completed");
		driver.close();

	}
	
	@Test
	public static void validateErrorMsg()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("123");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("22131");
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		login.click();
		WebElement errorMsg = driver.findElement(By.id("error"));
		String actualErrMsg = errorMsg.getText();
		String expectedErrMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
		System.out.println("TC 4B : Test Completed");
		driver.close();

	}

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		loginErrorMsg();
		checkRememberMe();
		
	}

}



