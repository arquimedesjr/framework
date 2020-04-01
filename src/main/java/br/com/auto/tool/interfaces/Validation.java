package br.com.auto.tool.interfaces;

import org.openqa.selenium.By;

public interface Validation {

	public void validationText(By by, String txt);

	public void validationText(By by, int seconds, String txt);

	public void validationObject(By by);

	public void validationObject(By by, int seconds);

}
