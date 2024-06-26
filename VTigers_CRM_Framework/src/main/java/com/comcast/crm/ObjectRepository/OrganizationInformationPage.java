package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver = null;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMessage;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement actualOrgName;

	@FindBy(id = "mouseArea_Phone")
	private WebElement actualPhoneNumber;

	public WebElement getHeaderMessage() {
		return headerMessage;
	}

	public WebElement getActualOrgName() {
		return actualOrgName;
	}

	public WebElement getActualPhoneNumber() {
		return actualPhoneNumber;
	}

}
