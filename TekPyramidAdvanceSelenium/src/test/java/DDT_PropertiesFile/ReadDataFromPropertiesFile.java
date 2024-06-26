package DDT_PropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//Step 1: get the repository object
		FileInputStream fis=new FileInputStream("E:\\Softwares\\DDT Properties Files\\CommonData.properties");
		
		//Step 2: create Properties class and load all the keys into it
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//Step 3: get the value based on key
		String BROWSER =pObj.getProperty("browser");	//browser---key
		System.out.println(BROWSER);					//chrome---value
		String URL = pObj.getProperty("url");
		System.out.println(URL);
	}

}
