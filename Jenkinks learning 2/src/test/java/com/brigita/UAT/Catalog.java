package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.Catalogmenu;

public class Catalog extends Catalogmenu {


	@Test ( priority = 1, groups= {"Setting"})
	public void TC_001_verify_Setting_Icon_Is_Available_With_Correct_Spelling_And_Clickable() throws InterruptedException 
	{

		verifySettingIcon("Settings");
	}

	@Test ( priority = 2, groups= {"Catalog"})
	public void TC_002_verify_Catalog_Menu_Is_Available_With_Logo_Correct_Spelling_And_Highlighted() throws InterruptedException 
	{

		verifyCataLogMenu("Catalog");
	}

	@Test ( priority = 3, groups= {"Catalog"})
	public void TC_003_verify_Connectors_Displayed_With_In_10_Seconds_In_Catalog_Screen() throws InterruptedException {

		verifyResponseTimeOfConnectors();
	}

	@Test ( priority = 4, groups= {"Catalog"})
	public void TC_004_verify_Nockpoint_Apps_Text_With_Correct_Spelling_In_Catalog_Screen() throws InterruptedException 
	{

		verifyNockpointAppsText();
	}

	@Test ( priority = 5, groups= {"Catalog"})
	public void TC_005_verify_All_Apps_Text_With_Correct_Spelling_In_Catalog_Screen() throws InterruptedException 
	{

		verifyAllAppsText();
	}

	@Test ( priority = 6, groups= {"Catalog"})
	public void TC_006_verify_Search_Field_Is_Available_In_Catalog_Screen() throws InterruptedException 
	{

		verifySearchField();
	}

	@Test (priority = 7, groups= {"Catalog"})
	public void TC_007_verify_All_Connectors_Available_In_Catalog_Screen() throws InterruptedException 
	{
		verifyConnectorsAvailability();
	}

	@Test(priority = 8, groups = {"Catalog"})
	public void TC_08_verify_Connect_Or_Connected_Text_Is_Displaying_After_Hover() throws InterruptedException {

		verifyConnectOrConnectedTextAfterHover();
	}

	@Test(priority = 9, groups = {"Catalog"})
	public void TC_009_verify_Drop_Down_Data_Is_Displaying_As_Expected() throws InterruptedException {

		verifyFilterByCategory();
	}

	@Test(priority = 10, groups = {"Catalog"})
	public void TC_010_verify_Sorting_A_Z_Z_A_Option_Is_Available() throws InterruptedException {

		verifySortOption();
	}

	@Test(priority = 11, groups = {"Catalog"})
	public void TC_011_verify_View_Connected_Apps_Button_Availability() throws InterruptedException {

		verifyAndClickOnViewConnectedApps("View Connected Apps");
	}

	@Test(priority = 12, groups = {"Catalog"})
	public void TC_012_verify_Connected_Apps_Are_Dispalying_With_Connected_Status() throws InterruptedException {

		verifyConnectorStatus();
	}

	@Test(priority = 13,  groups = {"Catalog"})
	public void TC_013_verify_View_All_Apps_Button_Availability() throws InterruptedException {

		verifyAndClickOnViewAllApps("View All Apps");
	}

}
