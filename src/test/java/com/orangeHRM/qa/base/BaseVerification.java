package com.orangeHRM.qa.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangeHRM.qa.config.ObjectRepositoryReader;
import com.orangeHRM.qa.config.ReadConfigProp;
import com.orangeHRM.qa.pages.AdminPage;
import com.orangeHRM.qa.pages.BuzzPage;
import com.orangeHRM.qa.pages.DashboardPage;
import com.orangeHRM.qa.pages.DirectoryPage;
import com.orangeHRM.qa.pages.LeavePage;
import com.orangeHRM.qa.pages.MaintenancePage;
import com.orangeHRM.qa.pages.MyInfoPage;
import com.orangeHRM.qa.pages.PIMPage;
import com.orangeHRM.qa.pages.PerformancePage;
import com.orangeHRM.qa.pages.RecruitmentPage;
import com.orangeHRM.qa.pages.TimePage;
import com.orangeHRM.qa.pages.WelcomeUserPage;

public class BaseVerification {
	
		WebDriver driver;
		//static BaseClass base = new BaseClass();
		ReadConfigProp readConfigProp = new ReadConfigProp();
		ObjectRepositoryReader objectRepositoryReader=new ObjectRepositoryReader();
		
		public BaseVerification(WebDriver driver)
		{
			this.driver=driver;
		}

		/*
		 * @BeforeTest public void setUp() throws IOException { BaseClass.initialise();
		 * BaseClass.loadUrl(); //objectRepositoryReader = new ObjectRepositoryReader(); }
		 */
		
		public  String verifyOrangeHRMTitle()
		{
			/*
			 * String title = BaseClass.driver.getTitle();
			 * System.out.println("Page Title is : "+title);
			 */
			return driver.getTitle();
			//String title1 = ReadConfigProp.prop.getProperty("title");
			/*
			 * String title1=objectRepositoryReader.getTitle(); Assert.assertEquals(title,title1);
			 */
		}
		
		public boolean isTitleContains() {
			
			return driver.getTitle().contains("OrangeHRM");
		}
		
		public boolean currentUrl(String url)
		{
			
			return driver.getCurrentUrl().contains(url);
		}
		
		
		public WebElement getLogo_id()
		{
			return driver.findElement(By.id(objectRepositoryReader.getLogoId()));
		}
		
		
		public WebElement getLogindetailsDisplayed_xpath()
		{
			String userPwd = driver.findElement(By.xpath(objectRepositoryReader.getLoginDetailsDisplayXpath())).getText();
			System.out.println("Login details : "+ userPwd);
			return driver.findElement(By.xpath(objectRepositoryReader.getLoginDetailsDisplayXpath()));
		}
		
		
		public WebElement getLoginPanel_id()
		{
			return driver.findElement(By.id(objectRepositoryReader.getLoginPanelId()));
		}
		
		/*
		 * public void login() {
		 * driver.findElement(By.id(readConfigProp.getUserId())).sendKeys(readConfigProp.getUserName());
		 * driver.findElement(By.id(readConfigProp.getPasswordId())).sendKeys(readConfigProp.getPassword());
		 * driver.findElement(By.id(readConfigProp.getLoginID())).click(); }
		 */
		
		
		
		
		public WebElement getAbout_id()
		{
			return driver.findElement(By.id(objectRepositoryReader.getAboutId()));
		}
		public WebElement getAfterLoginLogo_id()
		{
			//login();
			return driver.findElement(By.xpath(objectRepositoryReader.getAfterLoginLogoDisplayXpath()));
		}
		
		public WebElement getWelcomeUser_id()
		{
			//login();
			return driver.findElement(By.id(objectRepositoryReader.getWelcomeUserId()));
		}
		
		public WebElement getMarketPlace_id()
		{
			//login();
			return driver.findElement(By.id(objectRepositoryReader.getMarketPlaceId()));
		}
		
		
		public WebElement getBellIcon_id()
		{
			//login();
			return driver.findElement(By.id(objectRepositoryReader.getBellId()));
		}
		
		public WebElement getSubscribeButton_id()
		{
			//login();
			return driver.findElement(By.id(objectRepositoryReader.getSubscribeButtonId()));
		}
		
		public WebElement getHelpIcon_id()
		{
			//BaseClass.login();
			return driver.findElement(By.className(objectRepositoryReader.getHelpClassName()));
		}
		
		
		public WebElement getTitleBarList_id()
		{
			//BaseClass.login();
			return driver.findElement(By.id(objectRepositoryReader.getTitleBarListId()));
		}
		
		
		public WebElement getFooter_id()
		{	
			//BaseClass.login();
			return driver.findElement(By.id(objectRepositoryReader.getFooterId()));
		}
		
		public WebElement getAdmin_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getAdminId()));
		}
		
		public WebElement getPIM_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getPIMId()));
		}
		
		public WebElement getLeave_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getLeaveId()));
		}
		
		public WebElement getTime_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getTimeId()));
		}
		
		public WebElement getRecruitment_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getRecritmentId()));
		}
		
		public WebElement getMyinfo_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getMyinfoIdId()));
		}
		
		public WebElement getPerformance_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getPerformanceId()));
		}
		
		public WebElement getDashboard_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getDashboardId()));
		}
		
		public WebElement getDirectory_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getDirectoryId()));
		}
		
		public WebElement getMaintenance_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getMaintenanceId()));
		}
		
		public WebElement getBuzz_id()
		{	
			return driver.findElement(By.id(objectRepositoryReader.getBuzzId()));
		}
		/*public AfterLoginLogoPage navigatingToAfterLoginLogo()
		{
			getAfterLoginLogo_id().click();
			return new AfterLoginLogoPage(driver);
		}*/
		
		public WelcomeUserPage navigatingToWelcomeUser()
		{
			getWelcomeUser_id().click();
			return new WelcomeUserPage(driver);
		}
		
		/*public HelpIconPage navigatingToHelpIcon()
		{
			getHelpIcon().click();
			return new HelpIconPage(driver);
		}*/

		public AdminPage navigatingToAdmin()
		{
			getAdmin_id().click();
			return new AdminPage(driver);
		}
			
		public PIMPage navigatingToPIM()
		{
			getPIM_id().click();
			return new PIMPage(driver);
		}
		
		public LeavePage navigatingToLeave()
		{
			getLeave_id().click();
			return new LeavePage(driver);
		}
		
		public TimePage navigatingToTime()
		{
			getTime_id().click();
			return new TimePage(driver);
		}
		
		public RecruitmentPage navigatingToRecruitment()
		{
			getRecruitment_id().click();
			return new RecruitmentPage(driver);
		}
		
		public MyInfoPage navigatingToMyInfo()
		{
			getMyinfo_id().click();
			return new MyInfoPage(driver);
		}
		public PerformancePage navigatingToPerformance()
		{
			getPerformance_id().click();
			return new PerformancePage(driver);
		}
		
		public DashboardPage navigatingToDashboard()
		{
			getDashboard_id().click();
			return new DashboardPage(driver);
		}
		
		public DirectoryPage navigatingToDirectory()
		{
			getDirectory_id().click();
			return new DirectoryPage(driver);
		}
		
		public MaintenancePage navigatingToMaintenance()
		{
			getMaintenance_id().click();
			return new MaintenancePage(driver);
		}
		
		public BuzzPage navigatingToBuzz()
		{
			getBuzz_id().click();
			return new BuzzPage(driver);
		}
		
		
}

