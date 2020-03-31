package br.com.auto.runner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.AnalysisStrategy;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.file.FileConfigProperties;
import br.com.auto.file.FileExtentConfig;
import br.com.auto.file.FileUtil;
import br.com.auto.tool.TestBaseWeb;
import cucumber.api.Scenario;

public class Runner extends TestBaseWeb {

	private static Runner runner;
	public static List<String> nameScenario = new ArrayList<String>();

	public static Runner getInstance() {
		if (runner == null)
			runner = new Runner();
		return runner;
	}

	public static void beforeClass() {
		PropertyConfigurator.configure("src\\test\\resources\\config\\log4j.properties");
		FileConfigProperties.getInstance().createProperties();
		FileExtentConfig.getInstance().createXml();
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		
		extentProperties.setReportPath(reader.getPropertyByKey("dir_report_html"));
		

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

		String browser = reader.GetPropertyByKey("browser_name");
		Reporter.loadXMLConfig(FileExtentConfig.dirExtentConfig);
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

//		Reporter.setTestRunnerOutput("<pre>"logs+"</pre>");
//		
//		Reporter.setTestRunnerOutput("log 1");
//		Reporter.setTestRunnerOutput("<pre>Log 2</pre>");
//		Reporter.setTestRunnerOutput("<h2>heading 2</h2>");
//		Reporter.setTestRunnerOutput(Reporter.getExtentReport().());

	}

}
