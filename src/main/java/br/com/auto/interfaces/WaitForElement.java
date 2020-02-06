package br.com.auto.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface WaitForElement {

	public void waitFluent();

	public void waitElementVisibility(By by, int second);

	public void waitElementVisibility(By by);

	public void waitElementVisibility(WebElement element);

	public void waitElementInvisibility(By by, int second);

	public void waitElementInvisibility(By by);

	public void waitElementPresent(By by);

	public void waitElementPresent(By by, int second);

	public void waitElementToBeClickable(By by, int second);
	
	public void waitElementToBeClickable(WebElement element, int second);

	public void waitElementToBeClickable(By by);
	
	public void waitElementToBeClickable(WebElement element);

	/*
	 * WebDriverWait wait; Wait<WebDriver> waitDriver;
	 * 
	 * public void waitFluent() { waitDriver = new
	 * FluentWait<WebDriver>(getDriver()).withTimeout(30, TimeUnit.SECONDS)
	 * .pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class); }
	 * 
	 * public void waitElementVisibility(By by, int second) { wait = new
	 * WebDriverWait(getDriver(), second);
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
	 * 
	 * public void waitElementVisibility(By by) {
	 * getWait().until(ExpectedConditions.visibilityOfElementLocated(by)); }
	 * 
	 * public void waitElementInvisibility(By by, int second) { wait = new
	 * WebDriverWait(getDriver(), second);
	 * wait.until(ExpectedConditions.invisibilityOfElementLocated(by)); }
	 * 
	 * public void waitElementInvisibility(By by) {
	 * getWait().until(ExpectedConditions.invisibilityOfElementLocated(by)); }
	 * 
	 * public void waitElementPresent(By by, int second) { wait = new
	 * WebDriverWait(getDriver(), second);
	 * wait.until(ExpectedConditions.presenceOfElementLocated(by)); }
	 * 
	 * public void waitElementPresent(By by) {
	 * getWait().until(ExpectedConditions.presenceOfElementLocated(by)); }
	 * 
	 * public boolean alertIsPresent(int second) { wait = new
	 * WebDriverWait(getDriver(), second);
	 * wait.until(ExpectedConditions.alertIsPresent()); if
	 * (ExpectedConditions.alertIsPresent() != null) { return true; } return false;
	 * }
	 * 
	 * public boolean alertIsPresent() {
	 * getWait().until(ExpectedConditions.alertIsPresent()); if
	 * (ExpectedConditions.alertIsPresent() != null) { return true; } return false;
	 * }
	 */

}
