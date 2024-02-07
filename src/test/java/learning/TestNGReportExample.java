package learning;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestNGReportExample {

	@Test
	public void testMethod1() {
		System.out.println("Test method 1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Test method 2");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("Test method 3");
	}
	
	@Test
	public void testMethod4() {
		System.out.println("Test method 4");
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) {
		
	}

}
