package stepDefinitions.uiStepDefs.loginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_39_InvalidLogin extends CommonPage {

    @Then("After entered invalid Email, get the error messages")
    public void afterEnteredInvalidEmailGetTheErrorMessages() {
    getLoginPage().getEmailErrorText();

    }

    @Then("After entered invalid password, get the toast messages")
    public void afterEnteredInvalidPasswordGetTheErrorMessages() {
        getLoginPage().getPasswordToastMessage();
    }

    @And("User clicks on the Login button")

    public void userClicksOnTheLoginButton() {
        ReusableMethods.waitFor(4);

        getLoginPage().clickLoginButton();
    }
}