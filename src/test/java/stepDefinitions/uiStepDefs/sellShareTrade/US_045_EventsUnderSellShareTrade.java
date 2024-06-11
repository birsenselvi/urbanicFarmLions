package stepDefinitions.uiStepDefs.sellShareTrade;

import enums.LINKS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.verifyElementEnabled;
import static utilities.ReusableMethods.waitForClickability;

public class US_045_EventsUnderSellShareTrade extends CommonPage {
    @When("user clicks on Sell Share Trade on the navbar")
    public void userClicksOnSellShareTradeOnTheNavbar() {

        getSellShareTrade().sellShareTrade.click();
    }

    @Then("user verifies that it is navigated to Sell Share Trade page")
    public void userVerifiesThatItIsNavigatedToSellShareTradePage() {
assertEquals(LINKS.EXPECTED_LINKS.getSellShareTradeUrl(),driver.getCurrentUrl());

    }

    @And("Events module should be clickable on this page")
    public void eventsModuleShouldBeClickableOnThisPage() {
        verifyElementEnabled(getSellShareTrade().eventsOnTheSideBar);
    }

    @When("user clicks on Events on the left hand side menu")
    public void userClicksOnEventsOnTheLeftHandSideMenu() {
        waitForClickability(getSellShareTrade().eventsOnTheSideBar,3);
        getSellShareTrade().eventsOnTheSideBar.click();

    }

    @Then("relevant page should be displayed")
    public void relevantPageShouldBeDisplayed() {
        assertEquals(LINKS.EXPECTED_LINKS.getEventsUrl(), driver.getCurrentUrl());
    }
}
