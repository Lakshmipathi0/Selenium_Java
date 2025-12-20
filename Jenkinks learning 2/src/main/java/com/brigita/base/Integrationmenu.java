package com.brigita.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;

public class Integrationmenu extends BaseTest   {

	By settingIcon = By.xpath("//img[@ptooltip='Settings']");
	By verifyintegration = By.xpath("//span[text()='Integration ']");
	By verifydefaultintegrationlist = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr[1]");
	By verifyheaders = By.xpath("//thead[@class='p-datatable-thead']");
	By verifysize = By.xpath("//tr[@class='ng-star-inserted']");
	By clckpagination = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']/button[text()='2']");
	By movelastpagination = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	By movefirstpagination = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");
	By lastpaginationdisabled = By.xpath("//button[@class='p-ripple p-element p-paginator-last p-paginator-element p-link ng-star-inserted p-disabled']");
	By firstpaginationdisabled = By.xpath("//button[@class='p-ripple p-element p-paginator-first p-paginator-element p-link ng-star-inserted p-disabled']");
	By clickonviewdetails = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), ' NP Snowflake ')]/following-sibling::td/img[@ptooltip='View Details' ]");
	By verifydetails = By.xpath("//div[@class='p-tabview-panel ng-star-inserted']/div");
	By masuretime = By.xpath("//tbody[contains(@class,'p-element p-datatable-tbody')]");
	By clickoverlschemarefresh = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), ' NP Snowflake ')]/following-sibling::td/i[@ptooltip='Overall Schema Refresh' ]"); 
	By verifytoast = By.xpath("//div[@aria-live='assertive']/div");
	By paginationlocator = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']/span/button");
	By verifyintegrationlist = By.xpath("//h3[text()='Integration List']");
	By verifyreauthorize = By.xpath("//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(), ' NP Snowflake ')]/following-sibling::td/img[@ptooltip='Reauthorize' ]");
	By verifyreauthorizetoaste = By.xpath("//div[text()='Reauth not allowed for Nockpoint Cloud']");
	By verifyheaderinviewdetails = By.xpath("//h3[text()='Nockpoint Cloud']");

	public void clickSettingIcon() throws InterruptedException {

		TestReporter.log("Click On Setting Icon");
		BaseTest.clickOperation(BaseTest.createWebElement(settingIcon));

		WebElement Availability = BaseTest.createWebElement(verifyintegration);

		try {

			TestReporter.log("Verify The Integration Menu Availability And Highlighted");
			Assert.assertTrue(Availability.isDisplayed(), "Integration Menu is NOT available on the Setting Page.");
			System.out.println("Integration Menu is Available on the Setting Page");

			Assert.assertTrue(Availability.isEnabled(),"Integration Menu is NOT highlighted on the Setting Page.");
			System.out.println("Integration Menu is Highlighted on the Setting Page");

		} catch (Exception e) {	

			Assert.fail("An error occurred while verifying the Integration Menu: "+ e.getMessage());
		}
	}

	public void verifyintegrationlistheader() throws InterruptedException {

		WebElement integrationList = BaseTest.createWebElement(verifyintegrationlist);
		try {

			TestReporter.log("Verify The Integration Header 'Integration List'");
			Assert.assertTrue(integrationList.isDisplayed(),"Integration List Is Not Displaying");
			System.out.println("Integration Header 'Integration List' Is Dispalyed");

		}catch(Exception e) {

			Assert.fail("An error occured while verifying the integration header in screen:" + e.getMessage());
		}
	}

	public void verifyDefaultIntegration() throws InterruptedException {

		WebElement defaultIntegration = BaseTest.createWebElement(verifydefaultintegrationlist);
		String[] expectedDefaultIntegration = {"Nockpoint Cloud", "NP Snowflake"};

		for (String integration : expectedDefaultIntegration) {
			try {

				TestReporter.log("Verify The Default Integration Availablity");
				Assert.assertTrue(defaultIntegration.getText().contains(integration),"Default Integration Name '" + integration + "' is NOT displayed.");
				System.out.println("Default Integration Name '" + integration + "' is correctly displayed.");
			} catch (Exception e) {

				Assert.fail("An error occurred while verifying the Default Integration Menu: " + e.getMessage());
			}
		}
	}

	public void verifyHeadersInInterationScreen() throws InterruptedException {

		WebElement headersLocator = BaseTest.createWebElement(verifyheaders);
		String[] expectedHeaders = {"Name", "Application", "Status", "Details", "Reauthorize", "Actions"};

		for (String headers : expectedHeaders) {

			try {

				TestReporter.log("Verify The  Headers In The Integration Menu");
				Assert.assertTrue(headersLocator.getText().contains(headers),"Header '" + headers + "' is NOT displayed.");
				System.out.println("Header '" + headers + "' is correctly displayed.");
			} catch (Exception e) {

				Assert.fail("An error occurred while verifying the headers in the Integration Screen: " + e.getMessage());
			}
		}
	}

	public void verifystatusforconnector(String applicationName) throws InterruptedException {

		String xpath = "//tbody[@class='p-element p-datatable-tbody']/tr/td[contains(text(),\"" + applicationName + "\")]/following-sibling::td[text()=' connected ']";
		WebElement statusElement = BaseTest.createWebElement(By.xpath(xpath));
		TestReporter.log("Verify The Status For Connector ");		
		String statusText = statusElement.getText().trim();

		try {

			Assert.assertEquals(statusText, "connected", "Status for '" + applicationName + "' is NOT 'connected'. Actual status: " + statusText);
			System.out.println("Status for '" + applicationName + "' is: " + statusText);

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the status for '" + applicationName + "': " + e.getMessage());
		}
	}

	public void veriySizeOfConnectedIntegrations() throws InterruptedException {

		List<WebElement> integrationRows = BaseTest.createWebElements(verifysize);
		int integrationCount = integrationRows.size();

		try {

			TestReporter.log("Verify The Size Of Integrations In A Single Page");
			Assert.assertTrue(integrationCount > 0, "No integrations found!");
			System.out.println("Total integrations displayed: " + integrationCount);

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the size of connected integrations: " + e.getMessage());
		}
	}

	public void validateAndHandlePagination() throws InterruptedException {

		List<WebElement> paginationButtons = BaseTest.createWebElements(paginationlocator);
		TestReporter.log("Validating Pagination Availability");

		if (paginationButtons.size() == 1) {

			TestReporter.log("Only one pagination button available. Skipping pagination steps.");
			System.out.println("Pagination operations are considered successful.");
			Assert.assertTrue(true, "Pagination steps passed as only one page is available.");
			return;

		}

		TestReporter.log("Multiple pagination buttons detected. Performing pagination actions.");
		WebElement pagination2 = BaseTest.createWebElement(clckpagination);

		TestReporter.log("Click On Pagination 2");
		BaseTest.clickOperation(pagination2);

		try {

			Assert.assertTrue(pagination2.isEnabled(), "User is NOT in Pagination 2.");
			System.out.println("User is in Pagination 2.");

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying Pagination 2: " + e.getMessage());
		}
	}

	public void moveLastPagination() throws InterruptedException {

		List<WebElement> paginationButtons = BaseTest.createWebElements(paginationlocator);
		TestReporter.log("Validating Pagination Availability");
		if (paginationButtons.size() == 1) {

			TestReporter.log("Only one pagination button available. Skipping pagination steps.");
			System.out.println("Pagination operations are considered successful.");
			Assert.assertTrue(true, "Pagination steps passed as only one page is available.");
			return;

		}

		TestReporter.log("Multiple pagination buttons detected. Performing pagination actions.");
		WebElement lastPaginationButton = BaseTest.createWebElement(movelastpagination);

		TestReporter.log("Click & Move To Last Pagination");
		BaseTest.clickOperation(lastPaginationButton);

		TestReporter.log("Verify Last Pagination Is Disabled.");
		WebElement lastPaginationDisabled = BaseTest.createWebElement(lastpaginationdisabled);

		try {

			Assert.assertTrue(lastPaginationDisabled.isDisplayed(), "User Is NOT in the Last Page.");
			TestReporter.log("User Is In The Last Page");

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the last pagination: " + e.getMessage());
		}
	}

	public void moveFirstPagination() throws InterruptedException {

		List<WebElement> paginationButtons = BaseTest.createWebElements(paginationlocator);
		TestReporter.log("Validating Pagination Availability");

		if (paginationButtons.size() == 1) {

			TestReporter.log("Only one pagination button available. Skipping pagination steps.");
			System.out.println("Pagination operations are considered successful.");
			Assert.assertTrue(true, "Pagination steps passed as only one page is available.");
			return;
		}

		TestReporter.log("Multiple pagination buttons detected. Performing pagination actions.");
		WebElement firstPaginationButton = BaseTest.createWebElement(movefirstpagination);

		TestReporter.log("Click & Move To First Pagination");
		BaseTest.clickOperation(firstPaginationButton);

		TestReporter.log("Verify The First Pagination Is Disabled.");
		WebElement firstPaginationDisabled = BaseTest.createWebElement(firstpaginationdisabled);

		try {

			Assert.assertTrue(firstPaginationDisabled.isDisplayed(), "User Is NOT in the First Page.");
			TestReporter.log("User Is In The First Page");

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the first pagination: " + e.getMessage());
		}
	}

	public void verifyReauthorizeAvailabilityClickability() throws InterruptedException {

		WebElement reAuthorize = BaseTest.createWebElement(verifyreauthorize);
		try {

			TestReporter.log("Verify The Reauthorize Is Available For NP Snowflake");
			Assert.assertTrue(reAuthorize.isDisplayed(),"Reauthorize Is Not Available For NP Snowflake");

			TestReporter.log("Click On Reauthorize Button For NP Snowflake");
			BaseTest.clickOperation(reAuthorize);

			TestReporter.log("Verify The Reauthorize Toaste Message");
			WebElement reAuthorizetoaste = BaseTest.createWebElement(verifyreauthorizetoaste);
			String toaste = reAuthorizetoaste.getText();
			Assert.assertTrue(toaste.contains("Reauth not allowed for Nockpoint Cloud"),"Success Toast Message Is Not Displayed. Actual Message: " + toaste);
			System.out.println("Success Toast Message Is Displayed: " + toaste);

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the first pagination: "+ e.getMessage());
		}
	}

	public void verifyViewDetails() throws InterruptedException {

		TestReporter.log("Click On View Details Icon Of The NP Snowflake Application");
		BaseTest.clickOperation(BaseTest.createWebElement(clickonviewdetails));

		try {

			TestReporter.log("Verify The Header In View Details Screen");
			WebElement header = BaseTest.createWebElement(verifyheaderinviewdetails);
			Assert.assertTrue(header.isDisplayed(), "Nockpoint Cloud Header Is Not Displaying In The View Details Icon : " + header);
			System.out.println("Nockpoint Cloud Header Is Displaying : " + header);

			TestReporter.log("Verifying The NP Snowflake Application Details");
			List<WebElement> details = BaseTest.createWebElement1(verifydetails);

			for (WebElement value : details) {
				String detailText = value.getText().trim();
				Assert.assertFalse(detailText.isEmpty(), "Detail is empty!");
				System.out.println("Detail is not empty: " + detailText);
			}
		} catch (Exception e) {
			Assert.fail("An error occurred while verifying details or header: " + e.getMessage());
		}
	}

	public void verifyTableBodyVisibility() throws InterruptedException {

		TestReporter.log("Verify With In 10 Seconds Of Time Integrations Are Dispalying.");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			wait.until(ExpectedConditions.visibilityOf(BaseTest.createWebElement(masuretime)));
			System.out.println("Table body is visible.");

		} catch (TimeoutException e) {

			Assert.fail("Table body is not visible within 10 seconds." + e.getMessage());
		}
	}

	public void overallSchemaRefresh() throws InterruptedException {

		TestReporter.log("Click On Overall Schema Refresh Button On NP Snowflake Application");
		BaseTest.clickOperation(BaseTest.createWebElement(clickoverlschemarefresh));

		WebElement toast = BaseTest.createWebElement(verifytoast);

		try {

			TestReporter.log("Verifying The Overall Schema Refresh Is Success Or Fail");
			String toastMessage = toast.getText().trim();
			Assert.assertTrue(toastMessage.contains("success"),"Success Toast Message Is Not Displayed. Actual Message: " + toastMessage);
			System.out.println("Success Toast Message Is Displayed: " + toastMessage);

		} catch (Exception e) {

			Assert.fail("An error occurred while verifying the schema refresh: " + e.getMessage());
		}
	}
}
