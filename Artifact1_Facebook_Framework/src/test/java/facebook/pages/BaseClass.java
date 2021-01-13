package facebook.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import facebook.testcases.OpenHomePage;
import facebook.utility.ExcelDataProvider;
import facebook.utility.Gettimestamp;
import facebook.utility.ScreenshotProvider;

public class BaseClass {

	public WebDriver drivertopassinloginpage;
	
	public ExcelDataProvider excelobj;
	//public ConfigurationProvider cnf;
	public OpenHomePage  ohp ;
	public  ExtentReports Reports;
	public ExtentTest logger;

	@BeforeSuite
	public void Excelsetup()
	{
		 excelobj = new ExcelDataProvider();
		 ExtentHtmlReporter html = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/facebookReport"+ Gettimestamp.getcurrenttimestamp()+".html"));
		 Reports = new ExtentReports();
		 Reports.attachReporter(html);
		 
	}
	@BeforeClass(description ="Test Case 1 - To check Website is opening")
	public void TocheckWebsiteisopening()
	{
		ohp = new OpenHomePage();
		drivertopassinloginpage = ohp.openwebsite();// Direct call from class
	}
	
	@AfterMethod
	public void TearDown(ITestResult Result)
	
	{
		if(Result.getStatus() == ITestResult.FAILURE)
		{
			ScreenshotProvider sp = new ScreenshotProvider();
			String imgpath = sp.grabscreenshot(drivertopassinloginpage,"TestCaseNo-2" );
			try {
				logger.addScreenCaptureFromPath(imgpath);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			logger.log(Status.FAIL,"Login Unuccessful"+ Result.getThrowable());
		}
		Reports.flush();
	}

	
	
}
