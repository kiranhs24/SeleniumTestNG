package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class TestOne extends BaseClass {
	
	public WebDriver driver;
	
	@Parameters({"url"})
	@BeforeClass
	public void setUpChrome(String url) {
		
		driver = initChromeBrowser(url);
		
	} 
	
	@Test
	public void testChromeDemoOne() {
		
		String currentUrlString = driver.getCurrentUrl();
		System.out.println(currentUrlString);
		Assert.assertTrue(false);
		
	}
	
	@AfterClass
	public void quitChrome() {
		
		driver.quit();
		
	}

}
