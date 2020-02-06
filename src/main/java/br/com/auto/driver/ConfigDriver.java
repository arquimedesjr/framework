package br.com.auto.driver;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigDriver {
	
	private Logger logger = Logger.getLogger(ConfigDriver.class);

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	


	public ConfigDriver() {

	}

	public void setUp(String browser) {
		logger.info("Inicializando o driver: "+browser);
		try {
			
			if (browser.toUpperCase().equals("CHROME")) {

				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-notifications");
				options.addArguments("enable-automation");
				options.addArguments("--disable-popup-blocking");
				driver = new ChromeDriver(options);

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 10);

			} else if (browser.toUpperCase().equals("IE")) {

			} else if (browser.toUpperCase().equals("FIREFOX")) {

			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erro na inicialização do driver "+browser+": "+e.getMessage());
		}
		
        		
		

	}
	

}
