package stepDefinitions.uiStepDefs.loginPage;

import enums.LINKS;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.ReusableMethods;


public class US_038_LoginFunctionality extends CommonPage {

    @When("User clicks on the login button")
    public void when_user_clicks_on_the_login_button() {
        getHomePage().loginButton.click();
    }

        @Then("User verify Email address should be functional")
        public void user_verify_email_address_should_be_functional() {
            getLoginPage().verifyEmailaddressshouldbefunctional();
        }

        @Then("User verify password button should be functional")
        public void user_verify_password_button_should_be_functional() {
            getLoginPage().verifypasswordbuttonshouldbefunctional();
        }
    @When("User enters an email {string}")
    public void user_enters_an_email(String email) {
        getLoginPage().email_Text.sendKeys(email,Keys.ENTER);
        ReusableMethods.waitFor(3);
    }
    @When("User enters a password {string}")
    public void user_enters_a_password(String password){
        getLoginPage().password_Text.sendKeys(password,Keys.ENTER);
}
    @When("System clean email and password boxes")
    public void system_clean_email_and_password_boxes() {
        getLoginPage().cleanEmailAndPasswordBox();
    }
    @Then("When it is clicked Login button and relevant page should be displayed.")
    public void when_it_is_clicked_login_button_and_relevant_page_should_be_displayed() {
        getHomePage().verifyFooterLinks(LINKS.EXPECTED_LINKS.getScheduledDeliveryUrl());
    }
}


