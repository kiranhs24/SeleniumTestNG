package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	public static ExtentReports getExtentObject() {
		
		reporter = new ExtentSparkReporter("target/extent-report/index.html");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Selenium Web Automation");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Author", "Kiran");
		extent.setSystemInfo("Environment", "Local");
		
		return extent;
		
	}

}
