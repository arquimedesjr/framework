package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.auto.reader.properties.ConfigFileReader;

public class FileConfigProperties extends FileUtil {
	
	private Logger logger = Logger.getLogger(FileConfigProperties.class);

	private static FileConfigProperties configProperties;

	private final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao" + File.separator + "properties";
	
	private final static String archive = "config.properties";

	private static String pathfinal = path + File.separator +archive;
	

	public static FileConfigProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileConfigProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo "+archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("# Api or Browser or Mobile\r\n" + 
					"plataform_test=Api");
			whiter(pathfinal, listProperties);
			
		}

	}
	
	public String searchKeyProperties(String key) {
		logger.info("Procurando no arquivo "+archive+" o valor da chave "+key);
		return new ConfigFileReader(pathfinal).getPropertyByKey(key);		
	}

}
