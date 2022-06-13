package salesforce.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.base.BaseTests;

public class CreateAccount  extends BaseTests{
	@Test
	public static void createAcct() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement accts = driver.findElement(By.id("Account_Tab"));
		accts.click();
		Thread.sleep(5000);
		WebElement create = driver.findElement(By.xpath("//input[@title='New']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(create));
		create.click();

	}
	
	@Test
	public static void createNewViewAcct() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement accts = driver.findElement(By.id("Account_Tab"));
		accts.click();
		Thread.sleep(5000);
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
	public static void editViewContact() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement accts = driver.findElement(By.id("Account_Tab"));
		accts.click();
		Thread.sleep(5000);
		Select view = new Select(driver.findElement(By.id("fcf")));
		view.selectByVisibleText("gokul");

		WebElement editView = driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
		editView.click();
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		viewName.sendKeys("gokul");
		Select field = new Select(driver.findElement(By.id("fcol1")));
		field.selectByVisibleText("Account Name");
		Select operator = new Select(driver.findElement(By.id("fop1")));
		operator.selectByVisibleText("contains");
		WebElement value = driver.findElement(By.id("fval1"));
		value.sendKeys("a");
		Select availFields = new Select(driver.findElement(By.id("colselector_select_0")));
		availFields.selectByVisibleText("Last Activity");
		WebElement add = driver.findElement(By.className("rightArrowIcon"));
		add.click();
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		save.click();

	}
	@Test
	public static void mergeAccount() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement accts = driver.findElement(By.id("Account_Tab"));
		accts.click();
		Thread.sleep(5000);
		WebElement merge = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		merge.click();
		WebElement srch = driver.findElement(By.id("srch"));
		srch.sendKeys("Edge Communications");
		WebElement findacct = driver.findElement(By.xpath("//input[@title='Find Accounts'][@class=\"btn\"]"));
		findacct.click();
		WebElement chk1 = driver.findElement(By.xpath("//input[@id='cid0']"));
		if(!chk1.isSelected())
		{
			chk1.click();	
		}
		WebElement chk2 = driver.findElement(By.xpath("//input[@id='cid1']"));
		if(!chk2.isSelected())
		{
			chk2.click();	
		}
		WebElement next = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/form[1]/div[1]/div[2]/div[5]/div[1]/input[1]"));
		next.click();
		Thread.sleep(5000);
		WebElement merge2 = driver.findElement(By.xpath("//input[@title='Merge'][1]"));
		merge2.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test
	public static void createAccountReport() throws InterruptedException, IOException, AWTException
	{
		beforeTest();
		WebElement accts = driver.findElement(By.id("Account_Tab"));
		accts.click();
		Thread.sleep(5000);
		WebElement reportActivity = driver.findElement(By.xpath("//a[contains(text(),'Accounts with last activity > 30 days')]"));
		reportActivity.click();
		Thread.sleep(5000);
		WebElement dateField = driver.findElement(By.name("dateColumn"));
		dateField.click();
		WebElement createdDate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
		createdDate.click();
		Thread.sleep(5000);
		WebElement fromDate = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		Thread.sleep(5000);
		fromDate.click();
		WebElement today1 = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		Thread.sleep(5000);
		today1.click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(5000);
		WebElement toDate = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		toDate.click();
		Thread.sleep(5000);
		WebElement today2 = driver.findElement(By.xpath("(//button[contains(text(),'Today')])[2]"));
		Thread.sleep(5000);
		today2.click();	
		WebElement save = driver.findElement(By.id("ext-gen49"));
		save.click();
		WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		reportName.sendKeys("My Report");
		WebElement reportUnique = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		reportUnique.clear();
		reportUnique.sendKeys("My_Report_unique");
		reportUnique.click();
		Thread.sleep(5000);
		WebElement save1 = driver.findElement(By.xpath("//button[contains(text(),'Save and Run Report')]"));
		Thread.sleep(5000);
		save1.click();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
