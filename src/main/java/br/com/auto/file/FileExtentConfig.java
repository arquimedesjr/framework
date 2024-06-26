package br.com.auto.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileExtentConfig extends FileUtil{
	
	private Logger logger = Logger.getLogger(FileConfigProperties.class);
	
	private static FileExtentConfig extentConfig;

	public static final String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "config";
	
	public final static String archive = "Extent-Config.xml";

	public static String dirExtentConfig = path + File.separator +archive;

	public static FileExtentConfig getInstance() {
		if (extentConfig == null) {
			extentConfig = new FileExtentConfig();
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
			listProperties.add("		<![CDATA[$(document).ready(function(){$('.brand-logo black').css('display','none');});]]>");
			listProperties.add("		</scripts>");
			listProperties.add("		<!-- custom styles -->");
			listProperties.add("		<styles>");
			listProperties.add("		<![CDATA[$(document).ready(function() {$('.dashboard-view').click();});]]>");
			listProperties.add("		</styles>");
			listProperties.add("	</configuration>");
			listProperties.add("</extentreports>");
			whiter(dirExtentConfig, listProperties);
			
		}

	}

}
