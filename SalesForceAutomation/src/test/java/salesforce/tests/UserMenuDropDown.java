package salesforce.tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import salesforce.base.BaseTests;

public class UserMenuDropDown extends BaseTests 
{
	@Test
	public static void userMenu() throws IOException, InterruptedException
	{
		beforeTest();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		System.out.println("TC 5 : Test Completed");
		driver.close();
	}

	@Test
	public static void developerConsole() throws IOException, InterruptedException
	{
		beforeTest();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		Thread.sleep(5000);
		WebElement devConsole = driver.findElement(By.xpath("//a[contains(text(),'Developer Console')]"));
		devConsole.click();		
		String oldWindow = driver.getWindowHandle();
		Set<String>AllWindows=driver.getWindowHandles();
		String[] getAllWindows=AllWindows.toArray(new String[AllWindows.size()]);
		Thread.sleep(5000);
		driver.switchTo().window(getAllWindows[1]);
		driver.close();
		driver.switchTo().window(oldWindow);
	}
	@Test
	public static void myProfile() throws IOException,InterruptedException
	{
		beforeTest();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		Thread.sleep(5000);
		WebElement myProfile = driver.findElement(By.xpath("//a[@title='My Profile']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(myProfile));
		myProfile.click();
		WebElement edit = driver.findElement(By.xpath("//img[@title='Edit Profile'][1]"));
		edit.click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id==\"aboutTab\"]/a"))); //a[contains(text(),'About')]
		WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		action.moveToElement(aboutTab).click().build().perform();
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.clear();
		Thread.sleep(5000);
		lname.sendKeys("Gokulnath");
		WebElement saveAll = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		action.moveToElement(saveAll).click().build().perform();
		WebElement post = driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]"));
		post.click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//body")).sendKeys("Selenium Automation");
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("publishersharebutton")));
		action.moveToElement(driver.findElement(By.id("publishersharebutton"))).click().build().perform();
		Thread.sleep(5000);
		
		WebElement file = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
		file.click();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"chatterUploadFileAction\"]"))).click().build().perform();
		WebElement chatterfile = driver.findElement(By.id("chatterFile"));
		Thread.sleep(5000);
		chatterfile.sendKeys("/Users/gokulnath/Desktop/Screen Shot 2022-05-16 at 2.20.10 PM (2).png");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("publishersharebutton")));
		action.moveToElement(driver.findElement(By.id("publishersharebutton"))).click().build().perform();
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.id("uploadLink"))).click().build().perform();	
		Thread.sleep(5000);
		driver.switchTo().frame("uploadPhotoContentId");
		Thread.sleep(5000);
		WebElement uploadFile = driver.findElement(By.xpath("//*[@id=\"j_id0:uploadFileForm:uploadInputFile\"]"));
		uploadFile.click();
	}
	
	@Test
	public static void mySettings() throws IOException,InterruptedException
	{
		beforeTest();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		Thread.sleep(5000);
		//WebElement myProfile = driver.findElement(By.className("menuButtonMenuLink firstMenuItem"));
		WebElement mySettings = driver.findElement(By.xpath("//a[@title='My Settings']"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(mySettings));
		mySettings.click();
		WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
		personal.click();
		WebElement loginHis = driver.findElement(By.id("LoginHistory_font"));
		loginHis.click();
		WebElement dwnloadHis = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		dwnloadHis.click();
		WebElement dispLayout = driver.findElement(By.id("DisplayAndLayout_font"));
		dispLayout.click();
		WebElement customizeTab = driver.findElement(By.id("CustomizeTabs_font"));
		customizeTab.click();
		Select reports = new Select(driver.findElement(By.id("duel_select_0")));
		reports.selectByVisibleText("Reports");
		WebElement add = driver.findElement(By.className("rightArrowIcon"));
		add.click();
		WebElement save = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		save.click();
		WebElement email = driver.findElement(By.id("EmailSetup_font"));
		email.click();
		WebElement emailSetting = driver.findElement(By.id("EmailSettings_font"));
		emailSetting.click();
		WebElement emailName = driver.findElement(By.id("sender_name"));
		emailName.clear();
		emailName.sendKeys("Suganya");
		WebElement emailID = driver.findElement(By.id("sender_email"));
		emailID.clear();
		emailID.sendKeys("mailtosugan@gmail.com");
		WebElement bcc = driver.findElement(By.id("auto_bcc1"));
		if(!bcc.isSelected())
			bcc.click();
		WebElement save1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		save1.click();
		WebElement calenderReminder = driver.findElement(By.id("CalendarAndReminders_font"));
		calenderReminder.click();
		WebElement activityReminder = driver.findElement(By.id("Reminders_font"));
		activityReminder.click();
		WebElement testReminder = driver.findElement(By.id("testbtn"));
		testReminder.click();

		
		
	}
	@Test
	public static void logout() throws IOException, InterruptedException
	{
		beforeTest();
		WebElement dropdown = driver.findElement(By.id("userNavLabel"));
		dropdown.click();
		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
