package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactPage {
	WebDriver driver = null;

	public createContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="support_end_date")
	private WebElement EndDateTextFeild;
	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;


	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(name="support_start_date")
	private WebElement StartDateTextFeild;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement createOrgButton;
	
	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}


	public WebElement getStartDateTextFeild() {
		return StartDateTextFeild;
	}


	public WebElement getEndDateTextFeild() {
		return EndDateTextFeild;
	}


	
	public WebElement getlastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

}
