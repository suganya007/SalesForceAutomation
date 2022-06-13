package salesforce.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import salesforce.base.BaseTests;

public class CreateOpportunity extends BaseTests
{
//	public static void beforeTest() throws IOException, InterruptedException
//	{
//		CommonUtilities utility = new CommonUtilities();
//		String url = utility.getApplicationProperty("url");
//		String uname = utility.getApplicationProperty("username");
//		String pwd = utility.getApplicationProperty("password");
//		getDriver();
//		gotoUrl(url);
//		login(uname,pwd);
//	//	Thread.sleep(5000);
//
//	}

	@Test
	public static void viewOppty() throws InterruptedException, IOException
	{
		beforeTest();
		WebElement oppty = driver.findElement(By.id("Opportunity_Tab"));
		waitUntilVisible(oppty);
		oppty.click();
		Thread.sleep(5000);
		WebElement view = driver.findElement(By.id("fcf"));
		view.click();	
	}
	@Test
	public static void newOppty() throws InterruptedException, IOException
	{
		beforeTest();
		clickOppty();
		Thread.sleep(5000);
		WebElement create = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(create));
		create.click();
		WebElement opptyName = driver.findElement(By.id("opp3"));
		opptyName.sendKeys("United Oil Installations");
		WebElement acctName = driver.findElement(By.id("opp4"));
		acctName.sendKeys("United Oil & Gas Corp");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('opp9').value='5/16/2022'");
		Thread.sleep(5000);
		Select stage = new Select(driver.findElement(By.id("opp11")));
		stage.selectByVisibleText("Prospecting");
		WebElement prob = driver.findElement(By.id("opp12"));
		prob.sendKeys("0.5");
		WebElement campaign = driver.findElement(By.id("opp17"));
		campaign.sendKeys("");
		Select leadSource = new Select(driver.findElement(By.id("opp6")));
		leadSource.selectByVisibleText("web");
		WebElement save = driver.findElement(By.className("btn"));
		save.click();
		
		

				
	}
	@Test
	public static void opptyPipeline() throws InterruptedException, IOException
	{
		beforeTest();
		clickOppty();
		WebElement pipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		waitUntilVisible(pipeline);
		pipeline.click();
		
	}
	@Test
	public static void stuckOppty() throws InterruptedException, IOException
	{
		beforeTest();
		clickOppty();
		WebElement stuck = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		waitUntilVisible(stuck);
		stuck.click();
	}
	
	@Test
	public static void quarterlySummary() throws InterruptedException, IOException
	{
		beforeTest();
		clickOppty();
		Select interval = new Select(driver.findElement(By.id("quarter_q")));
		interval.selectByVisibleText("Next FQ");
		Select include = new Select(driver.findElement(By.id("open")));
		include.selectByVisibleText("All Opportunities");
		WebElement run = driver.findElement(By.xpath("//input[@title='Run Report']"));
		run.click();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
