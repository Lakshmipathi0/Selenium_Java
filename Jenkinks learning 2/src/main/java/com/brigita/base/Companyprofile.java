package com.brigita.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class Companyprofile extends BaseTest {


	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By compayProfile = By.xpath("//span[text()='Company Profile '] ");
	By companyProfileatleftside = By.xpath("//h3[text()='Company Profile']");
	By verifycompanyname = By.xpath("//h3[text()='Company Profile']/following-sibling::div//h3[contains(@class,'font-weight-bold')]");
	By verifyPlanValidity = By.xpath("//h3[text()='Company Profile']/following-sibling::div//h3[contains(@class,'font-weight-bold')]/following-sibling::div[text()='Plan validity: N/A']");
	By verifyCompanyNameLabel = By.xpath("//p[text()='Company Name']");
	By verifyCompanyNameLebelValue = By.xpath("//p[text()='Company Name']/following-sibling::span/input[@type='text']");
	By verifyCompanyNameLebelSaveButton = By.xpath("//p[text()='Company Name']/following-sibling::span/input[@type='text']/following-sibling::span/i[@ptooltip='Save']");
	By PROFILE_ICON = By.xpath("//img[@id=\"user-icon\"]");
	By PROFILE_ORG_NAME_TUID = By.xpath("//div[@class='_unSelectedOrg _curpointer _orgSelectedClass']");
	By NO_OF_USERS_LABEL = By.xpath("//p[text()='No of Users']");
	By NO_OF_USERS_VALUE = By.xpath("//p[text()='No of Users']/following-sibling::div");
	By SUBSCRIPTION_PLAN_LABEL = By.xpath("//p[text()='Subscription Plan']");
	By SUBSCRIPTION_PLAN_VALUE = By.xpath("//p[text()='Subscription Plan']/following-sibling::div");
	By PLAN_STATUS_LABEL = By.xpath("//p[text()='Plan Status']");
	By PLAN_STATUS_VALUE = By.xpath("//p[text()='Plan Status']/following-sibling::div");
	By TUID_LABEL = By.xpath("//p[text()='Tuid']");
	By TUID_VALUE = By.xpath("//p[text()='Tuid']/following-sibling::div");


	/**
	 * 
	 * @author Lakshmipathi Use of Method : Verifies the visibility of the Setting Icon and the tooltip text displayed upon hovering.
	 * @param  toolTip : Expected tooltip text(Setting) displayed after hovering over the setting icon.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifySettingIcon(String toolTip) throws InterruptedException {

		WebElement settingicon = BaseTest.createWebElement(settingIcon);

		try {

			TestReporter.log("==== Test Start: Verifying Setting Icon ====");

			TestReporter.log("Step 1: Verifying that the Setting Icon is available.");
			Assert.assertTrue(settingicon.isDisplayed(), "FAILED: Setting Icon is not displayed.");
			TestReporter.log("SUCCESS: Setting Icon is displayed.");

			TestReporter.log("Step 2: Verifying the tooltip text on the Setting Icon.");
			String toolTipText = settingicon.getAttribute("ptooltip");
			Assert.assertTrue(toolTipText.equals(toolTip), "FAILED: Tooltip text does not match expected value. Found: " + toolTipText);
			TestReporter.log("SUCCESS: Tooltip text is correct. Tooltip: " + toolTipText);

			TestReporter.log("Step 3: Clicking on the Setting Icon.");
			BaseTest.clickOperation(settingicon);
			TestReporter.log("SUCCESS: Setting Icon clicked successfully.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Setting Icon.");	        
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Setting Icon ====");
		}
	}


	/**
	 * 
	 * @author Lakshmipathi Use of Method Validate that the Company Profile menu is displayed under the Settings icon with correct spelling and becomes highlighted when clicked.
	 * @param CompanyProfile - Verifies the actual company profile text with the expected and correct company profile text
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyCompanyProfile(String expectedCompanyProfile) throws InterruptedException {

		WebElement companyProfile = BaseTest.createWebElement(compayProfile);

		try {
			TestReporter.log("==== Test Start: Verifying Company Profile Menu ====");

			TestReporter.log("Step 1: Validate that the Company Profile menu is displayed under the Settings icon with correct spelling");
			String name = companyProfile.getText().trim();
			Assert.assertTrue(name.equals(expectedCompanyProfile), "FAILED: Company Profile menu is not displyed under settings icon with correct spelling");
			TestReporter.log("SUCCESS: Company profile menu is displayed under settings icon with correct spelling");

			TestReporter.log("Step 2: Validate that the Company Profile menu is highlighted when clicked.");
			BaseTest.clickOperation(companyProfile);
			Assert.assertTrue(companyProfile.isEnabled(), "FAILED: Company profile menu is not highlighted when clicked.");
			TestReporter.log("SUCCESS: Company profile menu is highlighted when clicked");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occured while verifying the company profile menu");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Company Profile Menu ====");
		}

	}

	/**
	 * 
	 * @author Lakshmipathi Use os Method: Validate that the Company Profile text appears on the left side of the Company Profile page with correct spelling.
	 * @param companyProfile - Validates Company Profile text is visible on the left side of the screen
	 * @throws InterruptedException :  If the test execution is interrupted.
	 */
	public void verifyCompanyProfileTextAtLeftNavigation(String companyProfile) throws InterruptedException {

		WebElement CompanyProfile = BaseTest.createWebElement(companyProfileatleftside);

		try {

			TestReporter.log("Test Start: Verifying Company Profile text is visible on the left side of the screen");

			TestReporter.log("Step 1: Velidate Company Profile text is visible on the left side of the screen");
			Assert.assertTrue(CompanyProfile.isDisplayed(), "FAILED: Company profile text is not visible on the left side of the screen");
			TestReporter.log("SUCCESS: Company profile text is visible on the left side of the screen");
		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occured while verifying the company profile text in company profile menu");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());
		} finally {

			TestReporter.log("==== Test End: Verified Company Profile Menu ====");
		}

	}

	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies the displayed company name and plan validity value.
	 * @param expectedCompanyName expected company name text
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyCompanyName(String expectedCompanyName) throws InterruptedException {

		WebElement companyName = BaseTest.createWebElement(verifycompanyname);
		WebElement planValidity = BaseTest.createWebElement(verifyPlanValidity);

		try {

			TestReporter.log("Test Start: Verify that Company Name and Plan Validity fields are displayed with correct spelling. ");

			TestReporter.log("Step 1: Validate that Company Name fields are displayed with correct spelling.");
			String actualCompanyName = companyName.getText().trim();
			Assert.assertTrue(actualCompanyName.equals(expectedCompanyName),"FAILED: Company name field is not displaying Expected '" + expectedCompanyName + "' but found '" + actualCompanyName + "'");	
			TestReporter.log("SUCCESS: Company Name field is displaying with correct spelling");

			TestReporter.log("Step 2: Validate that Plan Validity fields are displayed with correct spelling.");
			Assert.assertTrue(planValidity.isDisplayed(),"FAILED: Plan Validity fieldsa re not displayed with correct spelling");
			TestReporter.log("SUCCESS: Plan Validity fields are displayed with correct spelling");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occured while verifying the company profile text in company profile menu");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());
		}finally {

			TestReporter.log("==== Test End: Verified Company Name & Plan Validity ====");
		}
	}


	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies Company Name label, editable value, and save button behavior.
	 * @param expectedCompanyNameValue expected value present in the Company Name input
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyCompanyNameLabel_Values_SaveButton(String expectedCompanyNameValue) throws InterruptedException {

		WebElement companyNameLabel = BaseTest.createWebElement(verifyCompanyNameLabel);
		WebElement companyNameInput = BaseTest.createWebElement(verifyCompanyNameLebelValue);
		WebElement companyNameSaveButton = BaseTest.createWebElement(verifyCompanyNameLebelSaveButton);

		try {

			TestReporter.log("==== Test Start: Verifying Company Name Label, Value & Save Button ====");

			TestReporter.log("Step 1: Validate Company Name label is displayed with correct spelling");
			Assert.assertTrue(companyNameLabel.isDisplayed(), "FAILED: Company Name label is not displayed");
			TestReporter.log("SUCCESS: Company Name label is displayed");

			TestReporter.log("Step 2: Validate Company Name input displays the correct registered company name");
			String actualCompanyNameValue = companyNameInput.getAttribute("value").trim();
			Assert.assertEquals(actualCompanyNameValue, expectedCompanyNameValue, "FAILED: Company Name value mismatched, expected " + expectedCompanyNameValue + "But displaying" + actualCompanyNameValue );
			TestReporter.log("SUCCESS: Company Name value is displayed correctly: " + actualCompanyNameValue);

			TestReporter.log("Step 3: Validate Company Name Save button is displayed");
			Assert.assertTrue(companyNameSaveButton.isDisplayed(), "FAILED: Company Name Save button is not displayed");
			TestReporter.log("SUCCESS: Company Name Save button is displayed");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying Company Name label, value, and save button");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Company Name Label, Value & Save Button ====");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Edits the Company Name field and verifies the updated value is reflected in the header and profile menu.
	 * @param editCompanyName the new company name to set
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyCompanyNameValueviaEditing(String editCompanyName) throws InterruptedException {

		WebElement companyNameInput = BaseTest.createWebElement(verifyCompanyNameLebelValue);
		WebElement companyNameSaveButton = BaseTest.createWebElement(verifyCompanyNameLebelSaveButton);

		try {

			TestReporter.log("==== Test Start: Verifying Company Name Edit Flow ====");

			TestReporter.log("Step 1: Clear the existing Company Name value");
			companyNameInput.clear();
			TestReporter.log("SUCCESS: Existing Company Name value cleared");

			TestReporter.log("Step 2: Enter new Company Name value");
			companyNameInput.sendKeys(editCompanyName);
			TestReporter.log("SUCCESS: New Company Name entered: " + editCompanyName);

			TestReporter.log("Step 3: Click on Save button");
			BaseTest.clickOperation(companyNameSaveButton);
			TestReporter.log("SUCCESS: Save button clicked");

			Thread.sleep(7000);

			TestReporter.log("Step 4: Verify updated Company Name value in input field");
			String actualCompanyNameValue = companyNameInput.getAttribute("value").trim();
			Assert.assertEquals(actualCompanyNameValue, editCompanyName,"FAILED: Company Name input value mismatch after edit, expected " + editCompanyName + "But displaying" + actualCompanyNameValue);
			TestReporter.log("SUCCESS: Company Name input updated correctly: " + actualCompanyNameValue);

			WebElement companyNameHeader = BaseTest.createWebElement(verifycompanyname);
			TestReporter.log("Step 5: Verify Company Name updated in header section");
			String actualHeaderCompanyName = companyNameHeader.getText().trim();
			Assert.assertEquals(actualHeaderCompanyName, editCompanyName,"FAILED: Company Name not updated in header section");
			TestReporter.log("SUCCESS: Company Name updated in header section");

			WebElement profileIcon = BaseTest.createWebElement(PROFILE_ICON);
			TestReporter.log("Step 6: Click on profile icon");
			BaseTest.clickOperation(profileIcon);
			TestReporter.log("SUCCESS: Profile icon clicked");

			WebElement companyNameInProfileIcon = BaseTest.createWebElement(PROFILE_ORG_NAME_TUID);
			TestReporter.log("Step 7: Verify Company Name updated in profile menu");
			String actualCompanyNameInProfile = companyNameInProfileIcon.getText().trim();
			Assert.assertTrue(actualCompanyNameInProfile.contains(editCompanyName),"FAILED: Company Name not updated in profile menu");
			TestReporter.log("SUCCESS: Company Name updated in profile menu");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying Company Name edit flow");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Company Name edit flow ====");
		}
	}


	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies the 'No of Users' label and count value on the Company Profile page.
	 * @param expectedCount expected users count text (exact or partial match depending on UI)
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyNoOfUsersCount(String expectedCount) throws InterruptedException {

		WebElement noOfUsersLabel = BaseTest.createWebElement(NO_OF_USERS_LABEL);
		WebElement noOfUsersCountValue = BaseTest.createWebElement(NO_OF_USERS_VALUE);

		try {
			TestReporter.log("==== Test Start: Verifying 'No of Users' count ====");

			TestReporter.log("Step 1: Verify 'No of Users' label is displayed.");
			Assert.assertTrue(noOfUsersLabel.isDisplayed(), "FAILED: 'No of Users' label is not visible.");
			TestReporter.log("SUCCESS: 'No of Users' label is visible on the page.");

			TestReporter.log("Step 2: Verify 'No of Users' count matches expected.");
			String actualCount = noOfUsersCountValue.getText().trim();
			Assert.assertTrue(actualCount.contains(expectedCount),"FAILED: Expected user count (" + expectedCount + ") not found. Actual displayed: " + actualCount);
			TestReporter.log("SUCCESS: 'No of Users' count matches expected value: " + expectedCount);

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying 'No of Users' count: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			TestReporter.log("==== Test End: Verifying 'No of Users' count ====");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies the Subscription Plan label and value on the Company Profile page.
	 * @param expectedPlan - expected subscription plan text
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifySubscriptionPlan(String expectedPlan) throws InterruptedException {

		WebElement subscriptionPlanLabel = BaseTest.createWebElement(SUBSCRIPTION_PLAN_LABEL);
		WebElement subscriptionPlanValue = BaseTest.createWebElement(SUBSCRIPTION_PLAN_VALUE);

		try {
			TestReporter.log("==== Test Start: Verifying Subscription Plan ====");

			TestReporter.log("Step 1: Verify 'Subscription Plan' label is displayed.");
			Assert.assertTrue(subscriptionPlanLabel.isDisplayed(), "FAILED: 'Subscription Plan' label is not visible.");
			TestReporter.log("SUCCESS: 'Subscription Plan' label is visible on the page.");

			TestReporter.log("Step 2: Verify 'Subscription Plan' value matches expected.");
			String actualPlan = subscriptionPlanValue.getText().trim();
			Assert.assertTrue(actualPlan.contains(expectedPlan),"FAILED: Expected Subscription Plan (" + expectedPlan + ") not found. Actual displayed: " + actualPlan);
			TestReporter.log("SUCCESS: 'Subscription Plan' value matches expected: " + expectedPlan);

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying Subscription Plan: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			TestReporter.log("==== Test End: Verifying Subscription Plan ====");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies the Plan Status label and value on the Company Profile page.
	 * @param expectedStatus - expected plan status text
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyPlanStatus(String expectedStatus) throws InterruptedException {

		WebElement planStatusLabel = BaseTest.createWebElement(PLAN_STATUS_LABEL);
		WebElement planStatusValue = BaseTest.createWebElement(PLAN_STATUS_VALUE);

		try {
			TestReporter.log("==== Test Start: Verifying Plan Status ====");

			TestReporter.log("Step 1: Verify 'Plan Status' label is displayed.");
			Assert.assertTrue(planStatusLabel.isDisplayed(), "FAILED: 'Plan Status' label is not visible.");
			TestReporter.log("SUCCESS: 'Plan Status' label is visible on the page.");

			TestReporter.log("Step 2: Verify 'Plan Status' value matches expected.");
			String actualStatus = planStatusValue.getText().trim();
			Assert.assertTrue(actualStatus.contains(expectedStatus),"FAILED: Expected Plan Status (" + expectedStatus + ") not found. Actual displayed: " + actualStatus);
			TestReporter.log("SUCCESS: 'Plan Status' value matches expected: " + expectedStatus);

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying Plan Status: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			TestReporter.log("==== Test End: Verifying Plan Status ====");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @UseOfMethod: Verifies the TUID label and value and ensures the value appears correctly in the profile menu.
	 * @param expectedTuid - expected TUID value
	 * @throws InterruptedException if the thread is interrupted
	 */
	public void verifyTuid(String expectedTuid) throws InterruptedException {

		WebElement tuidLabel = BaseTest.createWebElement(TUID_LABEL);
		WebElement tuidValue = BaseTest.createWebElement(TUID_VALUE);

		try {
			TestReporter.log("==== Test Start: Verifying TUID ====");

			TestReporter.log("Step 1: Verify 'Tuid' label is displayed.");
			Assert.assertTrue(tuidLabel.isDisplayed(), "FAILED: 'Tuid' label is not visible.");
			TestReporter.log("SUCCESS: 'Tuid' label is visible on the page.");

			TestReporter.log("Step 2: Verify 'Tuid' value matches expected value.");
			String actualTuid = tuidValue.getText().trim();
			Assert.assertTrue(actualTuid.contains(expectedTuid),"FAILED: Expected TUID (" + expectedTuid + ") not found. Actual displayed: " + actualTuid);
			TestReporter.log("SUCCESS: 'Tuid' value matches expected: " + expectedTuid);

			TestReporter.log("Step 3: Click profile icon to verify TUID in profile.");
			WebElement profileIcon = BaseTest.createWebElement(PROFILE_ICON);
			BaseTest.clickOperation(profileIcon);
			TestReporter.log("SUCCESS: Profile icon clicked.");

			TestReporter.log("Step 4: Verify TUID displayed in profile menu.");
			WebElement tuidInProfile = BaseTest.createWebElement(PROFILE_ORG_NAME_TUID);
			String actualTuidInProfile = tuidInProfile.getText().trim();
			Assert.assertTrue(actualTuidInProfile.contains(expectedTuid),"FAILED: TUID in profile does not match expected. Expected: " + expectedTuid+ ", Actual: " + actualTuidInProfile);
			TestReporter.log("SUCCESS: TUID is correctly displayed in profile: " + actualTuidInProfile);

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying TUID: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		} finally {
			TestReporter.log("==== Test End: Verifying TUID ====");
		}
	}

}
