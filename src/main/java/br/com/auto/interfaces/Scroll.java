package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Scroll {

	public void scrolElementAction(By by);
	
	public void scrolElementJS(By by);

	public void scrolElement(By by, int secons);

	public void scrolElement(WebElement by, int secons);

	public void scrolElement(WebElement by);
}
