package br.com.auto.tool.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Scroll {

	public void scrolElementAction(By by);
	
	public void scrolElementJS(By by);

	public void scrolElement(By by, int secons);


}
