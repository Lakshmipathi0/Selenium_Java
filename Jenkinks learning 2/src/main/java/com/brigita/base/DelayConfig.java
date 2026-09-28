package com.brigita.base;

import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brigita.selenium.common.TestReporter;

public class DelayConfig extends BaseTest {


    // The real <input> checkboxes are hidden by the theme CSS (opacity 0), so we click the
    // visible checkmark span and read the checked state from the hidden input.
    By selectAll = By.xpath("//input[@id='checkall']");
    By selectAllCheckmark = By.xpath("//input[@id='checkall']/following-sibling::span[@class='checkmark']");
    By allzonescheckbox = By.xpath("//table[@id='alternative_pagination_table_v1']//tbody//input[@class='checkrow']");
    By bulkUpdateButton = By.xpath("//a[@id='BulkUpdate']");

    public  void LunchModule() {
        try {
            TestReporter.log("=== Launch the Overflow Delay Manage module ===");
            driver.get("https://riderapp-admin.eateasy.ae/master/v3/overflow_delay_manageV1");
            TestReporter.log("=== Overflow Delay Manage module launched successfully ===");
        } catch (Exception e) {
            Assert.fail("Failed to launch Overflow Delay Manage module: " + e.getMessage());
        } finally {
            TestReporter.log("Test End : Launch Module");
        }
    }

public void verifySelectAllSelectsAllZones() {

    TestReporter.log("Test Start : Verify Select All Selects All Zones Checkboxes");

    try {

        WebElement selectAllCheckbox = driver.findElement(selectAll);

        if (!selectAllCheckbox.isSelected()) {

            TestReporter.log("Click On Select All Checkbox");
            BaseTest.clickOperation(BaseTest.createWebElement(selectAllCheckmark));
            TestReporter.log("Select All Checkbox Clicked");

        } else {

            TestReporter.log("Select All was Already Selected");
        }

        Assert.assertTrue(
                selectAllCheckbox.isSelected(),
                "Select All Checkbox is not selected"
        );

        TestReporter.log("Select All Checkbox is Selected");

        List<WebElement> allZones = BaseTest.createWebElements(allzonescheckbox);

        Assert.assertTrue(allZones.size() > 0, "No zone checkboxes found in the list");
        TestReporter.log("Total Zone Checkboxes Found : " + allZones.size());

        for (int i = 0; i < allZones.size(); i++) {

            WebElement zoneCheckbox = allZones.get(i);

            Assert.assertTrue(
                    zoneCheckbox.isSelected(),
                    "Zone Checkbox " + (i + 1) + " is not selected" 
            );

            TestReporter.log("Zone Checkbox " + (i + 1) + " is Selected");
        }

        TestReporter.log("All Zone Checkboxes are Selected Successfully");

        Assert.assertTrue(
                createWebElement(bulkUpdateButton).isDisplayed(),
                "Bulk Update button is not displayed after Select All"
        );

        TestReporter.log("Bulk Update Button is Displayed");

    } catch (Exception e) {

        Assert.fail("Failed while verifying Select All Zones: " + e.getMessage());
    }
}


}
