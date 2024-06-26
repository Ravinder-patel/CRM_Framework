package Tasks;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;



public class ReadScore {
	public static void main(String[] args) throws Throwable 
	{
		Connection con = null;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		try
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			
			Statement stat = con.createStatement();
		
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/87528/afg-vs-uga-5th-match-group-c-icc-mens-t20-world-cup-2024");
		// Runs
		List<WebElement> AllRuns = driver.findElements
		(By.xpath("//span[text()='Afghanistan Innings']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[contains(@class,'cb-col cb-col-8 text-right text-bold') and not(contains(.,'R'))]"));
		
		
		
		Iterator<WebElement> i = AllRuns.iterator();
		for (WebElement Run : AllRuns) 
		{
			String text = Run.getText();
			int n=Integer.parseInt(text);
			if(n<=30)
			{
				String Names="//span[contains(text(),'Afghanistan Innings')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[.='"+text+"' and contains(@class,'cb-col cb-col-8 text-right text-bold')]/preceding-sibling::div[@class='cb-col cb-col-25 ']";
				String StrikeRate="//span[contains(text(),'Afghanistan Innings')]/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']/descendant::div[.='"+text+"' and contains(@class,'cb-col cb-col-8 text-right text-bold')]/following-sibling::div[@style='padding-right:10px;']/following-sibling::div[@class='cb-col cb-col-8 text-right']";
				String Name = driver.findElement(By.xpath(Names)).getText();
				String SR = driver.findElement(By.xpath(StrikeRate)).getText();
				System.out.println(Name);
				System.out.println(text);
				System.out.println(SR);
				
				String Query= "insert into  scores values('"+Name+"' , '"+text+"' , '"+SR+"')";
				int set = stat.executeUpdate(Query);	
			}
		}
		String Query1 = " select * from  scores where runs > 10";
		ResultSet Data = stat.executeQuery(Query1);
		while(Data.next())
		{
			System.out.println( Data.getString(1) + " "+Data.getString(2) + " "+
					Data.getString(3)  );
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
		con.close();
		System.out.println("====Connection closed====");
		driver.quit();
		}
	}
	/*
	 * public static void main(String[] args) throws Throwable { DatabaseUtility du
	 * = new DatabaseUtility();
	 * 
	 * WebDriver driver = new EdgeDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 * driver.get("file:///E:/Tek%20Pyramid/Xpath/Scorecard.html"); List<WebElement>
	 * details = driver .findElements(By.xpath("//tr[td[3] < 30]"));
	 * List<WebElement> inneElements = null; for (WebElement ele : details) {
	 * 
	 * //System.out.print(ele.getText() + "\t"); inneElements = ele.findElements(By.
	 * xpath("//td[position()=1 or position()=3 or position()=7]"));
	 * 
	 * for (WebElement ele2 : inneElements) {
	 * 
	 * System.out.println(ele2.getText());
	 * 
	 * } break;
	 * 
	 * }
	 * 
	 * driver.quit(); }
	 */
}
