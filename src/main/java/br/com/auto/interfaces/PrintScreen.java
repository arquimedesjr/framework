package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface PrintScreen {

	public void takeScreenShotTest();

	public void takeScreenShotTest(By by, int secons);

	public void takeScreenShotTest(By by);

	public void takeScreenShotTest(WebElement element, int secons);

	public void takeScreenShotTest(WebElement element);

	public void takeScreenShotTestAllPage();

	public void takeScreenShotTestAllPage(By by, int secons);

	public void takeScreenShotTestAllPage(By by);

	public void takeScreenShotTestAllPage(WebElement element, int secons);

	public void takeScreenShotTestAllPage(WebElement element);

}
