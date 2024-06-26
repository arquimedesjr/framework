package br.com.auto.testBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.driver.ConfigDriver;
import br.com.auto.file.FileConfigProperties;
import br.com.auto.generator.ImgBase64;
import br.com.auto.interfaces.Capture;
import br.com.auto.interfaces.Click;
import br.com.auto.interfaces.DatesFormat;
import br.com.auto.interfaces.PrintScreen;
import br.com.auto.interfaces.Scroll;
import br.com.auto.interfaces.Select;
import br.com.auto.interfaces.SendKeys;
import br.com.auto.interfaces.Validation;
import br.com.auto.interfaces.WaitForElement;
import br.com.auto.reader.properties.ConfigFileReader;

public class TestBase extends ConfigDriver
		implements Capture, Click, DatesFormat, PrintScreen, Scroll, Select, SendKeys, Validation, WaitForElement {

	public static ConfigFileReader reader = new ConfigFileReader(FileConfigProperties.dirProperties);
	public static List<String> logs = new ArrayList<String>();

	public void driverSetUp() {
		setUp(reader.GetPropertyByKey("browser_name"));
	}

	public void setUrl() {
		driver.get(reader.GetPropertyByKey("url"));
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
		// TODO Auto-generated method stub

	}

	public void clickForElementAction(WebElement element, int secons) {
		// TODO Auto-generated method stub

	}

	public void clickForElementAction(WebElement element) {
		// TODO Auto-generated method stub

	}

	public String insertDaysNext(int dayNext) {
		// TODO Auto-generated method stub

		return null;
	}

	public String dateHours() {
		// TODO Auto-generated method stub

		return null;
	}

	public String dateToday() {
		// TODO Auto-generated method stub

		return null;
	}

	public void waitFluent() {
		// TODO Auto-generated method stub

	}

	public void waitElementVisibility(By by, int second) {
		// TODO Auto-generated method stub

	}

	public void waitElementVisibility(By by) {
		logs.add("Aguardo o Elemento <" + by.toString() + ">");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}

	public void waitElementVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitElementInvisibility(By by, int second) {
		// TODO Auto-generated method stub

	}

	public void waitElementInvisibility(By by) {
		// TODO Auto-generated method stub

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
		logs.add("Capturo imagem do browser");
	}

	public void takeScreenShotTest(By by, int secons) {
		waitElementPresent(by, secons);
		takeScreenShotTest();
	}

	public void takeScreenShotTest(By by) {
		waitElementPresent(by);
		takeScreenShotTest();
	}

	public void takeScreenShotTest(WebElement element, int secons) {
		// TODO Auto-generated method stub

	}

	public void takeScreenShotTest(WebElement element) {
		// TODO Auto-generated method stub

	}

	public void takeScreenShotTestAllPage() {
		logs.add("Capturo imagem do browser 'Tela Inteira'");
		String path = "." + File.separator + "src" + File.separator + "test" + File.separator + "resources";
		String archive = "print";

		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, true).withName(archive).save(path);

		screenReport(new ImgBase64().convertImgBase64Delete(path + File.separator + archive + ".png"));

	}

	public void takeScreenShotTestAllPage(By by, int secons) {

	}

	public void takeScreenShotTestAllPage(By by) {
		waitElementPresent(by);
		takeScreenShotTestAllPage();

	}

	public void takeScreenShotTestAllPage(WebElement element, int secons) {
		// TODO Auto-generated method stub

	}

	public void takeScreenShotTestAllPage(WebElement element) {
		// TODO Auto-generated method stub

	}

	public void sendkeysELement(By by, String value) {
		waitElementVisibility(by);
		logs.add("No elemento " + by.toString() + " escrevo" + value);
		driver.findElement(by).sendKeys(value);
	}

	public void sendkeysELement(By by, String value, int secons) {
		// TODO Auto-generated method stub

	}

	public void sendkeysELement(WebElement element, String value) {
		// TODO Auto-generated method stub

	}

	public void sendkeysELement(WebElement element, String value, int secons) {
		// TODO Auto-generated method stub

	}

	public void sendkeysELementAction(WebElement element, String value, int secons) {
		// TODO Auto-generated method stub

	}

	public void sendkeysELementAction(WebElement element, String value) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	public void scrolElement(WebElement by, int secons) {
		// TODO Auto-generated method stub

	}

	public void scrolElement(WebElement by) {
		// TODO Auto-generated method stub

	}

	public void selectText(By by, String txt, int secons) {
		// TODO Auto-generated method stub

	}

	public void selectText(By by, String txt) {
		// TODO Auto-generated method stub

	}

	public void selectText(WebElement element, String txt) {
		// TODO Auto-generated method stub

	}

	public void selectText(WebElement element, String txt, int secons) {
		// TODO Auto-generated method stub

	}

	public void selectIndex(By by, int index, int secons) {
		// TODO Auto-generated method stub

	}

	public void selectIndex(By by, int index) {
		// TODO Auto-generated method stub

	}

	public void selectIndex(WebElement element, int index) {
		// TODO Auto-generated method stub

	}

	public void selectIndex(WebElement element, int index, int secons) {
		// TODO Auto-generated method stub

	}

	public void clickForElementJS(By by) {
		// TODO Auto-generated method stub

	}

	public void clickForElementJS(By by, int secons) {
		// TODO Auto-generated method stub

	}

	public void clickForElementJS(WebElement element, int secons) {
		// TODO Auto-generated method stub

	}

	public void clickForElementJS(WebElement element) {
		// TODO Auto-generated method stub

	}

}
