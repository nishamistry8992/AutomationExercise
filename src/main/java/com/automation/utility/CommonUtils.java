package com.automation.utility;

import java.time.Duration;
import java.util.function.Function;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	private static final int MAXTIME_OUT = Integer.parseInt(PropertyFileReader.MAX_TIMEOUT);
	private static final int MINTIME_OUT = Integer.parseInt(PropertyFileReader.MIN_TIMEOUT);

	private static final Logger LOG = LogManager.getLogger(CommonUtils.class);

	public static void waitForElementToBeVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAXTIME_OUT));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForElementToBeVisible(WebDriver driver, WebElement ele, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForElementNotToBeVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MINTIME_OUT));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public static void waitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	@SuppressWarnings({ "unchecked", "deprecation", "rawtypes", "unused" })
	public static void waitForElementToBeVisibleFluent(WebDriver driver, String locator) {
		Wait wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});
	}

	public static void waitForElementToBeVisibleFluent(WebDriver driver, WebElement ele) {
		Wait wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(MAXTIME_OUT))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return ele;
			}
		});
	}

	public static void clickUsingJavaScript(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public void swipe(WebDriver driver) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}

	public static void scrollToElementView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("location.reload()");
	}

	public static void openNewTab(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('about:blank','_blank');");
	}

	public static void waitForPageLoad(String url, WebDriver selDriver) {
		Wait<WebDriver> wait = new WebDriverWait(selDriver, Duration.ofSeconds(MAXTIME_OUT));
		wait.until(driver -> String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
				.equals("complete") && (driver.getCurrentUrl().contains(url)));
	}
}
