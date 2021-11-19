package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;

	public WebDriver initChromeBrowser(String url) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
//		chromeOptions.addArguments("--disable-gpu");
//		chromeOptions.addArguments("--disable-extensions");
//		chromeOptions.addArguments("--no-sandbox");
//		chromeOptions.addArguments("--allow-insecure-localhost");

		driver = new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();

		return driver;

	}

	public WebDriver initFirefoxBrowser(String url) {

		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		firefoxOptions.addArguments("--headless");
//		firefoxOptions.addArguments("--disable-gpu");
//		firefoxOptions.addArguments("--disable-extensions");
//		firefoxOptions.addArguments("--no-sandbox");
//		firefoxOptions.addArguments("--allow-insecure-localhost");

		driver = new FirefoxDriver(firefoxOptions);
		driver.get(url);
		driver.manage().window().maximize();

		return driver;

	}

}
