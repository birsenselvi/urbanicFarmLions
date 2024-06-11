package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JS_utilities;

import static stepDefinitions.Hooks.driver;

public class US_013_ClickSellShareTrade extends CommonPage {

    @When("User clicks Sell button")
    public void userClicksSellButton() {
        JS_utilities.scrollAndClickWithJS(getHomePage().sellbutton);
        // ReusableMethods.waitFor(2);
    }

    @And("User back to homepage")
    public void userBackToHomepage() {
        driver.navigate().back();

    }

    @And("User clicks Share button")
    public void userClicksShareButton() {
        JS_utilities.scrollAndClickWithJS(getHomePage().sharebutton);
        // ReusableMethods.waitFor(2);

    }

    @Then("User clicks Trade button")
    public void userClicksTradeButton() {
        JS_utilities.scrollAndClickWithJS(getHomePage().tradebutton);
        //  ReusableMethods.waitFor(2);

    }

}
