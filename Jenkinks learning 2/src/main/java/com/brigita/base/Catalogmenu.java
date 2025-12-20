package com.brigita.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class Catalogmenu extends BaseTest {


	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By clickcatalog = By.xpath("//img[@src='assets/sidemenu-icon/datasource-connector.png']/following-sibling::span[text()='Catalog ']");	
	By verifynockpointappstext = By.xpath("//h3[text()='Nockpoint Apps']");
	By verifyallappstext = By.xpath("//span[text()='All Apps']");
	By verifysearchfield = By.xpath("//span[@class='p-input-icon-left']/i[@class='pi pi-search']/following-sibling::input[@placeholder='Search']");
	By verifyconnectors = By.xpath("//div[@style='display: flex; justify-content: center;']/following-sibling::div/div[@class='row']");
	By verifyfilterbycategory = By.xpath("//span[contains(text(),'Filter by category')]");
	By verifylistofdata = By.xpath("//li[@role='option']");
	By verifysortoption = By.xpath("//i[@class='pi pi-sort-alpha-down _sortIcon _curpointer ng-star-inserted']");
	By clickviewconnectedapps = By.xpath("//span[contains(text(),'View Connected Apps')]");
	By verifyconnectedapps = By.xpath("//div[@class='_connectorTab mt-2 styleAlign']/div/div");
	By verifyviewallapps = By.xpath("//span[text()='View All Apps']");
	By verifyresponsetime = By.xpath("//div[@class='_connectorTab mt-2 styleAlign']/div");
	By verifynpsnowflake = By.xpath("//span[text()='NP Snowflake']/following::div[@style='display: flex; justify-content: start;']");
	By verifyaha = By.xpath("//span[text()='Aha']");
	By verifyconnecttext = By.xpath("//span[text()='Aha']/following::div/p-button[@label='Connect']");

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
	 * @author Lakshmipathi Use of Method : Verifies the visibility of the "Nockpoint Apps" text.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyNockpointAppsText() throws InterruptedException {

		WebElement nockpointAppsText = BaseTest.createWebElement(verifynockpointappstext);

		try {

			TestReporter.log("==== Test Start: Verifying Nockpoint Apps Text ====");

			TestReporter.log("Step 1: Verifying that the 'Nockpoint Apps' text is displayed on the screen.");
			Assert.assertTrue(nockpointAppsText.isDisplayed(), "FAILED: 'Nockpoint Apps' text is not displayed.");
			TestReporter.log("SUCCESS: 'Nockpoint Apps' text is displayed correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Nockpoint Apps text.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Nockpoint Apps Text ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the visibility of the "All Apps" text.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyAllAppsText() throws InterruptedException {

		WebElement allAppsText = BaseTest.createWebElement(verifyallappstext);

		try {

			TestReporter.log("==== Test Start: Verifying 'All Apps' Text ====");

			TestReporter.log("Step 1: Verifying that the 'All Apps' text is displayed on the Nockpoint Apps screen.");
			Assert.assertTrue(allAppsText.isDisplayed(), "FAILED: 'All Apps' text is not displayed.");
			TestReporter.log("SUCCESS: 'All Apps' text is displayed correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the 'All Apps' text.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified 'All Apps' Text ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the visibility of the Search field with the search image in the Nockpoint Apps screen.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifySearchField() throws InterruptedException {

		WebElement searchField = BaseTest.createWebElement(verifysearchfield);

		try {

			TestReporter.log("==== Test Start: Verifying Search Field ====");

			TestReporter.log("Step 1: Verifying that the Search field with the search image is displayed.");
			Assert.assertTrue(searchField.isDisplayed(), "FAILED: Search Field with search image is not displayed.");
			TestReporter.log("SUCCESS: Search Field with search image is displayed correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the Search Field.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Search Field ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the availability of expected connectors on the Catalog screen.
	 * @param  expectedConnectors : The expected connectors that should be displayed on the Catalog screen.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyConnectorsAvailability() throws InterruptedException {

		List<WebElement> allLocators = BaseTest.createWebElement1(verifyconnectors);

		List<String> expectedList = Arrays.asList(
				"Aha", "Aircall", "Airtable", "Asana", "Auth0", "AWS CloudTrail", "BambooHR", "BigQuery",
				"Chargebee", "Chartmogul", "Clinical Trial", "Clockify", "CMS Medical", "Coda", "ConfigCat", 
				"Confluence", "Copper", "Customer.io", "Delighted", "Dialpad", "Docker Hub", "Drift", 
				"Everhour", "Facebook Marketing", "Freshdesk", "Frontegg Events", "FrontEgg Users", "GitHub", 
				"Google Drive", "Google Search Console", "Google Sheet for Plan", "Google Sheet for Quota", 
				"GoogleSheet", "Harvest", "Hub Planner", "Hubspot", "Hubspot Analytics", 
				"Hubspot Analytics History", "Hubspot Contact History", "Inspectlet", "Intercom", "Jenkins", 
				"Jira", "K6 Cloud", "LinkedIn Ads", "LinkedIn Pages", "Mailchimp", "Monday", "MyHours", "MySQL", 
				"NP Snowflake", "Onelogin", "Open Exchange Rates", "Outreach", "PagerDuty", "Postgres", 
				"PostHog", "QuickBooks", "RudderStack", "S3", "Salesforce", "Salesforce (Sandbox)", "Shopify", 
				"Slack", "Snowflake", "Stripe", "SurveyMonkey", "test14datasss", "test30012025", "Testmo", 
				"to", "Todoist", "Trello", "Twilio", "Typeform", "Workable", "Wrike", "Xero", "Zendesk Sell", 
				"Zendesk support", "Zenefits", "Glassfrog", "IP2Whois", "Klaviyo", "Freshcaller", 
				"Freshsales", "Freshservice", "Okta", "Reddit Ads", "S3_V2", "Tik Tok", "aprils", "OneDrive",
				"Plaid", "Timely", "WooCommerce", "YouTube Analytics Business"
				);

		try {
			TestReporter.log("==== Test Start: Verifying Connectors Availability ====");

			TestReporter.log("Step 1: Extracting actual connector texts from the Catalog screen.");
			List<String> actualConnectorTexts = new ArrayList<>();
			for (WebElement element : allLocators) {
				actualConnectorTexts.add(element.getText().trim());
			}

			TestReporter.log("Step 2: Verifying that all expected connectors are displayed.");
			for (String connector : expectedList) {
				Assert.assertTrue(actualConnectorTexts.contains(connector),"FAILED: Connector '" + connector + "' is NOT displayed in the Catalog screen.");
				TestReporter.log("SUCCESS: Connector '" + connector + "' is correctly displayed.");
			}

			TestReporter.log("Step 3: Verifying that no extra connectors are present.");
			List<String> extraConnectors = new ArrayList<>(actualConnectorTexts);
			extraConnectors.removeAll(expectedList);

			Assert.assertTrue(extraConnectors.isEmpty(),"FAILED: Extra connectors found in the catalog: " + extraConnectors);
			TestReporter.log("SUCCESS: No extra connectors found in the Catalog screen.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error occurred while verifying the connectors.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Connectors Availability ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies that the filter by category dropdown contains the expected options.
	 * @param  expectedList : The expected category options to be available in the dropdown.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyFilterByCategory() throws InterruptedException {

		WebElement applyFiltersText = BaseTest.createWebElement(verifyfilterbycategory);
		try {

			TestReporter.log("==== Test Start: Verifying Filter By Category ====");

			TestReporter.log("Step 1: Verifying that the 'Filter By Category' text is displayed.");
			Assert.assertTrue(applyFiltersText.isDisplayed(), "FAILED: 'Filter By Category' text is not displayed in the dropdown.");
			TestReporter.log("SUCCESS: 'Filter By Category' text is displayed correctly.");

			TestReporter.log("Step 2: Clicking on the 'Filter By Category' dropdown.");
			BaseTest.clickOperation(applyFiltersText);
			TestReporter.log("SUCCESS: 'Filter By Category' dropdown is Clicked ");

			List<WebElement> allOptions = BaseTest.createWebElement1(verifylistofdata);
			TestReporter.log("Step 3: Verifying dropdown options...");
			List<String> expectedFilters =  Arrays.asList("Sales","Marketing","All");

			List<String> actualFilters = new ArrayList<>();

			System.out.println("===== Printing all dropdown options =====");
			for (WebElement option : allOptions) {
				String text = option.getText().trim();
				actualFilters.add(text); 
				System.out.println("Dropdown Data: " + text); 
			}

			TestReporter.log("Verifying that the actual option texts match the expected list.");
			Assert.assertEquals(actualFilters,expectedFilters, "FAILED : Expected Filter " + expectedFilters + " Is Not Matched To The Actual Filter " +  actualFilters + ".");
			TestReporter.log("SUCCESS: Expected Filter " + expectedFilters + "Is Matched To The Actual Filters " + actualFilters + "." );

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected error while verifying the filter dropdown.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Filter By Category ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies that the sorting option (A-Z, Z-A) is available on the Catalog screen.
	 * @throws InterruptedException - If the test execution is interrupted.
	 */
	public void verifySortOption() throws InterruptedException {

		WebElement sort = BaseTest.createWebElement(verifysortoption);

		try {

			TestReporter.log("==== Test Start: Verifying Sort Option Availability ====");

			TestReporter.log("Step 1: Checking if the sorting option (A-Z, Z-A) is available.");
			Assert.assertTrue(sort.isDisplayed(),"FAILED: Sorting option (A-Z, Z-A) is NOT available on the Catalog screen.");
			TestReporter.log("SUCCESS: Sorting option (A-Z, Z-A) is correctly displayed on the Catalog screen.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying the sorting option.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Sort Option Availability ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi : Verifies the 'View Connected Apps' button is available, checks its text, and clicks on it.
	 * @param  expectedText : The expected text on the 'View Connected Apps' button.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyAndClickOnViewConnectedApps(String expectedText) throws InterruptedException {

		WebElement connectedButton = BaseTest.createWebElement(clickviewconnectedapps);

		try {

			TestReporter.log("==== Test Start: Verifying 'View Connected Apps' Button ====");

			TestReporter.log("Step 1: Checking if the 'View Connected Apps' button is available on the Catalog screen.");
			Assert.assertTrue(connectedButton.isDisplayed(),"FAILED: 'View Connected Apps' button is NOT available.");
			TestReporter.log("SUCCESS: 'View Connected Apps' button is displayed correctly.");

			TestReporter.log("Step 2: Verifying the text on the 'View Connected Apps' button.");
			String actualText = connectedButton.getText().trim();
			Assert.assertEquals(actualText, expectedText,"FAILED: Mismatch in 'View Connected Apps' button text! Expected: '" + expectedText + "', but found: '" + actualText + "'.");
			TestReporter.log("SUCCESS: The button text matches the expected value: '" + expectedText + "'.");

			TestReporter.log("Step 3: Clicking on the 'View Connected Apps' button.");
			BaseTest.clickOperation(connectedButton);
			TestReporter.log("SUCCESS: Click action performed on 'View Connected Apps' button.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying 'View Connected Apps' button.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified 'View Connected Apps' Button ====");
		}
	}

	/**
	 * 
	 * @author Lakshmipathi Use of Method : Verifies that all connectors display the 'Connected' status.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyConnectorStatus() throws InterruptedException {

		List<WebElement> connectors = BaseTest.createWebElements(verifyconnectedapps);
		boolean isAllConnected = true; // Flag to track if all connectors display "Connected"

		try {

			TestReporter.log("==== Test Start: Verifying Connector Status ====");

			// Step 1: Check if connectors are available
			TestReporter.log("Step 1: Checking if connectors are available on the Catalog screen.");
			Assert.assertFalse(connectors.isEmpty(), 
					"FAILED: No connectors found on the Catalog screen.");
			TestReporter.log("SUCCESS: Connectors are available.");

			// Step 2: Verify each connector displays 'Connected'
			TestReporter.log("Step 2: Validating 'Connected' status for each connector.");
			for (WebElement connector : connectors) {
				String text = connector.getText().trim();
				TestReporter.log("Connector Found: " + text);

				if (!text.contains("Connected")) {
					isAllConnected = false; // Mark as failed if one connector is missing "Connected"
					TestReporter.log("FAILED: Connector missing 'Connected' status: " + text);
				}
			}

			Assert.assertTrue(isAllConnected,"FAILED: One or more connectors do not display 'Connected' status.");
			TestReporter.log("SUCCESS: All connectors display 'Connected' correctly.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying connector status.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Connector Status ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the 'View All Apps' button on the Catalog screen and clicks it.
	 * @param  expectedText : The expected text of the 'View All Apps' button.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyAndClickOnViewAllApps(String expectedText) throws InterruptedException {

		WebElement viewAllButton = BaseTest.createWebElement(verifyviewallapps);

		try {

			TestReporter.log("==== Test Start: Verifying 'View All Apps' Button ====");

			TestReporter.log("Step 1: Checking if 'View All Apps' button is displayed on the Catalog screen.");
			Assert.assertTrue(viewAllButton.isDisplayed(),"FAILED: 'View All Apps' button is NOT available.");
			TestReporter.log("SUCCESS: 'View All Apps' button is visible.");

			TestReporter.log("Step 2: Validating the text displayed on 'View All Apps' button.");
			String actualText = viewAllButton.getText().trim();
			Assert.assertEquals(actualText, expectedText,"FAILED: Mismatch in 'View All Apps' button text. Expected: '" + expectedText + "', Found: '" + actualText + "'.");
			TestReporter.log("SUCCESS: 'View All Apps' button text is correct: " + actualText);

			TestReporter.log("Step 3: Clicking on the 'View All Apps' button.");
			BaseTest.clickOperation(viewAllButton);
			TestReporter.log("SUCCESS: Click operation on 'View All Apps' button was successful.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue while verifying 'View All Apps' button.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified 'View All Apps' Button ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies that connectors are displayed within 10 seconds on the catalog screen.
	 * @throws InterruptedException : If the test execution is interrupted.
	 */
	public void verifyResponseTimeOfConnectors() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			TestReporter.log("==== Test Start: Verifying Connector Response Time ====");

			TestReporter.log("Step 1: Checking if connectors are displayed within 10 seconds.");
			wait.until(ExpectedConditions.visibilityOf(BaseTest.createWebElement(verifyresponsetime)));
			TestReporter.log("Success: Connectors displayed within 10 seconds.");

		} catch (TimeoutException e) {

			TestReporter.log("Error: Connectors were not visible within 10 seconds.");
			Assert.fail("Test failed: Table body was not visible within 10 seconds. " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified Connector Response Time ====");
		}
	}

	/**
	 *
	 * @author Lakshmipathi Use of Method : Verifies the 'Connect' or 'Connected' text after hovering over connectors.
	 * @throws InterruptedException : if the thread is interrupted during execution.
	 */
	public void verifyConnectOrConnectedTextAfterHover() throws InterruptedException {

		WebElement npsnowflake = BaseTest.createWebElement(verifynpsnowflake);
		WebElement aha = BaseTest.createWebElement(verifyaha);

		try {

			TestReporter.log("==== Test Start: Verifying 'Connect' or 'Connected' Text After Hover ====");

			TestReporter.log("Step 1: Verifying the 'Connected' text for NP Snowflake connector.");
			String actualValue = npsnowflake.getText();
			String expectedValue = "Connected";
			Assert.assertTrue(actualValue.contains(expectedValue),"FAILED: 'Connected' text is NOT displayed for NP Snowflake connector. Found: " + actualValue);
			TestReporter.log("SUCCESS: 'Connected' text correctly displayed for NP Snowflake connector.");

			TestReporter.log("Step 2: Hovering over Aha connector...");
			BaseTest.mouseHoverOnElement(aha);

			WebElement ahaConnect = BaseTest.createWebElement(verifyconnecttext);
			TestReporter.log("Fetching the displayed text for Aha connector after hover");
			String actualValue1 = ahaConnect.getText();
			String expectedValue1 = "Connect";
			Assert.assertTrue(actualValue1.contains(expectedValue1),"FAILED: 'Connect' text is NOT displayed for Aha connector after hover. Found: " + actualValue1);
			TestReporter.log("SUCCESS: 'Connect' text correctly displayed for Aha connector after hover.");

			TestReporter.log("Completed verification of NP Snowflake and Aha connector text successfully.");

		} catch (Exception e) {

			TestReporter.log("ERROR: Unexpected issue encountered during verification.");
			Assert.fail("Test failed due to unexpected error: " + e.getMessage());

		} finally {

			TestReporter.log("==== Test End: Verified 'Connect' or 'Connected' Text After Hover ====");
		}
	}
}
