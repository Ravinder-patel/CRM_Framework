package com.crm.comcast.testng.createOrgTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.ListenerUtility.ListenerImplemetation;
import com.comcast.crm.ObjectRepository.createOrganizationPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.ObjectRepository.organizationsPage;
import com.crm.BaseClass.Utility.BaseClass;

public class CreateOrgTest1 extends BaseClass {
	@Test(groups = { "Smoke Test", "Regression Test" })
	public void createOrgTest() throws Throwable {
		
		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

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
			System.out.println(OrgName + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		
	}

	@Test(groups = "Regression Test")
	public void createOrgWithInsdustryAndTypeTest() throws Throwable {

		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

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
			System.out.println(OrgName + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		// verify header msg contains org name

		if (actualIndustry.equals(OrgIndustry)) {
			System.out.println(OrgIndustry + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgIndustry + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualType.equals(OrgType)) {
			System.out.println(OrgType + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgType + ": is not available in org table=====Fail");

		}
	}

	@Test(groups = "Regression Test")
	public void CreateOrgWithPhoneNumberTest() throws Throwable {

		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

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
			System.out.println(OrgName + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualOrgName.equals(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		// verify header msg contains org name
		if (actualIndustry.equals(OrgIndustry)) {
			System.out.println(OrgIndustry + ": is available in Header=====Pass");
		} else {
			System.out.println(OrgIndustry + ": is not available in Header=====Fail");
		}
		// verify org table contains org name
		if (actualType.equals(OrgType)) {
			System.out.println(OrgType + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgType + ": is not available in org table=====Fail");
		}
		// verify the phone number
		if (actualPhone.equals(OrgPhone)) {
			System.out.println(OrgPhone + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgPhone + ": is not available in org table=====Fail");
		}
	}
}
