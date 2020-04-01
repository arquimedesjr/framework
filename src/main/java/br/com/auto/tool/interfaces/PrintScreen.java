package br.com.auto.tool.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface PrintScreen {

	public void takeScreenShotTest();

	public void takeScreenShotTest(By by, int secons);

	public void takeScreenShotTest(By by);

	public void takeScreenShotTestAllPage();

	public void takeScreenShotTestAllPage(By by, int secons);

	public void takeScreenShotTestAllPage(By by);


	public void takeScreenShotTestAllPage(WebElement element);

}
