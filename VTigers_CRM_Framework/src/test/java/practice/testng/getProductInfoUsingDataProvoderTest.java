package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getProductInfoUsingDataProvoderTest {
	@Test(dataProvider ="getData" )
	public void dataproviderTest(String searchProduct,String phone) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// navigate to application
		driver.get("https://www.amazon.in/ref=nav_logo");
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchProduct,Keys.ENTER);
		//write dynamic xpath
		WebElement productPrice = driver.findElement(By.xpath("//a[@target='_blank' and contains(.,'"+phone+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small' and not(contains(.,'Sponsored')) ]/descendant::span[@class='a-price-whole']"));
		System.out.println(productPrice.getText());
		Thread.sleep(2000);
		driver.quit();

	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr=new Object[3][2];
		//a[@target="_blank"and contains(.,'Apple')and contains(.,'15 (128 GB) - Black')]/ancestor::div[@class="a-section a-spacing-small a-spacing-top-small"]/descendant::span[@class="a-price-whole"]
		
		objArr[0][0]="iphones";
		objArr[0][1]="iPhone 15 (128 GB) - Black";
		
		objArr[1][0]="redmi";
		objArr[1][1]="Redmi 13C (Starshine Green, 4GB RAM, 128GB Storage)";
		
		
		objArr[2][0]="Realme";
		objArr[2][1]="12X 5G (Twilight Purple, 6GB RAM, 128GB Storage)";
		
		return objArr;
		
		//create another data provider with 3 columns nd diff datatype
		
	}
}
