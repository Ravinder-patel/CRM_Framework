package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class loginPage extends WebDriverUtility { // Role 1: Ctreate pom class with same name as web page

	WebDriver driver = null; // make the driver reference as global so all methods can use it

	public loginPage(WebDriver driver) {// Rule 3: initialize the object...initialization should done inside the
										// constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // we use this keyword because it will indicates current object address
		// PageFactory.initElements(driver, loginPage.class);
	}

	// Rule 2: Identify the objects
	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUsername() { // Rule 4: object Encapsulation
		return usernameEdit; // Rule 5: objects utilization
	}

	public WebElement getPassword() {
		return passwordEdit;
	}

	public WebElement getLogin() {
		return loginButton;
	}

	// Create a business function whi is specific for that application only
	public void logIntoVtigers(String url, String username, String password) throws Throwable {

		maximizeWindow(driver);
		pageToLoad(driver);
		driver.get(url);
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();

	}
	public void logIntoVtigers(String username, String password) throws Throwable {
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();

	}

//	public void logIntoVtigers() throws Throwable {
//
//		usernameEdit.sendKeys(getDataFromProperties("username"));
//		passwordEdit.sendKeys(getDataFromProperties("password"));
//		loginButton.click();
//
//	}

}
