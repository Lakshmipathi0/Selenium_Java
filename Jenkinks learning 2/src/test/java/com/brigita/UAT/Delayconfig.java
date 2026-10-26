package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.DelayConfig;

public class Delayconfig extends DelayConfig {

@Test(priority = 1, groups = {"Smoke"})
public void TC_001_Lunchthemodule(){
    lunchmodule("https://riderapp-admin.eateasy.ae/master/v3/overflow_delay_manageV1");

}

@Test(priority = 2, dependsOnMethods="TC_001_Lunchthemodule", groups = {"Smoke"})
public void TC_002_Validatecheckboxfunc(){
    validatecheckboxfunc(); 
}

@Test(priority = 3, dependsOnMethods="TC_002_Validatecheckboxfunc", groups = {"Smoke"})
public void TC_003_ClickOnBulkUpdateButton(){
    ClickOnBulkUpdateButton();
}

@Test(priority= 4, dependsOnMethods = "TC_003_ClickOnBulkUpdateButton", groups = {"Smoke"})
public void TC_004_StatuscheckboxFunctionality(){
    StatusCheckBox();
}

@Test(priority= 5, dependsOnMethods = "TC_004_StatuscheckboxFunctionality", groups = {"Smoke"})
public void TC_005_ThresholdTimeFunctionality(){
    ThresholdTimefunc();
}

}