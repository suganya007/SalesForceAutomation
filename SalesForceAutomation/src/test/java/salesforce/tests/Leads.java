package salesforce.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.base.BaseTests;

public class Leads  extends BaseTests{

	@Test
	public static void testLead() throws InterruptedException , IOException
	{
		beforeTest();
		WebElement lead = driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(5000);
		lead.click();
	}
	
	@Test
	public static void leadSelectView() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement lead = driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(5000);
		lead.click();
		WebElement view = driver.findElement(By.id("fcf"));
		view.click();
	}

	@Test
	public static void todaysLead() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement lead = driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(5000);
		lead.click();
		Select view = new Select(driver.findElement(By.id("fcf")));
		view.selectByVisibleText("Today's Leads");
	}
	
	@Test
	public static void defaultView() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement lead = driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(5000);
		lead.click();
		Select view = new Select(driver.findElement(By.id("fcf")));
		view.selectByVisibleText("Today's Leads");
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		Thread.sleep(5000);
		WebElement username1 = driver.findElement(By.id("username"));
		WebElement login1 = driver.findElement(By.xpath("//input[@id='Login']"));
		username1.clear();
		username1.sendKeys("sugan@enexus.com");
		WebElement password1 = driver.findElement(By.id("password"));
		password1.sendKeys("myTest@2022");
		login1.click();
		WebElement lead1 = driver.findElement(By.id("Lead_Tab"));
		lead1.click();
	}
	
	@Test
	public static void newLead() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement lead = driver.findElement(By.id("Lead_Tab"));
		Thread.sleep(5000);
		lead.click();
		WebElement newLead = driver.findElement(By.xpath("//input[@title='New']"));
		newLead.click();
		WebElement lname = driver.findElement(By.id("name_lastlea2"));
		lname.sendKeys("ABCD");
		WebElement company = driver.findElement(By.id("lea3"));
		company.sendKeys("ABCD");
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
