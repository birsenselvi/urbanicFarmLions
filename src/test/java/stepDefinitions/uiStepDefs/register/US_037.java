package stepDefinitions.uiStepDefs.register;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RegisterPage;
import utilities.ReusableMethods;

public class US_037 extends RegisterPage {
    @Then("user get Welcome message")
    public void userGetWelcomeMessage() {
        ReusableMethods.verifyElementDisplayed(getRegisterPage().WelcomeAlert);
        ReusableMethods.waitFor(2);
    }

    @And("user verifies that relevant page is visible")
    public void userVerifiesThatRelevantPageIsVisible() {
        getRegisterPage().assertRegisterPage();

    }
}