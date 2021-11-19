package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Reports.ExtentReportGenerator;
import baseClass.BaseClass;
import utilities.Utilities;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extentReports = ExtentReportGenerator.getExtentObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test = extentReports.createTest(result.getMethod().getMethodName());
		try {
			
			if(result.getMethod().getMethodName().contains("Chrome")) {
				
				test.assignCategory("Chrome");
				
			} else if (result.getMethod().getMethodName().contains("Firefox")) {
				
				test.assignCategory("Firefox");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} 
		
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriver driver = null;
		extentTest.get().log(Status.FAIL, "Test Failed");
		extentTest.get().log(Status.FAIL, result.getThrowable());
		Object testObject = result.getInstance();
		Class className = result.getTestClass().getRealClass();
		
		try {
			
			driver = (WebDriver) className.getDeclaredField("driver").get(testObject);
			extentTest.get().addScreenCaptureFromBase64String(Utilities.getScreenshot(driver));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		extentTest.get().log(Status.SKIP, "Test Skipped");
		extentTest.get().log(Status.SKIP, "Test did not run");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {}

	public void onFinish(ITestContext context) {
		
		extentReports.flush();
		
	}

}
