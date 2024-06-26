package com.crm.comcast.testng.createContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.contactsPage;
import com.comcast.crm.ObjectRepository.createContactPage;
import com.comcast.crm.ObjectRepository.createOrganizationPage;
import com.comcast.crm.ObjectRepository.homePage;
import com.comcast.crm.ObjectRepository.organizationsPage;
import com.comcast.genric.webdriver.utility.WebDriverUtility;
import com.crm.BaseClass.Utility.BaseClass;

public class CreateContactTest2 extends BaseClass {
	@Test(groups = {"Smoke Test","Regression Test"})
	public void createContactTest() throws Throwable {

		homePage hp = new homePage(driver);
		hp.getContactsLink().click();

		contactsPage cp = new contactsPage(driver);
		cp.createContactLink().click();

		// get testscript data from excel file
		int randomInt = jUtil.getRandomInteger();
		String lastName = eUtil.getDataFromExcel("contact", 4, 6) + randomInt;

		// get the data from excel file object references
		createContactPage ccp = new createContactPage(driver);
		ccp.getlastNameTextField().sendKeys(lastName);

		// save changes
		ccp.getSaveButton().click();

		// Verify the Expected results

		// find created lastname name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find create lastrname in org table
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

		// verify header msg contains last name

		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + ": is available in Header=====Pass");
		} else {
			System.out.println(lastName + ": is not available in Header=====Fail");

		}
		// verify org table contains last name
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + ": is available in org table=====Pass");
		} else {
			System.out.println(lastName + ": is not available in org table=====Fail");

		}

	}

	@Test(groups = "Regression Test")
	public void CreateContactWithSupportDate() throws Throwable {

		homePage hp = new homePage(driver);
		hp.getContactsLink().click();

		contactsPage cp = new contactsPage(driver);
		cp.createContactLink().click();
		// get testscript data from excel file
		// get testscript data from excel file
		int randomInt = jUtil.getRandomInteger();
		String lastName = eUtil.getDataFromExcel("contact", 4, 6) + randomInt;

		String startDate = jUtil.getSystemDateYYYYMMDD();
		String endDate = jUtil.getRequiredDateYYYYMMDD(30);

		// get the data from excel file object references
		createContactPage createCont = new createContactPage(driver);
		createCont.getlastNameTextField().sendKeys(lastName);

		WebElement sDate = createCont.getStartDateTextFeild();
		sDate.clear();
		sDate.sendKeys(startDate);
		WebElement eDate = createCont.getEndDateTextFeild();
		eDate.clear();
		eDate.sendKeys(endDate);

		// save changes
		createCont.getSaveButton().click();

		// Verify the Expected results

		// find created lastname name in header messsage
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find create lastrname in org table
		String actualLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		// find start date created in contacts page
		String actualStartDate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		// find start date created in contacts page
		String actualEndDate = driver.findElement(By.id("mouseArea_Support End Date")).getText();

		// verify header msg contains last name

		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + ": is available in Header=====Pass");
		} else {
			System.out.println(lastName + ": is not available in Header=====Fail");

		}
		// verify org table contains last name
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + ": is available in org table=====Pass");
		} else {
			System.out.println(lastName + ": is not available in org table=====Fail");

		}
		// verify contacts contain support date

		if (actualStartDate.contains(startDate)) {
			System.out.println(startDate + ": is available=====Pass");
		} else {
			System.out.println(startDate + ": is not available=====Fail");

		}
		// verify contacts contain support date

		if (actualEndDate.contains(endDate)) {
			System.out.println(endDate + ": is available=====Pass");
		} else {
			System.out.println(endDate + ": is not available=====Fail");

		}
	}

	@Test(groups = "Regression Test")
	public void createContactWithOrgTest() throws Throwable {
		System.out.println("Org Started");

		homePage hp = new homePage(driver);
		hp.getOrganizationsLink().click();

		organizationsPage orgPage = new organizationsPage(driver);
		orgPage.getCrateOrgLink().click();

		int randomInt = jUtil.getRandomInteger();
		String OrgName = eUtil.getDataFromExcel("orgData", 1, 2) + randomInt;

		// get the data from excel file object references
		createOrganizationPage createOrg = new createOrganizationPage(driver);
		createOrg.getOrganizationTextFeild().sendKeys(OrgName);
		// save
		createOrg.getSaveButton().click();

		// verify the expected results
		// find created org name in header message
		String headerInfo = driver.findElement(By.className("dvHeaderText")).getText();
		// find created org name in org table
		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

		// verify header message contains org name
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
		System.out.println("Org ended");
		System.out.println("=============");
		System.out.println("contact with Started");

		// click on contacts
		hp.getContactsLink().click();

		// click on + (create contact) button

		contactsPage contPage = new contactsPage(driver);
		contPage.createContactLink().click();

		createContactPage createCont = new createContactPage(driver);

		// get testscript data from excel file
		String lastName = eUtil.getDataFromExcel("contact", 4, 6);

		String lastName3 = lastName + randomInt;

		// get the data from excel file object references
		createCont.getlastNameTextField().sendKeys(lastName3);

		// click on + (create contact with org) button
		createCont.getCreateOrgButton().click();

		// create parentv window handle
		String parentWindow = driver.getWindowHandle();
		// switch to child window
		WebDriverUtility webUtil = new WebDriverUtility();
		webUtil.switchToTabOnURL(driver, "Accounts&action");

		// perform child window actions
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgName);

		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='" + OrgName + "']")).click();

		// switch to parent window
		driver.switchTo().window(parentWindow);

		Thread.sleep(2000);

		// save contacts info
		createCont.getSaveButton().click();

		// find created last name in header message
		String headerInfo3 = driver.findElement(By.className("dvHeaderText")).getText();
		// find created last name in org table
		String actualLastName3 = driver.findElement(By.id("dtlview_Last Name")).getText();
		// selected org name
		String actualOrgName3 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		// verify header message contains last name

		if (headerInfo3.contains(lastName3)) {
			System.out.println(lastName3 + ": is available in Header=====Pass");
		} else {
			System.out.println(lastName3 + ": is not available in Header=====Fail");
		}
		// verify org table contains last name
		if (actualLastName3.contains(lastName3)) {
			System.out.println(lastName3 + ": is available in org table=====Pass");
		} else {
			System.out.println(lastName3 + ": is not available in org table=====Fail");
		}
		// verify org table name in contact with org
		if (actualOrgName3.contains(OrgName)) {
			System.out.println(OrgName + ": is available in org table=====Pass");
		} else {
			System.out.println(OrgName + ": is not available in org table=====Fail");
		}
		System.out.println("contact with org ends");
		Thread.sleep(3000);
	}

}
