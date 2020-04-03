package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.auto.reader.properties.ConfigFileReader;

public class FileExtentConfig extends FileUtil {

	private Logger logger = Logger.getLogger(FileConfigProperties.class);

	private static FileExtentConfig extentConfig;

	private final static String path = "C:" + File.separator + "Users" + File.separator + "Public" + File.separator
			+ "automacao" + File.separator + "config";

	private final static String archive = "Extent-Config.xml";

	private static String pathfinal = path + File.separator + archive;

	public static FileExtentConfig getInstance() {
		if (extentConfig == null) {
			extentConfig = new FileExtentConfig();
		}
		return extentConfig;
	}

	public void createXml() {
		logger.info("Criação do arquivo " + archive);
		boolean cond = false;

		cond = createrFile(path, archive);

		if (cond) {
			List<String> listProperties = new ArrayList<String>();
			listProperties.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			listProperties.add("<extentreports>");
			listProperties.add("	<configuration>");
			listProperties.add("		<!-- report theme -->");
			listProperties.add("		<!-- standard, dark -->");
			listProperties.add("		<theme>dark</theme>");
			listProperties.add("		<!-- document encoding -->");
			listProperties.add("		<!-- defaults to UTF-8 -->");
			listProperties.add("		<encoding>UTF-8</encoding>");
			listProperties.add("		<!-- offline report -->");
			listProperties.add("		<enableOfflineMode>true</enableOfflineMode>");
			listProperties.add("		<!-- enable or disable timeline on dashboard -->");
			listProperties.add("		<enableTimeline>false</enableTimeline>");
			listProperties.add("		<!-- protocol for script and stylesheets -->");
			listProperties.add("		<!-- defaults to https -->");
			listProperties.add("		<protocol>http</protocol>");
			listProperties.add("		<!-- title of the document -->");
			listProperties.add("		<documentTitle>Automation Report</documentTitle>");
			listProperties.add("		<!-- report name - displayed at top-nav -->");
			listProperties.add("		<reportName>");
			listProperties.add("		</reportName>");
			listProperties.add("		<!-- location of charts in the test view -->");
			listProperties.add("		<!-- top, bottom -->");
			listProperties.add("		<testViewChartLocation>top</testViewChartLocation>");
			listProperties.add("		<!-- custom javascript -->");
			listProperties.add("		<scripts>");
			listProperties.add(
					"		<![CDATA[$(document).ready(function(){$('.brand-logo black').css('display','none');});]]>");
			listProperties.add("		</scripts>");
			listProperties.add("		<!-- custom styles -->");
			listProperties.add("		<styles>");
			listProperties.add("		<![CDATA[$(document).ready(function() {$('.dashboard-view').click();});]]>");
			listProperties.add("		</styles>");
			listProperties.add("	</configuration>");
			listProperties.add("</extentreports>");
			whiter(pathfinal, listProperties);

		}

	}

	public String searchKeyProperties(String key) {
		logger.info("Procurando no arquivo "+archive+" o valor da chave "+key);
		return new ConfigFileReader(pathfinal).getPropertyByKey(key);
	}

}
