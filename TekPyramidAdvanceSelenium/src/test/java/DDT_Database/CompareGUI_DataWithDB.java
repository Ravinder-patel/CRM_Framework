package DDT_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CompareGUI_DataWithDB {

	// WA script to ctreate a project in Ninja HR then connect to DB and verify
	// project is created in data base or not ?
	// WA Optimized script
	public static void main(String[] args) throws Throwable {

		// create project in GUI============================
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigate ninja HR website
		driver.get("http://106.51.90.215:8084/");
		// login
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		// click on project
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		// click on create project
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		// enter project name
		driver.findElement(By.name("projectName")).sendKeys("QA-66-77-99");
		
		driver.findElement(By.name("createdBy")).sendKeys("Manager");

		WebElement status = driver.findElement(By.name("status"));
		Select select = new Select(status);
		select.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click(); // project created

		Thread.sleep(3000);
		driver.quit();
		// connect to remote DB and fetch the data

// connect to DB and check the project is created
		String projectName = "QA-66-77-99";
		boolean flag = false;

		// register driver
		Driver drivRef = new Driver();
		DriverManager.registerDriver(drivRef);
		// connect to db
		Connection connect = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("====Connected to Database====");

		try {
			// create sql statement
			Statement statement = connect.createStatement();
			// Execute the Query
			ResultSet resultset = statement.executeQuery("select * from project");

			String actualProjectName = null;

			while (resultset.next()) {
				actualProjectName = resultset.getString(4); // everytime go to new row fetch the project name in 4th column
				// CONDITION
				if (projectName.equals(actualProjectName)) // compare expected name with actualName in DB with
				{
					flag = true;
					System.out.println(resultset.getString(4)); // print id
					System.out.println(projectName + " is available in DB");
				}
			}
			if (flag == false) {
				System.out.println(projectName + " is not available in DB");
			}
		} catch (Exception e) {
			System.out.println("====Exception Handled====");
		}

		// even though is any exception is occured or not finally block will execute and
		// close the connection
		finally {
			// close connection
			connect.close();
			System.out.println("====Connection Closed====");
		}
	}

}
