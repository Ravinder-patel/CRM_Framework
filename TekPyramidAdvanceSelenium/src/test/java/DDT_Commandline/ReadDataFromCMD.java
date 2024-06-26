package DDT_Commandline;

import org.testng.annotations.Test;

public class ReadDataFromCMD {

	@Test
	public void runTimeParaMeterTest() {
		String BROWSER=System.getProperty("browser");
		String URL=System.getProperty("url");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		
		System.out.println("Browser Data====: "+BROWSER);
		System.out.println("Url Data====: "+URL);
		System.out.println("Username Data====: "+USERNAME);
		System.out.println("Password Data====: "+PASSWORD);
		
	System.out.println("testNG test");

	}
}
