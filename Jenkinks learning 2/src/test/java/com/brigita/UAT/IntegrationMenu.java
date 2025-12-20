package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.Integrationmenu;

public class IntegrationMenu extends Integrationmenu {



	@Test(priority=1,groups = {"Integration"})
	public void TC_001_confirm_That_Integration_Menu_Is_Available_On_Settings_Page() throws InterruptedException {

		clickSettingIcon();
	}

	@Test (priority=2, groups= {"Integration"})
	public void TC_002_measure_Integration_Menu_Load_Time_To_Display_Connected_Integrations() throws InterruptedException {

		verifyTableBodyVisibility();
	}

	@Test (priority=3,groups = {"Integration"})
	public void TC_003_confirm_The_Visibility_Of_Integration_List_Header() throws InterruptedException {

		verifyintegrationlistheader();

	}

	@Test(priority=4, groups= {"Integration"})
	public void TC_004_check_Integration_Menu_Displays_Expected_Elements() throws InterruptedException {

		verifyDefaultIntegration();
	}

	@Test(priority=5, groups= {"Integration"})
	public void TC_005_verify_Each_Integration_Headers_Are_Displayed() throws InterruptedException {

		verifyHeadersInInterationScreen();
	}

	@Test(priority=6, groups= {"Integration"})
	public void TC_006_verify_Connector_Status_In_Header() throws InterruptedException {

		String applicationToVerify = "NP Snowflake";
		verifystatusforconnector(applicationToVerify);

	}

	@Test (priority=7, groups= {"Integration"})
	public void TC_007_confirm_Integration_List_Displayed() throws InterruptedException	{

		veriySizeOfConnectedIntegrations();
	}

	@Test(priority=8,dependsOnMethods="TC_007_confirm_Integration_List_Displayed", groups= {"Integration"})
	public void TC_008_ensure_Pagination_Functions_Correctly() throws InterruptedException {

		validateAndHandlePagination();
		veriySizeOfConnectedIntegrations();

	}

	@Test (priority=9, groups= {"Integration"})
	public void TC_009_ensure_Users_Can_Navigate_To_LastPage() throws InterruptedException {

		moveLastPagination();

	}

	@Test (priority=10, groups= {"Integration"})
	public void TC_010_ensure_Users_Can_Navigate_To_FirstPage() throws InterruptedException {

		moveFirstPagination();

	}

	@Test (priority=11, groups= {"Integration"})
	public void TC_011_verify_Overall_Schema_Refresh_Success() throws InterruptedException {

		overallSchemaRefresh();

	}

	@Test (priority=12, groups= {"Integration"})
	public void TC_012_verify_Reauthorize_Button_Availability_Clickability() throws InterruptedException {

		verifyReauthorizeAvailabilityClickability();
	}

	@Test (priority=13, groups= {"Integration"})
	public void TC_013_verify_Connector_Details_In_ViewDetails_Icon() throws InterruptedException {

		verifyViewDetails();
	}

}
