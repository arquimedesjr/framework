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
		logger.info("Criação do arquivo "+archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("browser_name = chrome\r\n" + 
					"\r\n" + 
					"# CHROME arguments\r\n" + 
					"\r\n" + 
					"chrome_dir = C:\\\\Users\\\\Public\\\\Automacao\\\\drivers\\\\chromedriver.exe\r\n" + 
					"chrome_arguments_incognito = true\r\n" + 
					"chrome_arguments_start_maximized = true\r\n" + 
					"chrome_arguments_disable_extensions = true\r\n" + 
					"chrome_arguments_disable_notifications = true\r\n" + 
					"chrome_arguments_disable_infobars = true\r\n" + 
					"chrome_arguments_enable_automation = true\r\n" + 
					"chrome_arguments_disable_popup_blocking = true\r\n" + 
					"\r\n" + 
					"chrome_arguments_wait_driver = 10\r\n" + 
					"\r\n" + 
					"# IE arguments\r\n" + 
					"\r\n" + 
					"ie_dir = C:\\\\Users\\\\Public\\\\Automacao\\\\drivers\\\\IEDriverServer.exe\r\n" + 
					"ie_arguments_wait_driver = 10");
			whiter(pathfinal, listProperties);
			
		}

	}

}
