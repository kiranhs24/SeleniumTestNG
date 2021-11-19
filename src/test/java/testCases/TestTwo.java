package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class TestTwo extends BaseClass {
	
	public WebDriver driver;
	
	@Parameters({"url"})
	@BeforeClass
	public void setUpFirefox(String url) {
		
		driver = initFirefoxBrowser(url);
		
	} 
	
	@Test
	public void testFirefoxDemoOne() {
		
		String currentUrlString = driver.getCurrentUrl();
		System.out.println(currentUrlString);
		Assert.assertTrue(true);
		
	}
	
	@AfterClass
	public void quitFirefox() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
	}

		
}
