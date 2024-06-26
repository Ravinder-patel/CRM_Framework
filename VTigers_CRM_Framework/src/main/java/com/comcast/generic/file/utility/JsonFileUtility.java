package com.comcast.generic.file.utility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {
	
	public String getDataFromJson(String key) throws Throwable {
	FileReader fileRead=new FileReader("./ConfigAppData/CommonData.json");
	JSONParser jParser=new JSONParser();
	Object obj = jParser.parse(fileRead);
	JSONObject jObj=(JSONObject)obj;
	String data = (String) jObj.get(key);
	return data;
	
	}

}
