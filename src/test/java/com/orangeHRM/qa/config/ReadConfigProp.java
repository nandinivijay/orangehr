package com.orangeHRM.qa.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigProp {
	//public static WebDriver driver;
	Properties prop;
	static String browserName;
	public ReadConfigProp()
	{
		try
		{
			prop=new Properties();
			File src = new File("./src/test/java/com/orangeHRM/qa/config/config.properties");
			FileInputStream fis = new FileInputStream(src);
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("file not found"  + e.getMessage());
		}
	}
	
	public String getBrowser()
	{
		String browser = prop.getProperty("BROWSER");
		return browser;
	}
	
	public String getURL()
	{
		String url = prop.getProperty("URL");
		return url;
	}
	
	public String getUserId()
	{
		String UID = prop.getProperty("USERNAME_ID");
		return UID;
	}
	
	public String getUserName()
	{
		String UN = prop.getProperty("USERNAME");
		return UN;
	}
	
	public String getPasswordId()
	{
		String PID = prop.getProperty("PASSWORD_ID");
		return PID;
	}
	 
	public String getPassword()
	{
		String PW = prop.getProperty("PASSWORD");
		return PW;
	}
	
	public String getLoginID()
	{
		String loginID = prop.getProperty("LOGIN_ID");
		return loginID;
	}
	
	public String getExcelPath()
	{
		String loginID = prop.getProperty("EXCELPATH");
		return loginID;
	}
	
	public String getScreenShotPath()
	{
		String loginID = prop.getProperty("SCREENSHOTPATH");
		return loginID;
	}
	
	public String getReportPath()
	{
		String loginID = prop.getProperty("REPORTPATH");
		return loginID;
	}
	
	/*@Test
	public static void login() throws IOException
	{
		//@SuppressWarnings("unused")
	 browserName=prop.getProperty("browser");
	 System.out.println(browserName);	 
	 System.out.println(prop.getProperty("url")); 
	 System.out.println("Initiating Browser");
	 String UserName_ID = prop.getProperty("username_id");
	 String UserName = prop.getProperty("username");
	 String Password_ID = prop.getProperty("password_id");
	 String Password = prop.getProperty("password");
	 
	 BaseClass.initialise();
	 BaseClass.loadUrl();
	 System.out.println("This is driver object: "+driver);
		//System.out.println("i am in login");
		driver.findElement(By.id(UserName_ID)).sendKeys(UserName);
		driver.findElement(By.id(Password_ID)).sendKeys(Password);
		driver.findElement(By.id(prop.getProperty("login_id"))).click();	
	}*/

}

/*
 * public class ReadConfigProp { public static WebDriver driver; public static
 * Properties prop; public ReadConfigProp() { try { prop=new Properties(); File
 * src = new File(".\\com\\orangeHRM\\qa\\config\\config.properties");
 * FileInputStream fis = new FileInputStream(src); prop.load(fis);
 * 
 * }
 * 
 * catch(Exception e) { System.out.println("file not found" + e.getMessage()); }
 * }
 * 
 * @Test public static void login() { String
 * browserName=prop.getProperty("browser"); driver.get(prop.getProperty("url"));
 * driver.findElement(By.id(prop.getProperty("username_id"))).sendKeys(prop.
 * getProperty("username"));
 * driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys(prop.
 * getProperty("password"));
 * driver.findElement(By.id(prop.getProperty("login_id"))).click(); }
 * 
 * }
 */