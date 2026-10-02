package com.brigita.base;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.brigita.selenium.common.TestReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

	protected static String scenario;  
	protected static String suiteName;
	public static ExtentReports extent;
	public static String getText;
	public static ExtentTest test;
	public static final String OUTPUT_FOLDER = System.getProperty("user.dir")+"./test-output/ExtentReports/Reports/";
	public static final String OUTPUT_FOLDER1 = System.getProperty("user.dir")+ "/test-output/" + "/ExtentReports/" + "/Reports/";
	public static WebDriver driver;
	protected static String targetSystem;
	public static String screenshotPath;

	public ExtentTest logger;
	public Logger log;
	//String Username = "fevid66037@aikunkun.com"; 
	//String Passsword = Base64Coder.decodeString("UGF0aGlAMTIz");
	Robot r;

	//Object initialization
	NockpointValidation nockpoint = new NockpointValidation();

	/* *******************************************************************************************************************************************/
	/* Before Suite annotation */

	@BeforeSuite(alwaysRun = true)
	@Parameters("env")
	public String launchBrowser(ITestContext context,@Optional("Test") String env)
			throws InterruptedException, Exception {

		suiteName = context.getCurrentXmlTest().getSuite().getName(); // To retrive the suite name from the test context.  
		File directory = new File(OUTPUT_FOLDER);  // A output_folder is created, if not it will create (test reports)
		if (!directory.exists()) {
			directory.mkdirs();
		}

		ExtentHtmlReporter reporter = new ExtentHtmlReporter(  //A new HTML report is generated and the The report is saved in the OUTPUT_FOLDER with the suite name and current date-time.
				OUTPUT_FOLDER + "ExtentReports_"+suiteName +"_" + getCurrentDateTime() + ".html");

		reporter.config().setDocumentTitle("Nockpoint Automation Report");    //Several properties are set for the report like document title, report name, theme (dark), and time format.
		reporter.config().setReportName("Nockpoint Automation Testing"); // Name of the report
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("HH:mm:ss");
		reporter.config().setEncoding("utf-8");
		reporter.config().setProtocol(Protocol.HTTPS);

		extent = new ExtentReports();  //Initializes an ExtentReports object to manage the report.
		extent.attachReporter(reporter);  // Attaches the HTML reporter to the ExtentReports object.
		extent.setReportUsesManualConfiguration(true); //Sets the configuration of the report to manual.

		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", System.getProperty("browser"));
		extent.setSystemInfo("JAVA Version", System.getProperty("java.version"));

		TestReporter.log("============ Before Suite ===============");
		// Launch the Browser
		// Fallback when run directly from a test class (no suite XML parameter)
		if (env == null || env.trim().isEmpty()) {
			env = System.getProperty("env", "Test");
		}
		initialization(env);
		return env;
	}

	// Method to get Current Date and Time
	public static String getCurrentDateTime() throws Exception {
		DateFormat customformat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		Date currentDate = new Date();

		return customformat.format(currentDate);
	}

	public static void explicitWaitForElement(By ele) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(40));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

	/**
	 * @author Mahesh Use of Method: Create WebElement and highlight WebElement
	 */
	public static WebElement createWebElement(By locator) throws InterruptedException {

		explicitWaitForElement(locator);
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Here i pass values based on css style to make solid red color border around the element.
		for (int i = 0; i < 2; i++) {

			js.executeScript("arguments[0].style.border='2px solid red'", element);
			Thread.sleep(200);
			js.executeScript("arguments[0].style.border='2px solid white'", element);
		}
		return element;
	}

	/**
	 * @author Mahesh
	 * @throws InterruptedException 
	 */
	public void initialization(String env) throws InterruptedException{

		log = LogManager.getLogger(this.getClass().getMethods());
        WebDriverManager.chromedriver().setup(); // ✅ Auto-matches Chrome version
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//	System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");      
		//	driver = new ChromeDriver();
		//	System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");
		//	driver = new EdgeDriver();

		TestReporter.log("Chrome browser launched");
		switch(env) {
		case "Test":
			driver.get("https://riderapp-admin.eateasy.ae/");
			TestReporter.log("Launched Rider App "+env+" URL");
			break;
		case "UDM2.0":
			driver.get("https://accounts.udm2.gonockpoint.com/auth/registration");
			TestReporter.log("Launched nockpoint "+env+" URL");
			break;
		case "Production":
			driver.get("https://app.nockpoint.com/auth/registration");
			TestReporter.log("Launched nockpoint "+env+" URL");
			break;
		case "NPV2Test":
			driver.get("https://accounts.npv2test.gonockpoint.com/auth/registration");
			TestReporter.log("Launched nockpoint "+env+" URL");
			break;
		default:
			throw new IllegalArgumentException("Unknown env: " + env);
		}

		TestReporter.log("Nockpoint registarion page is displayed");	
	}

	public void logInToApplication() throws Exception {

		// TestReporter.log("Click on Login option in registration page");	
		// clickOperation(createWebElement(By.xpath("//div[@class='col-xl-8 col-lg-8 col-md-8 col-sm-8 col-xs-12 text-right _loginRedirectText']/p/a")));

		// TestReporter.log("Click on Email field");	
		// clickOperation(createWebElement(By.xpath("//input[@type='email']")));

		// TestReporter.log("Enter the user Email ID");
		// createWebElement(By.xpath("//input[@type='email']")).sendKeys(Username);

		// TestReporter.log("Click on Password field");
		// clickOperation(createWebElement(By.xpath("//input[@type='password']")));

		// TestReporter.log("Enter the Password");
		// createWebElement(By.xpath("//input[@type='password']")).sendKeys(Passsword);

		// TestReporter.log("Click on Login");
		// clickOperation(createWebElement(By.xpath("//span[@class='auth0-label-submit']")));

		TestReporter.log("Click On Email field");
		clickOperation(createWebElement(By.xpath("//input[@id='email']")));

        TestReporter.log("Enter the Email");
        createWebElement(By.xpath("//input[@id='email']")).sendKeys("admin@admin.com");

		TestReporter.log("Click On Password field");
		clickOperation(createWebElement(By.xpath("//input[@id='password']")));

        TestReporter.log("Enter the Password");
        createWebElement(By.xpath("//input[@id='password']")).sendKeys("Eateasy@123");

        TestReporter.log("Click on sign in Button");
		clickOperation(createWebElement(By.xpath("//input[@value='Sign In']")));

	}

	public static void waitseconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}catch (Exception e) {

		}
	}
	public void logOutFromApplication() throws InterruptedException {

		TestReporter.log("End of execution");
		waitseconds(20);
		// // Logout of Application
		// TestReporter.log("Click on profile");
		// clickOperation(createWebElement(By.xpath("//*[@id='user-icon']")));

		// WebElement Logout = createWebElement(By.xpath("//div[@class='col-md-3 _curpointer']//span"));

		// // Click on Logout button to logout from the application
		// TestReporter.log("Click on Logout button");
		// JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;  // Unnon pop up occures, java scirpt will help what u want
		// javascriptExecutor.executeScript("arguments[0].click();", Logout);
		// TestReporter.log("Logged out from the Nockpoint application");


		 TestReporter.log("Hover on rider logout image");
		 mouseHoverOnElement(createWebElement(By.xpath("//img[@alt='Profile']")));

		 TestReporter.log("Click on Logout Option");
		 clickOperation(createWebElement(By.xpath("//i[@class='ri-shut-down-line']")));
	}

	/**
	 * @author Mahesh Use of Method: Take screenshot
	 * @throws IOException 
	 */
	public static void takeScreenshotAtEndOfTest() {
		String userDirectory = System.getProperty("user.dir");
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = userDirectory + "/test-output/" + "/ExtentReports/" + "/Extent_Screenshots/" + System.currentTimeMillis() + ".png";

		File screenShotName = new File(path);
		try {
			FileUtils.copyFile(srcFile, screenShotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {  
			MediaEntityBuilder.createScreenCaptureFromBase64String(Base64()).build();
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
	}

	// Attaching Base64 Screenshot to Report
	public static String Base64() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}



	/* *******************************************************************************************************************************************/
	/* Before Test annotation */

	@BeforeTest(alwaysRun = true)
	public void logInToNockpoint() throws Exception {
		log = LogManager.getLogger();
		TestReporter.log("============= Before Test ===============");
		TestReporter.log("Start the execution");
		logInToApplication();
	}

	/* ******************************************************************************************************************************************/
	/* Before Method annotation */

	@BeforeMethod(alwaysRun = true)
	public void beforeTestMethod(Method method) throws Exception {
		TestReporter.log("============= Before Test Method ===============");
		scenario = method.getName();
		test = extent.createTest(scenario);
		TestReporter.log("============= Currently Executing Scenario: " + scenario);
	}

	/* *******************************************************************************************************************************************/
	/* After Method annotation */

	@AfterMethod(alwaysRun = true)
	public void afterTestMethod(ITestResult result) throws Exception {
		TestReporter.log("============= After Test Method ===============");   
		Thread.sleep(3000);

		if (result.getStatus() == ITestResult.FAILURE) {
			TestReporter.log("TEST CASE FAILED IS " + result.getName()+ "Test case failed"); // to add name in extent report
			TestReporter.log("TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
			takeScreenshotAtEndOfTest();
		} else if (result.getStatus() == ITestResult.SKIP) {
			TestReporter.log("Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			TestReporter.log("Test Case PASSED IS " + result.getName());
		}
		extent.flush();
	}

	/* *******************************************************************************************************************************************/
	/* After Test annotation */

	@AfterTest(alwaysRun = true)
	public void logOutFromNockpoint() throws InterruptedException {
		Thread.sleep(2000);
		logOutFromApplication();
	}

	/* *******************************************************************************************************************************************/
	/* After Suite annotation */

	@AfterSuite (alwaysRun = true)
	public void CloseBrowser() throws InterruptedException {
		// closing browser
		TestReporter.log("Closing Browser window");
		driver.close();
		TestReporter.logStep("Browser closed");
	}

	/**
	 * @author Mahesh Use of Method : Wait for invisibility of element
	 */	
	public static void explicitWaitForSearchResult(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	/**
	 * @author Mahesh Use of Method: Create List of WebElements
	 */
	public static List<WebElement> createWebElements(By locator) {

		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	/**
	 * @author Mahesh Use of Method: Validate and click on web element
	 */
	public static void clickOperation(WebElement locator) {

		locator.isDisplayed();
		locator.click();
	}

	/**
	 * @author Mahesh Use of Method: clear on web element
	 */
	public static void clearOperation(WebElement locator) {

		locator.isDisplayed();
		locator.clear();
	}

	/**
	 * @author Mahesh Use of Method: Mouse Hover on element
	 */
	public static void mouseHoverOnElement(WebElement locator) throws InterruptedException {

		// Mouse hover on element
		Actions action = new Actions(driver);
		action.moveToElement(locator).build().perform();
		Thread.sleep(3000);
	}

	/**
	 * @author Mahesh Use of Method: Click on an element using actions
	 */
	public static void clickOperationbyActions(WebElement locator) throws InterruptedException {

		// click operation by Actions
		Actions action = new Actions(driver);
		action.click(locator).build().perform();
		Thread.sleep(3000);
	}

	/**
	 * @author Mahesh Use of Method: Window scroll to element
	 */
	public static void scrollToElement(WebElement element) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	/**
	 * @author Mahesh Use of Method: Window scroll to Top of page
	 */
	public static void scrollToTop() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		Thread.sleep(500);
	}

	/**
	 * @author Mahesh Use of Method: Window scroll to Bottom of page
	 */
	public static void scrollToBottom() throws InterruptedException {

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	/**
	 * Generate random numbers with given length
	 * @param length
	 * @return
	 * @author Mahesh
	 */
	public static int randomNumberWithLength(int length) {
		Random random = new Random();
		String number = "";
		int count = 0;
		while (count < length) {
			int ranNumber = random.nextInt(9) + 1;
			number += ranNumber;
			count++;
		}
		return Integer.parseInt(number);
	}

	// Highlights element with yellow color
	public static void highlightWithYellow(WebElement ele) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.background='yellow'", ele);
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", ele);
	}

	/*
	 * Method to switch focus back to the main tab
	 */
	public static void switchToMainTab() {
		String mainTabHandle = driver.getWindowHandles().iterator().next();
		driver.switchTo().window(mainTabHandle);
	}

	public static List<WebElement> createWebElement1(By locator) throws InterruptedException {
		explicitWaitForElement(locator);

		// Fetch list of elements instead of a single element
		List<WebElement> elements = driver.findElements(locator);  
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Apply border highlight effect on all elements
		for (WebElement element : elements) {
			for (int i = 0; i < 2; i++) {
				js.executeScript("arguments[0].style.border='2px solid red'", element);
				Thread.sleep(200);
				js.executeScript("arguments[0].style.border='2px solid white'", element);
			}
		}

		return elements;
	}

}
