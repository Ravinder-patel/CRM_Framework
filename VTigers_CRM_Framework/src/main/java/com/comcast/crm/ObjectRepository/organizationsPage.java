package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class organizationsPage {
	WebDriver driver = null;

	public organizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement crateOrgLink;

	@FindBy(name = "search_text")
	private WebElement searchBox;

	@FindBy(name = "submit")
	private WebElement searchButton;

	@FindBy(id = "bas_searchfield")
	private WebElement selectDropDown;

	public WebElement getSelectDropDown() {
		return selectDropDown;
	}

	public WebElement getCrateOrgLink() {
		return crateOrgLink;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement dyna;
	
	//business action========Add this in web driver utility
	public void selectDropDown(String option) {
		Select sel=new Select(selectDropDown);
		sel.selectByVisibleText(option);
		
	}
	
	//create dynamic xpath method
	public WebElement dynamicElementDelete(String dynamicValue) {
		WebElement delete=driver.findElement(By.xpath("//a[.='" + dynamicValue + "']/../../descendant::a[.='del']"));
	   return  delete;
	
	}
	
	

}
