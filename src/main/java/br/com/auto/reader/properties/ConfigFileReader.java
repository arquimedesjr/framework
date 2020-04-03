package br.com.auto.reader.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class ConfigFileReader {
	private Logger logger = Logger.getLogger(ConfigFileReader.class);
	private static Properties properties = null;
	private String propertyFilePath;

	public ConfigFileReader(String path) {
		propertyFilePath = path;
		FileInputStream reader = null;
		try {
			reader = new FileInputStream(new File(propertyFilePath));
			properties = new Properties();

			try {
				properties.load(new InputStreamReader(reader, Charset.forName("UTF-8")));
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public String getPropertyByKey(String key) {
		String p = properties.getProperty(key);
		if (p != null) {
			return p;
		} else {
			Assert.assertFalse("Erro ao achar o parametro da palavra chave do properties: " + key, true);
			logger.error("Erro ao achar o parametro da palavra chave do properties: " + key);
		}
		return p;
	}

}
