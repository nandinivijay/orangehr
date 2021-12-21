package com.orangeHRM.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AttatchmentsUtil {

	public static void toolTipValidation(WebElement toolTipClickElement,WebDriver driver)
	{
        //xpath of element where we will get tooltip is toolTipClickElement
		 // Creating Actions class object by using ActionsUtilClass
        ActionsUtil.moveToElement(toolTipClickElement,driver);
      //xpath of tooltip
		WebElement toolTipElement = driver.findElement(By.xpath("//*[@id='tiptip_content']"));
		
	    //Getting tooltip text using getText() method and store into String
        String tooltipText = toolTipElement.getAttribute("textContent");
        System.out.println("Tool tip Text : "+tooltipText);
        //validating tooltip using assert method
        Assert.assertEquals(tooltipText, "Click to download");
        
        System.out.println(tooltipText);
	
	}
	
	 public static void verifyDownloadWithFileName(WebElement element) throws Exception 
	  {
		  
		  String filename = element.getText(); 
		  File downloadPathfile = new File("./downloads/");
		  //String fileDownloadPath = "C:\\Users\\pruthvi\\downloads";
		  String fileDownloadPath = downloadPathfile.getCanonicalPath();
			/*
			 * Map<String, Object> prefsMap = new HashMap<String, Object>();
			 * prefsMap.put("profile.default_content_settings.popups", 0);
			 * prefsMap.put("download.default_directory", fileDownloadPath);
			 * 
			 * ChromeOptions option = new ChromeOptions();
			 * option.setExperimentalOption("prefs", prefsMap);
			 * option.addArguments("--test-type");
			 * option.addArguments("--disable-extensions");
			 * 
			 * WebDriver driver1 = new ChromeDriver(option);
			 */
		  
		  SynchronisationWaitsUtil.threadsleep(2000);
		  element.click();
		  System.out.println("Downloaded");
		  Assert.assertTrue(isFileDownloaded(fileDownloadPath, filename));
		  SynchronisationWaitsUtil.threadsleep(2000);
		  //driver1.close();
	 
	  }
	 private static boolean isFileDownloaded(String downloadPath1, String filename1) 
	 {
		  boolean flag = false;
		  File dir = new File(downloadPath1);
		  File[] dir_contents = dir.listFiles();
		  for (int i = 0; i < dir_contents.length; i++) 
		  { 
			 if(dir_contents[i].getName().equals(filename1)) 
				 return flag=true; 
		 }
			  
		 return flag; 
	  }
	 
	 public static void uploadingFileUsingRobot(WebElement ele,WebDriver driver,String fName) throws Exception
	 {
		 JavascriptExecutorUtil.clickingOnElement(driver, ele);
			SynchronisationWaitsUtil.threadsleep(5000);
					  
			// creating object of Robot class 
			Robot rb = new Robot();
					  
			// copying File path to Clipboard
			File file = new File("./attachments/images/"+fName);
			//C:\Users\pruthvi\eclipse-workspace\LatestOrangeSprint\attachments\images\smallbird.jpg
			StringSelection str = new StringSelection(file.getCanonicalPath());
			System.out.println("Canonical Path : "+ file.getCanonicalPath());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
					  
			// press Contol+V for pasting 
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
					  
			// release Contol+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			
			rb.keyRelease(KeyEvent.VK_V);
					  
			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
	 }
	 
	 public static void uploadingFileUsingAutoIT(WebElement ele,WebDriver driver,String fName) throws Exception
	 {
		  JavascriptExecutorUtil.clickingOnElement(driver, ele);
		  //SynchronisationWaitsUtil.threadsleep(5000);
		  File file = new File("./attachments/images/"+fName);
		  Runtime.getRuntime().exec("./attachments/fileUpload.exe"+" "+file.getCanonicalPath());
		  System.out.println("Canonical Path : "+ file.getCanonicalPath());
				  
		  SynchronisationWaitsUtil.threadsleep(2000);
	 }
	 
	 public static void editFileLink(String filename,WebDriver driver,WebElement ele) throws Exception
	 {
		 //String filename = "smallbird1.jpg";
			AttatchmentsUtil.uploadingFileUsingRobot(ele, driver,filename);
			System.out.println("Replaced file : "+filename);
			
			Assert.assertTrue(driver.findElement(By.id("btnSaveAttachment")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.id("btnCommentOnly")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.id("cancelButton")).isDisplayed());
			driver.findElement(By.id("btnSaveAttachment")).click();
			SynchronisationWaitsUtil.threadsleep(5000);
			String filename1 = driver.findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).getText();//driver.findElement(By.linkText(filename)).getText();
			System.out.println("File : "+filename1);
			Assert.assertEquals(filename1,filename);
	 }
	 
	 public static void validatingTableHeader(WebDriver driver)
	 {
		 List<WebElement> li = driver.findElements(By.xpath("//*[@id='tblAttachments']/thead/tr/th"));
		 int n = li.size();
		 List<String> s = new ArrayList<String>();
		 System.out.println("size of Columns : "+n);
		 for(int i=0;i<n;i++) 
		 {
			 s.add(li.get(i).getText()); } System.out.println("List String : "+s);
			 System.out.println("No . of columns in a table are : "+n);
			 Assert.assertEquals(8,n);
				  
			 for(int i=1; i<=n; i++)
			 {
				 WebElement header=driver.findElement(By.xpath("//*[@id=\"tblAttachments\"]/thead/tr/th["+ i +"]")); 
				 System.out.print(header.getText());
				  
				 if(header.getText().equalsIgnoreCase("filename")) 
				 {
					 System.out.println(" : is in the header" );
					 Assert.assertTrue(header.getText().contains("filename")); } else
					 if(header.getText().equalsIgnoreCase("Description")) 
					 {
						 System.out.println(" : is  in the header ");
						 Assert.assertTrue(header.getText().contains("Description")); } else
				  if(header.getText().equalsIgnoreCase("Size")) {
				  System.out.println(": is in the header");
				  Assert.assertTrue(header.getText().contains("Size")); }
				  
				  else if(header.getText().equalsIgnoreCase("Type")) {
				  System.out.println(": is in the header");
				  Assert.assertTrue(header.getText().contains("Type")); } else
				  if(header.getText().equalsIgnoreCase("Date Added")) {
				  System.out.println(": is in the header");
				  Assert.assertTrue(header.getText().contains("Date Added")); } else
				  if(header.getText().equalsIgnoreCase("Added By")) {
				  System.out.println(": is in the header");
				  Assert.assertTrue(header.getText().contains("Added By")); } else {
				  System.out.println(" The given text is not in the header"); 
			}
		}		  
	 }

public static void uploadingFileUsingRobotInmac(WebElement ele, WebDriver driver,String fName) throws Exception {
		//JavascriptExecutorUtil.clickingOnElement(driver, ele);
		SynchronisationWaitsUtil.threadsleep(5000);
		File file = new File(fName);
		//File file2 = new File("./attachments/images/"+fName);

	    StringSelection StringSelection = new StringSelection(file.getAbsolutePath());
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);
		
	   	    
	    Robot robot = null;
	    try {
	        robot = new Robot();
	    } catch (AWTException e) {
	        e.printStackTrace();
	    }
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_TAB);
	    robot.delay(500);

	    //Open Goto window
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_SHIFT);
	    robot.keyPress(KeyEvent.VK_G);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_SHIFT);
	    robot.keyRelease(KeyEvent.VK_G);
	    //robot.keyPress(KeyEvent.VK_ESCAPE);
	    

	    //Paste the clipboard value
	    robot.keyPress(KeyEvent.VK_META);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_META);
	    robot.keyRelease(KeyEvent.VK_V);
	    //robot.keyPress(KeyEvent.VK_ESCAPE);

	    //Press Enter key to close the Goto window and Upload window
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot.delay(500);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    //robot.keyPress(KeyEvent.VK_ESCAPE);*/

	    ele.sendKeys(file.getAbsolutePath());
	   
	    	}
}
	