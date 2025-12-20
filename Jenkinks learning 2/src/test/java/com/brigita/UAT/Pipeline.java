package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.Pipelinemenu;

public class Pipeline extends Pipelinemenu {

	@Test ( priority = 1, groups= {"Setting"})
	public void TC_001_verify_Setting_Icon_Is_Available_With_Correct_Spelling_And_Clickable() throws InterruptedException 
	{

		verifySettingIcon("Settings");
	}

	@Test ( priority = 2, groups= {"Pipeline"})
	public void TC_002_verify_Pipeline_Menu_Is_Available_With_Logo_Correct_Spelling_And_Highlighted() throws InterruptedException 
	{

		verifyPipelineMenu("Pipeline");
	}

	@Test ( priority = 3, groups= {"Pipeline"})
	public void TC_003_verify_If_The_Pipeline_List_API_Is_Returning_A_500_Server_Error_Or_Pipeline_Message_Or_Pipeline_Headers_Are_Displaying() throws InterruptedException {

		verifyMessageBodyForNewUserOrExistingPiplelinesForExistingUser("exisingUser");
	}

	@Test (priority =4, groups = {"pipeline"})
	public void TC_004_verify_Create_New_Pipeline_Button_Is_Available_And_Clickable() throws InterruptedException {

		clickOnCreateNewPipelineButton();
	}

	@Test (priority =5, groups = {"pipeline"})
	public void TC_005_verify_Create_New_Pipeline_Text_Is_Available_In_Create_New_Pipeline_Screen() throws InterruptedException {

		verifyTextCreateNewPipeline("Create New Pipeline");
	}

	@Test (priority =6, groups = {"pipeline"})
	public void TC_006_verify_Enter_Pipeline_Name_Text_Availability_Edit_Icon_Clickability_And_Save_Button_Functionality() throws InterruptedException {

		verifyAndClickOnViewConnectedApps("Enter Pipeline Name","Pipeline Name can be Created");
	}

	@Test (priority =7, groups = {"pipeline"})
	public void TC_007_verify_Source_Selection_Dropdown_Is_Available_With_The_Expected_Source_Text() throws InterruptedException {


		verifySourceSelectionDropdownAvailability("Source");
	}

	@Test (priority =8, groups = {"pipeline"})
	public void TC_008_verify_Destination_Selection_Dropdown_Is_Available_With_The_Expected_Destination_Text() throws InterruptedException {

		verifyDestinationSelectionDropdownAvailability("Destination");
	}

	@Test (priority =9, groups = {"pipeline"})
	public void TC_009_verify_Schema_Tab_Avilability_In_Create_New_Pipeline_Screen() throws InterruptedException {

		verifySchemaTabsAvailability("Schema");
	}

	@Test (priority =10, groups = {"pipeline"})
	public void TC_010_verify_Sync_Details_Tab_Avilability_In_Create_New_Pipeline_Screen() throws InterruptedException {

		verifySyncDetialsTabAvailability("Sync Details");
	}

	@Test (priority =11, groups = {"pipeline"})
	public void TC_011_verify_Downstream_Tab_Avilability_In_Create_New_Pipeline_Screen() throws InterruptedException {

		verifyDownstreamTabAvailability("DownStream");
	}

	@Test (priority = 12, groups = {"pipeline"})
	public void TC_012_verify_Schema_Tab_Dispalying_The_Message() throws InterruptedException {

		verifySchemaTabAvailability("Please select the source & the destination to proceed further.");
	}

}
