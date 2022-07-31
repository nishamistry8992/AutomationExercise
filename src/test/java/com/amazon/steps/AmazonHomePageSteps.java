package com.amazon.steps;

import org.junit.Assert;

import com.amazon.pages.AmazonHomePage;
import com.automation.utility.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AmazonHomePageSteps {
	@Steps
	AmazonHomePage amazonHomePage;

	@Given("^user launches application successfully$")
	public void user_launches_application_successfully() {
		// Write code here that turns the phrase above into concrete actions
		amazonHomePage.launchApplication();
	}

	@When("^user clicks on the hamburger menu$")
	public void clickOnHamburgerMenu() {
		amazonHomePage.getHamburgerMenu().click();
		Assert.assertTrue("Trending menu is displayed",
				amazonHomePage.getElementByText(AmazonHomePage.MENU_TITLE_ON_HAMBURGER, "Trending").isDisplayed());
	}

	@And("^user clicks on TV, Appliances and Electronics link under shop by Department section$")
	public void clickOnTvAppliances() {
		amazonHomePage.clicksOnTvAppliances();
	}

	@Then("^verify TV section is open$")
	public void verifyTVSection() {
		Assert.assertTrue("Televisions sub menu is displayed", amazonHomePage.getLabelTelevisions().isDisplayed());
	}

	@When("^user clicks on Televisions under Tv, Audio & Cameras sub section$")
	public void clicksOnTelevision() {
		amazonHomePage.getLabelTelevisions().click();
		Assert.assertTrue("Televisions is selected",
				amazonHomePage.getSelectedCategory().getText().equals("Televisions"));
	}

	@And("^user scroll down and filter the results by brand \"([^\"]*)\"$")
	public void filterResultsByBrand(String brandName) {
		amazonHomePage.filterByBrand(brandName);
	}

	@And("^user sorts the Samsung results with price \"([^\"]*)\"$")
	public void sortsTheSamsung(String sortOption) {
		amazonHomePage.getSortByFeatured().click();
		amazonHomePage.getPriceHighToLow().click();
		Assert.assertTrue("Sorting option " + sortOption + " is selected",
				amazonHomePage.getSortByFeatured().getText().contains(sortOption));
	}

	@When("^user clicks on the second highest priced item$")
	public void clicksOnSecondHighestItem() {
		System.setProperty("second_highest_price", amazonHomePage.getProductItem().get(2).getText());
		amazonHomePage.getProductItem().get(2).click();
	}

	@And("^user switches the window$")
	public void switchWindow() {
		amazonHomePage.switchTab();
	}

	@And("^verifies about this item section$")
	public void verifyAboutThisItem() {
		CommonUtils.waitForElementToBeVisible(amazonHomePage.getDriver(), amazonHomePage.getPriceToPay());
		Assert.assertTrue(
				amazonHomePage.getPriceToPay().getText().equals(System.getProperty("second_highest_price").toString()));

		Assert.assertTrue("About this item section is visible", amazonHomePage.getAboutThisItemSection().isDisplayed());

	}
}
