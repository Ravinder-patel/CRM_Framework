package com.comcast.generic.file.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility {
	public String getDataFromProperties(String key) throws Throwable {

		FileInputStream fis = new FileInputStream("./ConfigAppData/CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;

	}

}
