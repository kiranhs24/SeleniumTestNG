package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	public static String getScreenshot(WebDriver driver) {
		
		TakesScreenshot shot = (TakesScreenshot) driver;
		String img = shot.getScreenshotAs(OutputType.BASE64);
		String destination = "data:image/png;base64," + img;
		return destination;
		
	} 

}
