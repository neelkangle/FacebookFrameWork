package facebook.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationProvider {

	Properties pro;
	
	public ConfigurationProvider()
	{
		File src = new File("./Config/Config.properties");
		
		try 
		{
				FileInputStream fis = new FileInputStream(src);			
				pro = new Properties();
				pro.load(fis);
		}
	
		catch (Exception e)
	    {
		System.out.println("File not found"+ e.getMessage());
	    }
		
	}
	public String CallBrowser()
	{
		return pro.getProperty("browser");
	}

	public String CallUrl()
	{
		return pro.getProperty("url");
	}
}
