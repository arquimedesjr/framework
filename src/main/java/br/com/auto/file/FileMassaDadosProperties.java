package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.auto.reader.properties.ConfigFileReader;

public class FileMassaDadosProperties extends FileUtil {

	private Logger logger = Logger.getLogger(FileMassaDadosProperties.class);

	private static FileMassaDadosProperties configProperties;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao" + File.separator + "properties";

	public final static String archive = "massa_dados.properties";

	public static String pathfinal = path + File.separator + archive;

	public static FileMassaDadosProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileMassaDadosProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo " + archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("# url API\r\n" + 
					"api_url=http://localhost:5000/alunos\r\n" + 
					"api_dir_json=src\\\\test\\\\java\\\\runner\\\\json.json\r\n" + 
					"\r\n" + 
					"# url browser\r\n" + 
					"browser_url=https://www.google.com/");
			whiter(pathfinal, listProperties);

		}
	}

	public String searchKeyProperties(String key) {
		logger.info("Procurando no arquivo "+archive+" o valor da chave "+key);
		return new ConfigFileReader(pathfinal).getPropertyByKey(key);
	}

}
