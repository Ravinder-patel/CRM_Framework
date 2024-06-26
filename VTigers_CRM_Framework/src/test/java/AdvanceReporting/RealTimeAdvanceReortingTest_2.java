package AdvanceReporting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.ListenerImplemetation;
import com.comcast.crm.ObjectRepository.createOrganizationPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.ObjectRepository.organizationsPage;
import com.comcast.crm.StaticPoolUlility.StaticObjectsUtility;
import com.crm.BaseClass.Utility.BaseClass;

public class RealTimeAdvanceReortingTest_2 extends BaseClass {

	@Test(groups = { "Smoke Test", "Regression Test" })
	public void createOrgTest() throws Throwable {
		StaticObjectsUtility.getTest().log(Status.INFO, "Navigate to VTigers application"); // with static variable

		homePage hp = new homePage(driver);
		StaticObjectsUtility.getTest().log(Status.INFO, "Click on organizations");
		hp.getOrganizationsLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on Create organizations");
		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

		int randomInt = jUtil.getRandomInteger();
		String OrgName = eUtil.getDataFromExcel("orgData", 1, 2) + randomInt;
		
		createOrganizationPage createOrgPage = new createOrganizationPage(driver);
		createOrgPage.getOrganizationTextFeild().sendKeys(OrgName);
		createOrgPage.getSaveButton().click();

		// Verify the Expected results
		// find created org name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		// verify header msg contains org name
		if (headerInfo.contains(OrgName)) {
			StaticObjectsUtility.getTest().log(Status.PASS, OrgName + " : is available in Header");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL, OrgName + " : is available in Header");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName+2)) {
			StaticObjectsUtility.getTest().log(Status.PASS, OrgName + " : is available in org table");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL, OrgName + " : is not available in org table");

		}
	}
	@Test(groups = "Regression Test")
	public void createOrgWithInsdustryAndTypeTest() throws Throwable {
		StaticObjectsUtility.getTest().log(Status.INFO, "Navigate to VTigers application"); // with static variable

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on Organizations link");
		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on create Organizations link");
		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "Enter Details");
		int randomInt = jUtil.getRandomInteger();
		String OrgName = eUtil.getDataFromExcel("orgData", 1, 2) + randomInt;
		String OrgIndustry = eUtil.getDataFromExcel("orgData", 2, 3);
		String OrgType = eUtil.getDataFromExcel("orgData", 2, 4);

		// get the data from excel file object references
		createOrganizationPage createOrgPage = new createOrganizationPage(driver);
		createOrgPage.getOrganizationTextFeild().sendKeys(OrgName);

		// select industry of the org
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Select selectIndustry = new Select(industryDrop);
		selectIndustry.selectByVisibleText(OrgIndustry);

		// select industry of the org
		WebElement typeDrop = driver.findElement(By.name("accounttype"));
		Select selectType = new Select(typeDrop);
		selectType.selectByVisibleText(OrgType);

		StaticObjectsUtility.getTest().log(Status.INFO, "Save Details");
		createOrgPage.getSaveButton().click();

		// Verify the Expected results
		// find created org name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		// find created org industry in org table
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		// find created org industry in org table
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();

		// verify header msg contains org name

		if (headerInfo.contains(OrgName)) {

			StaticObjectsUtility.getTest().log(Status.PASS,OrgName + ": is available in Header");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgName + ": is not available in Header");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgName + ": is available in org table");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgName + ": is not available in org table");
		}
		// verify header msg contains org name

		if (actualIndustry.equals(OrgIndustry)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgIndustry + ": is available in Header");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgIndustry + ": is not available in Header");
		}
		// verify org table contains org name
		if (actualType.equals(OrgType)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgType + ": is available in org table");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgType + ": is not available in org table");

		}
	}
	@Test(groups = "Regression Test")
	public void CreateOrgWithPhoneNumberTest() throws Throwable {
		StaticObjectsUtility.getTest().log(Status.INFO, "Navigate to VTigers application");

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on organizations link");
		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "Click on create organizations link");
		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

		StaticObjectsUtility.getTest().log(Status.INFO, "Enter deatails");
		int randomInt = jUtil.getRandomInteger();
		String OrgName = eUtil.getDataFromExcel("orgData", 3, 2) + randomInt;
		String OrgIndustry = eUtil.getDataFromExcel("orgData", 3, 3);
		String OrgType = eUtil.getDataFromExcel("orgData", 3, 4);
		String OrgPhone = eUtil.getDataFromExcel("orgData", 3, 5) + randomInt;

		// get the data from excel file object references
		createOrganizationPage createOrgPage = new createOrganizationPage(driver);
		createOrgPage.getOrganizationTextFeild().sendKeys(OrgName);

		// select industry of the org
		WebElement industryDrop = driver.findElement(By.name("industry"));
		Select selectIndustry = new Select(industryDrop);
		selectIndustry.selectByVisibleText(OrgIndustry);

		// select industry of the org
		WebElement typeDrop = driver.findElement(By.name("accounttype"));
		Select selectType = new Select(typeDrop);
		selectType.selectByVisibleText(OrgType);

		createOrgPage.getPhoneNumberTextFeild().sendKeys(OrgPhone);

		StaticObjectsUtility.getTest().log(Status.INFO, "Save details");
		createOrgPage.getSaveButton().click();

		// Verify the Expected results

		// find created org name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		// find created org industry in org table
		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		// find created org industry in org table
		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		// find created org industry in org table
		String actualPhone = driver.findElement(By.id("dtlview_Phone")).getText();

		// verify header msg contains org name
		if (headerInfo.contains(OrgName)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgName + ": is available in Header ");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgName + ": is not available in Header ");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgName + ": is available in org table ");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgName + ": is not available in org table ");
		}
		// verify header msg contains org name
		if (actualIndustry.equals(OrgIndustry)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgIndustry + ": is available in Header ");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgIndustry + ": is not available in Header ");
		}
		// verify org table contains org name
		if (actualType.equals(OrgType+1)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgType + ": is available in org table ");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgType + ": is not available in org table ");
			Assert.assertEquals(actualType, OrgType+1);
		}
		// verify the phone number
		if (actualPhone.equals(OrgPhone)) {
			StaticObjectsUtility.getTest().log(Status.PASS,OrgPhone + ": is available in org table ");
		} else {
			StaticObjectsUtility.getTest().log(Status.FAIL,OrgPhone + ": is not available in org table ");
		}
	}

}
