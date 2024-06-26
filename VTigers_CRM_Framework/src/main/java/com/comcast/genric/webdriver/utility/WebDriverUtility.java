package com.comcast.genric.webdriver.utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// maximize\
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// Implicitly Wait
	public void pageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	// Explicitly Wait
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	// switch to parent tab or window
	public void switchToParentWindow(WebDriver driver) {

		String parentWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandle);
	}

	// switch to new tab or window by url
	public void switchToTabOnURL(WebDriver driver, String childWindowUrl) {
		Set<String> childwindows = driver.getWindowHandles();
		Iterator<String> iterate = childwindows.iterator();
		while (iterate.hasNext()) {
			String windowID = iterate.next();
			driver.switchTo().window(windowID);

			String url = driver.getCurrentUrl();
			if (url.contains(childWindowUrl)) {
				break;
			}

		}
	}

	// switch to new tab or window by title
	public void switchToTabOnTitle(WebDriver driver, String childWindowTitle) {
		Set<String> childwindows = driver.getWindowHandles();
		Iterator<String> iterate = childwindows.iterator();
		while (iterate.hasNext()) {
			String windowID = iterate.next();
			driver.switchTo().window(windowID);

			String title = driver.getTitle();
			if (title.contains(childWindowTitle)) {
				break;
			}

		}
	}

	// switch to frames
	public void switchToFrameOnIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrameOnElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	// Handle alert
	public void alertAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// Dismiss alert
	public void alertDismiss(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// select drop down utility
	public void selectDropdownOnvisibleText(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);

	}

	public void selectDropdownOnIndex(WebElement element, int option) {
		Select select = new Select(element);
		select.selectByIndex(option);

	}

	public void selectDropdownOnValue(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByValue(option);

	}

	// Mouse Actions
	public void mouseOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	// method overloading
	public void mouseOnElement(WebDriver driver, WebElement element, int x, int y) {
		Actions action = new Actions(driver);
		action.moveToElement(element, x, y).perform();
	}

	public void mouseOnElementAndDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

}
