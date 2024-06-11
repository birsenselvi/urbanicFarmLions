package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

public class US_014_ClickRegisterNow extends CommonPage {
    @Then("User clicks Register Now button")
    public void userClicksRegisterNowButton() {
        ReusableMethods.waitFor(2);
        JS_utilities.scrollAndClickWithJS(getHomePage().registerNowButton);

    }

    @Then("User verifies that relevant page is displayed")
    public void userVerifiesThatRelevantPageIsDisplayed() {
        getHomePage().assertionRegisterPage();

    }
}
