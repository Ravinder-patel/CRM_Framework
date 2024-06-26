package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	WebDriver driver = null;

	public homePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[6]/a")
	private WebElement OrganizationsLink;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;

	@FindBy(linkText = "Products")
	private WebElement ProductsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	@FindBy(xpath = "//img[@alt='vtiger-crm-logo.gif']")
	private WebElement Logo;

	@FindBy(className = "hdrLink")
	private WebElement homeTitle;

	public WebElement getLogo() {
		return Logo;
	}

	public WebElement getHomeTitle() {
		return homeTitle;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	// Business Function
	public void logOut() {
		Actions action = new Actions(driver);
		action.moveToElement(adminImg).perform();
		signOutLink.click();
	}

}
