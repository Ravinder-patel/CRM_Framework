package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrganizationPage {
	WebDriver driver = null;

	public createOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrganizationTextFeild;

	@FindBy(name = "phone")
	private WebElement PhoneNumberTextFeild;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getOrganizationTextFeild() {
		return OrganizationTextFeild;
	}

	public WebElement getPhoneNumberTextFeild() {
		return PhoneNumberTextFeild;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
