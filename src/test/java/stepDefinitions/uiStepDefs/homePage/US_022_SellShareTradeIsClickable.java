package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

import static stepDefinitions.Hooks.driver;

public class US_022_SellShareTradeIsClickable extends CommonPage {
    @When("user clicks on Sell Share Trade button")
    public void userClicksOnSellShareTradeOnTheNavbar() {
        getSellShareTrade().sellShareTrade2.click();
    }

    @Then("relevant page should be displayedB")
    public void theRelevantPageShouldOpenAndVisible() {
        Assert.assertEquals("https://test.urbanicfarm.com/explore", driver.getCurrentUrl());
    }
}
