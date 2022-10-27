package Maven.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
   
public class Extentreports {
	ExtentReports extent;
	@BeforeTest
	public void reportFile()
	{
		//ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//setting up Report name
		reporter.config().setReportName("Test Report Capture");
		reporter.config().setDocumentTitle("Test Results");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","DeepuPinky");
	}
	
	
	@Test
	public void hitUrl()
	{
		extent.createTest("Hit Url");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dilip\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.getTitle();
		System.out.println(driver.getCurrentUrl());
		extent.flush();
	}
}
