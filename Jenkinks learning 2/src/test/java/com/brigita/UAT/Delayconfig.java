package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.DelayConfig;

public class Delayconfig extends DelayConfig {

@Test(priority = 1, groups = {"Smoke"})
public void TC_001_Lunchthemodule(){
    lunchmodule("https://riderapp-admin.eateasy.ae/master/v3/overflow_delay_manageV1");

}

@Test(priority = 2, groups = {"Smoke"})
public void TC_002_Validatecheckboxfunc(){
    validatecheckboxfunc(); 
}


}