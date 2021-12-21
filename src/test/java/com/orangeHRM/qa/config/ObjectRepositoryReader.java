package com.orangeHRM.qa.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ObjectRepositoryReader {

		public Properties orProp;
		public  ObjectRepositoryReader()
		{
			try
			{
				orProp=new Properties();
				File src = new File("./src/test/java/com/orangeHRM/qa/config/ObjectRepository.properties");
				FileInputStream fis = new FileInputStream(src);
				orProp.load(fis);
					
			}
			catch(Exception e)
			{
				System.out.println("file not found"  + e.getMessage());
			}
		}
		
		public String getTitle()
		{
			String titleId = orProp.getProperty("TITLE");
			return titleId;
		}
		public String getLogoId()
		{
			String logoId = orProp.getProperty("LOGO_ID");
			return logoId;
		}
		
		public String getLoginPanelId()
		{
			String loginpanelId = orProp.getProperty("LOGIN_PANEL_ID");
			return loginpanelId;
		}

		public String getMarketPlaceId()
		{
			String marketplaceId = orProp.getProperty("MARKETPLACE_ID");
			return marketplaceId;
		}

		public String getLoginDetailsDisplayXpath()
		{
			String loginDetailsDisplayXpath = orProp.getProperty("LOGIN_DETAILS_DISPLAY_XPATH");
			return loginDetailsDisplayXpath;
		}
		
		public String getAfterLoginLogoDisplayXpath()
		{
			String afterLoginLogoDisplayXpath = orProp.getProperty("AFTER_LOGIN_LOGO_XPATH");
			return afterLoginLogoDisplayXpath;
		}

		public String getHelpClassName()
		{
			String helpClassName = orProp.getProperty("HELP_CLASSNAME");
			return helpClassName;
		}
		public String getAboutId()
		{
			String aboutId = orProp.getProperty(getAboutId());
			return aboutId;
		}

		public String getBellId()
		{
			String bellId = orProp.getProperty("BELL_ID");
			return bellId;
		}
		
		public String getSubscribeButtonId()
		{
			String subscribeId = orProp.getProperty("SUBSCRIBE_BUTTON_ID");
			return subscribeId;
		}

		public String getWelcomeUserId()
		{
			String welcomeUserId = orProp.getProperty("WELCOME_USER_ID");
			return welcomeUserId;
		}

		public String getTitleBarListId()
		{
			String titleBarListId = orProp.getProperty("TITLE_BAR_LIST_ID");
			return titleBarListId;
		}

		public String getFooterId()
		{
			String footerId = orProp.getProperty("FOOTER_ID");
			return footerId;
		}
		
		public String getAdminId()
		{
			String adminId = orProp.getProperty("ADMIN_ID");
			return adminId;
		}
		
		public String getPIMId()
		{
			String pimId = orProp.getProperty("PIM_ID");
			return pimId;
		}
		
		public String getLeaveId()
		{
			String leaveId = orProp.getProperty("LEAVE_ID");
			return leaveId;
		}
		
		public String getTimeId()
		{
			String timeId = orProp.getProperty("TIME_ID");
			return timeId;
		}
		
		public String getRecritmentId()
		{
			String recritmentId = orProp.getProperty("RECRUITMENT_ID");
			return recritmentId;
		}
		
		public String getMyinfoIdId()
		{
			String myinfoId = orProp.getProperty("MYINFO_ID");
			return myinfoId;
		}
		
		public String getPerformanceId()
		{
			String performanceId = orProp.getProperty("PERFORMANCE_ID");
			return performanceId;
		}
		
		public String getDashboardId()
		{
			String dashboardId = orProp.getProperty("DASHBOARD_ID");
			return dashboardId;
		}
		
		public String getDirectoryId()
		{
			String directoryId = orProp.getProperty("DIRECTORY_ID");
			return directoryId;
		}
		
		public String getMaintenanceId()
		{
			String maintenanceId = orProp.getProperty("MAINTENANCE_ID");
			return maintenanceId;
		}
		
		public String getBuzzId()
		{
			String buzzId = orProp.getProperty("BUZZ_ID");
			return buzzId;
		}


}

