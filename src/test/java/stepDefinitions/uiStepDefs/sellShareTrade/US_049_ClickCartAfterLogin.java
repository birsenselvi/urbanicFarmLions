package stepDefinitions.uiStepDefs.sellShareTrade;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_049_ClickCartAfterLogin extends LoginPage {
    @And("User logs in with Buyer credentials")
    public void userLogsInWithBuyerCredentials() {
        getLoginPage().performLogin();

    }

    @And("the user close the  zipcode window")
    public void theUserCloseTheZipcodeWindow() {

        ReusableMethods.switchToWindow(0);
        ReusableMethods.waitFor(2);

    }

    @And("user clicks the basket on the navbar")
    public void userClicksTheBasketOnTheNavbar() {

        JS_utilities.clickElementByJS(getLoginPage().basketIcon);
        ReusableMethods.waitFor(5);

    }

    @Then("the relevant page associated with current Url")
    public void theRelevantPageAssociatedWithCurrentUrl() {
        Assert.assertEquals("https://test.urbanicfarm.com/basket", driver.getCurrentUrl());

    }
}
