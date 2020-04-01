package br.com.auto.tool.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.AnalysisStrategy;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.file.FileBrowserProperties;
import br.com.auto.file.FileConfigProperties;
import br.com.auto.file.FileExtentConfig;
import br.com.auto.file.FileExtentConfigProperties;
import br.com.auto.file.FileUtil;
import br.com.auto.reader.properties.ConfigFileReader;
import cucumber.api.Scenario;

public class TestToolUtils{

	private static TestToolUtils testToolUtils;
	public static List<String> nameScenario = new ArrayList<String>();
	protected static ConfigFileReader extent_report_propertied = new ConfigFileReader(FileExtentConfigProperties.pathfinal);
	
	
	
	public TestToolUtils() {
		
	}
	
	public static TestToolUtils getInstance() {
		if (testToolUtils == null)
			testToolUtils = new TestToolUtils();
		return testToolUtils;
	}

	public static void beforeClass() {
		PropertyConfigurator.configure("src\\test\\resources\\config\\log4j.properties");
		FileConfigProperties.getInstance().createProperties();
		FileExtentConfig.getInstance().createXml();
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		
		extentProperties.setReportPath(new ConfigFileReader(FileExtentConfigProperties.pathfinal).getPropertyByKey("dir_report_html"));
		

	}

	public void before() {
		try {
			Reporter.getExtentReport().setGherkinDialect("pt");
			Reporter.getExtentHtmlReport().setAnalysisStrategy(AnalysisStrategy.CLASS);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public void after(Scenario scenario) {
		if (scenario.isFailed())
			takeScreenShotTest();

		driverquit();
	}

	public static void afterClass() {

		String browser = new ConfigFileReader(FileBrowserProperties.pathfinal).getPropertyByKey("browser_name");
		Reporter.loadXMLConfig(FileExtentConfig.pathfinal);
		Reporter.setSystemInfo("Browser: ", browser);
		Reporter.setSystemInfo("Usuario Maquina: ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Ambiente: ", "Testes");
		Reporter.assignAuthor("Automation Report");

		FileUtil fileUtil = new FileUtil();

		try {
			List<String> string = fileUtil.reader(".\\target\\report-automation\\info.log");
			for (String s : string) {
				Reporter.setTestRunnerOutput(s + "<br>");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
