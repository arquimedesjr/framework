package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileExtentConfigProperties extends FileUtil{
	
	private Logger logger = Logger.getLogger(FileConfigProperties.class);
	
	private static FileExtentConfigProperties extentConfig;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao"+ File.separator+ "properties";
	
	public final static String archive = "extent_report.properties";

	public static String pathfinal = path + File.separator +archive;

	public static FileExtentConfigProperties getInstance() {
		if (extentConfig == null) {
			extentConfig = new FileExtentConfigProperties();
		}
		return extentConfig;
	}
	
	public void createXml() {
		logger.info("Criando o arquivo Extent-Config.xml");
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			whiter(pathfinal, listProperties);
			
		}

	}

}
