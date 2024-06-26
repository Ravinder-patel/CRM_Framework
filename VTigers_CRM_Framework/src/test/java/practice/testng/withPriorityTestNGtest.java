package practice.testng;

import org.testng.annotations.Test;

public class withPriorityTestNGtest {
	@Test(priority = 1)
	public void createContactTest() {
		System.out.println("crate contact test====1");
		System.out.println("create contact-->> ICICI");

	}

	@Test(priority = 3)
	public void deleteContactTest() {
		System.out.println("delete Contact test====3");
		System.out.println("create contact-->> SBI");
		// -----or------
		System.out.println("create contact SBI in Database by executeQuery");
		System.out.println("delete Contact -->> SBI");
	}

	@Test(priority = 2)
	public void modifyContactTest() {
		System.out.println("modify Contact test====2");
		System.out.println("create contact-->> ICICI");
		// ------or-------
		System.out.println("create contact ICICI in Database by executeQuery");
		System.out.println("modify contact-->> ICICI-->>SBI");
	}

}
