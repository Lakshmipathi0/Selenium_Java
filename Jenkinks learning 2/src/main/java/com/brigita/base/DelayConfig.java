package com.brigita.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;



public class DelayConfig extends BaseTest {


        By Tabledata = By.xpath("//table[@id='alternative_pagination_table_v1']/tbody/tr");
        // The real <input> checkboxes are hidden by the theme CSS (opacity 0), so we click the
        // visible checkmark span and read the checked state from the hidden input.
        By selectAllInput = By.xpath("//input[@id='checkall']");
        By selectAllCheckmark = By.xpath("//input[@id='checkall']/following-sibling::span[@class='checkmark']");
        By rowCheckboxes  = By.xpath("//table[@id='alternative_pagination_table_v1']//tbody//input[@class='checkrow']");
        By Bulkupdate = By.xpath("//a[text()='Bulk Update']");
        By SelectedZones = By.xpath("//label[text()='Selected Zones']/following-sibling::div/span");
        By ClosePopup = By.xpath("(//button[@aria-label='Close']/span)[1]");
        By StatusChecbox = By.xpath("//span[text()='Status']/following-sibling::span[@class='checkmark']");
        By StatusCheckboxInput = By.xpath("//span[text()='Status']/parent::label//input[@type='checkbox']");
        // Status toggles are Bootstrap Toggles: the real <input> is hidden, the visible part is the
        // wrapping <div class="toggle ...">, which gets the extra class "off" when the input is unchecked.
        // Both "Active" and "Inactive" labels always exist inside it, so status must be read from the "off" class.
        By verifystatusbutton = By.xpath("//span[text()='Status']/parent::label/following-sibling::div[contains(concat(' ',normalize-space(@class),' '),' toggle ')]");
        By clickstatusbutton = By.xpath("//input[@id='bulk_status']");
        By updatebutton = By.xpath("//button[text()='Update']");
        By zoneStatusToggles = By.xpath("//table[@id='alternative_pagination_table_v1']/tbody/tr//div[contains(concat(' ',normalize-space(@class),' '),' toggle ') and .//label[text()='Active']]");
        By verifystatusofzones = By.xpath("//table[@id='alternative_pagination_table_v1']/tbody/tr//div[contains(concat(' ',normalize-space(@class),' '),' toggle ') and .//label[text()='Active'] and contains(concat(' ',normalize-space(@class),' '),' off ')]");
        By activestatusofzones = By.xpath("//table[@id='alternative_pagination_table_v1']/tbody/tr//div[contains(concat(' ',normalize-space(@class),' '),' toggle ') and .//label[text()='Active'] and not(contains(concat(' ',normalize-space(@class),' '),' off '))]");
        // Threshold Time uses the same hidden-checkbox markup as Status. The dropdown is a bootstrap-select:
        // the real <select> is hidden and holds the value, the visible part is the button with data-id.
        By thresholdtime = By.xpath("//span[text()='Threshold Time']/following-sibling::span[@class='checkmark']");
        By thresholdtimeInput = By.xpath("//span[text()='Threshold Time']/parent::label//input[@type='checkbox']");
        By thresholdSelect = By.xpath("//select[@id='bulk_threshold_time']");
        By Threasholddropdown = By.xpath("//button[@aria-haspopup='listbox' and @data-id='bulk_threshold_time']");
        By thresholdDropdownOptions = By.xpath("//button[@data-id='bulk_threshold_time']/following-sibling::div[contains(@class,'dropdown-menu')]//li[not(contains(@class,'disabled'))]//span[@class='text']");




        public  void lunchmodule(String expectedURL){

                TestReporter.log("Test Start: Verify Delay Config Module Lunch");
                try {
                        TestReporter.log("Lunching The Delay Config Module");
                        driver.get(expectedURL);
                        String actualURl = driver.getCurrentUrl();
                        Assert.assertTrue(actualURl.contains("overflow_delay_manageV1"),
                                        "Delay Config Module Lunch Failed. Actual URL: " + actualURl);

                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                        List<WebElement> tableRows = createWebElements(Tabledata);

                        TestReporter.log("Validating Table Data");
                        Assert.assertFalse(tableRows.isEmpty(), "Table Data is Empty");
                        TestReporter.log("Table Data Found. Total Rows: " + tableRows.size());

                        TestReporter.log("Delay Config Module Lunched Successfully");

                } catch (Exception e) {
                        TestReporter.log("Error while launching Delay Config Module: " + e.getMessage());
                        Assert.fail("An error occurred while launching Delay Config Module", e);
                } finally {
                        TestReporter.log("Test End: Verify Delay Config Module Lunch");
                }
        }



        public  void validatecheckboxfunc(){

                TestReporter.log("Test Start: Validate Checkbox Functionality");
                try {

                        WebElement selectAllBox = createWebElement(selectAllCheckmark);

                        TestReporter.log("Verify Select All checkbox is displayed");
                        Assert.assertTrue(selectAllBox.isDisplayed(), "Select All checkbox is not displayed");
                        TestReporter.log("Select All checkbox is displayed");

                        TestReporter.log("Verify Select All checkbox is initially unselected");
                        Assert.assertFalse(driver.findElement(selectAllInput).isSelected(), "Select All checkbox is already selected");

                        TestReporter.log("Clicking on the Select All checkbox");
                        clickOperation(selectAllBox);
                        TestReporter.log("Select All checkbox clicked successfully");

                        TestReporter.log("Verifying Select All checkbox is selected");
                        Assert.assertTrue(driver.findElement(selectAllInput).isSelected(), "Select All checkbox is not selected");
                        TestReporter.log("Select All checkbox is selected successfully");

                        TestReporter.log("Verify Select All Selected All the other checkboxes");
                        // The page's script ticks the row checkboxes after Select All is clicked, so give it
                        // time to finish; the loop below still reports the exact row if one never gets selected.
                        try {
                                new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> {
                                        List<WebElement> boxes = d.findElements(rowCheckboxes);
                                        return !boxes.isEmpty() && boxes.stream().allMatch(WebElement::isSelected);
                                });
                        } catch (TimeoutException ignored) {
                        }
                        List<WebElement> rows = driver.findElements(rowCheckboxes);
                        Assert.assertFalse(rows.isEmpty(), "No zone checkboxes found in the table");
                        for (int i = 0; i < rows.size(); i++) {
                                Assert.assertTrue(rows.get(i).isSelected(), "Zone checkbox in row " + (i + 1) + " is not selected");
                        }
                        TestReporter.log("All " + rows.size() + " zone checkboxes are selected successfully");

                        TestReporter.log("Verify Bulk Update Button is displayed");
                        WebElement Bulkupdatebutton = createWebElement(Bulkupdate);
                        Assert.assertTrue(Bulkupdatebutton.isDisplayed(), "Bulk Update Button is not displaying");
                        TestReporter.log("Bulk Update button is showing Successfully");

                        TestReporter.log("Checkbox Functionality Validated Successfully");

                } catch (Exception e) {
                        TestReporter.log("Error while validating checkbox functionality: " + e.getMessage());
                        Assert.fail("An error occurred while validating checkbox functionality", e);
                } finally {
                        TestReporter.log("Test End: Validate Checkbox Functionality");
                }
        }



        public void ClickOnBulkUpdateButton() {

                TestReporter.log("====== Test Start: Click on Bulk Update Button ====");
                try {
                        int selectedRows = 0;
                        for (WebElement row : driver.findElements(rowCheckboxes)) {
                                if (row.isSelected()) {
                                        selectedRows++;
                                }
                        }
                        TestReporter.log("Zones selected in the table: " + selectedRows);

                        TestReporter.log("Click on Bulk Update Button");
                        WebElement bulk = createWebElement(Bulkupdate);
                        clickOperation(bulk);
                        TestReporter.log("Clicked On Bulk Update Button");

                        TestReporter.log("Validate All Selected Zones Are Showing in The Bulk Update Popup");
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectedZones));
                        List<WebElement> SelectedZone = createWebElements(SelectedZones);
                        for (WebElement zones : SelectedZone) {
                                TestReporter.log("Avilable Selected Zones Are : " + zones.getText());
                        }
                        Assert.assertEquals(SelectedZone.size(), selectedRows,
                                        "Selected Zones count in the popup does not match the zones selected in the table");
                        TestReporter.log("All " + SelectedZone.size() + " Selected Zones Are Showing in The Popup");

                        TestReporter.log("Close The Popup");
                        WebElement close = createWebElement(ClosePopup);
                        clickOperation(close);
                        TestReporter.log("Popup Closed");

                } catch (Exception e) {
                        TestReporter.log("Error while validating Bulk Update popup: " + e.getMessage());
                        Assert.fail("An error occurred while validating Bulk Update popup", e);
                } finally {
                        TestReporter.log("Test End: Bulk Updation Button Clicked & Validated Selected Zones");
                }
        }



        // BaseTest sets a 40s implicit wait, which makes findElements() block for 40s whenever the
        // count is 0 (e.g. no Active zones). Turn it off while counting, then restore it.
        private int countWithoutImplicitWait(By locator) {
                driver.manage().timeouts().implicitlyWait(Duration.ZERO);
                try {
                        return driver.findElements(locator).size();
                } finally {
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
                }
        }



        public void StatusCheckBox(){
                TestReporter.log("=== Test Start: Verify Status Checkbox Functionality ====");

                try {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                        // Step 1: read the current status of every zone from its toggle ("off" class = Inactive)
                        TestReporter.log("Check the current status of all zones");
                        wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                        int totalZones = driver.findElements(zoneStatusToggles).size();
                        Assert.assertTrue(totalZones > 0, "No zone status toggles found in the table");
                        int inactiveZones = countWithoutImplicitWait(verifystatusofzones);
                        int activeZones = countWithoutImplicitWait(activestatusofzones);
                        TestReporter.log("Total zones: " + totalZones + ", Active: " + activeZones + ", Inactive: " + inactiveZones);
                        Assert.assertEquals(activeZones + inactiveZones, totalZones, "Could not read the status of every zone");

                        // All zones Inactive -> enable them all; otherwise -> disable them all
                        boolean enableZones = inactiveZones == totalZones;
                        By expectedStatus = enableZones ? activestatusofzones : verifystatusofzones;
                        String expectedStatusText = enableZones ? "Active" : "Inactive";
                        TestReporter.log(enableZones
                                        ? "All zones are disabled, so all zones will be enabled"
                                        : "Zones are enabled, so all zones will be disabled");

                        // Step 2: make sure every zone is selected and open the Bulk Update popup
                        // (ClickOnBulkUpdateButton() closes the popup at the end, so it is reopened if needed)
                        openBulkUpdatePopup(wait);

                        // Step 3: Status checkbox is unchecked and the Status toggle is locked
                        TestReporter.log("Verify Status CheckBox is avilable in the Popup");
                        WebElement statuscheckbox = createWebElement(StatusChecbox);
                        Assert.assertTrue(statuscheckbox.isDisplayed(), "Status Checkbox is not avilable");
                        TestReporter.log("Status checkbox is avilable in the popup");

                        TestReporter.log("Verify Status checkbox is unchecked by default");
                        Assert.assertFalse(driver.findElement(StatusCheckboxInput).isSelected(),
                                        "Status checkbox is already checked before clicking");
                        TestReporter.log("Status checkbox is unchecked by default");

                        // The visible toggle is a div; the hidden input#bulk_status holds the enabled/checked state
                        WebElement statusbutton = createWebElement(verifystatusbutton);
                        boolean initialToggleState = driver.findElement(clickstatusbutton).isSelected();
                        TestReporter.log("Status toggle default state: " + (initialToggleState ? "Active" : "Inactive"));

                        TestReporter.log("Validate Status Button is disabled while Status checkbox is unchecked");
                        Assert.assertFalse(driver.findElement(clickstatusbutton).isEnabled(),
                                        "Status Button is enabled even though Status checkbox is unchecked");
                        TestReporter.log("Status Button is in the disabled state");

                        TestReporter.log("Click on the status button without clicking on the status checkbox");
                        clickOperation(statusbutton);
                        TestReporter.log("Verify Status button state is not changed");
                        Assert.assertEquals(driver.findElement(clickstatusbutton).isSelected(), initialToggleState,
                                        "Status Button state changed even though Status checkbox is unchecked");
                        TestReporter.log("Status Button state is not changed");

                        // Step 4: tick the Status checkbox, which unlocks the toggle
                        TestReporter.log("Click on status checkbox");
                        clickOperation(statuscheckbox);
                        TestReporter.log("Status checkbox is clicked");

                        TestReporter.log("Validate Status checkbox is checked");
                        Assert.assertTrue(driver.findElement(StatusCheckboxInput).isSelected(), "Status checkbox is not checked");
                        TestReporter.log("Status checkbox is checked");

                        // input#bulk_status is hidden by Bootstrap Toggle, so wait for it to be enabled, not clickable
                        TestReporter.log("Validate Status Button is enabled after checking Status checkbox");
                        wait.until(d -> d.findElement(clickstatusbutton).isEnabled());
                        TestReporter.log("Status Button is enabled");

                        // Step 5: set the toggle to the target status (only click when it is not already there)
                        if (driver.findElement(clickstatusbutton).isSelected() != enableZones) {
                                TestReporter.log("Click on the status button to set status to " + expectedStatusText);
                                clickOperation(statusbutton);
                                wait.until(d -> d.findElement(clickstatusbutton).isSelected() == enableZones);
                        } else {
                                TestReporter.log("Status button is already set to " + expectedStatusText + ", no need to click");
                        }
                        Assert.assertEquals(driver.findElement(clickstatusbutton).isSelected(), enableZones,
                                        "Status Button is not set to " + expectedStatusText);
                        TestReporter.log("Status Button is set to " + expectedStatusText);

                        // Step 6: update and verify every zone in the table has the new status
                        TestReporter.log("Click on update button");
                        clickOperation(createWebElement(updatebutton));
                        TestReporter.log("Update button is clicked");

                        TestReporter.log("Verify zones status is updated to " + expectedStatusText);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(SelectedZones));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                        wait.until(d -> countWithoutImplicitWait(expectedStatus) == totalZones);
                        int updatedZones = countWithoutImplicitWait(expectedStatus);
                        Assert.assertEquals(updatedZones, totalZones,
                                        "Not all zones are updated to " + expectedStatusText);
                        TestReporter.log("All " + updatedZones + " zones status updated to " + expectedStatusText);

                } catch (Exception e) {
                        TestReporter.log("Error while validating Status checkbox functionality: " + e.getMessage());
                        Assert.fail("An error occurred while validating Status checkbox functionality", e);
                } finally {
                        TestReporter.log("=== Test End: Verify Status Checkbox Functionality ===");
                }
        }


        public void ThresholdTimefunc(){

                    TestReporter.log("====== Verify Threshold functionality =====");

                    try {
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                        // StatusCheckBox() submits and closes the popup, so select the zones and open it again
                        int totalZones = openBulkUpdatePopup(wait);
                        TestReporter.log("Bulk Update popup is open with " + totalZones + " zones selected");

                        TestReporter.log("Step 1 : Verify Threshold visible text avilable with the checkbox");
                        WebElement thresholdtimevisibletext = createWebElement(thresholdtime);
                        Assert.assertTrue(thresholdtimevisibletext.isDisplayed(), "Fail : Threshold visible text not avilable in the Bulk update popup");
                        // The visible checkmark span is always "enabled"; the checked state lives in the hidden input
                        Assert.assertFalse(driver.findElement(thresholdtimeInput).isSelected(), "Fail : Threshold Time checkbox is already checked");
                        TestReporter.log("Pass :  Threshold visible text avilable with the checkbox in the bulk update popup");

                        TestReporter.log("Verify Threshold Time dropdown is disabled while the checkbox is unchecked");
                        Assert.assertFalse(driver.findElement(thresholdSelect).isEnabled(),
                                        "Fail : Threshold Time dropdown is enabled even though the checkbox is unchecked");
                        TestReporter.log("Pass : Threshold Time dropdown is disabled");

                        TestReporter.log("Step 2 : Click on Threshold Time checkbox & check it is enabled");
                        clickOperation(thresholdtimevisibletext);
                        TestReporter.log("Pass: Checkbox is clicked");
                        TestReporter.log("Step-3 :  Verify Threshold time checkbox is enabled");
                        Assert.assertTrue(driver.findElement(thresholdtimeInput).isSelected(), "Fail: Threshold time checkbox is not checked");
                        wait.until(d -> d.findElement(thresholdSelect).isEnabled());
                        TestReporter.log("Pass: Threshold Time checkbox is checked and the dropdown is enabled");

                        TestReporter.log("Step 4 : Click on Threashold Time dropdown in the bulk update popup");
                        Select thresholdOptions = new Select(driver.findElement(thresholdSelect));
                        String currentValue = thresholdOptions.getFirstSelectedOption().getText().trim();
                        TestReporter.log("Current Threshold Time: " + currentValue);
                        clickOperation(createWebElement(Threasholddropdown));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(thresholdDropdownOptions));

                        // Pick the first option that differs from the current one, so the update is an actual change
                        List<WebElement> options = driver.findElements(thresholdDropdownOptions);
                        Assert.assertFalse(options.isEmpty(), "Fail: Threshold Time dropdown has no options");
                        WebElement optionToSelect = options.stream()
                                        .filter(o -> !o.getText().trim().isEmpty() && !o.getText().trim().equals(currentValue))
                                        .findFirst()
                                        .orElseThrow(() -> new AssertionError("Fail: No other Threshold Time option to select"));
                        String selectedValue = optionToSelect.getText().trim();
                        TestReporter.log("Selecting Threshold Time: " + selectedValue);
                        clickOperation(optionToSelect);

                        TestReporter.log("Step 5 : Verify the selected Threshold Time is applied to the dropdown");
                        wait.until(d -> new Select(d.findElement(thresholdSelect)).getFirstSelectedOption().getText().trim().equals(selectedValue));
                        Assert.assertEquals(createWebElement(Threasholddropdown).getText().trim(), selectedValue,
                                        "Fail: Threshold Time dropdown does not show the selected value");
                        TestReporter.log("Pass: Threshold Time is set to " + selectedValue);

                        TestReporter.log("Step 6 : Click on update button");
                        clickOperation(createWebElement(updatebutton));
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(SelectedZones));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                        TestReporter.log("Pass: Threshold Time updated to " + selectedValue + " for " + totalZones + " zones");

                    } catch (Exception e) {
                        TestReporter.log("Error while validating Threshold Time functionality: " + e.getMessage());
                        Assert.fail("An error occurred while validating Threshold Time functionality", e);
                    } finally {
                        TestReporter.log("====== Test End: Verify Threshold functionality =====");
                    }

        }



        // Selects every zone (if not already selected) and opens the Bulk Update popup if it is closed.
        // Returns the number of zones in the table, after checking they all show up in the popup.
        private int openBulkUpdatePopup(WebDriverWait wait) throws InterruptedException {
                wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                int totalZones = driver.findElements(zoneStatusToggles).size();

                if (!driver.findElement(selectAllInput).isSelected()) {
                        TestReporter.log("Select All checkbox is not selected, selecting all zones");
                        clickOperation(createWebElement(selectAllCheckmark));
                        Assert.assertTrue(driver.findElement(selectAllInput).isSelected(), "Select All checkbox is not selected");
                }

                List<WebElement> popupZones = driver.findElements(SelectedZones);
                if (popupZones.isEmpty() || !popupZones.get(0).isDisplayed()) {
                        TestReporter.log("Bulk Update popup is closed, opening it again");
                        clickOperation(createWebElement(Bulkupdate));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectedZones));
                }
                int selectedZoneCount = driver.findElements(SelectedZones).size();
                TestReporter.log("Zones selected for bulk update: " + selectedZoneCount);
                Assert.assertEquals(selectedZoneCount, totalZones, "Not all zones are selected in the Bulk Update popup");
                return totalZones;
        }

}
