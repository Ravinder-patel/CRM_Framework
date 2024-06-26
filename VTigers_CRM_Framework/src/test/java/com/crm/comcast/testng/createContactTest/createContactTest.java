package com.crm.comcast.testng.createContactTest;

import org.testng.annotations.Test;

import com.crm.comcast.baseclass.utility.ExamplebaseClass;

public class createContactTest extends ExamplebaseClass {

	@Test
	public void createContactTest() {
		System.out.println("Contact created & verify");
	}

	@Test
	public void createContactWithOrgTest() {
		System.out.println("Contact with org created & verify");
	}

}
