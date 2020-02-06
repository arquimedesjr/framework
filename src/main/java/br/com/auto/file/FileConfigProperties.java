package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileConfigProperties extends FileUtil {
	
	private Logger logger = Logger.getLogger(FileConfigProperties.class);

	private static FileConfigProperties configProperties;

	public final static String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "config";
	public final static String archive = "config.properties";

	public static String dirProperties = path + File.separator +archive;

	public static FileConfigProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileConfigProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo config.propriedades");
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("browser_name=CHROME");
			listProperties.add("url=https://www.google.com/");
			listProperties.add("dir_report_html=target/report-automation/report.html");
			whiter(dirProperties, listProperties);
			
		}

	}

}
