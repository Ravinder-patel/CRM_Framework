package Tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.irctcpage;

public class readDataFromIRCTC {
	@Test
	public void irctc() throws AWTException, InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.irctc.co.in/nget/train-search");
//		Thread.sleep(3000);
//		driver.findElement(By.className("fa fa-window-close pull-right loginCloseBtn ng-tns-c19-13")).click();
//		Thread.sleep(3000);
		Robot r = new Robot();
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement fromTF = driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']"));
		fromTF.sendKeys("HYDERABAD DECAN - HYB (SECUNDERABAD)");
		fromTF.click();

		WebElement toTextF = driver.findElement(By
				.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/input[@aria-controls='pr_id_2_list']"));
		toTextF.sendKeys("MANCHIRYAL - MCI", Keys.ENTER);

		Thread.sleep(2000);

		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();

		irctcpage i = new irctcpage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(7000, 0)");
		Thread.sleep(3000);

		System.out.println(i.getTrain().getText());
		WebElement Arrival_time = driver.findElement(By.xpath(
				"//div[@class='col-sm-5 col-xs-11 train-heading']/strong[contains(text(),'YPR BSP SPL (08292)')]/ancestor::div[@class='form-group no-pad col-xs-12 bull-back border-all']/descendant::div[@class='white-back no-pad col-xs-12']/descendant::span[@class='time']/strong[text()='16:02 | ']"));
		System.out.println(Arrival_time.getText());

		WebElement Arrival_TrainName = driver.findElement(By.xpath(
				"//div[@class='col-sm-5 col-xs-11 train-heading'] /strong[contains(text(),'YPR BSP SPL (08292)')]/ancestor::div[@class='form-group no-pad col-xs-12 bull-back border-all']/descendant::div[@class='white-back no-pad col-xs-12']/descendant::div[@class='col-xs-5 hidden-xs' and contains(text(),' LINGAMPALLI | Mon, 17 Jun')]"));
		System.out.println(Arrival_TrainName.getText());

		WebElement Departure_Time = driver.findElement(By.xpath(
				"//div[@class='col-sm-5 col-xs-11 train-heading']/strong[contains(text(),' YPR BSP SPL (08292)')]/ancestor::div[@class='form-group no-pad col-xs-12 bull-back border-all']/descendant::div[@class='white-back no-pad col-xs-12']/div[@class='col-xs-7 hidden-xs']/span[@class='pull-right']/strong[text()='20:29 | ']"));
		System.out.println(Departure_Time.getText());

		WebElement Departure_TrainName = driver.findElement(By.xpath(
				"//div[@class='col-sm-5 col-xs-11 train-heading']/strong[contains(text(),' YPR BSP SPL (08292)')]/ancestor::div[@class='form-group no-pad col-xs-12 bull-back border-all']/descendant::div[@class='white-back no-pad col-xs-12']/div[@class='col-xs-7 hidden-xs']/span[text()=' MANCHIRYAL | Mon, 17 Jun']"));
		System.out.println(Departure_TrainName.getText());

		FileInputStream fis = new FileInputStream("E:\\Tek Pyramid\\Tasks\\task.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("irctc");
		Row row = sh.getRow(0);
		Cell c = row.createCell(1);
		c.setCellValue(i.getTrain().getText());
		sh.getRow(1).createCell(1).setCellValue(Arrival_time.getText());
		sh.getRow(2).createCell(1).setCellValue(Arrival_TrainName.getText());
		sh.getRow(3).createCell(1).setCellValue(Departure_Time.getText());
		sh.getRow(4).createCell(1).setCellValue(Departure_TrainName.getText());

		FileOutputStream fos = new FileOutputStream("E:\\Tek Pyramid\\Tasks\\task.xlsx");
		wb.write(fos);
		wb.close();

		driver.quit();
	}

}
