package com.brigita.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class ManageGroups extends BaseTest {

	// Locators
	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By verifyManageGroup = By.xpath("//span[text()='Manage Groups ']");
	By verifyCreateButton = By.xpath("//span[@class='pi pi-plus p-button-icon ng-star-inserted']");
	By verifyCreateDashboardPopup = By.xpath("//span[text()='Create Dashboard Group']");
	By dashboardGroupName = By.xpath("//input[@placeholder='Dashboard Group Name']");
	By dashboardGroupDisplayName = By.xpath("(//input[@placeholder='Dashboard Group Name' or @placeholder='Dashboard Group Display Name'])[2]");
	By description = By.xpath("((//input[@placeholder='Dashboard Group Name' or @placeholder='Dashboard Group Display Name']) | //textarea[@placeholder='Description'])[last()]");
	By dashboard = By.xpath("(//input[@placeholder='Dashboard Group Name' or @placeholder='Dashboard Group Display Name'] | //textarea[@placeholder='Description'] | //p-multiselect[@placeholder='Select Dashboard '])[last()]");
	By dashboardListItem = By.xpath("(//div[contains(@class,'p-multiselect-items-wrapper')]//div[@class='p-checkbox-box'])[1]");
	By saveButton = By.xpath("//span[text()='Save']");
	By verifyEditDashboardPopup = By.xpath("//span[text()='Edit Dashboard Group']");
	By closewrongicon = By.xpath("//span[contains(@class,'p-multiselect-close-icon')]");
	By manageGroupDetails = By.xpath("//h2[text()='Manage Groups Details']");

	// Generated values
	public static String generatedGroupName;
	public static String generatedDisplayName;
	public static String generatedDescription;

	public static String generatedGroupNameInEditFlow;
	public static String generatedDisplayNameInEditFlow;
	public static String generatedDescriptionInEditFlow;

	/**
	 * @author Lakshmipathi
	 * Clicks the Settings icon and navigates to the Manage Groups menu.
	 * Verifies menu availability, spelling, and highlights the menu.
	 * @throws InterruptedException
	 */
	public void clickSettingIcon() throws InterruptedException {
		TestReporter.log("STEP: Click on the 'Settings' icon to open Settings menu");
		BaseTest.clickOperation(BaseTest.createWebElement(settingIcon));

		WebElement manageGroupMenu = BaseTest.createWebElement(verifyManageGroup);
		String expectedText = "Manage Groups";

		try {
			TestReporter.log("STEP: Verify the 'Manage Groups' menu is displayed in Settings");
			Assert.assertTrue(manageGroupMenu.isDisplayed(), "'Manage Groups' menu is NOT available on the Settings page.");
			TestReporter.log("PASS: 'Manage Groups' menu is displayed");

			TestReporter.log("STEP: Verify the spelling of 'Manage Groups' menu");
			Assert.assertEquals(manageGroupMenu.getText(), expectedText, "'Manage Groups' spelling is incorrect.");
			TestReporter.log("PASS: 'Manage Groups' spelling is correct: " + manageGroupMenu.getText());

			TestReporter.log("STEP: Click on the 'Manage Groups' menu");
			BaseTest.waitseconds(5);
			BaseTest.clickOperation(manageGroupMenu);
			Assert.assertTrue(manageGroupMenu.isEnabled(), "'Manage Groups' menu is NOT highlighted on the Settings page.");
			TestReporter.log("PASS: 'Manage Groups' menu is clicked and highlighted");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while clicking Settings -> Manage Groups: " + e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage() + " at line: " + e.getStackTrace()[0].getLineNumber());
		}
	}

	/**
	 * @author Lakshmipathi
	 * Verifies the Create '+' button is visible and clickable on Manage Groups page.
	 * @throws InterruptedException
	 */
	public void verifyAndClickCreateButton() throws InterruptedException {
		WebElement createButton = BaseTest.createWebElement(verifyCreateButton);

		try {
			TestReporter.log("STEP: Verify the Create '+' button is displayed on Manage Groups page");
			Assert.assertTrue(createButton.isDisplayed(), "Create '+' button is NOT available on the Manage Groups page.");
			TestReporter.log("PASS: Create '+' button is displayed");

			TestReporter.log("STEP: Click on Create '+' button");
			BaseTest.clickOperation(createButton);
			TestReporter.log("PASS: Create '+' button clicked successfully");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying or clicking Create '+' button: " + e.getMessage());
			Assert.fail("Failed to verify or click Create '+' button due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Verifies that the Create Dashboard Group popup is displayed after clicking Create '+'.
	 * @throws InterruptedException
	 */
	public void verifyCreateDashboardGroupPopup() throws InterruptedException {
		WebElement popup = BaseTest.createWebElement(verifyCreateDashboardPopup);

		try {
			TestReporter.log("STEP: Verify 'Create Dashboard Group' popup is displayed");
			Assert.assertTrue(popup.isDisplayed(), "Create Dashboard Group popup is NOT displayed.");
			TestReporter.log("PASS: 'Create Dashboard Group' popup is displayed");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying Create Dashboard Group popup: " + e.getMessage());
			Assert.fail("Failed to verify Create Dashboard Group popup due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters a random Dashboard Group Name in the input field.
	 * @throws InterruptedException
	 */
	public void enterDashboardGroupName() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(dashboardGroupName);
		generatedGroupName = "Automation Dashboard Group " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Dashboard Group Name: " + generatedGroupName);
			field.clear();
			field.sendKeys(generatedGroupName);
			TestReporter.log("PASS: Dashboard Group Name entered successfully");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Dashboard Group Name: " + e.getMessage());
			Assert.fail("Failed to enter Dashboard Group Name due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters a random Dashboard Group Display Name in the input field.
	 * @throws InterruptedException
	 */
	public void enterDashboardGroupDisplayName() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(dashboardGroupDisplayName);
		generatedDisplayName = "Automation Display Name " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Dashboard Group Display Name: " + generatedDisplayName);
			field.clear();
			field.sendKeys(generatedDisplayName);
			TestReporter.log("PASS: Dashboard Group Display Name entered successfully");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Display Name: " + e.getMessage());
			Assert.fail("Failed to enter Display Name due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters a random Description for the Dashboard Group.
	 * @throws InterruptedException
	 */
	public void enterDashboardGroupDescription() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(description);
		generatedDescription = "Automation Description " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Description: " + generatedDescription);
			field.clear();
			field.sendKeys(generatedDescription);
			TestReporter.log("PASS: Description entered successfully");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Description: " + e.getMessage());
			Assert.fail("Failed to enter Description due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Saves the Dashboard Group with optional dashboard selection.
	 * @param dashboardOption "select dashboard" or "not select dashboard"
	 * @throws InterruptedException
	 */
	public void saveDashboardGroup(String dashboardOption) throws InterruptedException {
		WebElement saveButtonElement = BaseTest.createWebElement(saveButton);

		try {
			switch (dashboardOption.toLowerCase()) {
			case "not select dashboard":
				TestReporter.log("STEP: Click Save without selecting a dashboard");
				BaseTest.clickOperation(saveButtonElement);
				TestReporter.log("PASS: Dashboard group saved without selecting a dashboard");
				break;

			case "select dashboard":
				TestReporter.log("STEP: Select a dashboard before saving");
				WebElement dashboardDropdown = BaseTest.createWebElement(dashboard);
				BaseTest.clickOperation(dashboardDropdown);
				TestReporter.log("INFO: Dashboard dropdown clicked");

				WebElement firstDashboardItem = BaseTest.createWebElement(dashboardListItem);
				BaseTest.clickOperation(firstDashboardItem);
				TestReporter.log("INFO: First dashboard selected");

				TestReporter.log("Close the dropdown");
				WebElement wrongicon = BaseTest.createWebElement(closewrongicon);
				BaseTest.clickOperation(wrongicon);
				TestReporter.log("Dropdown is closed.");

				BaseTest.clickOperation(saveButtonElement);
				TestReporter.log("PASS: Dashboard group saved with dashboard selection");
				break;

			default:
				Assert.fail("Invalid option: Use 'select dashboard' or 'not select dashboard'");
			}

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while saving Dashboard Group: " + e.getMessage());
			Assert.fail("Failed to save Dashboard Group due to exception.");
		}
	}

	/**
	 * Verifies Dashboard Group details in paginated table without validating Group Name
	 * and clicks on the View Dashboard Group icon if matched.
	 *
	 * @param expectedDisplayName Expected Display Name of the Dashboard Group
	 * @param expectedDescription Expected Description of the Dashboard Group
	 */
	public void verifyviewDashboardGroupDetailsInPaginationWithoutGroupName(
			String expectedDisplayName, String expectedDescription) {
		try {
			TestReporter.log("STEP: Start verifying Dashboard Group details in pagination (excluding Group Name)");

			int paginationSize = driver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
			boolean isRecordFound = false;

			// Loop through all pages
			for (int i = 1; i <= paginationSize; i++) {

				// Fetch rows on the current page
				List<WebElement> rows = BaseTest.createWebElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr"));

				// Check each row
				for (WebElement row : rows) {
					String actualDisplayName = row.findElement(By.xpath("td[3]")).getText().trim();
					String actualDescription = row.findElement(By.xpath("td[4]")).getText().trim();

					if (actualDisplayName.equals(expectedDisplayName)&& actualDescription.equals(expectedDescription)) {

						isRecordFound = true;
						TestReporter.log("PASS: Dashboard Group verified: DisplayName='" + actualDisplayName+ "', Description='" + actualDescription + "'");

						// Click Edit icon
						String xpath = "//tbody[@class='p-element p-datatable-tbody']/tr[td[contains(text(),'"+ actualDisplayName + "')]]//img[@ptooltip='View Details']";
						WebElement viewIcon = BaseTest.createWebElement(By.xpath(xpath));

						TestReporter.log("STEP: Verify Edit Dashboard Group icon for: " + actualDisplayName);
						try {
							Assert.assertTrue(viewIcon.isDisplayed(), "View Dashboard Group icon is not displayed");
							TestReporter.log("PASS: View Dashboard Group icon is displayed");

							TestReporter.log("STEP: Click on View Dashboard Group icon");
							BaseTest.clickOperation(viewIcon);
							TestReporter.log("PASS: View Dashboard Group icon clicked successfully");

						} catch (Exception e) {
							TestReporter.log("ERROR: Failed to verify or click view Dashboard Group icon: " + e.getMessage());
							Assert.fail("Exception occurred while verifying/clicking Edit icon");
						}

						break; // Stop checking rows on current page
					}
				}

				// If found, exit pagination loop
				if (isRecordFound) break;

				// Move to next page if record not found
				if (i < paginationSize) {
					TestReporter.log("STEP: Navigate to pagination page " + (i + 1));
					WebElement pageButton = BaseTest.createWebElement(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button[" + (i + 1) + "]"));
					BaseTest.clickOperation(pageButton);
					BaseTest.waitseconds(2);
				}
			}

			Assert.assertTrue(isRecordFound,"Expected Dashboard Group record NOT found in any page (excluding Group Name).");
			TestReporter.log("PASS: Dashboard Group record is displayed in pagination with Display Name and Description.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Exception occurred while verifying Dashboard Group details (excluding Group Name): "+ e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}
	
	
	public void verifyManageGroupDetails() throws InterruptedException {
		
		WebElement ManageGroupDetails = BaseTest.createWebElement(manageGroupDetails);
		
		try {
			TestReporter.log("STEP: Verify 'View Dashboard Details' text is displayed");
			Assert.assertTrue(ManageGroupDetails.isDisplayed(), "View Dashboard Group text is NOT displayed.");
			TestReporter.log("PASS: 'View Dashboard Group' text is displayed");
		} catch (Exception e) {
		
			TestReporter.log("ERROR: Exception occurred while verifying Dashboard Group details (excluding Group Name): "+ e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage());
		}
		
	}
	
	
	
	
	/**
	 * Verifies Dashboard Group details in paginated table without validating Group Name
	 * and clicks on the Edit Dashboard Group icon if matched.
	 *
	 * @param expectedDisplayName Expected Display Name of the Dashboard Group
	 * @param expectedDescription Expected Description of the Dashboard Group
	 */
	public void verifyDashboardGroupDetailsInPaginationWithoutGroupName(
			String expectedDisplayName, String expectedDescription) {
		try {
			TestReporter.log("STEP: Start verifying Dashboard Group details in pagination (excluding Group Name)");

			int paginationSize = driver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
			boolean isRecordFound = false;

			// Loop through all pages
			for (int i = 1; i <= paginationSize; i++) {

				// Fetch rows on the current page
				List<WebElement> rows = BaseTest.createWebElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr"));

				// Check each row
				for (WebElement row : rows) {
					String actualDisplayName = row.findElement(By.xpath("td[3]")).getText().trim();
					String actualDescription = row.findElement(By.xpath("td[4]")).getText().trim();

					if (actualDisplayName.equals(expectedDisplayName)&& actualDescription.equals(expectedDescription)) {

						isRecordFound = true;
						TestReporter.log("PASS: Dashboard Group verified: DisplayName='" + actualDisplayName+ "', Description='" + actualDescription + "'");

						// Click Edit icon
						String xpath = "//tbody[@class='p-element p-datatable-tbody']/tr[td[contains(text(),'"+ actualDisplayName + "')]]//img[@ptooltip='Edit Dashboard Group Details']";
						WebElement editIcon = BaseTest.createWebElement(By.xpath(xpath));

						TestReporter.log("STEP: Verify Edit Dashboard Group icon for: " + actualDisplayName);
						try {
							Assert.assertTrue(editIcon.isDisplayed(), "Edit Dashboard Group icon is not displayed");
							TestReporter.log("PASS: Edit Dashboard Group icon is displayed");

							TestReporter.log("STEP: Click on Edit Dashboard Group icon");
							BaseTest.clickOperation(editIcon);
							TestReporter.log("PASS: Edit Dashboard Group icon clicked successfully");

						} catch (Exception e) {
							TestReporter.log("ERROR: Failed to verify or click Edit Dashboard Group icon: " + e.getMessage());
							Assert.fail("Exception occurred while verifying/clicking Edit icon");
						}

						break; // Stop checking rows on current page
					}
				}

				// If found, exit pagination loop
				if (isRecordFound) break;

				// Move to next page if record not found
				if (i < paginationSize) {
					TestReporter.log("STEP: Navigate to pagination page " + (i + 1));
					WebElement pageButton = BaseTest.createWebElement(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button[" + (i + 1) + "]"));
					BaseTest.clickOperation(pageButton);
					BaseTest.waitseconds(2);
				}
			}

			Assert.assertTrue(isRecordFound,"Expected Dashboard Group record NOT found in any page (excluding Group Name).");
			TestReporter.log("PASS: Dashboard Group record is displayed in pagination with Display Name and Description.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Exception occurred while verifying Dashboard Group details (excluding Group Name): "+ e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}


	/**
	 * @author Lakshmipathi
	 * Verifies that the Edit Dashboard Group popup is displayed.
	 */
	public void verifyEditDashboardGroupPopup() throws InterruptedException {
		WebElement popup = BaseTest.createWebElement(verifyEditDashboardPopup);

		try {
			TestReporter.log("STEP: Verify 'Edit Dashboard Group' popup is displayed");
			Assert.assertTrue(popup.isDisplayed(), "Edit Dashboard Group popup is NOT displayed.");
			TestReporter.log("PASS: 'Edit Dashboard Group' popup is displayed");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying Edit Dashboard Group popup: " + e.getMessage());
			Assert.fail("Failed to verify Edit Dashboard Group popup due to exception.");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters Dashboard Group Name in Edit flow.
	 */
	public void enterDashboardGroupNameInEditFlow() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(dashboardGroupName);
		generatedGroupNameInEditFlow = "Automation Dashboard Group in Edit Flow " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Dashboard Group Name in Edit Flow: " + generatedGroupNameInEditFlow);
			field.clear();
			field.sendKeys(generatedGroupNameInEditFlow);
			TestReporter.log("PASS: Dashboard Group Name entered in Edit Flow");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Dashboard Group Name in Edit Flow: " + e.getMessage());
			Assert.fail("Failed to enter Dashboard Group Name in Edit Flow");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters Dashboard Group Display Name in Edit flow.
	 */
	public void enterDashboardGroupDisplayNameInEditFlow() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(dashboardGroupDisplayName);
		generatedDisplayNameInEditFlow = "Automation Display Name in Edit Flow " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Dashboard Group Display Name in Edit Flow: " + generatedDisplayNameInEditFlow);
			field.clear();
			field.sendKeys(generatedDisplayNameInEditFlow);
			TestReporter.log("PASS: Dashboard Group Display Name entered in Edit Flow");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Display Name in Edit Flow: " + e.getMessage());
			Assert.fail("Failed to enter Display Name in Edit Flow");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Enters Dashboard Group Description in Edit flow.
	 */
	public void enterDashboardGroupDescriptionInEditFlow() throws InterruptedException {
		WebElement field = BaseTest.createWebElement(description);
		generatedDescriptionInEditFlow = "Automation Description in Edit Flow " + BaseTest.randomNumberWithLength(1);

		try {
			TestReporter.log("STEP: Enter Description in Edit Flow: " + generatedDescriptionInEditFlow);
			field.clear();
			field.sendKeys(generatedDescriptionInEditFlow);
			TestReporter.log("PASS: Description entered in Edit Flow");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while entering Description in Edit Flow: " + e.getMessage());
			Assert.fail("Failed to enter Description in Edit Flow");
		}
	}

	/**
	 * @author Lakshmipathi
	 * Saves Dashboard Group in Edit flow with optional dashboard selection.
	 */
	public void saveDashboardGroupInEditFlow(String dashboardOption) throws InterruptedException {
		WebElement saveButtonElement = BaseTest.createWebElement(saveButton);

		try {
			switch (dashboardOption.toLowerCase()) {
			case "not select dashboard":
				TestReporter.log("STEP: Click Save in Edit Flow without selecting a dashboard");
				BaseTest.clickOperation(saveButtonElement);
				TestReporter.log("PASS: Dashboard group saved in Edit Flow without selecting a dashboard");
				break;

			case "select dashboard":
				TestReporter.log("STEP: Select a dashboard in Edit Flow before saving");
				WebElement dashboardDropdown = BaseTest.createWebElement(dashboard);
				BaseTest.clickOperation(dashboardDropdown);
				TestReporter.log("INFO: Dashboard dropdown clicked in Edit Flow");

				WebElement firstDashboardItem = BaseTest.createWebElement(dashboardListItem);
				BaseTest.clickOperation(firstDashboardItem);
				TestReporter.log("INFO: First dashboard selected in Edit Flow");

				TestReporter.log("Close the dropdown");
				WebElement wrongicon = BaseTest.createWebElement(closewrongicon);
				BaseTest.clickOperation(wrongicon);
				TestReporter.log("Dropdown is closed.");

				BaseTest.waitseconds(5);
				BaseTest.clickOperation(saveButtonElement);
				TestReporter.log("PASS: Dashboard group saved in Edit Flow with dashboard selection");
				break;

			default:
				Assert.fail("Invalid option: Use 'select dashboard' or 'not select dashboard' in Edit Flow");
			}

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception while saving Dashboard Group in Edit Flow: " + e.getMessage());
			Assert.fail("Failed to save Dashboard Group in Edit Flow due to exception.");
		}
	}

	/**
	 * Verifies Dashboard Group details in paginated table without validating Group Name
	 * and clicks on the Edit Dashboard Group icon if matched (if needed).
	 *
	 * @param expectedDisplayName Expected Display Name of the Dashboard Group
	 * @param expectedDescription Expected Description of the Dashboard Group
	 */
	public void verifyDashboardGroupDetailsInPaginationineditflow(
			String expectedDisplayName, String expectedDescription) {
		try {
			TestReporter.log("STEP: Start verifying Dashboard Group details in pagination (excluding Group Name)");

			int paginationSize = driver.findElements(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button")).size();
			boolean isRecordFound = false;

			// Loop through all pages
			for (int i = 1; i <= paginationSize; i++) {

				// Fetch rows on the current page
				List<WebElement> rows = BaseTest.createWebElements(By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr"));

				// Check each row
				for (WebElement row : rows) {
					String actualDisplayName = row.findElement(By.xpath("td[3]")).getText().trim();
					String actualDescription = row.findElement(By.xpath("td[4]")).getText().trim();

					if (actualDisplayName.equals(expectedDisplayName)&& actualDescription.equals(expectedDescription)) {

						isRecordFound = true;
						TestReporter.log("PASS: Dashboard Group verified: DisplayName='" + actualDisplayName+ "', Description='" + actualDescription + "'");
						break; // Stop checking rows on current page
					}
				}

				// If found, exit pagination loop
				if (isRecordFound) 
					break;

				// Move to next page if record not found
				if (i < paginationSize) {
					TestReporter.log("STEP: Navigate to pagination page " + (i + 1));
					WebElement pageButton = BaseTest.createWebElement(By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button[" + (i + 1) + "]"));
					BaseTest.clickOperation(pageButton);
					BaseTest.waitseconds(2);
				}
			}

			Assert.assertTrue(isRecordFound,"Expected Dashboard Group record NOT found in any page (excluding Group Name).");
			TestReporter.log("PASS: Dashboard Group record is displayed in pagination with Display Name and Description.");

		} catch (Exception e) {
			TestReporter.log("ERROR: Exception occurred while verifying Dashboard Group details (excluding Group Name): "
					+ e.getMessage());
			Assert.fail("Exception occurred: " + e.getMessage());
		}
	}

}
