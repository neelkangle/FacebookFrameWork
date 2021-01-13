package facebook.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver Driver;
	public static WebDriver StartApplication(WebDriver Driver,String BrowserName, String UrlName)
	{
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
		
			System.setProperty("webdriver.chrome.driver", "./Drivers/Chromedriver_Version_86/chromedriver.exe");
			Driver = new ChromeDriver();
		  
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
			 System.setProperty("webdriver.gecko.driver","./Drivers/firefox/geckodriver.exe");
			 Driver = new FirefoxDriver();
			
		}
		
		else if(BrowserName.equalsIgnoreCase("ie"))
		{
			 System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer_Win32_2.39.0/IEDriverServer.exe");
			 Driver = new InternetExplorerDriver();
		}
		else
		{
			 System.out.println("Invalid browser");
		}
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Driver.get(UrlName);
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return Driver;
	}
	
	public static void closeBrowser(WebDriver Driver)
	{
		Driver.close();
	}

}
