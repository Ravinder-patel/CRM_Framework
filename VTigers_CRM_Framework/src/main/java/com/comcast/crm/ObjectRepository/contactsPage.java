package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage {
	
	WebDriver driver = null;
	public contactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath= "//img[@alt='Create Contact...']")
	private WebElement crateContactLink;
	
	public WebElement createContactLink() {
		return crateContactLink;
	}

	
}
