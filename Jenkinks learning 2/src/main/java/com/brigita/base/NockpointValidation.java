package com.brigita.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class NockpointValidation  {


	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By catalogMenu = By.xpath("//span[text()='Catalog '] ");
	By searchField = By.cssSelector("[placeholder='Search']");
	By mouseHoverOnConnector = By.xpath("//span[text()='Onelogin']");
	By connectButton = By.xpath("//span[text()='Connect']");
	By connectionName = By.cssSelector("[placeholder='Name']");
	By connectionDescription = By.cssSelector("[placeholder='Description']");
	By nextButtonAtStep1 = By.xpath("//button[text()=' Next : Credentials '] ");
	By testConnectionButton = By.xpath("//button[text()=' Test Connection '] ");
	By startAIButton = By.xpath("//button[text()='Start AI Setup']");
	By returnToSettingButton = By.xpath("//a[text()='Return to Settings']");
	By viewConnectedAppsButton = By.xpath("//span[text()='View Connected Apps']");
	By integrationMenu = By.xpath("//span[text()='Integration '] ");
	By viewDetailsIcon = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), ' Hubspot ')]/following-sibling::td/img[@ptooltip='View Details']");
	By pipelineMenu = By.xpath("//span[text()='Pipeline ']");
	By viewDetailsIconPipeline = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), 'Hubspot')]/following-sibling::td/img[@ptooltip='View & Edit']");
	By enabledTabless = By.xpath("//div[@class='p-inputswitch p-component p-inputswitch-checked']/../following::td[2]");
	By syncDetailsTab = By.xpath("//span[text()=' Sync Details '] ");
	By defaultSyncTime = By.xpath("//p-dropdown[@optionlabel='label']");
	By downstreamTab = By.xpath("//span[text()=' DownStream '] ");
	By logs =By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), 'Hubspot')]/following-sibling::td/img[@ptooltip='Pipeline Logs']");
	By downsteam = By.xpath("//div[@class='ng-star-inserted']//div/div[1]/div[2]/div/div[2]");
	By eventsTableFields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' ACCOUNT_ID ' or text()=' CREATED_AT ' or text()=' USER_ID ' or text()=' ACTOR_USER_ID ' or text()=' EVENT_TYPE_ID ' or text()=' APP_ID ' or text()=' ROLE_ID ' or text()=' GROUP_ID ' or text()=' USER_NAME ' or text()=' ACTOR_USER_NAME ' or text()=' ROLE_NAME ' or text()=' NOTES ')]");
	By appsTableFields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' NAME ' or text()=' AUTH_METHOD ' or text()=' UPDATED_AT ' or text()=' CONNECTOR_ID ' or text()=' CREATED_AT ' or text()=' DESCRIPTION ' or text()=' AUTH_METHOD_DESCRIPTION ')]");
	By appsUsersTableFields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' APP_ID ' or text()=' USERNAME ' or text()=' FIRSTNAME ' or text()=' LASTNAME ' or text()=' EMAIL ')]");
	By usersTableFields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' CREATED_AT ' or text()=' STATUS ' or text()=' STATE ' or text()=' FIRSTNAME ' or text()=' LASTNAME ' or text()=' USERNAME ' or text()=' TITLE ' or text()=' DEPARTMENT ' or text()=' EMAIL ' or text()=' ACTIVATED_AT ' or text()=' LOCKED_UNTIL ' or text()=' LAST_LOGIN ' or text()=' UPDATED_AT ' or text()=' INVITATION_SENT_AT ' or text()=' ROLE_ID ' or text()=' GROUP_ID ' or text()=' DIRECTORY_ID ' or text()=' COMPANY ' or text()=' PASSWORD_CHANGED_AT ' or text()=' MANAGER_USER_ID ' or text()=' INVALID_LOGIN_ATTEMPTS ' or text()=' LOCALE_CODE ' or text()=' TRUSTED_IDP_ID ')]");
	By usersAppsTableFields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' USER_ID ' or text()=' LOGIN_ID ' or text()=' EXTENSION ' or text()=' PROVISIONED ' or text()=' NAME ' or text()=' PERSONAL ')]");
	By clickDropdown = By.xpath("//button[@icon=\"pi pi-chevron-down\"]");
	By clickPDF = By.xpath("//ul[@role='menu']/li/a/span[2][text()='PDF']");
	By verifytoastemessage = By.xpath("//div[contains(text(),'Export has started. ')]");
	By verifysuccesfulltoastmessage = By.xpath("//div[contains(text(),'Exporting the dashboard completed successfully and saved in local. ')]");
	By clickonfilters = By.xpath("//i[@class='pi pi-filter']");
	By clickapplyfiltersdropdown = By.xpath("//div[@aria-haspopup='listbox']");
	By applyfilters = By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']//li/span[text()='Previous Year']");
	By clickapplyfiltes = By.xpath("//button[text()=' All Filters ']");
	By removefilters = By.xpath("//p[text()='Clear all filters']");
	By closefiltertab = By.xpath("//div[contains(@class,'p-dialog-header-icons ')]");
	By clickimage = By.xpath("//ul[@role='menu']/li/a/span[2][text()='Image']");	
	By clickgoogledoc = By.xpath("//ul[@role='menu']/li/a/span[2][text()='Google Doc']");
	By provideemail = By.xpath("//input[@type='email']");
	By clickemail = By.xpath("//div[@class='DOLDDf']");
	By providepassword = By.xpath("//input[@type='password']");
	By clicknext = By.xpath("//span[text()='Next']");
	By clickadvance = By.xpath("//a[text()='Advanced']");
	By clickgotonockpoint = By.xpath("//a[text()='Go to Nockpoint (unsafe)']");
	By clickconnectbutton = By.xpath("//span[text()='Continue']");
	By clickgoogleslides = By.xpath("//ul[@role='menu']/li/a/span[2][text()='Google Slides']");
	By verifyondemandtoast = By.xpath("//div[text()='Data Sync started']");
	By hub_companiesfields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' ARCHIVED ')]");
	By hub_companies_properties = By.xpath("//span[@class='dtextone' and (text()=' NAME ' or text()=' TYPE ' or text()=' INDUSTRY ' or text()=' ANNUALREVENUE ' or text()=' NUMBEROFEMPLOYEES ' or text()=' HUBSPOT_OWNER_ID ' or text()=' COUNTRY ' or text()=' PARENT_ID ')]");
	By hub_Dealsfields = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' ARCHIVED ' or text()=' CREATEDAT ')]");
	By hub_dealsproperties = By.xpath("//span[@class='dtextone' and (text()=' PARENT_ID ' or text()=' HS_ANALYTICS_LATEST_SOURCE ' or text()=' ENGAGEMENTS_LAST_MEETING_BOOKED_CAMPAIGN ' or text()=' DEALNAME ' or text()=' DEALSTAGE ' or text()=' AMOUNT_IN_HOME_CURRENCY ' or text()=' CLOSEDATE ' or text()=' DEALTYPE ' or text()=' HS_IS_CLOSED ' or text()=' HS_IS_CLOSED_WON ' or text()=' HUBSPOT_OWNER_ID ' or text()=' HS_CREATED_BY_USER_ID ' or text()=' DESCRIPTION ' or text()=' HS_ARR ' or text()=' HS_ACV ' or text()=' HS_FORECAST_PROBABILITY ' or text()=' HS_MANUAL_FORECAST_CATEGORY ' or text()=' HS_LASTMODIFIEDDATE ' or text()=' HS_NEXT_STEP ' or text()=' CLOSED_LOST_REASON ' or text()=' HS_MANUAL_FORECAST_CATEGORY ' or text()=' HS_DATE_ENTERED_QUALIFIEDTOBUY ' or text()=' HS_DATE_ENTERED_APPOINTMENTSCHEDULED ' or text()=' HS_DATE_ENTERED_DECISIONMAKERBOUGHTIN ' or text()=' HS_DATE_ENTERED_CLOSEDLOST ' or text()=' HS_DATE_ENTERED_PRESENTATIONSCHEDULED ' or text()=' HS_DATE_ENTERED_CONTRACTSENT ' or text()=' HS_DATE_ENTERED_CLOSEDWON ' or text()=' HS_TCV ' or text()=' HS_ARR ' or text()=' HS_FORECAST_AMOUNT ')]");
	By hub_dealassociation = By.xpath("//span[@class='dtextone' and (text()=' PARENT_ID ' or text()=' ASSOCIATION_TYPE ' or text()=' OBJECT_ID ' )]");
	By hub_lineitems = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' ARCHIVED ' or text()=' CREATEDAT ' )]");
	By hub_lineitemproperties = By.xpath("//span[@class='dtextone' and (text()=' PARENT_ID ' or text()=' HS_PRODUCT_ID ' or text()=' PRICE ' or text()=' DISCOUNT ' or text()=' QUANTITY ' or text()=' HS_RECURRING_BILLING_START_DATE ' or text()=' HS_RECURRING_BILLING_END_DATE ' or text()=' NAME ' or text()=' HS_SKU ' or text()=' HS_ACV ' or text()=' HS_TCV '  )]");
	By hub_owners = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' EMAIL ' or text()=' FIRSTNAME ' or text()=' LASTNAME ' or text()=' CREATEDAT ' or text()=' ARCHIVED ' or text()=' USERID '   )]");
	By hub_ownerteams = By.xpath("//span[@class='dtextone' and (text()=' ID ' or text()=' NAME ' )]");
	By hub_product2 = By.xpath("//span[@class='dtextone' and (text()=' ID ' )]");
	By hub_productproperties = By.xpath("//span[@class='dtextone' and (text()=' NAME ' or text()=' DESCRIPTION ' or text()=' HS_SKU ' or text()=' PARENT_ID ' )]");
	By hub_contacts = By.xpath("//span[@class='dtextone' and (text()=' ARCHIVED ' or text()=' ID ' )]");
	By hub_contactproperties = By.xpath("//span[@class='dtextone' and (text()=' PARENT_ID ' or text()=' HS_ANALYTICS_SOURCE ' or text()=' HS_LIFECYCLESTAGE_MARKETINGQUALIFIEDLEAD_DATE ' or text()=' CREATEDATE ' or text()=' HS_LEAD_STATUS ' or text()=' JOBTITLE ' or text()=' FIRSTNAME ' or text()=' LASTNAME ' )]");
	By hub_contactassociation = By.xpath("//span[@class='dtextone' and (text()=' PARENT_ID ' or text()=' ASSOCIATION_TYPE ' or text()=' OBJECT_ID '  )]");
	By hub_dealspipelines = By.xpath("//span[@class='dtextone' and (text()=' PIPELINEID ' or text()=' STAGES ' or text()=' ACTIVE ' or text()=' DISPLAYORDER ' or text()=' OBJECTTYPE ' or text()=' CREATEDAT ' or text()=' UPDATEDAT ' )]");
	By hub_dealpipelinestages = By.xpath("//span[@class='dtextone' and (text()=' STAGEID ' or text()=' LABEL ' or text()=' ACTIVE ' or text()=' METADATA ' or text()=' DISPLAYORDER ' or text()=' CREATEDAT ' or text()=' UPDATEDAT ' )]");




	/**
	 * @throws InterruptedException ***********************************************************************************************/

	/**
	 * @author Lakshmipathi
	 * @param connectorname  - Enter the Connector name - Jira, Onelogin....etc
	 * @param connectionname - Enter the Connection name - Onelogin Connection...etc
	 * @param Descriptionname - Enter the Connection description - Onelogin Description...etc
	 * @throws InterruptedException
	 * 
	 */


	public void connectaconnector(String connectorname, String connectionname, String Descriptionname) throws InterruptedException {

		TestReporter.log("Click on Setting icon after login");
		BaseTest.clickOperation(BaseTest.createWebElement(settingIcon));

		BaseTest.waitseconds(10);
		TestReporter.log("Click on catalog menu present in the setting icon");
		BaseTest.clickOperation(BaseTest.createWebElement(catalogMenu));

		BaseTest.waitseconds(10);
		TestReporter.log("Click on search field to search the connector");
		BaseTest.clickOperation(BaseTest.createWebElement(searchField));

		TestReporter.log("Provide the Connector name in the search field ");
		BaseTest.createWebElement(searchField).sendKeys(connectorname);

		TestReporter.log("Mouse Over on the searched connector");
		BaseTest.mouseHoverOnElement((BaseTest.createWebElement(mouseHoverOnConnector)));

		TestReporter.log("Click on the Connect button for the searched connector");
		BaseTest.clickOperation((BaseTest.createWebElement(connectButton)));

		BaseTest.waitseconds(10);
		TestReporter.log("Click on Connection name field in the Step - 1");
		BaseTest.clickOperation(BaseTest.createWebElement(connectionName));

		TestReporter.log("Provide the Connection name in the field");
		BaseTest.createWebElement(connectionName).sendKeys(connectionname);

		TestReporter.log("Click on Connection Description field in the Step - 1");
		BaseTest.clickOperation(BaseTest.createWebElement(connectionDescription));

		TestReporter.log("Provide the Connection Description in the field");
		BaseTest.createWebElement(connectionDescription).sendKeys(Descriptionname);

		TestReporter.log("Click on Next:Credentials button at step - 1");
		BaseTest.clickOperation(BaseTest.createWebElement(nextButtonAtStep1));


	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */

	public void testconnection() throws InterruptedException {

		BaseTest.waitseconds(30);
		TestReporter.log("TestConnection button clicked");
		BaseTest.clickOperation(BaseTest.createWebElement(testConnectionButton));

		BaseTest.waitseconds(20);
		TestReporter.log("StartAISetup button clicked");
		BaseTest.clickOperation(BaseTest.createWebElement(startAIButton));

		BaseTest.waitseconds(20);
		TestReporter.log("Return to setting button clicked");
		BaseTest.clickOperation(BaseTest.createWebElement(returnToSettingButton));
		BaseTest.waitseconds(50);
	}


	/**
	 * 
	 * @param connectedConnectorName   - Provide the Connected Connector name - Jira, Onelogin...etc
	 * @param connectorLocator  - The connector name  - Jira, Onelogin...etc
	 * @throws InterruptedException
	 */
	public void validateConnectedConnector(String connectedConnectorName, By connectorLocator) throws InterruptedException {
		TestReporter.log("Click on View Connected APP button in Catalog menu");
		BaseTest.clickOperation(BaseTest.createWebElement(viewConnectedAppsButton));
		TestReporter.log("Confirm the Connected Connector is displayed in Catalog menu");
		// Through the xpath we need to verify use it


		WebElement connectedElement = BaseTest.createWebElement(connectorLocator);
		if (connectedElement.isDisplayed()) {
			System.out.println("Connected Connector: " + connectedElement.getText() + " is displaying.");
			Assert.assertTrue(connectedElement.isDisplayed(), "Connected Connector: " + connectedConnectorName + " is not displaying.");
		} else {
			Assert.fail("Connected Connector: " + connectedConnectorName + " is not displaying.");
		}
	}

	/**
	 * 
	 * @param ConnectedconnectorName  - Jira, Onelogin...etc
	 * @param connectorLocator - Jira, Onelogin...etc
	 * @throws InterruptedException
	 */
	public void validateConnectedConnectorInIntegration(String ConnectedconnectorName, By connectorLocator) throws InterruptedException {

		BaseTest.waitseconds(10);
		TestReporter.log("Click on Integration menu");
		BaseTest.clickOperation(BaseTest.createWebElement(integrationMenu));

		TestReporter.log("Confirm the Connected Connector is displayed in Integration menu");
		WebElement ConnectedElementInIntegration = BaseTest.createWebElement(connectorLocator);
		if(ConnectedElementInIntegration.isDisplayed()) {
			System.out.println("Connected Connector: " + ConnectedElementInIntegration.getText() +" is displaying.");
			Assert.assertTrue(ConnectedElementInIntegration.isDisplayed(), "Connected Connector: " + ConnectedconnectorName + " is not displaying.");
		} else {
			Assert.fail("Connected Connector: " + ConnectedconnectorName + " is not displaying.");
		}

		TestReporter.log("Click on Connected Connector View Details icon");
		BaseTest.clickOperation(BaseTest.createWebElement(viewDetailsIcon));
	}

	/**
	 * 
	 * @param DefaultPipelinename  - Default Pipeline for onelogin connector - 'Onelogin_Default_Pipeline'
	 * @param connectorLocator - Jira, Onelogin...etc
	 * @param expectedTables 
	 * @throws InterruptedException
	 */
	public void checkDefaultPiplineCreated(String DefaultPipelinename, By connectorLocator , List<String> expectedTables, String DefaultDownsteam) throws InterruptedException {

		BaseTest.waitseconds(5);
		TestReporter.log("Confirm the Default Pipeline is displayed in Pipeline Menu");
		WebElement DefaultPipeline = BaseTest.createWebElement(connectorLocator);
		Assert.assertTrue(DefaultPipeline.getText().contains(DefaultPipelinename), 
				"Default Pipeline '" + DefaultPipelinename + "' is not displayed as expected.");

		TestReporter.log("Click on Default Pipeline View Details icon In Pipeline menu");
		BaseTest.clickOperation(BaseTest.createWebElement(viewDetailsIconPipeline));
		BaseTest.waitseconds(10);
		TestReporter.log("Test the expected Tables Are Enabled");
		// need to mention what list<webelement> will do proper log required
		List<WebElement> enabledTables = BaseTest.createWebElements(enabledTabless);
		List<String> enabledTableNames = new ArrayList<>();
		for (WebElement table : enabledTables) {
			String tableName = table.getText();
			enabledTableNames.add(tableName);
			System.out.println("Enabled Table: " + tableName);
		}
		for (String expectedTable : expectedTables) {
			Assert.assertTrue(enabledTableNames.contains(expectedTable),
					"Expected table '" + expectedTable + "' is not displayed in the enabled tables.");
		}


		TestReporter.log("Click on Sync Details Tab in the Edit Pipeline Flow");
		BaseTest.clickOperation(BaseTest.createWebElement(syncDetailsTab));
		WebElement selectElement = BaseTest.createWebElement(defaultSyncTime);
		String syncTime = selectElement.getText();
		System.out.println("Selected Sync Time: " + syncTime);
		Assert.assertFalse(syncTime.isEmpty(), "No sync time is displayed, failing the method.");


		TestReporter.log("Click on Downstream Tab in the Edit Pipeline Flow");
		BaseTest.clickOperation(BaseTest.createWebElement(downstreamTab));
		WebElement Radiobutton = BaseTest.createWebElement(downsteam);
		Radiobutton.isEnabled();
		System.out.println("Selected DownStream : " + Radiobutton.getText());
		Assert.assertTrue(Radiobutton.isDisplayed(), "Default Downstream : " + DefaultDownsteam + " is Selected.");
	}


	/**
	 * 
	 * @param expected - Expected Tables Field for Onelogin
	 * @throws InterruptedException
	 */
	public void validateEventsTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(eventsTableFields);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}


	/**
	 * 
	 * @param expected  - Expected Tables Field
	 * @throws InterruptedException
	 */
	public void validateAppsTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData2 = BaseTest.createWebElements(appsTableFields);

		for (int i = 0; i < expected.length; i++) {
			String optionValues = tableData2.get(i).getText();

			if (optionValues.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValues + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValues + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValues + "'.");
			}
		}
	}

	/**
	 * 
	 * @param expected - Expected Tables Field
	 * @throws InterruptedException
	 */
	public void validateApps_UsersTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData3 = BaseTest.createWebElements(appsUsersTableFields);

		for (int i = 0; i < expected.length; i++) {
			String optionValuess = tableData3.get(i).getText();

			if (optionValuess.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValuess + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValuess + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValuess + "'.");
			}
		}
	}


	/**
	 * 
	 * @param expected - Expected Tables Field
	 * @throws InterruptedException
	 */
	public void validateUsersTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData4 = BaseTest.createWebElements(usersTableFields);

		for (int i = 0; i < expected.length; i++) {
			String optionValu = tableData4.get(i).getText();

			if (optionValu.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValu + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValu + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValu + "'.");
			}
		}
	}

	/**
	 * 
	 * @param expected - Expected Tables Field
	 * @throws InterruptedException
	 */
	public void validateUsers_APPSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData5 = BaseTest.createWebElements(usersAppsTableFields);

		for (int i = 0; i < expected.length; i++) {
			String optionValuee = tableData5.get(i).getText();

			if (optionValuee.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValuee + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValuee + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValuee + "'.");
			}
		}
	}

	/**
	 * 
	 * @param expected - Expected Companies Tables Field for Hubspot
	 * @throws InterruptedException
	 */
	public void validateCompaniesTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_companiesfields);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Companiesproperties table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateCompanies_propertiesTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_companies_properties);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Deals table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateDealsTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_Dealsfields);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * 
	 * @param expected - Deals properties table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateDealsPropertiesTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_dealsproperties);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Dealsassociations table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateDEALS_ASSOCIATIONSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_dealassociation);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Lineitems table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateLINE_ITEMSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_lineitems);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Lineitemproperties table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateLINE_ITEMS_PROPERTIESTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_lineitemproperties);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Owners table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateOWNERSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_owners);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Ownerteams table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateOWNERS_TEAMSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_ownerteams);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Product2 fields for hubspot
	 * @throws InterruptedException
	 */
	public void validatePRODUCT_2TableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_product2);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Productsproperties table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validatePRODUCTS_PROPERTIESTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_productproperties);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Contacts table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateCONTACTSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_contacts);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Contactsproperties table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateCONTACTS_PROPERTIESTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_contactproperties);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Companiesassociations table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateCONTACTS_ASSOCIATIONSTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_contactassociation);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Dealspipelines table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateDEALS_PIPELINESTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_dealspipelines);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}

	/**
	 * @author Lakshmipathi
	 * @param expected - Dealspipelinesstages table fields for hubspot
	 * @throws InterruptedException
	 */
	public void validateDEALS_PIPELINES_STAGESTableValues(String[] expected) throws InterruptedException {
		List<WebElement> tableData = BaseTest.createWebElements(hub_dealpipelinestages);

		for (int i = 0; i < expected.length; i++) {
			String optionValue = tableData.get(i).getText();

			if (optionValue.equals(expected[i])) {
				TestReporter.log("Table Field '" + optionValue + "' Is Mapped To The NPIO Object Field");
			} else {
				TestReporter.log("Mismatch: Expected table data '" + expected[i] + "' but found '" + optionValue + "'.");
				Assert.fail("Expected table field '" + expected[i] + "' but found '" + optionValue + "'.");
			}
		}
	}


	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void clickOnSettingAndPipeline() throws InterruptedException {

		TestReporter.log("Click on Setting icon after login");
		BaseTest.clickOperation(BaseTest.createWebElement(settingIcon));
		BaseTest.waitseconds(5);
		TestReporter.log("Click on Pipeline menu");
		BaseTest.clickOperation(BaseTest.createWebElement(pipelineMenu));
	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void clickOnOnDemandAndGetToast() throws InterruptedException {

		WebElement toast = BaseTest.createWebElement(verifyondemandtoast);
		String value = toast.getText();
		String data ="Data Sync started";
		if (value.contains(data)) {
			TestReporter.log("OnDemand Raw Data Sync Started.");
		} else {
			TestReporter.log("OnDemand Raw Data Sync Is Failed.");
			Assert.fail("OnDemand Is Failed");
		}
	}



	/**
	 * 
	 * @param expectedLogs
	 * @throws InterruptedException
	 */
	public void verifyTheExpectedLogs(List<String> expectedLogs) throws InterruptedException {
		// Log the expected logs
		TestReporter.log("Expected Logs Are.......");

		// Retrieve the list of WebElements for logs
		List<WebElement> enabledLogs = BaseTest.createWebElements(logs);

		// Store the extracted text from WebElements
		List<String> enabledTableNames = new ArrayList<>();

		for (WebElement log : enabledLogs) {
			String pipelineLog = log.getText().trim(); // Trim spaces for accuracy
			enabledTableNames.add(pipelineLog);
			System.out.println("Enabled Log: " + pipelineLog);
		}

		// Validate that each expected log is present in the retrieved logs
		for (String expectedLog : expectedLogs) {
			boolean isPresent = enabledTableNames.stream()
					.anyMatch(log -> log.contains(expectedLog)); // Allows partial match

			Assert.assertTrue(isPresent, "Expected Log '" + expectedLog + "' is NOT displayed in the selected pipeline.");
		}
	}


	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 * 
	 */
	public void dashboardexportPDFbeforeapplyfilters() throws InterruptedException {

		// Before Applying Filtes 

		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On PDF In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickPDF));
		WebElement message = BaseTest.createWebElement(verifytoastemessage);
		String value = message.getText();
		String name = ("Export has started.");
		if (value.contains(name)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}

		WebElement successmessage = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value1 = successmessage.getText();
		String name1 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value1.contains(name1)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportPDFafterapplyfilters() throws InterruptedException {

		// After Applying Filters 
		BaseTest.waitseconds(20);
		TestReporter.log("Click On Filters Icon In Dashboard View Page");
		BaseTest.clickOperation(BaseTest.createWebElement(clickonfilters));
		TestReporter.log("Click Apply Filters Dropdown Icon ");
		BaseTest.clickOperation(BaseTest.createWebElement(clickapplyfiltersdropdown));
		TestReporter.log("Apply Filters To The Visual");
		BaseTest.clickOperation(BaseTest.createWebElement(applyfilters));

		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On PDF In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickPDF));
		WebElement message2 = BaseTest.createWebElement(verifytoastemessage);
		String value2 = message2.getText();
		String name2 = ("Export has started.");
		if (value2.contains(name2)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}

		WebElement successmessage2 = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value3 = successmessage2.getText();
		String name3 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value3.contains(name3)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}

	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportingPDFafterremovefilters () throws InterruptedException {

		//After Removing The Filters
		BaseTest.waitseconds(25); // Until remove the toaste message
		TestReporter.log("Click On Apply Filters Button To Remove The Filters");
		BaseTest.clickOperation(BaseTest.createWebElement(clickapplyfiltes));
		TestReporter.log("Remove The Applied Filters");
		BaseTest.clickOperation(BaseTest.createWebElement(removefilters));
		TestReporter.log("Close The Filter Tab After Filters Removed");
		BaseTest.clickOperation(BaseTest.createWebElement(closefiltertab));

		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On PDF In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickPDF));
		WebElement message4 = BaseTest.createWebElement(verifytoastemessage);
		String value4 = message4.getText();
		String name4 = ("Export has started.");
		if (value4.contains(name4)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}

		WebElement successmessage4 = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value5 = successmessage4.getText();
		String name5 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value5.contains(name5)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export PDF Is Not Working");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportImagebeforefilters() throws InterruptedException {

		// Before Applying Filtes 

		BaseTest.waitseconds(30);
		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On IMAGE In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickimage));
		WebElement message = BaseTest.createWebElement(verifytoastemessage);
		String value = message.getText();
		String name = ("Export has started.");
		if (value.contains(name)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}

		WebElement successmessage = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value1 = successmessage.getText();
		String name1 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value1.contains(name1)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}
	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportimageafterfiltersapplied() throws InterruptedException 
	{	

		// After Applying Filters 
		BaseTest.waitseconds(30);
		TestReporter.log("Click Apply Filters Dropdown Icon ");
		BaseTest.clickOperation(BaseTest.createWebElement(clickapplyfiltersdropdown));
		BaseTest.waitseconds(5);
		TestReporter.log("Apply Filters To The Visual");
		BaseTest.clickOperation(BaseTest.createWebElement(applyfilters));

		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On IMAGE In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickimage));
		WebElement message2 = BaseTest.createWebElement(verifytoastemessage);
		String value2 = message2.getText();
		String name2 = ("Export has started.");
		if (value2.contains(name2)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}

		WebElement successmessage2 = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value3 = successmessage2.getText();
		String name3 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value3.contains(name3)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}

	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportimageafterfiltesremoved() throws InterruptedException {

		//After Removing The Filters
		BaseTest.waitseconds(25); // Until remove the toaste message
		TestReporter.log("Click On Apply Filters Button To Remove The Filters");
		BaseTest.clickOperation(BaseTest.createWebElement(clickapplyfiltes));
		TestReporter.log("Remove The Applied Filters");
		BaseTest.clickOperation(BaseTest.createWebElement(removefilters));
		TestReporter.log("Close The Filter Tab After Filters Removed");
		BaseTest.clickOperation(BaseTest.createWebElement(closefiltertab));

		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On IMAGE In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickimage));
		WebElement message4 = BaseTest.createWebElement(verifytoastemessage);
		String value4 = message4.getText();
		String name4 = ("Export has started.");
		if (value4.contains(name4)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}

		WebElement successmessage4 = BaseTest.createWebElement(verifysuccesfulltoastmessage);
		String value5 = successmessage4.getText();
		String name5 = ("Exporting the dashboard completed successfully and saved in local.");
		if (value5.contains(name5)) {
			TestReporter.log("Success Toast message verified successfully!");
		} else {
			TestReporter.log("Success Toast message Verification Failed!");
			Assert.fail("Export IMAGE Is Not Working");
		}
	}


	/**
	 * @author Lakshmipathi
	 * @param email - provide email to download into google doc
	 * @param password - provide password to the email
	 * @throws InterruptedException
	 */
	public void dashboardexportgoogledoc(String email, String password) throws InterruptedException {

		// Before Applying Filtes 

		BaseTest.waitseconds(30);
		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On GOOGLE DOC In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickgoogledoc));
		WebElement message = BaseTest.createWebElement(verifytoastemessage);
		String value = message.getText();
		String name = ("Export has started.");
		if (value.contains(name)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export Google Doc Is Not Working");
		}

		TestReporter.log("Provide The Email Id In Sign In Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(provideemail));
		BaseTest.createWebElement(provideemail).sendKeys(email);
		TestReporter.log("Click On Next Button In The Sign In Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(clicknext));
		TestReporter.log("Provide Password In The Sign In Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(providepassword));
		BaseTest.createWebElement(providepassword).sendKeys(password);
		TestReporter.log("Click On Next Button In The Sign In Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(clicknext));
		TestReporter.log("Click On Advance Link In Choose An Account Page");
		BaseTest.clickOperation(BaseTest.createWebElement(clickadvance));
		TestReporter.log("Click On Goto Nockpoint Link In The Choose An Account Page");
		BaseTest.clickOperation(BaseTest.createWebElement(clickgotonockpoint));
		TestReporter.log("Click On Connect Button In Connect Accout Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(clickconnectbutton));

	}

	/**
	 * @author Lakshmipathi
	 * @throws InterruptedException
	 */
	public void dashboardexportgoogleslides () throws InterruptedException {
		// Before Applying Filtes 

		BaseTest.waitseconds(30);
		BaseTest.switchToMainTab();
		BaseTest.waitseconds(5);
		TestReporter.log("Click On Dropdown In Export Functionality");
		BaseTest.clickOperation(BaseTest.createWebElement(clickDropdown));

		TestReporter.log("Click On Google Slides In The Export Feature");
		BaseTest.clickOperation(BaseTest.createWebElement(clickgoogleslides));
		WebElement message = BaseTest.createWebElement(verifytoastemessage);
		String value = message.getText();
		String name = ("Export has started.");
		if (value.contains(name)) {
			TestReporter.log("Toast message verified Successfully!");
		} else {
			TestReporter.log("Toast Message Verification Failed!");
			Assert.fail("Export Google slides Is Not Working");
		}

		TestReporter.log("Click The Email Id In Sign In Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(clickemail));
		TestReporter.log("Click On Advance Link In Choose An Account Page");
		BaseTest.clickOperation(BaseTest.createWebElement(clickadvance));
		TestReporter.log("Click On Goto Nockpoint Link In The Choose An Account Page");
		BaseTest.clickOperation(BaseTest.createWebElement(clickgotonockpoint));
		TestReporter.log("Click On Connect Button In Connect Accout Screen");
		BaseTest.clickOperation(BaseTest.createWebElement(clickconnectbutton));
		BaseTest.waitseconds(20);
		BaseTest.switchToMainTab();
		BaseTest.waitseconds(5);
	}

}
