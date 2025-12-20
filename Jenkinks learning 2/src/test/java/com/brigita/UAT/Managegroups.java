package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.ManageGroups;

public class Managegroups extends ManageGroups {

	@Test(priority = 1, groups = {"Setting"})
	public void TC_001_verify_Setting_Icon_Is_Available_With_Correct_Spelling_And_Clickable() throws InterruptedException {
		clickSettingIcon();
	}

	@Test(priority = 2, groups = {"Managegroups"})
	public void TC_002_verify_Create_Button_Is_Available_And_Clickable() throws InterruptedException {
		verifyAndClickCreateButton();
	}

	@Test(priority = 3, groups = {"Managegroups"})
	public void TC_003_verify_Create_Dashboard_Group_Popup_Is_Displayed() throws InterruptedException {
		verifyCreateDashboardGroupPopup();
	}

	@Test(priority = 4, groups = {"Managegroups"})
	public void TC_004_enter_Dashboard_Group_Name() throws InterruptedException {
		enterDashboardGroupName();
	}

	@Test(priority = 5, groups = {"Managegroups"})
	public void TC_005_enter_Dashboard_Group_Display_Name() throws InterruptedException {
		enterDashboardGroupDisplayName();
	}

	@Test(priority = 6, groups = {"Managegroups"})
	public void TC_006_enter_Dashboard_Group_Description() throws InterruptedException {
		enterDashboardGroupDescription();
	}

	@Test(priority = 7, groups = {"Managegroups"})
	public void TC_007_save_Dashboard_Group_Without_Selecting_Dashboard() throws InterruptedException {
		saveDashboardGroup("Not select dashboard");
	}

	@Test(priority = 8, groups = {"Managegroups"})
	public void verifyDashboardGroupDetailsInPaginationWithoutGroupName() {
		verifyDashboardGroupDetailsInPaginationWithoutGroupName( generatedDisplayName, generatedDescription);
	}

//	@Test(priority = 9, groups = {"Managegroups"})
//	public void TC_009_verify_Edit_Dashboard_Group_Icon_Functionality() throws InterruptedException {
//		verifyEditDashboardGroupFunctionality(generatedDisplayName);
//	}

	@Test(priority = 10, groups = {"Managegroups"})
	public void TC_010_verify_Edit_Dashboard_Group_Popup_Is_Displayed() throws InterruptedException {
		verifyEditDashboardGroupPopup();
	}

	@Test(priority = 11, groups = {"Managegroups"})
	public void TC_011_enter_Dashboard_Group_Name_In_Edit_Flow() throws InterruptedException {
		enterDashboardGroupNameInEditFlow();
	}

	@Test(priority = 12, groups = {"Managegroups"})
	public void TC_012_enter_Dashboard_Group_Display_Name_In_Edit_Flow() throws InterruptedException {
		enterDashboardGroupDisplayNameInEditFlow();
	}

	@Test(priority = 13, groups = {"Managegroups"})
	public void TC_013_enter_Dashboard_Group_Description_In_Edit_Flow() throws InterruptedException {
		enterDashboardGroupDescriptionInEditFlow();
	}

	@Test(priority = 14, groups = {"Managegroups"})
	public void TC_014_save_Dashboard_Group_In_Edit_Flow_Without_Selecting_Dashboard() throws InterruptedException {
		saveDashboardGroupInEditFlow("Not select dashboard");
	}

	@Test(priority = 15, groups = {"Managegroups"})
	public void TC_015_verify_Dashboard_Group_Details_In_Pagination_After_Edit_Flow() {
		verifyDashboardGroupDetailsInPaginationineditflow(generatedDisplayNameInEditFlow,generatedDescriptionInEditFlow);
	}
}
