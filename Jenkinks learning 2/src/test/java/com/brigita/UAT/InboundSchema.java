package com.brigita.UAT;

import org.testng.annotations.Test;

import com.brigita.base.Inbounschemamenu;

public class InboundSchema extends Inbounschemamenu {

	@Test ( priority = 1, groups= {"Setting"})
	public void TC_001_verify_Setting_Icon_Is_Available_With_Correct_Spelling_And_Clickable() throws InterruptedException 
	{

		verifySettingIcon("Settings");
	}

	@Test ( priority = 2, groups= {"Inbound Schema"})
	public void TC_002_verify_Inbound_Schema_Menu_Is_Available_With_Logo_Correct_Spelling_And_Highlighted() throws InterruptedException 
	{

		verifInboundSchemaMenu("Inbound Schema");
	}

	@Test ( priority = 3, groups= {"Inbound Schema"})
	public void TC_003_verify_Inbound_Mapping_Text_Is_Available_With_Correct_Spelling() throws InterruptedException 
	{

		verifyInboundMappingText("Inbound Mapping");
	}

	@Test ( priority = 4, groups= {"Inbound Schema"})
	public void TC_003_Verify_That_The_ALL_Link_Is_Available_Clickable_And_Has_The_Correct_Spelling() throws InterruptedException 
	{

		verifyAllLink("ALL");
	}

	@Test ( priority = 5, groups= {"Inbound Schema"})
	public void TC_003_Verify_That_The_Mapped_Link_Is_Available_Clickable_And_Has_The_Correct_Spelling() throws InterruptedException 
	{

		verifyMappingLink("Mapped");
	}

	@Test ( priority = 6, groups= {"Inbound Schema"})
	public void TC_003_Verify_That_The_Unmapped_Link_Is_Available_Clickable_And_Has_The_Correct_Spelling() throws InterruptedException 
	{

		verifyUnmappedLink("Unmapped");
	}
}
