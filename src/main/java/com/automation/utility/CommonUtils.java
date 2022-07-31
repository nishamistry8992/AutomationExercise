package com.automation.utility;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
//	private final static Integer MAXTIME_OUT = Integer.valueOf(SerenitySystemProperties.getProperties()
//			.getValue(ThucydidesSystemProperty.WEBDRIVER_TIMEOUTS_IMPLICITLYWAIT));
	
	// private static final int MAXTIME_OUT =
	// Integer.parseInt(PropertyFileReader.MAX_TIMEOUT);
	// private static final int MINTIME_OUT =
	// Integer.parseInt(PropertyFileReader.MIN_TIMEOUT);
	//
	// private static final Logger LOG =
	// LogManager.getLogger(CommonUtils.class);
	//
	public static void waitForElementToBeVisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	//
	// public static void waitForElementToBeVisible(WebDriver driver, WebElement
	// ele, int waitTime) {
	// WebDriverWait wait = new WebDriverWait(driver,
	// Duration.ofSeconds(waitTime));
	// wait.until(ExpectedConditions.visibilityOf(ele));
	// }
	//
	// public static void waitForElementNotToBeVisible(WebDriver driver,
	// WebElement ele) {
	// WebDriverWait wait = new WebDriverWait(driver,
	// Duration.ofSeconds(MINTIME_OUT));
	// wait.until(ExpectedConditions.invisibilityOf(ele));
	// }
	//
	// public static void waitForAlertPresent(WebDriver driver) {
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	// wait.until(ExpectedConditions.alertIsPresent());
	// }
	//
	// @SuppressWarnings({ "unchecked", "deprecation", "rawtypes", "unused" })
	// public static void waitForElementToBeVisibleFluent(WebDriver driver,
	// String locator) {
	// Wait wait = new
	// FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(300))
	// .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	// WebElement element = (WebElement) wait.until(new Function<WebDriver,
	// WebElement>() {
	// public WebElement apply(WebDriver driver) {
	// return driver.findElement(By.xpath(locator));
	// }
	// });
	// }
	//
	// public static void waitForElementToBeVisibleFluent(WebDriver driver,
	// WebElement ele) {
	// Wait wait = new
	// FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(MAXTIME_OUT))
	// .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
	// WebElement element = (WebElement) wait.until(new Function<WebDriver,
	// WebElement>() {
	// public WebElement apply(WebDriver driver) {
	// return ele;
	// }
	// });
	// }

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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		Wait<WebDriver> wait = new WebDriverWait(selDriver, Duration.ofSeconds(80));
		wait.until(driver -> String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
				.equals("complete") && (driver.getCurrentUrl().contains(url)));
	}
}
