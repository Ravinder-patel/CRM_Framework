package practice.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class dataProviderTAsk {
	@Test(threadPoolSize = 10,invocationCount = 0)
	public void test1() {
		WebDriver driver=new ChromeDriver();
	}

}
