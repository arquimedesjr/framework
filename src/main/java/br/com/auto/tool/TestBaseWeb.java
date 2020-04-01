package br.com.auto.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.file.FileConfigProperties;
import br.com.auto.generator.ImgBase64;
import br.com.auto.reader.properties.ConfigFileReader;
import br.com.auto.tool.interfaces.Capture;
import br.com.auto.tool.interfaces.Click;
import br.com.auto.tool.interfaces.PrintScreen;
import br.com.auto.tool.interfaces.Scroll;
import br.com.auto.tool.interfaces.Selects;
import br.com.auto.tool.interfaces.SendKeys;
import br.com.auto.tool.interfaces.Validation;
import br.com.auto.tool.interfaces.WaitForElement;

public class TestBaseWeb implements Capture, Click, PrintScreen, Scroll, Selects, SendKeys, Validation, WaitForElement {

	protected static ConfigFileReader reader = new ConfigFileReader(FileConfigProperties.pathfinal);
	protected static ConfigFileReader browser_properties = new ConfigFileReader(FileConfigProperties.pathfinal);
	public static List<String> logs = new ArrayList<String>();
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private Logger logger = Logger.getLogger(TestBaseWeb.class);

	public void setUpBrowser() {
		String browser = browser_properties.getPropertyByKey("browser_name");
		logger.info("Inicializando o driver: " + browser);
		try {
			if (browser.toUpperCase().equals("CHROME")) {

				System.setProperty("webdriver.chrome.driver", browser_properties.getPropertyByKey("chrome_dir"));
				ChromeOptions options = new ChromeOptions();

				if (browser_properties.getPropertyByKey("chrome_arguments_incognito").equals("true"))
					options.addArguments("--incognito");
				if (browser_properties.getPropertyByKey("chrome_arguments_start_maximized").equals("true"))
					options.addArguments("--start-maximized");
				if (browser_properties.getPropertyByKey("chrome_arguments_disable_extensions").equals("true"))
					options.addArguments("--disable-extensions");
				if (browser_properties.getPropertyByKey("chrome_arguments_disable_notifications").equals("true"))
					options.addArguments("--disable-notifications");
				if (browser_properties.getPropertyByKey("chrome_arguments_disable_infobars").equals("true"))
					options.addArguments("--disable-infobars");
				if (browser_properties.getPropertyByKey("chrome_arguments_enable_automation").equals("true"))
					options.addArguments("--enable-automation");
				if (browser_properties.getPropertyByKey("chrome_arguments_disable_popup_blocking").equals("true"))
					options.addArguments("--disable-popup-blocking");

				driver = new ChromeDriver(options);

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				wait = new WebDriverWait(driver,
						Integer.parseInt(browser_properties.getPropertyByKey("chrome_arguments_wait_driver")));

			} else if (browser.toUpperCase().equals("IE")) {

				System.setProperty("webdriver.ie.driver", browser_properties.getPropertyByKey("ie_dir"));

			} else if (browser.toUpperCase().equals("FIREFOX")) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Erro na inicialização do driver " + browser + ": " + e.getMessage());
		}
	}

	public void setUrl(String url) {
		driver.get(url);
	}

	public void driverquit() {
		driver.quit();
	}

	public void clickForELement(By by) {
		waitElementToBeClickable(by);
		driver.findElement(by).click();
		logs.add("Clico no Elemento <" + by.toString() + ">");
	}

	public void clickForELement(By by, int secons) {
		waitElementToBeClickable(by, secons);
		driver.findElement(by).click();
	}

	public void clickForELement(WebElement element) {
		waitElementToBeClickable(element);
		element.click();
	}

	public void clickForELement(WebElement element, int secons) {
		waitElementToBeClickable(element, secons);
		element.click();

	}

	public void clickForElementAction(WebElement element, int secons) {
		waitElementToBeClickable(element, secons);
		Actions ob = new Actions(driver);
		ob.click(element);
		Action action = ob.build();
		action.perform();

	}

	public void clickForElementAction(WebElement element) {
		waitElementToBeClickable(element);
		Actions ob = new Actions(driver);
		ob.click(element);
		Action action = ob.build();
		action.perform();

	}

	public void waitElementVisibility(By by, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

	}

	public void waitElementVisibility(By by) {
		logs.add("Aguardo o Elemento <" + by.toString() + ">");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public void waitElementVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementInvisibility(By by, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}

	public void waitElementInvisibility(By by) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

	}

	public void waitElementPresent(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitElementPresent(By by, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public void waitElementToBeClickable(By by, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitElementToBeClickable(WebElement element, int second) {
		WebDriverWait wait = new WebDriverWait(driver, second);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitElementToBeClickable(By by) {
		logs.add("Verifico se o elemento <" + by.toString() + "> é clicavel");
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void screenReport(String imagem) {
		try {
			Reporter.addScreenCaptureFromPath("data:image/png;base64," + imagem);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShotTest() {
		String imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		screenReport(imagem);
		logs.add("Capturo imagem");
	}

	public void takeScreenShotTest(By by, int secons) {
		waitElementPresent(by, secons);
		takeScreenShotTest();
	}

	public void takeScreenShotTest(By by) {
		waitElementPresent(by);
		takeScreenShotTest();
	}

	public void takeScreenShotTestAllPage() {
		logs.add("Capturo imagem do browser 'Tela Inteira'");
		String path = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources";
		String archive = "print";

		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, true).withName(archive).save(path);
		screenReport(new ImgBase64().convertImgBase64Delete(path + File.separator + archive + ".png"));

	}

	public void takeScreenShotTestAllPage(By by, int secons) {
		waitElementPresent(by, secons);
		takeScreenShotTestAllPage();
	}

	public void takeScreenShotTestAllPage(By by) {
		waitElementPresent(by);
		takeScreenShotTestAllPage();

	}

	public void takeScreenShotTestAllPage(WebElement element) {
		waitElementVisibility(element);
		takeScreenShotTestAllPage();

	}

	public void sendkeysELement(By by, String value) {
		waitElementVisibility(by);
		logs.add("No elemento " + by.toString() + " escrevo" + value);
		driver.findElement(by).sendKeys(value);
	}

	public void sendkeysELement(By by, String value, int secons) {
		waitElementVisibility(by, secons);
		driver.findElement(by).sendKeys(value);

	}

	public void sendkeysELement(WebElement element, String value) {
		waitElementToBeClickable(element);
		element.sendKeys(value);
	}

	public void sendkeysELement(WebElement element, String value, int secons) {
		waitElementToBeClickable(element, secons);
		element.sendKeys(value);

	}

	public void sendkeysELementAction(WebElement element, String value, int secons) {
		waitElementToBeClickable(element, secons);
		Actions ob = new Actions(driver);
		ob.click(element);
		ob.sendKeys(value);
		Action action = ob.build();
		action.perform();

	}

	public void sendkeysELementAction(WebElement element, String value) {
		waitElementToBeClickable(element);
		Actions ob = new Actions(driver);
		ob.click(element);
		ob.sendKeys(value);
		Action action = ob.build();
		action.perform();
	}

	public String captureText(By by) {
		waitElementVisibility(by);
		return driver.findElement(by).getText();
	}

	public String captureText(By by, int seconds) {
		waitElementVisibility(by, seconds);
		return driver.findElement(by).getText();
	}

	public void validationText(By by, String txt) {
		waitElementPresent(by);

		String text = driver.findElement(by).getText();

		if (!text.contains(txt) || text.isEmpty())
			Assert.assertFalse("Textos divergentes", true);
	}

	public void validationText(By by, int seconds, String txt) {
		waitElementPresent(by, seconds);
		validationText(by, txt);
	}

	public void validationObject(By by) {
		boolean cond = wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
		if (!cond)
			Assert.assertFalse("Objeto < " + by.toString() + " > n�o encontrado.", true);
	}

	public void validationObject(By by, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		boolean cond = wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
		if (!cond)
			Assert.assertFalse("Objeto < " + by.toString() + " > n�o encontrado.", true);
	}

	public void scrolElementAction(By by) {
		WebElement element = driver.findElement(by);
		waitElementVisibility(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	public void scrolElementJS(By by) {

		try {

			WebElement element = driver.findElement(by);
			waitElementVisibility(element);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			Reporter.addScenarioLog(e.getMessage());
		}
	}

	public void scrolElement(By by, int secons) {
		try {

			WebElement element = driver.findElement(by);
			waitElementVisibility(by, secons);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			Reporter.addScenarioLog(e.getMessage());
		}

	}

	public void selectText(By by, String txt, int secons) {
		waitElementPresent(by, secons);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByValue(txt);

	}

	public void selectText(By by, String txt) {
		waitElementPresent(by);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByValue(txt);

	}

	public void selectText(WebElement element, String txt) {
		waitElementToBeClickable(element);
		new Select(element).deselectByValue(txt);
	}

	public void selectText(WebElement element, String txt, int secons) {
		waitElementToBeClickable(element, secons);
		new Select(element).deselectByValue(txt);

	}

	public void selectIndex(By by, int index, int secons) {
		waitElementPresent(by, secons);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByIndex(index);
	}

	public void selectIndex(By by, int index) {
		waitElementPresent(by);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByIndex(index);
	}

	public void selectIndex(WebElement element, int index) {
		waitElementToBeClickable(element);
		new Select(element).deselectByIndex(index);
	}

	public void selectIndex(WebElement element, int index, int secons) {
		waitElementToBeClickable(element, secons);
		new Select(element).deselectByIndex(index);

	}

	public void clickForElementJS(By by) {
		waitElementPresent(by);
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void clickForElementJS(By by, int secons) {
		waitElementPresent(by, secons);
		WebElement element = driver.findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void clickForElementJS(WebElement element, int secons) {
		waitElementToBeClickable(element, secons);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void clickForElementJS(WebElement element) {
		waitElementToBeClickable(element);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

}
