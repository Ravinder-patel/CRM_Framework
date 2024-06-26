package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsWindowPage {
	WebDriver driver = null;

	public OrganizationsWindowPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//input[@name='search_text']")
	private WebElement SearchFeild;

	public WebElement getSearchFeild() {
		return SearchFeild;
	}
	@FindBy(xpath ="//input[@name='search']")
	private WebElement SearchButton;

	public WebElement getSearchButton() {
		return SearchFeild;
	}

}
