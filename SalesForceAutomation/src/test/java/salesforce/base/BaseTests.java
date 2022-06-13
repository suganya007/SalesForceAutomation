package salesforce.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import salesforce.utility.CommonUtilities;
import salesforce.utility.Constants;

public class BaseTests 
{
	 protected static WebDriver driver;
	 protected static WebDriverWait wait;

		public static void beforeTest() throws IOException, InterruptedException
		{
			CommonUtilities utility = new CommonUtilities();
			String url = utility.getApplicationProperty("url");
			String uname = utility.getApplicationProperty("username");
			String pwd = utility.getApplicationProperty("password");
			getDriver();
			gotoUrl(url);
			login(uname,pwd);
		//	Thread.sleep(5000);

		}

	 public String readProperties(String keyname) throws IOException
	 {
		 Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream(Constants.APPLICATION_PROPERTIES_PATH);
		 prop.load(fis);
		 return prop.getProperty(keyname);
	 }
	 
	public static void getDriver() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome driver instance created");
	 }
	
	public static void gotoUrl(String url)
	{
		driver.get(url);
	}
	
	public static void login(String uname, String passwd)
	{
		WebElement username = driver.findElement(By.id("username"));
		WebElement login = driver.findElement(By.xpath("//input[@id='Login']"));
		username.clear();
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passwd);
		login.click();

	}
	
	public static void waitUntilVisible(WebElement elt) 
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(elt));
	}
	 
	public static void clickOppty() throws InterruptedException 
	{
		WebElement oppty = driver.findElement(By.id("Opportunity_Tab"));
		Thread.sleep(5000);
		oppty.click();

	}
}