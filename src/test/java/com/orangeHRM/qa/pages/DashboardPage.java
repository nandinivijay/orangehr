package com.orangeHRM.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.internal.collections.Pair;
import com.orangeHRM.qa.util.ActionsUtil;
import com.orangeHRM.qa.util.SynchronisationWaitsUtil;

public class DashboardPage  {
	WebDriver driver;
	int i;

	public DashboardPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public boolean getcurrentUrl()
	{
		
		return driver.getCurrentUrl().contains("dashboard");
	}

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
	private final By TOOLTIPCOLOR=By.xpath(("//div[@id='hover_div_graph_display_emp_distribution']/span"));
	private final By LEGENTCOLOR =By.xpath("//td[@class='legendColorBox']/div/div");
	private final By LEGENTTEXT=By.xpath("//td[@class='legendLabel']");
	
	
	
	
	//using isDispalyed() method
	public boolean quickLaunchIsDisplayed() {
		return driver.findElement(QL).isDisplayed();
	}
	public boolean AssignLeaveIsDisplayed() {
		return driver.findElement(AL).isDisplayed();
	}
	
	
	public boolean LeaveListIsDisplayed() {
		return driver.findElement(LL).isDisplayed();
	}
	public boolean TimeSheetsIsDispalyed() {
		return driver.findElement(TS).isDisplayed();
	}
	public boolean ApplyLeaveIsDisplayed() {
		return driver.findElement(APL).isDisplayed();
	}
	public boolean MyLeaveIsDisplayed() {
		return driver.findElement(ML).isDisplayed();
	}
	public boolean MyTimeSheetIsDisplayed() {
		return driver.findElement(MTS).isDisplayed();
	}
	public boolean emp_DistributionIsDisplayed() {
		return driver.findElement(ED).isDisplayed();
	}

	public boolean legendIsDisplayed() {
		return driver.findElement(LE).isDisplayed();
	}

	public boolean pending_leave_requestIsDisplayed() {
		return driver.findElement(PLR).isDisplayed();
	}
	
	//clicking elements methods
	
	public AssignLeavePage clickAssignLeave() throws Throwable {
		 driver.findElement(AL).click();
		return new AssignLeavePage(driver); 
	}
	public LeaveListPage clickLeaveList() {
		driver.findElement(LL).click();
		return new LeaveListPage(driver);
	}
	
	public ApplyLeavePage clickApplyLeave() {
		 driver.findElement(APL).click();;
		return new ApplyLeavePage(driver) ;
	}
	public MyLeavePage clickMyLeave() {
		 driver.findElement(ML).click();
		 return new MyLeavePage(driver);
	}
	
	
	public EmployeeTimeSheetsPage clickTimeSheets() {
		 driver.findElement(TS).click();
		 return new EmployeeTimeSheetsPage(driver);
	}
	
	public MyTimeSheetsPage clickMyTimeSheet() {
		 driver.findElement(MTS).click();
		 return new MyTimeSheetsPage(driver);
	}

	

	
	
	
	
	//just returning driver
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
	
	public WebElement gettooltipcolor() {
	//	System.out.println("tooltip colr : "+driver.findElement(TOOLTIPCOLOR)).getCssValue("color"));
		return (driver.findElement(TOOLTIPCOLOR));
	}
	
	/*
	public List<WebElement> getsegmenttext() {
		return (driver.findElements(SEGMENTTEXT));
	} */
	 List<Integer>tooltipvalue=new ArrayList<Integer>();
public Pair<Map,List> getTooltipTotalPercentage() throws Throwable {
	Map<String,String>tooltipTextColor=new HashMap<String,String>();
	
	SynchronisationWaitsUtil.threadsleep(3000);
	 int no_of_segments=getlegentText().size();
	 System.out.println(" no_of_segments :" + no_of_segments);
	//to move cursor to each segment
	ActionsUtil a=new ActionsUtil();
	
	 for(int i=0;i<getlegentText().size();i++) {
		// System.out.println("in for loop");
		 SynchronisationWaitsUtil.threadsleep(3000);
		 //if condition is given as second segmenttext is not displayed in the graph and want to access its textfrom tooltip.
 if(i==1) {
			 
			 ActionsUtil.moveoffset(30,40,driver);
			  System.out.println("tooltip text : "+getToolTip().getText());
				}	else if(i==2) {
			 
			 ActionsUtil.moveoffset(30,50,driver);
			  System.out.println("tooltip text : "+getToolTip().getText());
				} else {
			
		 System.out.println("text" +driver.findElement(By.xpath("//div[@id='div_graph_display_emp_distribution']/span[@id='pieLabel"+i+"']/div")).getText());
	
	 ActionsUtil.movetoelementoffset(driver.findElement(By.xpath("//div[@id='div_graph_display_emp_distribution']/span[@id='pieLabel"+i+"']/div")), 10, 10,driver);
		
		 
		 System.out.println("tooltip text : "+getToolTip().getText());
	//  System.out.println("tooltip style using attribute--tooltipcolor :"+gettooltipcolor().getAttribute("style"));
	  String ttcolor[]=gettooltipcolor().getAttribute("style").split("color: ");
	  String tooltipcolor= ttcolor[1].replace(";","");
	 	 System.out.println("Tooltip color "+ tooltipcolor);
	 		 	 
	 String tooltipText=getToolTip().getText();
	//	System.out.println("text : "+ tooltipText);
	 
	 //adding to map
	 	if(!(tooltipTextColor.containsKey(tooltipText))){
	 		tooltipTextColor.put(tooltipText,tooltipcolor);
	 		}
	 	System.out.println("map of tooltipTextColor" + tooltipTextColor);

		
	 //to split tooltipText with '('
		String tooltipTextArr[]=tooltipText.split("\\(");
		//System.out.println(tooltipTextArr[2]);

		//to get the number with out %
		String tooltipTextSub=	tooltipTextArr[2].substring(0, tooltipTextArr[2].length()-2);
		Double tooltipTextDoubleValue=Double.valueOf(tooltipTextSub);
		
		
	//	System.out.println("tooltipTextSub--- this is without percentage and bracket: "+ tooltipTextSub);
	//	System.out.println("tooltipTextDoubleValue"+ tooltipTextDoubleValue);
	//	System.out.println("After roundup of "+ tooltipTextDoubleValue +"is " +(int) (Math.ceil(tooltipTextDoubleValue)));
		
		//values from graph
	//	Long graphSegmentValue= (Long)NumberFormat.getNumberInstance(java.util.Locale.US).parse(driver.findElement(By.xpath("//div[@id='div_graph_display_emp_distribution']/span[@id='pieLabel"+i+"']/div")).getText());
	//	System.out.println("graphSegmentValue : "+ graphSegmentValue);
		if((tooltipTextDoubleValue-tooltipTextDoubleValue.intValue())>=0.50){
			tooltipvalue.add((int)Math.ceil(tooltipTextDoubleValue));
			System.out.println("After roundup of "+ tooltipTextDoubleValue +"is " +(int) (Math.ceil(tooltipTextDoubleValue)));
			
		}else {
			tooltipvalue.add((int)Math.floor(tooltipTextDoubleValue));
			
		}
	
		 } 
	 }
	 System.out.println("tooltip valut---------List and size"+tooltipvalue +"size" +tooltipvalue.size());
	 return new Pair<Map, List>(tooltipTextColor, tooltipvalue);
	
}


}


