package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.auto.reader.properties.ConfigFileReader;

public class FileLog4jProperties extends FileUtil {

	private Logger logger = Logger.getLogger(FileLog4jProperties.class);

	private static FileLog4jProperties configProperties;

	public final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao" + File.separator + "properties";

	public final static String archive = "log4j.properties";

	public static String pathfinal = path + File.separator + archive;

	public static FileLog4jProperties getInstance() {
		if (configProperties == null) {
			configProperties = new FileLog4jProperties();
		}
		return configProperties;
	}

	public void createProperties() {
		logger.info("Criação do arquivo " + archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("# Root logger option\r\n" + 
					"log4j.rootLogger=DEBUG, stdout, file\r\n" + 
					"\r\n" + 
					"# Redirect log messages to console\r\n" + 
					"log4j.appender.stdout=org.apache.log4j.ConsoleAppender\r\n" + 
					"log4j.appender.stdout.Target=System.out\r\n" + 
					"log4j.appender.stdout.layout=org.apache.log4j.PatternLayout\r\n" + 
					"log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n\r\n" + 
					"\r\n" + 
					"# Redirect log messages to a log file, support file rolling.\r\n" + 
					"log4j.appender.file=org.apache.log4j.RollingFileAppender\r\n" + 
					"log4j.appender.file.File=C:\\\\Users\\\\Public\\\\automacao\\\\report-bdd\\\\${date:yyyyMMdd}\\\\log-${HHmmss}.log\r\n" + 
					"log4j.appender.file.MaxFileSize=5MB\r\n" + 
					"log4j.appender.file.MaxBackupIndex=10\r\n" + 
					"log4j.appender.file.layout=org.apache.log4j.PatternLayout\r\n" + 
					"log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
			whiter(pathfinal, listProperties);

		}

	}

	public String searchKeyProperties(String key) {
		logger.info("Procurando no arquivo "+archive+" o valor da chave "+key);
		return new ConfigFileReader(pathfinal).getPropertyByKey(key);
	}

}
