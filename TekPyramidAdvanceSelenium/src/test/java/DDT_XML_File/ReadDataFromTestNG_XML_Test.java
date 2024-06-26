package DDT_XML_File;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromTestNG_XML_Test {
 @Test
 public void  runTest(XmlTest test) {
	 String BROWSER = test.getParameter("browser");
	 String URL = test.getParameter("url");
	 String USERNAME = test.getParameter("username");
	 String PASSWORD = test.getParameter("password");
	 
	 System.out.println(BROWSER);
	 System.out.println(URL);
	 System.out.println(USERNAME);
	 System.out.println(PASSWORD);
	 
	 System.out.println("Test Executed");
 }
}
