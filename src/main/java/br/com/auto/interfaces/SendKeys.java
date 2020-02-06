package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface SendKeys {

	public void sendkeysELement(By by, String value);

	public void sendkeysELement(By by, String value, int secons);

	public void sendkeysELement(WebElement element, String value);

	public void sendkeysELement(WebElement element,String value, int secons);

	public void sendkeysELementAction(WebElement element,String value, int secons);

	public void sendkeysELementAction(WebElement element, String value);
}
