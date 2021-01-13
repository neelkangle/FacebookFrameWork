package facebook.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import facebook.pages.BaseClass;
import facebook.pages.LoginPage;
import facebook.utility.ScreenshotProvider;

public class successful_loginTestcase extends BaseClass{

	@Test(priority=2,description ="Test Case 2 - To check User logged in Successfully")
	public void TocheckUserloggedinsuccessfully() throws IOException
	{
		
		logger = Reports.createTest("Test Case 2 - To check User logged in Successfully");
		
		LoginPage lgp =PageFactory.initElements(drivertopassinloginpage, LoginPage.class);		
		
		String username = excelobj.ReadValuefromfirstrowcolumn("Login", 0, 0);
		
		String Password = excelobj.ReadValuefromfirstrowcolumn(0, 0, 1);
		
		lgp.loginintoFb(username, Password);
		System.out.println(drivertopassinloginpage.getCurrentUrl());
		
		String expected = drivertopassinloginpage.getCurrentUrl();
		String actual =drivertopassinloginpage.getCurrentUrl();
		Assert.assertEquals(actual, expected,"login unsucessful");
		ScreenshotProvider sp = new ScreenshotProvider();
		String img = sp.grabscreenshot(drivertopassinloginpage,"TestCaseNo-2" );
		logger.addScreenCaptureFromPath(img);
		logger.log(Status.PASS,"Login successful");
		Reports.flush();
	}
	
}
