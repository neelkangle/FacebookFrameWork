package facebook.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotProvider {

	WebDriver driver;
	public String grabscreenshot(WebDriver driver, String TestCaseNumbering)
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr =ts.getScreenshotAs(OutputType.FILE);
		String orgimg = System.getProperty("user.dir")+"/AllScreenshot/Facebookloginpage/"+TestCaseNumbering+"/"+Gettimestamp.getcurrenttimestamp()+".png";
		File des = new File(orgimg);
		try 
		{
			FileUtils.copyFile(scr, des);
			return orgimg;
		} 
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
		
	}
}
