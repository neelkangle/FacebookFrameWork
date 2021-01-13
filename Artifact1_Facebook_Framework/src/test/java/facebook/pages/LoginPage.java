package facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	 WebDriver driver;
	@FindBy(id="email") WebElement userEmail_ele;
	@FindBy(id="pass") WebElement userPass_ele;
	@FindBy(name="login") WebElement loginButton_ele;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver= ldriver;
			  
	}
	
	public void loginintoFb(String catchApplication_username, String catchApplicatuon_password)
	{
		userEmail_ele.sendKeys(catchApplication_username);
		userPass_ele.sendKeys(catchApplicatuon_password);
		loginButton_ele.click();
	}
}
