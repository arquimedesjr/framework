package br.com.auto.reader.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class ConfigFileReader {
	
	private static Properties properties;
	private String propertyFilePath;

	public ConfigFileReader(String path){
		propertyFilePath = path;
		FileInputStream  reader = null;
		try {
			reader = new FileInputStream (new File(propertyFilePath));
			properties = new Properties();
			
			try { 
				properties.load(new InputStreamReader(reader, Charset.forName("UTF-8"))); 
			}
			catch (IOException e) { 				
				e.printStackTrace(); 
			}
		} 
		catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		}
		finally {
			try { 
				if(reader != null) 
					reader.close(); 
			}
			catch (IOException ignore) {}
		}
	}
	
	public String GetPropertyByKey(String key) {
		try{
			String p = properties.getProperty(key);
			
			if(p!= null) 
				return p;
			else 
				throw new RuntimeException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
		}
		catch (Exception e) {
			throw new RuntimeException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
		}
	}	
}
