package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.DelayConfig;

public class Delayconfig extends DelayConfig {

@Test(priority = 1)
public void TC_001_Lunchthemodule(){
    LunchModule();
}

@Test(priority = 2, dependsOnMethods = "TC_001_Lunchthemodule")
public void TC_002_Click_on_select_option(){
    verifySelectAllSelectsAllZones();
}

}
