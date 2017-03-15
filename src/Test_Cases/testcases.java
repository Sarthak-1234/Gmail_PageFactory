package Test_Cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Account_Page;
import Pages.Home_Page;




public class testcases implements ITestListener{
	
	WebDriver driver;
	Home_Page homeobj;
	Account_Page accobj;
	
	
	@BeforeTest
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\New folder\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.gmail.com");
		
	}
	
	@Test
	public void VerifyTitle(){
		homeobj = new Home_Page(driver);
		Assert.assertEquals(homeobj.getHomePageText(), "Gmail");
	}
	
	/*return driver.findElement(JigsawCheckBoxButtons.getAttemps()).isDisplayed()
			&& driver.findElement(JigsawCheckBoxButtons.getSubmit()).isDisplayed()
			&& driver.findElement(JigsawCheckBoxButtons.getNavigation()).isDisplayed()
			&& driver.findElement(JigsawCheckBoxButtons.getQuestionTitle()).isDisplayed();*/
	
	@Test (dependsOnMethods = { "VerifyTitle" })
	public void Login(){
	
		homeobj = new Home_Page(driver);
		homeobj.enterUsername();
		homeobj.nextButtonClick();
		homeobj.enterPassword();
		homeobj.staySignInClick();
		homeobj.signINClick();
		Assert.assertTrue(homeobj.successfullLogin().contains("Sarthak Chadha"));
		//Assert.assertEquals(homeobj.successfullLogin(), "Google Account: Sarthak Chadha   (sarthak.mzn@gmail.com)");
	}
	
	@Test (dependsOnMethods = { "VerifyTitle", "Login" })
	public void ComposeEmail() throws Exception{
		accobj = new Account_Page(driver);
		accobj.composeEmail();
		Thread.sleep(2000);
		accobj.enterRec();
		accobj.enterSub();
		Thread.sleep(2000);
		accobj.entermsgBody();
		accobj.sendEmail();
	}

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("TestCases Finish");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("TestCases Started");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("TestCase Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("TestCase Skipped");
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Test (dependsOnMethods = { "VerifyTitle", "Login", "ComposeEmail" })
	public void verifyComposeFrame() throws Exception{
		accobj = new accountPage(driver);
		
	}*/
	
	
	/*@Test (enabled = false)
	public void Logout(){
		
	}
	
	@AfterTest
	public void close(){
		
		driver.close();
		
	}*/

}

