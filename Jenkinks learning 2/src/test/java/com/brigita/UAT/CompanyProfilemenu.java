package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.Companyprofile;

public class CompanyProfilemenu extends Companyprofile {


	// ===================== Settings =====================

	@Test(priority = 1, groups = {"Settings", "Smoke"})
	public void TC_001_Verifies_the_visibility_of_the_Setting_Icon_and_tooltip_text() throws InterruptedException {
		verifySettingIcon("Settings");
	}

	// ===================== Company Profile Navigation =====================

	@Test(priority = 2, groups = {"CompanyProfile", "Smoke"})
	public void TC_002_Verifies_Company_Profile_menu_display_under_Settings() throws InterruptedException {
		verifyCompanyProfile("Company Profile");
	}

	@Test(priority = 3, groups = {"CompanyProfile", "Smoke"})
	public void TC_003_Verifies_Company_Profile_text_at_left_navigation() throws InterruptedException {
		verifyCompanyProfileTextAtLeftNavigation("Company Profile");
	}

	// ===================== Company Name =====================

	@Test(priority = 4, groups = {"CompanyName", "Regression"})
	public void TC_004_Verifies_Company_Name_and_Plan_Validity_display() throws InterruptedException {
		verifyCompanyName("BRIGITA1");
	}

	@Test(priority = 5, groups = {"CompanyName", "Regression"})
	public void TC_005_Verifies_Company_Name_Label_Value_and_Save_Button() throws InterruptedException {
		verifyCompanyNameLabel_Values_SaveButton("BRIGITA1");
	}

	@Test(priority = 6, groups = {"CompanyName", "Regression"})
	public void TC_006_Verifies_Company_Name_edit_flow_and_reflection_across_UI() throws InterruptedException {
		verifyCompanyNameValueviaEditing("BRIGITA12345");
	}

	// ===================== User Management =====================

	@Test(priority = 7, groups = {"UserManagement", "Regression"})
	public void TC_007_Verifies_No_of_Users_count() throws InterruptedException {
		verifyNoOfUsersCount("2");
	}

	// ===================== Subscription =====================

	@Test(priority = 8, groups = {"Subscription", "Regression"})
	public void TC_008_Verifies_Subscription_Plan_value() throws InterruptedException {
		verifySubscriptionPlan("Basic");
	}

	@Test(priority = 9, groups = {"Subscription", "Regression"})
	public void TC_009_Verifies_Plan_Status_value() throws InterruptedException {
		verifyPlanStatus("Active");
	}

	@Test(priority = 10, groups = {"CompanyProfile", "Regression"})
	public void TC_010_Verifies_TUID_value_and_profile_menu_display() throws InterruptedException {
		verifyTuid("EG7WMNE3W6IS");
	}
}
