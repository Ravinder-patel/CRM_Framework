package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class simpleClassWithPom {

	@FindBy(name = "user_name")
	WebElement username;

	@FindBy(name = "user_password")
	WebElement password;

	@FindBy(id = "submitButton")
	WebElement login;

	@Test
	public void simplePom() throws Throwable {

		WebDriver driver = new ChromeDriver();

		simpleClassWithPom pf = PageFactory.initElements(driver, simpleClassWithPom.class);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http:/localhost:8888");

		pf.username.sendKeys("admin");
		pf.password.sendKeys("root");
		Thread.sleep(3000);

		driver.navigate().refresh(); // page get refresh and address of the webelements will change

		pf.username.sendKeys("admin"); // it will locate the current address of the webelements
		pf.password.sendKeys("root");
		pf.login.click();

		Thread.sleep(3000);

		driver.quit();

	}

}
