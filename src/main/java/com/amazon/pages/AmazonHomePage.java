package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utility.CommonUtils;

import net.thucydides.core.pages.PageObject;

public class AmazonHomePage extends PageObject {
	private static final Logger LOG = LogManager.getLogger(AmazonHomePage.class);

	public static String MENU_TITLE_ON_HAMBURGER = "//div[@class='hmenu-item hmenu-title ' and text()='trending']";

	private static String BRAND_NAME = "//span[text()='Brands']/../following-sibling::ul//../following-sibling::span[text()='%s']/..//input";

	@FindBy(id = "nav-hamburger-menu")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//div[@class='hmenu-item hmenu-title ' and text()='shop by department']")
	private WebElement labelShopBydeparatment;

	@FindBy(xpath = "//a[div[text()='TV, Appliances, Electronics']]")
	private WebElement labelTvAppliances;

	@FindBy(xpath = "//a[text()='Televisions']")
	private WebElement labelTelevisions;

	@FindBy(xpath = "//span[text()='Brands' and @class='a-size-base a-color-base a-text-bold']")
	private WebElement brandsSection;

	@FindBy(css = "[class='a-button-inner']>span:nth-child(1)")
	private WebElement sortByFeatured;

	@FindBy(css = "[id=s-result-sort-select_2]")
	private WebElement priceHighToLow;

	@FindBy(css = "[class='a-price-whole']")
	private List<WebElement> productItem;

	@FindBy(css = "[class='a-size-base-plus a-text-bold']")
	private WebElement aboutThisItemSection;

	@FindBy(css = "#searchDropdownBox>option[selected]")
	private WebElement selectedCategory;

	public WebElement getSelectedCategory() {
		return selectedCategory;
	}

	public static Logger getLog() {
		return LOG;
	}

	public WebElement getHamburgerMenu() {
		return hamburgerMenu;
	}

	public WebElement getLabelShopBydeparatment() {
		return labelShopBydeparatment;
	}

	public WebElement getLabelTvAppliances() {
		return labelTvAppliances;
	}

	public WebElement getLabelTelevisions() {
		return labelTelevisions;
	}

	public WebElement getBrandsSection() {
		return brandsSection;
	}

	public WebElement getSortByFeatured() {
		return sortByFeatured;
	}

	public WebElement getPriceHighToLow() {
		return priceHighToLow;
	}

	public List<WebElement> getProductItem() {
		return productItem;
	}

	public WebElement getAboutThisItemSection() {
		return aboutThisItemSection;
	}

	public WebElement getElementByText(String locator, String text) {
		return getDriver().findElement(By.xpath(String.format(locator, text)));
	}

	public void launchApplication() {
		getDriver().manage().window().maximize();
		open();
	}

	public void checkOutAmazonPage() {
		CommonUtils.scrollToElementView(getDriver(), brandsSection);
	}

	public void clicksOnTvAppliances() {
		CommonUtils.scrollToElementView(getDriver(), getLabelShopBydeparatment());
		// CommonUtils.waitForElementToBeVisible(getDriver(),
		// getLabelTvAppliances());
		getLabelTvAppliances().click();
	}

	public void filterByBrand(String brandName) {
		CommonUtils.scrollToElementView(getDriver(), getBrandsSection());
		CommonUtils.clickUsingJavaScript(getDriver(), getElementByText(BRAND_NAME, brandName));
		Assert.assertTrue("Brand " + brandName + "is selected", getElementByText(BRAND_NAME, brandName).isSelected());
	}

	public void switchTab() {
		ArrayList<String> tabs2 = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(1));
	}
}
