package com.brigita.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.brigita.selenium.common.TestReporter;



public class DelayConfig extends BaseTest {


        By Tabledata = By.xpath("//table[@id='alternative_pagination_table_v1']/tbody/tr");
        By checkbox =  By.xpath("(//span[@class=\"checkmark\"])[1]");
        By checkbox1 = By.xpath("//span[@class='checkmark']");


        public  void lunchmodule(String expectedURL){


                TestReporter.log("Test Start: Verify Delay Config Module Lunch");
                try {
                        TestReporter.log("Lunching The Delay Config Module");
                        driver.get(expectedURL);
                        String actualURl = driver.getCurrentUrl();
                        Assert.assertEquals(actualURl, expectedURL, "Delay Config Module Lunch Failed");

                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(ExpectedConditions.visibilityOfElementLocated(Tabledata));
                        List<WebElement> tableRows = createWebElements(Tabledata);

                        TestReporter.log("Validating Table Data");
                        Assert.assertFalse(tableRows.isEmpty(), "Table Data is Empty");

                        TestReporter.log("Table Data Found. Total Rows: " + tableRows.size());

                } catch (Exception e) {
                        TestReporter.log("Error while launching Delay Config Module: "+ e.getMessage()
        );

        Assert.fail("An error occurred while launching Delay Config Module",e);
                } finally {
                        TestReporter.log("Test End: Delay Config Module Lunched Successfully");
                }
        }



              public  void validatecheckboxfunc(){

               TestReporter.log("Test Start: Validate Checkbox Functionality");
               
               try {

                     WebElement checkboxElement = createWebElement(checkbox);

                     TestReporter.log("Verify checkbox is displayed");
                     Assert.assertTrue(checkboxElement.isDisplayed(), "Checkbox is not displayed");
                     TestReporter.log("Checkbox is displayed");

                    // 2. Verify initial state
                TestReporter.log("Verify checkbox is initially unselected");
                Assert.assertFalse(checkboxElement.isSelected(),"Checkbox is already selected");

                     TestReporter.log("Clicking on the checkbox");
                     clickOperation(checkboxElement);
                     TestReporter.log("Checkbox clicked successfully");

                     TestReporter.log("Verifying checkbox is selected");
                     Assert.assertTrue(checkboxElement.isSelected(), "checkbox is not selected");
                     TestReporter.log("Checkbox is selected successfully");

                     TestReporter.log("Verify Select all Selected All the other checkboxes");
                     List<WebElement> checkboxList = createWebElements(checkbox1);
                     for (WebElement checkbox : checkboxList) {
                         Assert.assertTrue(checkbox.isSelected(), "Out of the Checkbox is not selected");
                     }
                     TestReporter.log("All checkboxes are selected successfully");


               } catch (Exception e) {
                     TestReporter.log("Error while validating checkbox functionality: "+ e.getMessage());
                     Assert.fail("An error occurred while validating checkbox functionality",e);
               } finally {
                     TestReporter.log("Test End: Checkbox Functionality Validated Successfully");
                     TestReporter.log("Learning Github and Jenkins Integration");
               }

              }




}