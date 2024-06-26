package Tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class AmazonMobiles {
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile phones");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> phones= driver.findElements(By.xpath("//div[@data-cy='title-recipe' and not (contains(.,'Sponsored'))]"));
	
		FileInputStream fis=new FileInputStream("E:\\Tek Pyramid\\Tasks\\UnsponsoredMobiles.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Task");
		int i=0;
		for (WebElement ph: phones) 
		{
		  System.out.println(ph.getText());
	      sh.createRow(i++).createCell(0).setCellValue(ph.getText());
		}
		FileOutputStream fos= new FileOutputStream("E:\\Tek Pyramid\\Tasks\\UnsponsoredMobiles.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("*Excecuted*");
		driver.quit();
	}
	

}
