package DDT_JSON_File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;

public class ReadDataFromJSONfile {

	public static void main(String[] args) throws Throwable, ParseException {
		// Step 1: Create the object of java representation file(JSON)
		FileReader read=new FileReader("E:\\Softwares\\DDT_JSON_files\\CommonData.json");
		// Step 2: Create the JSONParser class
		JSONParser jp = new JSONParser();
		// step 3: pass the object of java physical file in parse()
		Object obj = jp.parse(read); // upcast
		/*
		 * it returns the Object class and it load all objects like HashMap
		 */
		// Step 4: Convert java Object into JSONObject by using casting
		JSONObject jsonObj = (JSONObject) obj; // Downcasting
		// step 3: get the values by using get() in JSONObjeect class
		String BROWSER = jsonObj.get("browser").toString(); // key
		String URL = jsonObj.get("url").toString();
		String USERNAME = jsonObj.get("username").toString();
		String PASSWORD = jsonObj.get("password").toString();
		Object TIMEOUT = jsonObj.get("timeout");

		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println(TIMEOUT);
	}

}
