package stepDefinitions.uiStepDefs.sellShareTrade;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_044_ScheduledDelivery extends CommonPage {
    @And("user logs in")
    public void userLogsIn() {
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(ConfigurationReader.getProperty("email"),ConfigurationReader.getProperty("password"));
    }
    @And("the user enters a zip code")
    public void theUserEntersAZipCode() {
        ReusableMethods.waitForVisibility(getSellShareTrade().zipCode,10);
        //JS_utilities.clickElementByJS( getSellShareTrade().zipCode);
       // getSellShareTrade().zipCode.click();
        JS_utilities.setValueByJS(getSellShareTrade().zipCode,ConfigurationReader.getProperty("zipCode"));
        //getSellShareTrade().zipCode.sendKeys(ConfigurationReader.getProperty("zipCode"));
        getSellShareTrade().go.click();
    }
    @And("user clicks on the popup")
    public void userClicsOnThePopup() {
        try {
            ReusableMethods.waitForVisibility(getHomePage().PopUp,10);
            getHomePage().PopUp.click();
        } catch (Exception e) {

        }
        ReusableMethods.waitFor(3);
    }
    @When("user clicks on Sell Share Trade")
    public void userClicksOnSellShareTrade() {
        ReusableMethods.waitForVisibility(getSellShareTrade().sellShareTrade,10);
        getSellShareTrade().sellShareTrade.click();

    }
    @And("user clicks on the Scheduled delivery")
    public void userClicksOnTheScheduledDelivery() {
        driver.navigate().refresh();
        JS_utilities.clickElementByJS(getSellShareTrade().scheduledDelivery);




    }


    @Then("user should see relevant page and popup")
    public void userShouldSeeRelevantPageAndPopup() {
        assert getSellShareTrade().zipCode.isDisplayed();
    }
}
