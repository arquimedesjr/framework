package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileMassaDadosProperties extends FileUtil {
	
	private Logger logger = Logger.getLogger(FileMassaDadosProperties.class);

	private static FileMassaDadosProperties configProperties;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao"+ File.separator+ "properties";
	
	public final static String archive = "massa_dados.properties";

	public static String pathfinal = path + File.separator +archive;

	public static FileMassaDadosProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileMassaDadosProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo "+archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("browserName = CHROME\r\n" + 
					"url = https://www.google.com/\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"# caminho config do relatório\r\n" + 
					"reportConfigPath = .\\\\configs\\\\extent-config.xml\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"evidenciaDirRaiz = C:\\\\EV_PILOTO\r\n" + 
					"\r\n" + 
					"# caminho do diretório raiz do relatório\r\n" + 
					"relatorioDirRaiz ");
			whiter(pathfinal, listProperties);
			
		}

	}

}
