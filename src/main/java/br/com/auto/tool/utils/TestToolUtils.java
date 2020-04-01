package br.com.auto.tool.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.AnalysisStrategy;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.file.FileBrowserProperties;
import br.com.auto.file.FileConfigProperties;
import br.com.auto.file.FileExtentConfig;
import br.com.auto.file.FileExtentConfigProperties;
import br.com.auto.file.FileLog4jProperties;
import br.com.auto.file.FileMassaDadosProperties;
import br.com.auto.file.FileUtil;
import br.com.auto.reader.properties.ConfigFileReader;
import br.com.auto.tool.TestBaseWeb;
import cucumber.api.Scenario;

public class TestToolUtils {

	private static TestToolUtils testToolUtils;
	public static List<String> nameScenario = new ArrayList<String>();
	protected static ConfigFileReader extent_report_propertied;
	protected static ConfigFileReader browser_propertied;
	protected static ConfigFileReader extent_config;
	protected static TestBaseWeb testBasewWeb;

	public TestToolUtils() {
	
	}

	public static TestToolUtils getInstance() {
		if (testToolUtils == null)
			testToolUtils = new TestToolUtils();
		return testToolUtils;
	}

	public static void beforeClass() {
		FileConfigProperties.getInstance().createProperties();
		FileBrowserProperties.getInstance().createProperties();
		FileExtentConfigProperties.getInstance().createProperties();
		FileLog4jProperties.getInstance().createProperties();
		FileMassaDadosProperties.getInstance().createProperties();
		FileExtentConfig.getInstance().createXml();
		testBasewWeb = new TestBaseWeb();
		extent_report_propertied = new ConfigFileReader(FileExtentConfigProperties.pathfinal);
		browser_propertied = new ConfigFileReader(FileBrowserProperties.pathfinal);
		PropertyConfigurator.configure("src\\test\\resources\\config\\log4j.properties");
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		
		extentProperties.setReportPath(extent_report_propertied.getPropertyByKey("dir_report_html"));

	}

	public void before() {
		try {
			Reporter.getExtentReport().setGherkinDialect("pt");
			Reporter.getExtentHtmlReport().setAnalysisStrategy(AnalysisStrategy.CLASS);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		testBasewWeb.setUpBrowser();
	}

	public void after(Scenario scenario) {
		if (scenario.isFailed())
			testBasewWeb.takeScreenShotTest();

		testBasewWeb.driverquit();
	}

	public static void afterClass() {

		String browser = browser_propertied.getPropertyByKey("browser_name");
		Reporter.loadXMLConfig(extent_report_propertied.getPropertyByKey("dir_report"));
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
