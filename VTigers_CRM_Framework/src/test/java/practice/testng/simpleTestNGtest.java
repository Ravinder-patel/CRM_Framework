package practice.testng;

import java.util.Date;

import org.testng.annotations.Test;

public class simpleTestNGtest {
	@Test
	public void createContactTest() {
		System.out.println("crate contact test");
	}
	
	@Test
	public void createContactWithOrgTest() {
		System.out.println("crate Contact With Org test");
		System.out.println(new Date().toString());
	}

}
