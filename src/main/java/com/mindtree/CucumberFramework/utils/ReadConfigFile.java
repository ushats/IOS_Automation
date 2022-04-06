package com.mindtree.CucumberFramework.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile extends DriverFactory2 {
	private Properties properties;
	private final String propertyFilePath = "./src\\main\\java\\com\\mindtree\\CucumberFramework\\properties\\config.properties";

	public ReadConfigFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}

	public String getURL(String name) {
		String URL = properties.getProperty(name);
		if (URL != null)
			return URL;
		else
			throw new RuntimeException("URL not specified in the Configuration.properties file.");
	}
	
	public String getData(String name) {
		String URL = properties.getProperty(name);
		if (URL != null)
			return URL;
		else
			throw new RuntimeException("DAta not specified in the Configuration.properties file.");
	}

}
