package practice.testng;

import org.testng.annotations.Test;

public class invocationCountTest {

	@Test(invocationCount = 5)
	public void createContactTest() {
		System.out.println("crate contact test====1");
		System.out.println("create contact-->> ICICI");
		//Assert.fail();

	}

	@Test
	public void deleteContactTest() {
		System.out.println("delete Contact test====3");
		System.out.println("delete Contact -->> SBI");
	}

	@Test
	public void modifyContactTest() {
		System.out.println("modify Contact test====2");
		System.out.println("modify contact-->> ICICI-->>SBI");
			}

}
