package Assertion;

import org.testng.annotations.Test;

import com.comcast.generic.database.utility.DatabaseUtility;
import com.comcast.generic.file.utility.ExcelFileUtility;
import com.comcast.generic.file.utility.PropertiesFileUtility;
import com.comcast.genric.java.utility.JavaUtility;
import com.comcast.genric.webdriver.utility.WebDriverUtility;

public class AssertionTest1 {
	 JavaUtility jUtil = new JavaUtility();
	 DatabaseUtility dbUtil = new DatabaseUtility();
	 PropertiesFileUtility pFileUtil = new PropertiesFileUtility();
	 ExcelFileUtility eUtil = new ExcelFileUtility();
	 WebDriverUtility wlib = new WebDriverUtility();
	
	public void homePageTitleTest() {
		/*
		 * String BROWSER = pFileUtil.getDataFromProperties("browser"); String URL =
		 * pFileUtil.getDataFromProperties("url");
		 * 
		 * 
		 * if (BROWSER.equals("chrome")) { driver = new ChromeDriver(); } else if
		 * (BROWSER.equals("edge")) { driver = new EdgeDriver();
		 * 
		 * } else if (BROWSER.equals("firefox")) { driver = new FirefoxDriver(); } else
		 * { driver = new ChromeDriver(); // default browser }
		 * 
		 * String expectedTitle = "Home"; homePage hp = new homePage(driver); String
		 * actualTitle = hp.getHomeTitle().getText();
		 * 
		 * if (actualTitle.contains(expectedTitle)) { System.out.println(expectedTitle +
		 * " is verified====PASS"); } else { System.out.println(expectedTitle +
		 * " is not verified====FAIL"); }
		 */
	}
	
	@Test
	public void homePageLogoTest() {
//		//homePage hp = new homePage(driver);
//		//boolean status = hp.getLogo().isEnabled();
//		if (status) {
//			System.out.println("Logo is enabled====PASS");
//		} else {
//			System.out.println("Logo is not enabled====FAIL");
//		}
}

}
