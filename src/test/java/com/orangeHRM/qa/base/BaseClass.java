
package com.orangeHRM.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orangeHRM.qa.config.ReadConfigProp;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass /* implements ITestListener */  {
	
	
		String browserName;
		public static WebDriver driver = null;
		ReadConfigProp readConfigProp = new ReadConfigProp();

		@BeforeClass
		public void initialise() throws IOException
		{
			
			browserName = readConfigProp.getBrowser();
			System.out.println("Browser Activating "+browserName);
			if(driver==null)
			{
				switch (browserName) {
				
				case "Chrome":
					System.out.println("Entered switch");
					WebDriverManager.chromedriver().setup();
					File parentDirectoryPathfile = new File("./downloads");
					String downloadFilepath = parentDirectoryPathfile.getCanonicalPath();
					//APP_LOGS.debug("Chrome Download path set to: "+downloadFilepath);
					File downloadFolder = new File(downloadFilepath);
					if (!downloadFolder.exists()){
					      downloadFolder.mkdir();
					 }
				
					Map<String, Object> prefs = new HashMap<>();
					prefs.put("download.default_directory", downloadFilepath);
					prefs.put("download.prompt_for_download", false);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", prefs);
					 driver = new ChromeDriver(options);
					//driver = new ChromeDriver();
					
					//System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe");			 
					//driver.get("http://www.gmail.com");
					break;
					
				case "Firefox":
					
					//System.setProperty("webdriver.chrome.driver", "./Browsers/geckodriver.exe");
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					break;
					
				case "IE":
					
					//System.setProperty("webdriver.chrome.driver", "./Browsers/IEDriverServer.exe");
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
					break;
					
				case "Edge":
					
					//System.setProperty("webdriver.chrome.driver", "./Browsers/safaridriver.exe");
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					break;
				default :
					
					System.out.println("No browser value is given");
				}
				System.out.println("Exited Switch");
			}
			driver.manage().window().maximize();
		}
		@BeforeClass
		public void loadUrl()
		{
			String url1 = readConfigProp.getURL();
			driver.get(url1);
		}

		
		@BeforeClass
		public void testcontext(ITestContext context) {
			 System.out.println("driver : "+driver);
	 		context.setAttribute("driver1",driver);
	 		System.out.println("drivername is set to context instance");
	 	
	 	}
		//@Test
		public void login()
		{
			driver.findElement(By.id(readConfigProp.getUserId())).sendKeys(readConfigProp.getUserName());
			driver.findElement(By.id(readConfigProp.getPasswordId())).sendKeys(readConfigProp.getPassword());
			driver.findElement(By.id(readConfigProp.getLoginID())).click();
		}
		
		
		
				
		@AfterClass
		public void close()
		{
			System.out.println("Closing Browser");
			driver.close();
			driver = null;
		}
		//@AfterSuite
		public void quit()
		{
			System.out.println("Quitting Browser");
			driver.quit();
			driver = null;
		}
		
}