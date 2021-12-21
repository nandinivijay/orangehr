package com.orangeHRM.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	int i;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	// TITLE=OrangeHRM

//	private final By LOGO = By.id("divLogo");// logoID
//	private final By LPI = By.id("divLoginForm");// logopanelID
//	private final By LD = By.xpath("//*[@id='content']/div[2]/span");// LOGIN_DETAILS_DISPLAY_XPATH
//	private final By MP = By.id("MP_link");// MARKETPLACE_ID
	//private final By HI = By.className("help-icon-div");// HELP_CLASSNAME
//	private final By BI = By.id("notification");// BELL_ID
	//private final By WU = By.id("welcome");// WELCOME_USER_ID
	//private final By TI = By.id("mainMenuFirstLevelUnorderedList");// TITLE_BAR_LIST_ID
//	private final By FI = By.id("footer");// FOOTER_ID
	private final By QL = By.id("panel_draggable_0_0");
	private final By AL=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]/div/a/span");
	private final By LL=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[2]/div/a/span");
	private final By TS=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[3]/div/a/span");
	private final By APL=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[4]/div/a/span");
	private final By ML=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[5]/div/a/span");
	private final By MTS=By.xpath("//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[6]/div/a/span");
	// private final By ED = By.id("panel_wrapper_1");
	private final By ED = By.id("div_graph_display_emp_distribution");
	private final By LE = By.id("panel_draggable_1_1");
	private final By PLR = By.id("panel_draggable_1_2");
	
	
	private final By SEGMENTLIST=By.xpath("//div[@id='div_graph_display_emp_distribution']//span");
	private final By CHART=By.xpath("//canvas[@class='flot-overlay']");
	private final By TOOLTIP=By.xpath("//div[@id='hover_div_graph_display_emp_distribution']");
	private final By LEGENTCOLOR =By.xpath("//td[@class='legendColorBox']/div/div");
	private final By LEGENTTEXT=By.xpath("//td[@class='legendLabel']");
	
			
	/*public WebElement logo() {
		return driver.findElement(LOGO);
	}

	public WebElement logo_panel_id() {
		return driver.findElement(LPI);
	}

	public WebElement login_details_xpath() {
		return driver.findElement(LD);
	}

	public WebElement marketplace_id() {
		return driver.findElement(MP);
	}

	public WebElement help_classname() {
		return driver.findElement(HI);
	}

	public WebElement bell_id() {
		return driver.findElement(BI);
	}

	public WebElement welcome_user_id() {
		return driver.findElement(WU);
	}

	public WebElement titlebar_list_id() {
		return driver.findElement(TI);
	}

	public WebElement footer_id() {
		return driver.findElement(FI);
	}*/
	public WebElement quickLaunch() {
		return driver.findElement(QL);
	}
	public WebElement clickOnAssignLeave() {
		return driver.findElement(AL);
	}
	public WebElement clickOnLeaveList() {
		return driver.findElement(LL);
	}
	public WebElement clickOnTimeSheets() {
		return driver.findElement(TS);
	}
	public WebElement clickOnApplyLeave() {
		return driver.findElement(APL);
	}
	public WebElement clickOnMyLeave() {
		return driver.findElement(ML);
	}
	public WebElement clickOnMyTimeSheet() {
		return driver.findElement(MTS);
	}
	public WebElement emp_Distribution() {
		return driver.findElement(ED);
	}

	public WebElement legend() {
		return driver.findElement(LE);
	}

	public WebElement pending_leave_request() {
		return driver.findElement(PLR);
	}
	
	public List<WebElement> getSegmentsList(){
		return driver.findElements(SEGMENTLIST);
	}
	
	public WebElement chartDetails() {
		return 	driver.findElement(CHART);
	}
	
	public WebElement getToolTip() {
		return driver.findElement(TOOLTIP);
	}
	
	public List<WebElement> getlegendColorBox(){
		
return (driver.findElements(LEGENTCOLOR));
	}
	
	public List<WebElement> getlegentText(){
		
	
	return (driver.findElements(LEGENTTEXT));
}
	
	/*
	public List<WebElement> getsegmenttext() {
		return (driver.findElements(SEGMENTTEXT));
	} */
}
