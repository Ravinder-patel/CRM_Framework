package com.crm.comcast.testng.createOrgTest;

import org.testng.annotations.Test;

import com.crm.comcast.baseclass.utility.ExamplebaseClass;

public class createOrgTest extends ExamplebaseClass {
	@Test
	public void createOrgTest() {
		System.out.println("Org created & verify");
	}

	@Test
	public void createOrgWithIndustryTest() {
		System.out.println("Org with industry created & verify");
	}
}






