package Tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadMouseHoverOptionFlipkart {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Creating a new instance of the Chrome driver
		WebDriver driver = new ChromeDriver();

		// Maximizing browser window
		driver.manage().window().maximize();

		// Launching flipkart website
		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Creating an instance of Actions class
		Actions action = new Actions(driver);

		// Performing mouse hover action on 'Fashion' element
		WebElement fashon = driver.findElement(By.xpath("//span[.='Fashion']"));
		action.moveToElement(fashon).perform(); // mouse hover on fashon

		FileInputStream fis = new FileInputStream("E:\\Tek Pyramid\\Tasks\\flipkartList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");

		List<WebElement> subElements = driver.findElements(By.xpath("//a[contains(@class,'_1BJVlg')]"));
		List<WebElement> innerSubElements = null;
		int i = 0;
		for (WebElement element1 : subElements) {
			Thread.sleep(1000);
			action.moveToElement(element1).perform();
			sh.getRow(i++).createCell(0).setCellValue(element1.getText());
			System.out.println(element1.getText());

			innerSubElements = driver.findElements(By.xpath("//a[contains(@class,'_3490ry')]"));

			for (WebElement element2 : innerSubElements) {
				sh.getRow(i++).createCell(0).setCellValue(element2.getText());
				System.out.println(element2.getText());
			}
		}

		FileOutputStream fos = new FileOutputStream("E:\\Tek Pyramid\\Tasks\\flipkartList.xlsx");
		wb.write(fos);

		wb.close();

		Thread.sleep(3000);
		driver.quit();
	}
}
