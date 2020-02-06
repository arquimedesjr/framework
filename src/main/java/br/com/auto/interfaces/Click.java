package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Click {

	public void clickForELement(By by);

	public void clickForELement(By by, int secons);

	public void clickForELement(WebElement element);

	public void clickForELement(WebElement element, int secons);

	public void clickForElementAction(WebElement element, int secons);

	public void clickForElementAction(WebElement element);

	public void clickForElementJS(By by);

	public void clickForElementJS(By by, int secons);

	public void clickForElementJS(WebElement element, int secons);

	public void clickForElementJS(WebElement element);

}
