package salesforce.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import salesforce.base.BaseTests;

public class Contacts extends BaseTests{

	@Test
	public static void newContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement create = driver.findElement(By.xpath("//input[@title='New']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(create));
		create.click();
		WebElement lName = driver.findElement(By.id("name_lastcon2"));
		lName.sendKeys("gokulnath");
		WebElement acctName = driver.findElement(By.id("con4"));
		acctName.sendKeys("Edge Communications");
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));	
		save.click();
	}
	
	@Test
	public static void newViewContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNewView.click();
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("sugan");
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUniqueName.sendKeys("ya");
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
	}
	
	@Test
	public static void recentContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		Select recent = new Select(driver.findElement(By.id("hotlist_mode")));
		recent.selectByVisibleText("Recently Created");

	}

	@Test
	public static void myContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		Select view = new Select(driver.findElement(By.id("fcf")));
		view.selectByVisibleText("My Contacts");

	}
	
	@Test
	public static void viewContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement recent = driver.findElement(By.xpath("//a[contains(text(),'gokulnath')]"));
		recent.click();

	}
	@Test
	public static void newViewContactErr() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNewView.click();
//		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
//		viewName.sendKeys("sugan");
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUniqueName.sendKeys("EFGH");
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();
		WebElement error = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[2]"));
		String actualErrorMsg = error.getText();
		String expectedErrorMsg = "Error: You must enter a value";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}
	@Test
	public static void cancelNewViewContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement createNewView = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		createNewView.click();
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("ABCD");
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		viewUniqueName.sendKeys("EFGH");
		WebElement cancel = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));
		cancel.click();
	}
	
	@Test
	public static void saveNewContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement contacts = driver.findElement(By.id("Contact_Tab"));
		Thread.sleep(5000);
		contacts.click();
		WebElement create = driver.findElement(By.xpath("//input[@title='New']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(create));
		create.click();
		WebElement lName = driver.findElement(By.id("name_lastcon2"));
		lName.sendKeys("rajagopal");
		WebElement acctName = driver.findElement(By.id("con4"));
		acctName.sendKeys("Edge Communications");
		WebElement saveNew = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[2]"));	
		saveNew.click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
