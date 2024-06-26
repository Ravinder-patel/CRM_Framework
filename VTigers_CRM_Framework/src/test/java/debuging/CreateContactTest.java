package debuging;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ObjectRepository.contactsPage;
import com.comcast.crm.ObjectRepository.createContactPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.StaticPoolUlility.StaticObjectsUtility;
import com.crm.BaseClass.Utility.BaseClass;

/**
 * @author Ravinnder patel
 * @implNote This Testcase is used test the Vtigers apliacation Contact module
 * 
 */
@Listeners(com.comcast.crm.ListenerUtility.ListenerImplemetation.class)
public class CreateContactTest extends BaseClass {
	SoftAssert sAssert=new SoftAssert();
	@Test
	public void createContactTest() throws Throwable {
		StaticObjectsUtility.getTest().log(Status.INFO, "Navigate to vtigers");

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on Contacts link");
		homePage hp = new homePage(driver);
		hp.getContactsLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "click on create contact link image");
		contactsPage cp = new contactsPage(driver);
		cp.createContactLink().click();

		/* get testscript data from excel file */
		int randomInt = jUtil.getRandomInteger();
		String lastName = eUtil.getDataFromExcel("contact", 4, 6) + randomInt;

		/* get the data from excel file object references */
		StaticObjectsUtility.getTest().log(Status.INFO, "Enter data into last name text feild");
		createContactPage ccp = new createContactPage(driver);
		ccp.getlastNameTextField().sendKeys(lastName);

		StaticObjectsUtility.getTest().log(Status.INFO, " click on save button ");
		ccp.getSaveButton().click();

		/* Verify the Expected results */

		/* find created lastname name in header messsage */
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find create lastrname in org table
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		/* verify header msg contains last name */
		StaticObjectsUtility.getTest().log(Status.INFO, "Verify the Data");
		if (headerInfo.contains(lastName+3)) {
			StaticObjectsUtility.getTest().log(Status.PASS, lastName + ": is available in Headers");
		} else {
			//StaticObjectsUtility.getTest().log(Status.FAIL, lastName + ": is not available in Header");
			sAssert.fail();
		}
		/* verify org table contains last name */
		if (actualLastName.equals(lastName+1)) {
			StaticObjectsUtility.getTest().log(Status.PASS, lastName + ": is available in org table");
		} else {
			Assert.fail();
		}

	}

}
