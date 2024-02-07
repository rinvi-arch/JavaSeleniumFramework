package learning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReportClass {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add enviroment details 
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("user", "rinvi");
		reports.setSystemInfo("Browser", "chrome");

		// configuration to change the look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	@Test
	public void testMethod1() {
		test = reports.createTest("Launch broser and open url");
		System.out.println("Test method 1");
		Assert.assertTrue(true); //test pass
	}

	@Test
	public void testMethod2() {
		System.out.println("\"Test method 2");
		test = reports.createTest("verify title");
		Assert.assertTrue(false);
	}

	@Test
	public void testMethod3() {
		System.out.println("Test method 3");
		test = reports.createTest("verify logo");
		Assert.assertTrue(true);
	}

	@Test
	public void testMethod4() {
		System.out.println("Test method 4");
		test = reports.createTest("Verify email");
		throw new SkipException("Skipping this test case with exception");

	}
	
	@Test
	public void testMethod5() {
		System.out.println("Test method 5");
		test = reports.createTest("Verify email");
		Assert.assertTrue(false);
	}
}
