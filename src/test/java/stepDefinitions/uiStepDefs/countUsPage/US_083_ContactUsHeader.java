package stepDefinitions.uiStepDefs.countUsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.ContactUsPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_083_ContactUsHeader extends CommonPage {

    @Given("The Contact Us banner at the top of the Welcome Page should be visible and clickable.")
    public void the_contact_us_banner_at_the_top_of_the_welcome_page_should_be_visible_and_clickable() {
    Assert.assertTrue(getContactUsPage().contactUsWelcomePage.isDisplayed());
    getContactUsPage().contactUsWelcomePage.click();
    ReusableMethods.waitFor(1);
    }

    @Given("Closes the page.")
    public void closes_the_page() {
        Driver.closeDriver();
    }

    @When("you click on the contact us heading, it is confirmed that GET IN TOUCH appears on the Contact Us page.")
    public void you_click_on_the_contact_us_heading_it_is_confirmed_that_get_ın_touch_appears_on_the_contact_us_page() {
        Assert.assertTrue(getContactUsPage().getInTouchTitle.isDisplayed());
        ReusableMethods.waitFor(1);
    }

    @When("The visitor clicks the Send Message button without filling in the mandatory fields \\(your name, your, email, message) on the GET IN TOUCH page.")
    public void the_visitor_clicks_the_send_message_button_without_filling_in_the_mandatory_fields_your_name_your_email_message_on_the_get_ın_touch_page() {
        getContactUsPage().sendMessageButon.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Verify that prompts such as Please enter a valid name,Please enter a valid email address., Please enter a message with at least {int} characters. appear.")
    public void verify_that_prompts_such_as_please_enter_a_valid_name_please_enter_a_valid_email_address_please_enter_a_message_with_at_least_characters_appear(Integer int1) {

        Assert.assertTrue(getContactUsPage().yourNameBox.isDisplayed());
        Assert.assertTrue(getContactUsPage().yourEmailBox.isDisplayed());
        Assert.assertTrue(getContactUsPage().messageBox.isDisplayed());

        ReusableMethods.waitFor(5);
    }

    @When("visitor enters valid username and message")
    public void visitor_enters_valid_username_and_message() {
       String validName = "validName";
       String validMessage= "validMessage";
        getContactUsPage().yourNameBox.sendKeys(validName);
        getContactUsPage().messageBox.sendKeys(validMessage);
        ReusableMethods.waitFor(2);
    }

    @When("The visitor enters an invalid email \\(with a missing @ symbol) and clicks the Send Message button.")
    public void the_visitor_enters_an_invalid_email_with_a_missing_symbol_and_clicks_the_send_message_button() {
        String invalidEmail = "invalidmailgmail.com";
        getContactUsPage().yourEmailBox.sendKeys(invalidEmail);
        ReusableMethods.waitFor(1);
        getContactUsPage().sendMessageButon.click();
        ReusableMethods.waitFor(1);
    }

    @When("Please enter a valid email address. message should be displayed")
    public void please_enter_a_valid_email_address_message_should_be_displayed() {
        Assert.assertTrue("Please enter a valid email address.", getContactUsPage().pleaseValidEmail.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @When("visitor enters valid username and email")
    public void visitor_enters_valid_username_and_email() {
        String validName = "validName";
        getContactUsPage().yourNameBox.sendKeys(validName);
        ReusableMethods.waitFor(1);

        String validEmail = "validmail@gmail.com";
        getContactUsPage().yourEmailBox.sendKeys(validEmail);
        ReusableMethods.waitFor(1);

        getContactUsPage().sendMessageButon.click();
        ReusableMethods.waitFor(1);
    }

    @When("Visitor enters a message of less than {int} characters and clicks the Send Message button.")
    public void visitor_enters_a_message_of_less_than_characters_and_clicks_the_send_message_button(Integer int1) {
    String lessTen= "less ten";
    getContactUsPage().messageBox.sendKeys(lessTen);
    ReusableMethods.waitFor(1);

        getContactUsPage().sendMessageButon.click();
        ReusableMethods.waitFor(1);
    }

    @When("Please enter a message with at least {int} characters. message should be displayed")
    public void please_enter_a_message_with_at_least_characters_message_should_be_displayed(Integer int1) {
        Assert.assertTrue("Please enter a message with at least 10 characters.", getContactUsPage().pleaseTenCharacters.isDisplayed());
        ReusableMethods.waitFor(2);
    }


    @When("visitors enter the required information and click the Send Message button")
    public void visitors_enter_the_required_information_and_click_the_send_message_button() {
        String validName = "validName";
        getContactUsPage().yourNameBox.sendKeys(validName);
        ReusableMethods.waitFor(1);

        String validEmail = "validmail@gmail.com";
        getContactUsPage().yourEmailBox.sendKeys(validEmail);
        ReusableMethods.waitFor(1);

        String validMessage= "validMessage";
        getContactUsPage().messageBox.sendKeys(validMessage);
        ReusableMethods.waitFor(1);

        getContactUsPage().sendMessageButon.click();
        ReusableMethods.waitFor(1);
    }

    @When("Confirm that after the visitor enters the necessary information and sends the message, the message Thanks for your message! It has been sent to us. is displayed.")
    public void confirm_that_after_the_visitor_enters_the_necessary_information_and_sends_the_message_the_message_thanks_for_your_message_ıt_has_been_sent_to_us_is_displayed() {
        Assert.assertTrue("Thanks for your message! It has been sent to us.", getContactUsPage().thanksForYourMessageText.isDisplayed());
        ReusableMethods.waitFor(2);
    }


}
