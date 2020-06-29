package com.happyreturns.test.Utils;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * Class to load properties file.
 * 

 */
public class PropertiesReader {

	public Properties prop;

	/**
	 * Return the property object prop after loading the file
	 * 
	 * @param filepath the location of the property file
	 */
	public void loadPropertiesFile(String filepath) {
		prop = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream(filepath);
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Problem loading properties file: " + e);
		}
	}

}