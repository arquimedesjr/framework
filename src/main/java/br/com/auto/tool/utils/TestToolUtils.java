package br.com.auto.tool.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.aventstack.extentreports.AnalysisStrategy;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.file.FileBrowserProperties;
import br.com.auto.file.FileConfigProperties;
import br.com.auto.file.FileExtentConfig;
import br.com.auto.file.FileExtentConfigProperties;
import br.com.auto.file.FileMassaDadosProperties;
import br.com.auto.file.FileUtil;
import br.com.auto.tool.TestBaseApi;
import br.com.auto.tool.TestBaseWeb;
import cucumber.api.Scenario;

public class TestToolUtils {
	private static Logger logger = Logger.getLogger(TestToolUtils.class);
	private static TestToolUtils testToolUtils;
	public static List<String> nameScenario = new ArrayList<String>();
	public static TestBaseWeb testBasewWeb;
	public static TestBaseApi testBasewApi;
	static String date;
	static String time;

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
//		FileLog4jProperties.getInstance().createProperties();
		FileMassaDadosProperties.getInstance().createProperties();
		FileExtentConfig.getInstance().createXml();
		testBasewWeb = new TestBaseWeb();
		testBasewApi = new TestBaseApi();

		date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		time = new SimpleDateFormat("HHmmss").format(new Date());

		// Creates Pattern Layout
		PatternLayout patternLayoutObj = new PatternLayout();
		String conversionPattern = "[%p] %d %c %M - %m%n";
		patternLayoutObj.setConversionPattern(conversionPattern);

		// Create Daily Rolling Log File Appender
		DailyRollingFileAppender rollingAppenderObj = new DailyRollingFileAppender();
		rollingAppenderObj.setFile(FileExtentConfigProperties.getInstance().searchKeyProperties("dirReportHtml") + "\\"
				+ date + "\\" + time + "\\info.log");
		rollingAppenderObj.setDatePattern("'.'yyyy-MM-dd");
		rollingAppenderObj.setLayout(patternLayoutObj);
		rollingAppenderObj.activateOptions();

		// Configure the Root Logger
		Logger rootLoggerObj = Logger.getRootLogger();
		rootLoggerObj.setLevel(Level.DEBUG);
		rootLoggerObj.addAppender(rollingAppenderObj);

//		PropertyConfigurator.configure(FileLog4jProperties.pathfinal);
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;

		extentProperties.setReportPath(FileExtentConfigProperties.getInstance().searchKeyProperties("dirReportHtml")
				+ "\\" + date + "\\" + time + "\\report.html");

	}

	public void before() {
		try {
			Reporter.getExtentReport().setGherkinDialect("pt");
			Reporter.getExtentHtmlReport().setAnalysisStrategy(AnalysisStrategy.CLASS);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		if (FileConfigProperties.getInstance().searchKeyProperties("plataform_test").toUpperCase().equals("BROWSER"))
			testBasewWeb.setUpBrowser();

	}

	public void after(Scenario scenario) {

		if (FileConfigProperties.getInstance().searchKeyProperties("plataform_test").toUpperCase().equals("BROWSER")) {
			if (scenario.isFailed()) {
				testBasewWeb.takeScreenShotTest();
			}
			testBasewWeb.driverquit();
		}

	}

	public static void afterClass() {

		Reporter.loadXMLConfig(FileExtentConfigProperties.getInstance().searchKeyProperties("dirConfigXml"));
		Reporter.setSystemInfo("Browser: ", FileBrowserProperties.getInstance().searchKeyProperties("browser_name"));
		Reporter.setSystemInfo("Usuario Maquina: ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Ambiente: ",
				FileExtentConfigProperties.getInstance().searchKeyProperties("info_ambiente"));
		Reporter.assignAuthor("Automation Report");

		FileUtil fileUtil = new FileUtil();

		try {
			List<String> string = fileUtil
					.reader(FileExtentConfigProperties.getInstance().searchKeyProperties("dirReportHtml") + "\\" + date
							+ "\\" + time + "\\info.log");
			for (String s : string) {
				Reporter.setTestRunnerOutput(s + "<br>");
			}

		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}

}
