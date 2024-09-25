package com.training.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileRead {
	
	FileInputStream fileinput;
	
	public String getProperties(String key) throws IOException {
		
		//1. path of file to be read
		String userDir=System.getProperty("user.dir");
		String fileseperator = System.getProperty("file.separator");
		System.out.println(fileseperator);
		
		String filepath= userDir + fileseperator + "properties" + fileseperator + "application.properties";
		
		//2. load this filepath to file object
	    fileinput = new FileInputStream(filepath);
		
		//3. create an object of the properties file
		Properties prop = new Properties();
		prop.load(fileinput);
		
		String value = prop.getProperty(key);
		return value;
	}

}
