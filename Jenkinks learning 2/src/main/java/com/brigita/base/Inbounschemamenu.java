package com.brigita.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class Inbounschemamenu extends BaseTest {

	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By clickinbound = By.xpath("//img[@src='assets/sidemenu-icon/company-profile.png']/following-sibling::span[text()='Inbound Schema ']");	
	By verifyinboundtext = By.xpath("//h3[text()='Inbound Mapping']");
	By verifyalllink = By.xpath("//span[text()='ALL']");
	By verifymappinglink = By.xpath("//span[text()='Mapped']");
	By verifyunmappedlink = By.xpath("//span[text()='Unmapped']");

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
	 * Verifies the Inbound schema menu in the application.
	 * Checks if the menu is available, displays the correct text and logo, and is highlighted after clicking.
	 * 
	 * @author Lakshmipathi
	 * @param  expectedText - The expected text of the Inbound Schema menu.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifInboundSchemaMenu(String expectedText) throws InterruptedException {

		WebElement pipeline = BaseTest.createWebElement(clickinbound); 
		try {

			TestReporter.log("===== Starting Test: Verify Inbound Schema Menu =====");

			TestReporter.log("Step 1: Verifying Inbound Schema Menu availability with correct spelling and logo."); 
			String actualText = pipeline.getText().trim();
			Assert.assertEquals(actualText, expectedText, 
					"FAILED: Expected Inbound Schema Menu text '" + expectedText + "', but found '" + actualText + "'");

			TestReporter.log("SUCCESS: Inbound Schema Menu is correctly displayed as: " + expectedText);

			TestReporter.log("Step 2: Clicking on the Inbound Schema Menu.");
			BaseTest.clickOperation(pipeline);

			TestReporter.log("SUCCESS: Inbound Schema Menu is Clicked Successfully");

			TestReporter.log("Step 3: Verifying if the Inbound Schema Menu is highlighted after clicking.");
			Assert.assertTrue(pipeline.isEnabled(), "FAIlED: Inbound Schema Menu is not highlighted after selection.");

			TestReporter.log("SUCCESS: Inbound Schema Menu is highlighted correctly after clicking.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying the Inbound Schema Menu: " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified Inbound Schema Menu =====");
		}
	}

	/**
	 * verify whether the "Inbound Mapping" text is visible on the UI
	 * 
	 * @author Lakshmipathi 
	 * @param  expectedtext - The expected text of the Inbound Mapping text.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifyInboundMappingText(String expectedText) throws InterruptedException {

		WebElement inboundMapping = BaseTest.createWebElement(verifyinboundtext);
		try {

			TestReporter.log("===== Test Started: Verify Inbound Mapping Text =====");

			TestReporter.log("Step 1: Verifying if the Inbound Mapping text is visible on the screen.");
			if (inboundMapping.isDisplayed()) {
				TestReporter.log("SUCCESS: 'Inbound Mapping' text is visible and appears with correct spelling.");

			} else {

				TestReporter.log("FAILED: 'Inbound Mapping' text is either not visible or may be misspelled.");
				Assert.fail();
			}

			TestReporter.log("Step 2 : Verify the actual output text matched to the exepected 'Inbound Mapping' text");
			String actualOutPut = inboundMapping.getText().trim();
			Assert.assertEquals(actualOutPut, expectedText, 
					"FAILED: Actual output text does not match the expected 'Inbound Mapping' text. Expected: '" 
							+ expectedText + "', but found: '" + actualOutPut + "'");
			TestReporter.log("SUCCESS: Actual output text matches the expected 'Inbound Mapping' text.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying the Inbound Mapping text - " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verify Inbound Mapping Text =====");
		}
	}

	/**
	 * verifies the visibility, correctness, and clickability of 'ALL' link.
	 * 
	 * @author Lakshmipathi
	 * @param  expectedText - The expected text of the ALL links.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifyAllLink(String expectedText) throws InterruptedException {

		WebElement links = BaseTest.createWebElement(verifyalllink);

		try {

			TestReporter.log("===== Test Started: Verify 'ALL Link =====");

			TestReporter.log("Step 1: Verifying that the 'ALL' link is visible on the screen.");
			Assert.assertTrue(links.isDisplayed(), "FAILED: The 'ALL' link is not visible.");
			TestReporter.log("SUCCESS: The 'ALL' link is visible on the screen.");

			TestReporter.log("Step 2: Validating the actual text of the link matches the expected text.");
			String actualOutput = links.getText().trim();
			Assert.assertEquals(actualOutput, expectedText, "FAILED: Expected output '" + expectedText + "' does not match expected to actual output'" + actualOutput + "'.");
			TestReporter.log("SUCCESS: Actual output "+ actualOutput + "matches expected text: '" + expectedText + "'.");

			TestReporter.log("Step 3: Clicking on the '" + expectedText + "' link.");
			BaseTest.clickOperation(links);
			TestReporter.log("SUCCESS: Successfully clicked on the '" + expectedText + "' link.");

			// TODO: Handle toast message after click if needed

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying All link - " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified 'ALL' Link =====");
		}
	}

	/**
	 * verifies the visibility, correctness, and clickability of 'Mapped' link.
	 * 
	 * @author Lakshmipathi
	 * @param  expectedText - The expected text of the Mapped links.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifyMappingLink(String expectedText) throws InterruptedException {

		WebElement links = BaseTest.createWebElement(verifymappinglink);

		try {

			TestReporter.log("===== Test Started: Verify 'Mapped' Link =====");

			TestReporter.log("Step 1: Verifying that the 'Mapped' link is visible on the screen.");
			Assert.assertTrue(links.isDisplayed(), "FAILED: The 'Mapped' link is not visible.");
			TestReporter.log("SUCCESS: The 'Mapped' link is visible on the screen.");

			TestReporter.log("Step 2: Validating the actual text of the link matches the expected text.");
			String actualOutput = links.getText().trim();
			Assert.assertEquals(actualOutput, expectedText, "FAILED: Expected output '" + expectedText + "' does not match expected to actual output'" + actualOutput + "'.");
			TestReporter.log("SUCCESS: Actual output "+ actualOutput + "matches expected text: '" + expectedText + "'.");

			TestReporter.log("Step 3: Clicking on the '" + expectedText + "' link.");
			BaseTest.clickOperation(links);
			TestReporter.log("SUCCESS: Successfully clicked on the '" + expectedText + "' link.");

			// TODO: Handle toast message after click if needed

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying Mapped links - " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified 'Mapped' Links =====");
		}
	}

	/**
	 * verifies the visibility, correctness, and clickability of 'Unmapped' link.
	 * 
	 * @author Lakshmipathi
	 * @param  expectedText - The expected text of the Unmapped links.
	 * @throws InterruptedException - If the thread is interrupted.
	 */
	public void verifyUnmappedLink(String expectedText) throws InterruptedException {

		WebElement links = BaseTest.createWebElement(verifyunmappedlink);

		try {

			TestReporter.log("===== Test Started: Verify 'Unmapped' Link =====");

			TestReporter.log("Step 1: Verifying that the 'Unmapped' link is visible on the screen.");
			Assert.assertTrue(links.isDisplayed(), "FAILED: The 'Unmapped' link is not visible.");
			TestReporter.log("SUCCESS: The 'Unmapped' link is visible on the screen.");

			TestReporter.log("Step 2: Validating the actual text of the link matches the expected text.");
			String actualOutput = links.getText().trim();
			Assert.assertEquals(actualOutput, expectedText, "FAILED: Expected output '" + expectedText + "' does not match expected to actual output'" + actualOutput + "'.");
			TestReporter.log("SUCCESS: Actual output "+ actualOutput + "matches expected text: '" + expectedText + "'.");

			TestReporter.log("Step 3: Clicking on the '" + expectedText + "' link.");
			BaseTest.clickOperation(links);
			TestReporter.log("SUCCESS: Successfully clicked on the '" + expectedText + "' link.");

			// TODO: Handle toast message after click if needed

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered while verifying Unmapped links - " + e.getMessage());
			Assert.fail("Test failed due to an unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("===== Test Completed: Verified 'Unmapped' Links =====");
		}
	}

}
