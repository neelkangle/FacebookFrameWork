package facebook.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import facebook.pages.BaseClass;
import facebook.pages.LoginPage;
import facebook.utility.BrowserFactory;
import facebook.utility.ConfigurationProvider;

public class OpenHomePage {
	
	public WebDriver driver;
	
	@Test
	public WebDriver openwebsite()
	{
		ConfigurationProvider cnf = new ConfigurationProvider();
		//String browserfrompropteryfile =cnf.CallBrowser();
		//String Urlfrompropteryfile =cnf.CallUrl();
		
		 return BrowserFactory.StartApplication(driver, cnf.CallBrowser(), cnf.CallUrl());
	}

}
