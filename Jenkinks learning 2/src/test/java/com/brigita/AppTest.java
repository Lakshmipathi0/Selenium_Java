package com.brigita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.brigita.selenium.common.TestReporter;
import com.brigita.base.BaseTest;
import com.brigita.base.EncodeDecode;
import com.brigita.base.NockpointValidation;
//import com.brigita.base.sample;

public class AppTest extends BaseTest  
{

	By domainField = By.cssSelector("[placeholder='Domain']");
	By clientIDField = By.cssSelector("[placeholder='Client Id']");
	By clientSecretField = By.cssSelector("[placeholder='Client Secret']");
	By nextButton = By.xpath("//button[text()=' Next : Test Connection ']");
	By connectorLocator = By.xpath("//span[text()='Onelogin']");
	By connectedConnector = By.xpath("//td[text()=' Onelogin ']");
	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By defaultPipeline = By.xpath("//td[text()='Onelogin_Default_Pipeline']");
	By inboundSchemaMenu = By.xpath("//span[text()='Inbound Schema ']");
	By identityObject = By.xpath("//span[@class='expandable' and contains(text(), 'IDENTITY')]");
	By eventsObject = By.xpath("//span[@class='expandable' and contains(text(), ' EVENTS ')]");
	By appsObject = By.xpath("//span[@class='expandable' and contains(text(), ' APPS ')]");
	By appsUsersObject = By.xpath("//span[@class='expandable' and contains(text(), ' APPS_USERS ')]");
	By usersObject = By.xpath("//span[@class='expandable' and contains(text(), ' USERS ')]");
	By usersAppsObject = By.xpath("//span[@class='expandable' and contains(text(), ' USERS_APPS ')]");
	By dashboardIcon = By.xpath("//img[@id='dashboard-icon']");
	By informationTechnology = By.xpath("//div[text()=' Information Technology ']");
	By dashboards = By.xpath("//div[@class='row _contentText font-weight-bold pt-2 pb-2 pl-2 pr-2']");
	By appsUsersDashboard = By.xpath("//span[text()=' App Usage ']");
	By userAccessButton = By.xpath("//div[@class='col-7 d-flex p-0']//h3");
	By appUsersByMonthDashboard = By.xpath("//span[text()=' App Usage By Month ']");
	By visualappusersbymonth = By.xpath("//div[@class='col-7 d-flex p-0']//h3[text()=' App Usage By Month ']");
	By enabledUserDashboard = By.xpath("//span[text()=' Enabled Users ']");
	By visualenableduser = By.xpath("//div[@class='col-7 d-flex p-0']//h3[text()=' Enabled Users ']");
	By enabledFeatureDashboard = By.xpath("//span[text()=' Events Feature ']");
	By visualeventfeature = By.xpath("//div[@class='col-7 d-flex p-0']//h3[text()=' Events Feature ']");
	By clickonlogs = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), 'Onelogin')]/following-sibling::td/img[@ptooltip='Pipeline Logs']");
	By expandfirstone = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr[1]/td[1]");
	By clickondemand = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), 'Onelogin')]/following-sibling::td/i[@ptooltip='Sync Refresh']");




	public String Domain = "avalanche-dev";
	public String ClientID = "c241c66a784a0b6b59706e4f26859c75b54628bf8b9d07371fef5026fa54f247";
	public String Clientsecreat = "67007a960c31eac8625776d83f3105bfc0093403e2f9877a2d5419e4df936fcb";


	NockpointValidation validation = new NockpointValidation();
	BaseTest base = new BaseTest();
	EncodeDecode encode = new EncodeDecode();


	@Test(priority = 1,enabled= false, groups = {"Nockpoint", "Catalog"})
	public  void samplerun() throws Exception {

		TestReporter.log("Connect a Connector process started");
		String connectorname = "Onelogin";
		String Connectionname = "Oneloginconnectionsss";
		String ConnectionDescription = "OneloginDescriptionsss";

		TestReporter.log("Step - 1 Excution Started");
		validation.connectaconnector(connectorname, Connectionname, ConnectionDescription);
		TestReporter.log("Step - 1 Excution Completed");


		BaseTest.waitseconds(10);
		TestReporter.log("Step-2 Excution Started");
		TestReporter.log("Click on the Domain text field");
		BaseTest.clickOperation(BaseTest.createWebElement(domainField));

		TestReporter.log("Provide the Domain into the text field");
		BaseTest.createWebElement(domainField).sendKeys(Domain);

		TestReporter.log("Click on the ClientID text field");
		BaseTest.clickOperation(BaseTest.createWebElement(clientIDField));

		TestReporter.log("Provide the ClientID into the text field");
		BaseTest.createWebElement(clientIDField).sendKeys(ClientID);

		TestReporter.log("Click on the ClientSecret text field");
		BaseTest.clickOperation(BaseTest.createWebElement(clientSecretField));

		TestReporter.log("Provide  the ClientSecret into the text field");
		BaseTest.createWebElement(clientSecretField).sendKeys(Clientsecreat);

		TestReporter.log("Click on Next:Connection button at step - 2");
		BaseTest.clickOperation(BaseTest.createWebElement(nextButton));
		TestReporter.log("Step-2 Execution Completed");

		TestReporter.log("Step -3 Exucution Started");
		validation.testconnection();
		TestReporter.log("Onelogin Connector is succesfully connected");


	}


	@Test (priority = 2, enabled = false, groups = {"Nockpoint", "Catalog"})
	public void testConnectedConnectorIsDisplayed() throws InterruptedException {
		String expectedConnectorName = "Onelogin";
		validation.validateConnectedConnector(expectedConnectorName, connectorLocator);
	}


	@Test (priority = 3,enabled = false, groups = {"Nockpoint", "Integration"})
	public void testConnectedConnectorIsDispalyedInIntegration() throws InterruptedException {
		String ConnectedConnectorInIntegration = "Onelogin";
		validation.validateConnectedConnectorInIntegration(ConnectedConnectorInIntegration, connectedConnector);

	}

	@Test(priority=1, groups= {"Ondemand"})
	public void TC_001_clickOnOndemandButton() throws InterruptedException {
		validation.clickOnSettingAndPipeline();
		TestReporter.log("Click On On-Demand Button In The Pipeline");
		BaseTest.clickOperation(BaseTest.createWebElement(clickondemand));
		validation.clickOnOnDemandAndGetToast();
		BaseTest.waitseconds(600); //10 min time

	}

	@Test (priority = 2, groups = {"Pipeline"})
	public void TC_002_verifyPipelineAvailabilityAndSchemaSync() throws InterruptedException {
		BaseTest.waitseconds(5);
		String DefaultPipelinename = "Onelogin_Default_Pipeline";
		String Dowstream ="Nockpoint Defined Transformations and Writeback";
		List<String> expectedTables = Arrays.asList("events_types", "users_apps", "apps","users","events", "apps_users");
		validation.checkDefaultPiplineCreated(DefaultPipelinename, defaultPipeline, expectedTables,Dowstream);

	}


	@Test (priority = 3, groups = {"InboundSchema"})
	public void TC_003_verifyMappedNPTIOInInboundSchema() throws InterruptedException {

		TestReporter.log("Click on InboundSchema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(inboundSchemaMenu));

		BaseTest.waitseconds(5);
		TestReporter.log("Click on Identity Nockpoint Object For The Onelogin Connector");
		BaseTest.clickOperation(BaseTest.createWebElement(identityObject));

		TestReporter.log("Expand Event Object In The Inbound Schema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(eventsObject));
		String[] expectedValues = {"ID", "ACCOUNT_ID", "CREATED_AT", "USER_ID", "ACTOR_USER_ID", "EVENT_TYPE_ID", "APP_ID", "ROLE_ID", "GROUP_ID", "USER_NAME", "ACTOR_USER_NAME", "ROLE_NAME", "NOTES"};
		validation.validateEventsTableValues(expectedValues);
		BaseTest.clickOperation(BaseTest.createWebElement(eventsObject));


		TestReporter.log("Expand Apps Object In the Inbound Schema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(appsObject));
		String[] expectedValues2 = {"ID", "NAME", "AUTH_METHOD", "UPDATED_AT", "CONNECTOR_ID", "CREATED_AT", "DESCRIPTION", "AUTH_METHOD_DESCRIPTION",};
		validation.validateAppsTableValues(expectedValues2);
		BaseTest.clickOperation(BaseTest.createWebElement(appsObject));


		TestReporter.log("Expand Apps_User Object in the Inbound Schema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(appsUsersObject));
		String[] expectedValues3 = {"ID", "APP_ID", "USERNAME", "FIRSTNAME", "LASTNAME", "EMAIL",};
		validation.validateApps_UsersTableValues(expectedValues3);
		BaseTest.clickOperation(BaseTest.createWebElement(appsUsersObject));

		TestReporter.log("Expand Users Object in the Inbound Schema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(usersObject));
		String[] expectedValues4 = {"ID", "CREATED_AT", "STATUS", "STATE", "FIRSTNAME", "LASTNAME", "USERNAME", "TITLE", "DEPARTMENT", "EMAIL", "ACTIVATED_AT", "LOCKED_UNTIL", "LAST_LOGIN", "UPDATED_AT", "INVITATION_SENT_AT", "ROLE_ID", "GROUP_ID", "DIRECTORY_ID", "COMPANY", "PASSWORD_CHANGED_AT", "MANAGER_USER_ID", "INVALID_LOGIN_ATTEMPTS", "LOCALE_CODE", "TRUSTED_IDP_ID"};
		validation.validateUsersTableValues(expectedValues4);
		BaseTest.clickOperation(BaseTest.createWebElement(usersObject));

		TestReporter.log("Expand Users_Apps in the Inbound Schema menu");
		BaseTest.clickOperation(BaseTest.createWebElement(usersAppsObject));
		String[] expectedValues5 = {"ID", "USER_ID", "LOGIN_ID", "EXTENSION", "PROVISIONED", "NAME", "PERSONAL"};
		validation.validateUsers_APPSTableValues(expectedValues5);
		BaseTest.clickOperation(BaseTest.createWebElement(usersAppsObject));
	}

	@Test(priority = 4,alwaysRun=true, groups = {"Nockpoint", "Pipeline"})
	public void TC_004_verifyLogsAreDisplayed() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='Pipeline ']")).click();
		TestReporter.log("Click on Logs Icon");

		BaseTest.clickOperation(BaseTest.createWebElement(clickonlogs));
		BaseTest.waitseconds(5);

		TestReporter.log("First Sync Is Expanding In The Logs");
		BaseTest.clickOperation(BaseTest.createWebElement(expandfirstone));

		List<String> expectedTables = Arrays.asList(
				"Raw data sync started successfully",
				"Raw data sync completed successfully",
				"RT Transformations are currently executing",
				"RT Transformations completed successfully",
				"NT Transformations are currently executing",
				"NT Transformations completed successfully",
				"Dashboards are currently publishing",
				"Dashboards published successfully"
				);

		validation.verifyTheExpectedLogs(expectedTables);
	}

	@Test(priority = 5,alwaysRun=true, groups = {"Nockpoint", "dashboard-icon"})
	public void TC_005_verifyDashboardGroupIsClickableAndDisplaysExpectedDashboards() throws InterruptedException {

		TestReporter.log("Click on Dashboard icon in the Tenancy");
		BaseTest.clickOperation(BaseTest.createWebElement(dashboardIcon));
		BaseTest.waitseconds(5);
		TestReporter.log("Click On Onelogin Dashboard Group Information Technology");
		BaseTest.clickOperation(BaseTest.createWebElement(informationTechnology));

		List<String> expectedDashboards = Arrays.asList("App Usage", "App Usage By Month", "Enabled Users", "Events Feature");
		List<WebElement> dashboardElements = BaseTest.createWebElements(dashboards);
		List<String> displayedDashboardNames = new ArrayList<>();

		for (WebElement dashboard : dashboardElements) {
			String dashboardName = dashboard.getText();
			System.out.println("Displayed Dashboard: " + dashboardName);
			Assert.assertTrue(dashboard.isDisplayed(), "Expected Dashboards are not displayed.");
			displayedDashboardNames.add(dashboardName); 
		}
		for (String expectedDashboard : expectedDashboards) {
			Assert.assertTrue(displayedDashboardNames.contains(expectedDashboard),
					"Expected dashboard '" + expectedDashboard + "' is not displayed.");
		}

	}


	@Test(priority = 6,alwaysRun=true, groups = {"Nockpoint", "Onelogin"})
	public void TC_006_verifyDashboardDisplaysVisualsOnClick() throws InterruptedException {
		TestReporter.log("Click on App_Users Dashboard");
		BaseTest.clickOperation(BaseTest.createWebElement(appsUsersDashboard));
		BaseTest.waitseconds(15);
		WebElement element = BaseTest.createWebElement(userAccessButton);
		String actualText = element.getText();
		String expectedSubstring = "App Usage";
		if (actualText.contains(expectedSubstring)) {
			TestReporter.log("App_Users Dashboard Visual is Displayed " + actualText);
		} else {
			TestReporter.log("App_Users Dashboard Visual is NOT Displayed " + actualText);
			Assert.fail("App_Users Dashboard Visual is NOT Displayed");
		}

		BaseTest.clickOperation(BaseTest.createWebElement(informationTechnology));
		TestReporter.log("Click on App Usage By Month Dashboard");
		BaseTest.clickOperation(BaseTest.createWebElement(appUsersByMonthDashboard));
		BaseTest.waitseconds(10);
		WebElement element1 = BaseTest.createWebElement(visualappusersbymonth);
		String actualText1 = element1.getText();
		String expectedSubstring1 = "App Usage By Month";
		if (actualText1.contains(expectedSubstring1)) {
			TestReporter.log("App_Usage_By_Month Dashboard Visual is Displayed ");
		} else {
			TestReporter.log("App_Usage_By_Month Dashboard Visual is NOT Displayed ");
			Assert.fail("App_Usage_By_Month Dashboard Visual is NOT Displayed");
		}

		BaseTest.clickOperation(BaseTest.createWebElement(informationTechnology));
		TestReporter.log("Click on Enabled User Dashboard ");
		BaseTest.clickOperation(BaseTest.createWebElement(enabledUserDashboard));
		BaseTest.waitseconds(10);
		WebElement element2 = BaseTest.createWebElement(visualenableduser);
		String actualText2 = element2.getText();
		String expectedSubstring2 = "Enabled Users";
		if (actualText2.contains(expectedSubstring2)) {
			TestReporter.log("Enabled_Users Dashboard Visual is Displayed ");
		} else {
			TestReporter.log("Enabled_Users Dashboard Visual is NOT Displayed ");
			Assert.fail("Enabled_Users Dashboard Visual is NOT Displayed");
		}

		BaseTest.clickOperation(BaseTest.createWebElement(informationTechnology));
		TestReporter.log("Click on Event Feature Dashboard");
		BaseTest.clickOperation(BaseTest.createWebElement(enabledFeatureDashboard));
		BaseTest.waitseconds(10);
		WebElement element3 = BaseTest.createWebElement(visualeventfeature);
		String actualText3 = element3.getText();
		String expectedSubstring3 = "Events Feature";
		if (actualText3.contains(expectedSubstring3)) {
			TestReporter.log("Events_Feature Dashboard Visual is Displayed ");
		} else {
			TestReporter.log("Events_Feature Dashboard Visual is NOT Displayed ");
			Assert.fail("Events_Feature Dashboard Visual is NOT Displayed");
		}


	}

	@Test(priority = 7,alwaysRun=true, groups = {"Nockpoint", "Dashboard"})
	public void TC_007_exportDashboardAsPDFBeforeApplyingFilters() throws InterruptedException {
		validation.dashboardexportPDFbeforeapplyfilters();
	}
	@Test(priority = 8,alwaysRun=true, groups = {"Nockpoint", "Dashboard"})
	public void TC_008_exportDashboardAsPDFAfterApplyingFilters() throws InterruptedException {
		validation.dashboardexportPDFafterapplyfilters();
	}
	@Test(priority = 9,alwaysRun=true, groups = {"Nockpoint", "Dashboard"})
	public void TC_009_exportDashboardAsPDFAfterRemovingFilters() throws InterruptedException {
		validation.dashboardexportingPDFafterremovefilters();
	}


	@Test(priority = 10,alwaysRun=true,groups = {"Nockpoint", "Dashboard"})
	public void TC_010_exportDashboardAsImageBeforeApplyingFilters() throws InterruptedException {
		validation.dashboardexportImagebeforefilters();
	}

	@Test(priority = 11,alwaysRun=true,dependsOnMethods ="TC_010_exportDashboardAsImageBeforeApplyingFilters", groups = {"Nockpoint", "Dashboard"})
	public void TC_011_exportDashboardAsImageAfterApplyingFilters () throws InterruptedException {
		validation.dashboardexportimageafterfiltersapplied();
	}

	@Test(priority = 012,alwaysRun=true,dependsOnMethods ="TC_011_exportDashboardAsImageAfterApplyingFilters", groups = {"Nockpoint", "Dashboard"})
	public void TC_012_exportDashboardAsImageAfterRemovingFilters() throws InterruptedException {
		validation.dashboardexportimageafterfiltesremoved();
	}
	@Test(priority = 13,alwaysRun=true, groups = {"Nockpoint", "Dashboard"})
	public void TC_013_exportDashboardAsGoogleDocBeforeApplyingFilters () throws InterruptedException {
		String email = "m.lakshmipathi@brigita.co";
		String password = "Lakshmipathi@12345";
		validation.dashboardexportgoogledoc(email,password);
	}

	@Test(priority = 14,alwaysRun=true, groups = {"Nockpoint", "Dashboard"})
	public void TC_014_exportDashboardAsGoogleSlodesBeforeApplyingFilters() throws InterruptedException {
		validation.dashboardexportgoogleslides();
	}
}













