package screenshotSample;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.BaseClass.Utility.BaseClass;

//@Listeners(com.comcast.crm.ListenerUtility.ListenerImplimenation.class)
public class InvoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest() {
		String homePageName = driver.getTitle();
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertEquals(homePageName, "PatelGraphy");
		System.out.println("Step-3");
		System.out.println("Step-4");

	}

	@Test
	public void createInvoiceWithcontactTest() {
		System.out.println("Step-1");
		System.out.println("Step-2");
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertEquals("Ravi", "revi");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
		sAssert.assertAll();
	}

}
