package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileBrowserProperties extends FileUtil {
	
	private Logger logger = Logger.getLogger(FileBrowserProperties.class);

	private static FileBrowserProperties configProperties;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao"+ File.separator+ "properties";
	
	public final static String archive = "browser.properties";

	public static String pathfinal = path + File.separator +archive;

	public static FileBrowserProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileBrowserProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo config.propriedades");
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("# config browser chrome arguments\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"dir_chromedriver = src\\\\main\\\\resources\\\\driver\\\\chromedriver.exe\r\n" + 
					"incognito = true\r\n" + 
					"start-maximized = true\r\n" + 
					"disable-extensions = true\r\n" + 
					"disable-notifications = true\r\n" + 
					"disable-infobars = true\r\n" + 
					"enable-automation = true\r\n" + 
					"disable-popup-blocking = true\r\n" + 
					"\r\n" + 
					"wait_driver = 10");
			whiter(pathfinal, listProperties);
			
		}

	}

}
