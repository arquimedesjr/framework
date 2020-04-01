package br.com.auto.tool;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.auto.tool.interfaces.Capture;
import br.com.auto.tool.interfaces.Click;
import br.com.auto.tool.interfaces.PrintScreen;
import br.com.auto.tool.interfaces.Scroll;
import br.com.auto.tool.interfaces.Selects;
import br.com.auto.tool.interfaces.SendKeys;
import br.com.auto.tool.interfaces.Validation;
import br.com.auto.tool.interfaces.WaitForElement;

public class TestBaseMobile
		implements Capture, Click, PrintScreen, Scroll, Selects, SendKeys, Validation, WaitForElement {

//	protected static ConfigFileReader browser_properties = new ConfigFileReader(FileConfigProperties.dirProperties);
	public static List<String> logs = new ArrayList<String>();
//	protected static Mobile driver;
	protected static WebDriverWait wait;
	private Logger logger = Logger.getLogger(TestBaseMobile.class);
	public void waitFluent() {
		// TODO Auto-generated method stub
		
	}
	public void waitElementVisibility(By by, int second) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementVisibility(By by) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementVisibility(WebElement element) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementInvisibility(By by, int second) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementInvisibility(By by) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementPresent(By by) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementPresent(By by, int second) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementToBeClickable(By by, int second) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementToBeClickable(WebElement element, int second) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementToBeClickable(By by) {
		// TODO Auto-generated method stub
		
	}
	public void waitElementToBeClickable(WebElement element) {
		// TODO Auto-generated method stub
		
	}
	public void validationText(By by, String txt) {
		// TODO Auto-generated method stub
		
	}
	public void validationText(By by, int seconds, String txt) {
		// TODO Auto-generated method stub
		
	}
	public void validationObject(By by) {
		// TODO Auto-generated method stub
		
	}
	public void validationObject(By by, int seconds) {
		// TODO Auto-generated method stub
		
	}
	public void sendkeysELement(By by, String value) {
		// TODO Auto-generated method stub
		
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
	public void scrolElementAction(By by) {
		// TODO Auto-generated method stub
		
	}
	public void scrolElementJS(By by) {
		// TODO Auto-generated method stub
		
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
	public void takeScreenShotTest() {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTest(By by, int secons) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTest(By by) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTest(WebElement element, int secons) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTest(WebElement element) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTestAllPage() {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTestAllPage(By by, int secons) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTestAllPage(By by) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTestAllPage(WebElement element, int secons) {
		// TODO Auto-generated method stub
		
	}
	public void takeScreenShotTestAllPage(WebElement element) {
		// TODO Auto-generated method stub
		
	}
	public void clickForELement(By by) {
		// TODO Auto-generated method stub
		
	}
	public void clickForELement(By by, int secons) {
		// TODO Auto-generated method stub
		
	}
	public void clickForELement(WebElement element) {
		// TODO Auto-generated method stub
		
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
	public String captureText(By by) {
		// TODO Auto-generated method stub
		return null;
	}
	public String captureText(By by, int seconds) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
