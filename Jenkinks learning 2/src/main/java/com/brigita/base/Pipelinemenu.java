package com.brigita.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class Pipelinemenu extends BaseTest {

	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By clickpipeline = By.xpath("//img[@src='assets/sidemenu-icon/company-profile.png']/following-sibling::span[text()='Pipeline ']");	
	By verifymessageifnopipelines = By.xpath("//h3[@class='fontfamily _pagebody']/..");
	By verifybody = By.xpath("//div[@class='example-sidenav-content']");
	By clickcreatenewpipeline = By.xpath("//span[@class='pi pi-plus p-button-icon ng-star-inserted']");
	By verifycreatenewpipelinetext = By.xpath("//h3[text()='Create New Pipeline']");
	By verifyenternamefieldname = By.xpath("//h3[text()='Enter Pipeline Name']");
	By verifyenernamefieldicon = By.xpath("//h3[text()='Enter Pipeline Name']/following-sibling::img");
	By clicksavebutton = By.xpath("//img[@src='/assets/tenant-menu/diskette.png']");
	By verifytoast = By.xpath("//div[text()='Pipeline Name can be Created']");
	By verifysourceselectiondropdown = By.xpath("//p-dropdown[@placeholder='Source']");
	By clicksourcevalue = By.xpath("//ul[@role='listbox']/p-dropdownitem");
	By verifydestinationselectiondropdown = By.xpath("//p-dropdown[@placeholder='Destination']");
	By verifydestinationvalue = By.xpath("//span[text()='Nockpoint Cloud']");
	By verifytabs = By.xpath("//div[@class='col']/span");
	By verifyeveryfornotclicked = By.xpath("//h3[text()='Every']");
	By verifyschemamessage = By.xpath("//h3[contains(text(),' Please select the source & the destination to proceed further. ')]");
	By verifyschematab = By.xpath("//span[text()=' Schema ']");
	By verifyapplycomendedbutton = By.xpath("//span[text()='Apply Recommended']");
	By verifynextbutton = By.xpath("//span[text()='Next']");
	By verifytoastebeforeschemaenable = By.xpath("//div[text()='Please select the table row']");
	By verifysyncdetailstab = By.xpath("//span[text()=' Sync Details ']");
	By verifytoastebeforesyncselect = By.xpath("//div[text()='Please select sync details']");
	By verifyeverytext = By.xpath("//h3[text()='Every']");
	By verifysyncplaceholder = By.xpath("//p-dropdown[@placeholder='Select sync']");
	By verifydropdownoptions = By.xpath("//ul[@role='listbox']/p-dropdownitem");
	By select24option = By.xpath("//li[@aria-label='24 hours']");
	By verifydownstreamtab = By.xpath("//span[text()=' DownStream ']");
	By verifycreatebutton = By.xpath("//span[text()='Create']");
	By verifyradiobuttonslaebl = By.xpath("//div[@class='d-flex']/div");
	By verifyradiobuttonheader = By.xpath("//h3[text()='Apply The Downstream Activity']");
	By verifynodownstream = By.xpath("//div[@class='p-radiobutton-box']");
	By verifypipelinelisttext = By.xpath("//h3[text()='Pipeline List']");
	By verifypipelinelistheaders = By.xpath("//thead[@class='p-datatable-thead']/tr/th");

	/**
	 * Verifies the Setting icon in the application.
	 * Ensures the icon is visible, displays the correct tooltip, and is clickable.
	 *
	 * @author Lakshmipathi
	 * @param  expectedToolTip - The expected tooltip text for the Setting icon.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifySettingIcon(String expectedToolTip) throws InterruptedException {

		WebElement settingicon = BaseTest.createWebElement(settingIcon);
		try {

			TestReporter.log("===== Starting Test: Verify Setting Icon =====");

			TestReporter.log("Step 1: Verifying if the Setting Icon is displayed.");
			Assert.assertTrue(settingicon.isDisplayed(), "Validation Failed: Setting Icon is not displayed.");

			TestReporter.log("SUCCESS: Setting Icon is displayed ");

			TestReporter.log("Step 2: Verifying the tooltip text of the Setting Icon.");
			String actualToolTipText = settingicon.getAttribute("ptooltip");
			Assert.assertEquals(actualToolTipText, expectedToolTip, 
					"FAILED: Expected tooltip text '" + expectedToolTip + "', but found '" + actualToolTipText + "'.");

			TestReporter.log("SUCCESS: Setting Icon tooltip is displayed correctly: " + actualToolTipText);

			TestReporter.log("Step 3: Clicking on the Setting Icon.");
			BaseTest.clickOperation(settingicon);

			TestReporter.log("SUCCESS: Setting Icon clicked successfully.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying the Setting Icon: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified Setting Icon =====");
		}
	}

	/**
	 * Verifies the Pipeline menu in the application.
	 * Checks if the menu is available, displays the correct text and logo, and is highlighted after clicking.
	 * 
	 * @author Lakshmipathi
	 * @param  expectedText - The expected text of the Pipeline menu.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifyPipelineMenu(String expectedText) throws InterruptedException {

		WebElement pipeline = BaseTest.createWebElement(clickpipeline); 
		try {

			TestReporter.log("===== Starting Test: Verify Pipeline Menu =====");

			TestReporter.log("Step 1: Verifying Pipeline Menu availability with correct spelling and logo."); 
			String actualText = pipeline.getText().trim();
			Assert.assertEquals(actualText, expectedText, 
					"FAILED: Expected Pipeline Menu text '" + expectedText + "', but found '" + actualText + "'");

			TestReporter.log("SUCCESS: Pipeline Menu is correctly displayed as: " + expectedText);

			TestReporter.log("Step 2: Clicking on the Pipeline Menu.");
			BaseTest.clickOperation(pipeline);

			TestReporter.log("SUCCESS: Pipeline Menu is Clicked Successfully");

			TestReporter.log("Step 3: Verifying if the Pipeline Menu is highlighted after clicking.");
			Assert.assertTrue(pipeline.isEnabled(), "Validation Failed: Pipeline Menu is not highlighted after selection.");

			TestReporter.log("SUCCESS: Pipeline Menu is highlighted correctly after clicking.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying the Pipeline Menu: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified Pipeline Menu =====");
		}
	}

	/**
	 * 
	 * Verify if the Pipeline List API is returning a 500 Server Error Or Verifies the message displayed in the Pipeline screen.
	 * If no message exist, the headers should be displayed ( Which indicate pipeline exists). 
	 * 
	 * @author Lakshmipathi
	 * @param  newUser - verify message when no pipeline exists
	 * @param  existingUser - verify headers when pipeline exists
	 * @throws InterruptedException
	 */
	public void verifyMessageBodyForNewUserOrExistingPiplelinesForExistingUser(String newUserOrexistingUser) throws InterruptedException {

		try {

			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			TestReporter.log("Starting Test : Verifying Message Body For New User Or Existing Pipeline For Existing User Started");

			switch (newUserOrexistingUser) {
			case "newUser" :

				WebElement pipelineMessage = BaseTest.createWebElement(verifymessageifnopipelines);
				wait.until(ExpectedConditions.visibilityOf(pipelineMessage));

				String expectedMessage = "You haven't created any pipelines yet, click the 'Create pipeline' button to create your first pipeline.";

				TestReporter.log("Step 1: Verify For Message When No Pipelines Exist");
				Assert.assertTrue(pipelineMessage.isDisplayed(), "FAILED: Message Is Not Displaying When No Pipeline Exists");
				TestReporter.log("SUCCESS: Message Is Displaying When No Pipeline Exists");

				String actualMessage = pipelineMessage.getText().trim();
				TestReporter.log("Step 2: Message displayed. Validating Actual Message Content With Expected Message.");
				Assert.assertEquals(actualMessage, expectedMessage,
						"FAILED: Expected message '" + expectedMessage + "', but found '" + actualMessage + "'.");

				TestReporter.log("SUCCESS: The actual message matched the expected message.");
				break;
			case "exisingUser" :

				List<WebElement> headers = BaseTest.createWebElement1(verifypipelinelistheaders);
				wait.until(ExpectedConditions.visibilityOfAllElements(headers));
				List<String> expectedList = Arrays.asList("Name", "Status", "Source", "Destination", "Sync Frequency", "Actions");

				TestReporter.log("Step 1: Verify all headers are visible for existing user");
				for (WebElement header : headers) {
					Assert.assertTrue(header.isDisplayed(), "FAILED: Header element is not displayed. " +header);
					TestReporter.log("SUCCESS: Header '" + header.getText().trim() + "' is visible.");
				}

				TestReporter.log("Step 2: Compare actual and expected headers");
				List<String> actualList = new ArrayList<>();
				for (WebElement header : headers) {
					actualList.add(header.getText().trim());
				}

				Assert.assertEquals(actualList, expectedList, "FAILED: Actual headers do not match the expected headers.");
				TestReporter.log("SUCCESS: All actual headers match the expected headers."); 
				break;
			}
		}  catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error while verifying the pipeline menu " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified pipeline menu for new user & exising user =====");
		} 
	}

	/**
	 * verify the presence of the "Create New Pipeline" button and clicks on it.
	 *
	 * @author Lakshmipathi
	 * @throws InterruptedException - if the thread is interrupted during execution
	 */
	public void clickOnCreateNewPipelineButton() throws InterruptedException {

		WebElement createPipelineButton = BaseTest.createWebElement(clickcreatenewpipeline);	    try {

			TestReporter.log("===== START: Verifying and Clicking 'Create New Pipeline' Button =====");

			TestReporter.log("Step 1: Verifying if the button is displayed.");
			Assert.assertTrue(createPipelineButton.isDisplayed(), 
					"FAILED: 'Create New Pipeline' button is NOT available on the Pipeline Screen.");

			TestReporter.log("SUCCESS: 'Create New Pipline' button is avilable in pipeline screen");

			TestReporter.log("Step 2: Clicking on the 'Create New Pipeline' button.");
			BaseTest.clickOperation(createPipelineButton);

			TestReporter.log("SUCCESS: 'Create New Pipeline' button clicked successfully.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error while verifying the 'Create New Pipeline' button: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());
		} finally {

			TestReporter.log("===== Test Completed: Verified and Click of 'Create New Pipeline' Button =====");
		}
	}

	/**
	 * verify whether the "Create New Pipeline" text is correctly displayed on the "Create New Pipeline" screen.
	 *
	 * @author Lakshmipathi
	 * @param  expectedText The expected text that should be displayed.
	 * @throws InterruptedException if the thread is interrupted during execution.
	 */
	public void verifyTextCreateNewPipeline(String expectedText) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement actualText = BaseTest.createWebElement(verifycreatenewpipelinetext);
		wait.until(ExpectedConditions.visibilityOf(actualText));

		try {
			TestReporter.log("===== START: Verifying 'Create New Pipeline' Text =====");

			TestReporter.log("Step 1: Checking if the 'Create New Pipline' text  is displayed.");
			Assert.assertTrue(actualText.isDisplayed(), "FAILED: 'Create New Pipeline' text is NOT available.");

			TestReporter.log("SUCCESS: 'Create New Pipline' text is displaying");
			TestReporter.log("Step 2: Validating if the displayed text matches the expected text.");
			String getText = actualText.getText().trim();
			Assert.assertEquals(getText, expectedText, 
					"FAILED: Mismatch in 'Create New Pipeline' text! Expected: '" + expectedText + "', Found: '" + getText + "'");

			TestReporter.log("SUCCESS: 'Create New Pipeline' actual output is matched to the expected text correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying 'Create New Pipeline' text: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());
		} finally {

			TestReporter.log("===== Test Completed: Verified 'Create New Pipeline' Text =====");
		}
	}

	/**
	 * verify and interacts with the "Enter Pipeline Name" field in the "Create New Pipeline" screen.
	 * It checks if the text and edit icon are available, enters a new name, saves it, and verifies the success toast message.
	 *
	 * @author Lakshmipathi
	 * @param  expectedText   -    The expected text for the "Enter Pipeline Name" field.
	 * @param  expectedToastMessage - The expected toast message after saving the field.
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifyAndClickOnViewConnectedApps(String expectedText, String expectedToastMessage) throws InterruptedException {

		WebElement fieldName = BaseTest.createWebElement(verifyenternamefieldname);
		try {
			TestReporter.log("===== START: Verifying and Clicking on 'View Connected Apps' =====");

			TestReporter.log("Step 1: Checking if the 'Enter Pipeline Name' text is displayed.");
			Assert.assertTrue(fieldName.isDisplayed(), "FAILED: 'Enter Pipeline Name' text is NOT available.");
			TestReporter.log("SUCCESS: 'Enter Pipeline Name' text is displayed.");

			TestReporter.log("Step 2: Validating if the displayed text matches the expected text.");
			String actualText = fieldName.getText().trim();
			Assert.assertEquals(actualText, expectedText,
					"FAILED: Mismatch in 'Enter Pipeline Name' text! Expected: '" + expectedText + "', Found: '" + actualText + "'");
			TestReporter.log("SUCCESS: 'Enter Pipeline Name' text matches expected value.");

			WebElement fieldIcon = BaseTest.createWebElement(verifyenernamefieldicon);
			TestReporter.log("Step 3: Checking if the edit icon is displayed.");
			Assert.assertTrue(fieldIcon.isDisplayed(), "FAILED: 'Enter Pipeline Name' field edit icon is NOT available.");
			TestReporter.log("SUCCESS: 'Enter Pipeline Name' edit icon is displayed.");

			TestReporter.log("Step 4: Clicking on the 'Enter Pipeline Name' edit icon.");
			BaseTest.clickOperation(fieldIcon);
			TestReporter.log("SUCCESS: Clicked on the edit icon.");

			TestReporter.log("Step 5: Entering 'Field Verification Name' in the name field.");
			fieldIcon.sendKeys("Field Verification Name");
			TestReporter.log("SUCCESS: Entered 'Field Verification Name'.");

			WebElement saveButton = BaseTest.createWebElement(clicksavebutton);
			TestReporter.log("Step 6: Clicking on the Save button.");
			BaseTest.clickOperation(saveButton);
			TestReporter.log("SUCCESS: Clicked on the Save button.");

			WebElement toastMessage = BaseTest.createWebElement(verifytoast);
			TestReporter.log("Step 7: Verifying the success toast message.");
			String actualToast = toastMessage.getText().trim();
			Assert.assertEquals(actualToast, expectedToastMessage,
					"FAILED: Mismatch in toast message! Expected: '" + expectedToastMessage + "', Found: '" + actualToast + "'");
			TestReporter.log("SUCCESS: Toast message is displayed correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying 'Enter Pipeline Name': " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());
		} finally {

			TestReporter.log("===== Test Completed: Verified  'Enter Pipelien Name' field =====");
		}
	}

	/**
	 * verify the availability of the Source Selection dropdown in the Create New Pipeline screen.
	 * It ensures the dropdown is displayed, validates the placeholder name, and verifies that the dropdown is clickable.
	 *
	 * @author Lakshmipathi
	 * @param  expectedPlaceHolderName - The expected placeholder text for the Source Selection dropdown.
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifySourceSelectionDropdownAvailability(String expectedPlaceHolderName) throws InterruptedException {

		WebElement sourceDropdown = BaseTest.createWebElement(verifysourceselectiondropdown);
		try {
			TestReporter.log("===== START: Verifying Source Selection Dropdown Availability =====");

			TestReporter.log("Step 1: Checking if the Source Selection dropdown is displayed.");
			Assert.assertTrue(sourceDropdown.isDisplayed(), "FAILED: Source Selection Dropdown is NOT available.");
			TestReporter.log("SUCCESS: Source Selection Dropdown is displayed.");

			TestReporter.log("Step 2: Verifying the placeholder text of the Source Selection dropdown.");
			String actualPlaceholderName = sourceDropdown.getAttribute("placeholder");
			Assert.assertEquals(actualPlaceholderName, expectedPlaceHolderName,
					"FAILED: Placeholder text mismatch! Expected: '" + expectedPlaceHolderName + "', Found: '" + actualPlaceholderName + "'");
			TestReporter.log("SUCCESS: Placeholder text matches expected value.");

			TestReporter.log("Step 3: Clicking on the Source Selection dropdown.");
			BaseTest.clickOperation(sourceDropdown);
			TestReporter.log("SUCCESS: Clicked on the Source Selection dropdown.");

			TestReporter.log("Step 4: Verifying that the Source Selection dropdown is enabled after clicking.");
			Assert.assertTrue(sourceDropdown.isEnabled(), "FAILED: Source Selection Dropdown is NOT highlighted.");
			TestReporter.log("SUCCESS: Source Selection Dropdown is highlighted and ready for selection.");

		} catch (Exception e) {
			TestReporter.log("ERROR: Unexpected issue while verifying the Source Selection Dropdown: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());
		} finally {
			TestReporter.log("===== Test Completed: Verified of Source Selection Dropdown Availability =====");
		}
	}

	/**
	 * verify the availability of the Destination Selection dropdown in the Create New Pipeline screen.
	 * It ensures the dropdown is displayed, validates the placeholder name, and checks if the dropdown becomes disabled after clicking.
	 *
	 * @author Lakshmipathi
	 * @param  expectedPlaceHolderName - The expected placeholder text for the Destination Selection dropdown.
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifyDestinationSelectionDropdownAvailability(String expectedPlaceHolderName) throws InterruptedException {

		WebElement destinationDropdown = BaseTest.createWebElement(verifydestinationselectiondropdown);
		try {
			TestReporter.log("===== START: Verifying Destination Selection Dropdown Availability =====");

			TestReporter.log("Step 1: Checking if the Destination Selection dropdown is displayed.");
			Assert.assertTrue(destinationDropdown.isDisplayed(), "FAILED: Destination Selection Dropdown is NOT available.");
			TestReporter.log("SUCCESS: Destination Selection Dropdown is displayed.");

			TestReporter.log("Step 2: Verifying the placeholder text of the Destination Selection dropdown.");
			String actualPlaceholderName = destinationDropdown.getAttribute("placeholder");
			Assert.assertEquals(actualPlaceholderName, expectedPlaceHolderName,
					"FAILED: Placeholder text mismatch! Expected: '" + expectedPlaceHolderName + "', Found: '" + actualPlaceholderName + "'");
			TestReporter.log("SUCCESS: Placeholder text matches expected value.");

			TestReporter.log("Step 3: Clicking on the Destination Selection dropdown.");
			BaseTest.clickOperation(destinationDropdown);
			TestReporter.log("SUCCESS: Clicked on the Destination Selection dropdown.");

			TestReporter.log("Step 4: Verifying that the Destination Selection dropdown becomes disabled after clicking.");
			Assert.assertFalse(!destinationDropdown.isEnabled(), "FAILED: Destination Selection Dropdown is still enabled after clicking.");
			TestReporter.log("SUCCESS: Destination Selection Dropdown is disabled after clicking as expected.");

		} catch (Exception e) {
			TestReporter.log("ERROR: Unexpected issue while verifying the Destination Selection Dropdown: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());
		} finally {
			TestReporter.log("===== END: Verified of Destination Selection Dropdown Availability =====");
		}
	}

	/**
	 * Verify Schema tab is available & it matched to expected Schema value
	 * 
	 * @author Lakshmipathi
	 * @param  expectedSchemaTab - Actual schema should match to the expected schema tab
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifySchemaTabsAvailability(String expectedSchemaTab) throws InterruptedException {

		WebElement schema = BaseTest.createWebElement(verifyschematab);
		try {
			TestReporter.log("===== START: Verifying Schema Tab Availability in Create New Pipeline Screen =====");
			String actualSchemaTab = schema.getText().trim();

			TestReporter.log("Step 1: Checking if the Schema tab is displayed.");
			Assert.assertTrue(schema.isDisplayed(), "FAILED: Schema Tab is NOT available.");
			TestReporter.log("SUCCESS: Schema Tab is displayed: " + actualSchemaTab);

			TestReporter.log("Step 2: Verifying if the actual schema tab name matches the expected schema tab name.");
			Assert.assertEquals(actualSchemaTab,expectedSchemaTab,
					"FAILED: Expected Schema Tab " + expectedSchemaTab + "Is Not Matched To Actual Tab" + actualSchemaTab);
			TestReporter.log("SUCCESS: Schema Tab name matches the expected value: "+ actualSchemaTab);

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying the tabs: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified of Tabs Availability in Create New Pipeline Screen =====");
		}
	}

	/**
	 * Verify Sync details tab is available & it matched to expected Sync details value & Sync details tab is not clickable
	 * 
	 * @author Lakshmipathi
	 * @param  expectedSchemaTab - Actual schema should match to the expected schema tab
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifySyncDetialsTabAvailability(String expectedSyncDetailsTab) throws InterruptedException {

		WebElement syncDetails = BaseTest.createWebElement(verifysyncdetailstab);
		try {

			TestReporter.log("===== Test Started: Verify Sync Details Tab Availablility In Create New Pipeline Screen =====");	
			String actualSyncDetails = syncDetails.getText().trim();

			TestReporter.log("Step 1 : Checking if the Sync Details tab is dispalyed.");
			Assert.assertTrue(syncDetails.isDisplayed(),"FAILED : Sync Details tab Is Not Displaying");
			TestReporter.log("SUCCESS : Sync Details Tab Is Displayed :" + actualSyncDetails );

			TestReporter.log("Step 2 : Verifying if the actual tab name matches to the expected tab name.");
			Assert.assertEquals(actualSyncDetails,expectedSyncDetailsTab,
					"FAILED: Expected Schema Tab " + expectedSyncDetailsTab + "Is Not Matched To Actual Tab" + actualSyncDetails);
			TestReporter.log("SUCCESS: Schema Tab name matches the expected value: "+ actualSyncDetails);

			TestReporter.log("Step 3: Verifying if the Sync Details tab is not clickable.");
			syncDetails.click();
			Assert.assertFalse(syncDetails.isSelected(), "FAILED: Sync Details Tab is clickable.");
			TestReporter.log("SUCCESS: Sync Detials Tab is not clickable as expected: "+ actualSyncDetails);

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying the tabs: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified of Sync Details Tab Availability in Create New Pipeline Screen =====");
		}
	}

	/**
	 * Verify Downstream tab is available & it matched to expected Downstream value & Downstream tab is not clickable
	 * 
	 * @author Lakshmipathi
	 * @param  expectedSchemaTab - Actual schema should match to the expected schema tab
	 * @throws InterruptedException - if the thread is interrupted during execution.
	 */
	public void verifyDownstreamTabAvailability(String expectedDownstreamTab) throws InterruptedException {

		WebElement downstream = BaseTest.createWebElement(verifydownstreamtab);
		try {

			TestReporter.log("===== Test Started: Verify Downstream Tab Availablility In Create New Pipeline Screen =====");	
			String actualDownstream = downstream.getText().trim();

			TestReporter.log("Step 1 : Checking if the Downstream tab is dispalyed.");
			Assert.assertTrue(downstream.isDisplayed(),"FAILED : Downstream tab Is Not Displaying");
			TestReporter.log("SUCCESS : Sync Details Tab Is Displayed :" + actualDownstream );

			TestReporter.log("Step 2 : Verifying if the actual Downstream tab name matches to the expected Downstream tab name.");
			Assert.assertEquals(actualDownstream,expectedDownstreamTab,
					"FAILED: Expected Downstream Tab " + expectedDownstreamTab + "Is Not Matched To Actual Downstream Tab" + actualDownstream);
			TestReporter.log("SUCCESS: Downstream Tab name matches the expected value: "+ actualDownstream);

			TestReporter.log("Step 3: Verifying if the Downstream tab is not clickable.");
			downstream.click();
			Assert.assertFalse(downstream.isSelected(), "FAILED: Downstream tab is clickable.");
			TestReporter.log("SUCCESS: Downstream Tab is not clickable as expected: "+ actualDownstream);

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying the tabs: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified Downstream Tab Availability in Create New Pipeline Screen =====");
		}

	}

	/**
	 * verify the availability of the Schema Tab in the Create New Pipeline screen.
	 * It ensures that the schema response body is displayed and validates the message content.
	 *
	 * @author Lakshmipathi
	 * @param expectedMessage The expected message displayed in the schema response body.
	 * @throws InterruptedException if the thread is interrupted during execution.
	 */
	public void verifySchemaTabAvailability(String expectedMessage) throws InterruptedException {

		WebElement verifyBody = BaseTest.createWebElement(verifyschemamessage);
		try {
			TestReporter.log("===== START: Verifying Schema Tab Availability =====");

			TestReporter.log("Step 1: Checking if the Schema Response Body is displayed.");
			Assert.assertTrue(verifyBody.isDisplayed(), "FAILED: Schema Response Body is NOT displayed.");
			TestReporter.log("SUCCESS: Schema Response Body is displayed.");

			String actualMessage = verifyBody.getText().trim();
			TestReporter.log("Step 2: Verifying if the actual message matches the expected message.");
			Assert.assertEquals(actualMessage, expectedMessage, 
					"FAILED: Schema message mismatch! Expected: '" + expectedMessage + "', Found: '" + actualMessage + "'");
			TestReporter.log("SUCCESS: Schema message matches the expected value.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying the Schema Tab: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verification of Schema Tab Availability =====");
		}
	}
}
