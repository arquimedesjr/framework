package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.auto.reader.properties.ConfigFileReader;

public class FileExtentConfigProperties extends FileUtil {

	private Logger logger = Logger.getLogger(FileConfigProperties.class);

	private static FileExtentConfigProperties extentConfig;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao" + File.separator + "properties";

	public final static String archive = "extent_config.properties";

	public static String pathfinal = path + File.separator + archive;

	public static FileExtentConfigProperties getInstance() {
		if (extentConfig == null) {
			extentConfig = new FileExtentConfigProperties();
		}
		return extentConfig;
	}

	public void createProperties() {
		logger.info("Criação do arquivo " + archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("dirConfigXml = C:\\\\Users\\\\Public\\\\automacao\\\\config\\\\Extent-Config.xml\r\n"
					+ "dirReportHtml = C:\\\\Users\\\\Public\\\\automacao\\\\report-bdd\r\n" + "info_ambiente=TESTE");
			whiter(pathfinal, listProperties);
		}
	}

	public String searchKeyProperties(String key) {
		logger.info("Procurando no arquivo " + archive + " o valor da chave " + key);
		return new ConfigFileReader(pathfinal).getPropertyByKey(key);
	}

}
