package com.brigita.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class FunctionalityCatalog extends BaseTest {

	By settingicon = By.xpath("//img[@ptooltip=\"Settings\"]");
	By clickcatalog = By.xpath("//img[@src='assets/sidemenu-icon/datasource-connector.png']/following-sibling::span[text()='Catalog ']");	
	By verifysearchfield = By.xpath("//span[@class='p-input-icon-left']/i[@class='pi pi-search']/following-sibling::input[@placeholder='Search']");


	/**
	 * @author Lakshmipathi Use of Method : Verify setting Icon Availability
	 * @throws InterruptedException : Metod might through an exception
	 */
	public void clickSettingicon() throws InterruptedException {

		TestReporter.log("Verify Setting Icon Is Available");
		WebElement setting = BaseTest.createWebElement(settingicon);
		TestReporter.log("Setting Icon Is Available");
		String expectedToolTip = "Settings";

		try {

			TestReporter.log("Verify Setting Icon Is Clickable");
			setting.click();
			TestReporter.log("SUCCESS : Setting Icon Is Clicked Successfully");

			Assert.assertTrue(setting.isEnabled(),"Failed : Setting icon is not highlighted");
			TestReporter.log("Success : setting icon is enabled");

			TestReporter.log("Verify Tooptip Is atched To Expected Tooltip");
			String actualTooltip = setting.getAttribute("ptooltip");
			Assert.assertEquals(actualTooltip, expectedToolTip, "Failed : Expected Tool tip " + expectedToolTip + "is Not Matched To Expected Tool Tip "  + actualTooltip);
			TestReporter.log("Expected Tooltip Is matched to expected tooltip");

		} catch ( Exception e) {

			TestReporter.log("Un Expected Eroor " + e.getStackTrace());
			TestReporter.log("Unexpected message " + e.getMessage());

		} finally {

			TestReporter.log("Test Compelted == Setting icon verified");

		}
	}

	/**
	 *
	 * @author  Lakshmipathi Use of Method : Verifies the Catalog menu's presence.
	 * @param   Expectedtext : The expected text (Catalog) of the Catalog menu to be verified.
	 * @throws  InterruptedException : If the test execution is interrupted.
	 */
	public void verifyCataLogMenu(String Expectedtext) throws InterruptedException {

		WebElement catalog = BaseTest.createWebElement(clickcatalog);

		try {

			TestReporter.log("==== Test Start: Verifying Catalog Menu ====");

			TestReporter.log("Step 1: Verifying that the Catalog menu is available with the correct text.");
			String actualText = catalog.getText().trim();
			Assert.assertTrue(actualText.equals(Expectedtext),"FAILED: Catalog menu is not available with the correct spelling. Expected: " + Expectedtext + ", Found: " + actualText);
			TestReporter.log("SUCCESS: Catalog menu text is displayed correctly: " + Expectedtext);

			TestReporter.log("Step 2: Clicking on the Catalog menu.");
			BaseTest.clickOperation(catalog);
			TestReporter.log("SUCCESS: Catalog menu clicked successfully.");

			TestReporter.log("Step 3: Verifying if the Catalog menu is highlighted.");
			Assert.assertTrue(catalog.isEnabled(), "FAILED: Catalog menu is not highlighted.");
			TestReporter.log("SUCCESS: Catalog menu is highlighted and enabled.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Catalog Menu.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Catalog Menu ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the visibility of the Search field with the search image in the Nockpoint Apps screen.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifySearchField() throws InterruptedException {

		WebElement searchField = BaseTest.createWebElement(verifysearchfield);
		String connectorName = "Hubspot";

		try {

			TestReporter.log("==== Test Start: Verifying Search Field ====");

			TestReporter.log("Step 1: Verifying that the Search field with the search image is displayed.");
			Assert.assertTrue(searchField.isDisplayed(), "FAILED: Search Field with search image is not displayed.");
			TestReporter.log("SUCCESS: Search Field with search image is displayed correctly.");

			TestReporter.log("Proide Connector Name In The search Field ");
			searchField.sendKeys(connectorName);
			TestReporter.log("Connector Name Is Provided in the search field");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Search Field.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Search Field ====");
		}
	}


	public void clickHubspotConnectButton() throws InterruptedException {

		TestReporter.log("Verify SynamicConnector Locator Is Available");
		String dynamicconnectorname = "Hubspot";
		By verifyaha = By.xpath("//span[text()='"+ dynamicconnectorname +"']");
		WebElement name = BaseTest.createWebElement(verifyaha);
		TestReporter.log("Dynamic Connector Name Is Available");

		try {

			TestReporter.log("Mouse Hover On Particular Connector");
			BaseTest.mouseHoverOnElement(name);
			TestReporter.log("Mouse Hovered On Particular Connector");

			TestReporter.log("Verify SynamicConnector Locator 'Connect Button' Is Available");
			String xpath = "//span[text()='"+ dynamicconnectorname +"']/following::div/p-button[@label='Connect']";		
			TestReporter.log("Dynamic Connector Name 'Connect Button' Is Available");

			WebElement clickaction = driver.findElement(By.xpath(xpath));
			clickaction.click();
			TestReporter.log("Dynamic Connector connect button is clicked");
		} catch ( Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Search Field.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Search Field ====");
		}
	}

}
