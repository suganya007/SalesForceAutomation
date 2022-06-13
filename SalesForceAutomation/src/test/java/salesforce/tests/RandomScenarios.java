package salesforce.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import salesforce.base.BaseTests;

public class RandomScenarios extends BaseTests {

	
	//----------Incomplete------------//
	@Test
		public static void verifyUser() throws IOException, InterruptedException 
		{
			beforeTest();
			WebElement home = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
			home.click();
			Thread.sleep(5000);
			WebElement fullname = driver.findElement(By.xpath("//a[contains(text(),'Suganya Rajagopal')]"));
			fullname.click();
			WebElement title = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
			String actual = title.getText();
			System.out.println(actual);
			String expected = "Suganya Rajagopal";
			System.out.println(expected);
			Assert.assertEquals("Suganya Rajagopal", actual);
			
		}
}
