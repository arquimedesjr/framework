package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Select {

	public void selectText(By by, String txt, int secons);

	public void selectText(By by, String txt);

	public void selectText(WebElement element, String txt);

	public void selectText(WebElement element, String txt, int secons);

	public void selectIndex(By by, int index, int secons);

	public void selectIndex(By by, int index);

	public void selectIndex(WebElement element, int index);

	public void selectIndex(WebElement element, int index, int secons);
}
