package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileLog4jProperties extends FileUtil {
	
	private Logger logger = Logger.getLogger(FileLog4jProperties.class);

	private static FileLog4jProperties configProperties;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao"+ File.separator+ "properties";
	
	public final static String archive = "log4j.properties";

	public static String pathfinal = path + File.separator +archive;

	public static FileLog4jProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileLog4jProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo log4j.propriedades");
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("browser_name=CHROME");
			listProperties.add("url=https://www.google.com/");
			listProperties.add("dir_report_html=target/report-automation/report.html");
			whiter(pathfinal, listProperties);
			
		}

	}

}
