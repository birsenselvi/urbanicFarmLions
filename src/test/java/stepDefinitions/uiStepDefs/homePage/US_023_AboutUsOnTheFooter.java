package stepDefinitions.uiStepDefs.homePage;

import enums.LINKS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JS_utilities;

import static stepDefinitions.Hooks.driver;

public class US_023_AboutUsOnTheFooter extends CommonPage {

    @Given("User goes to the homepage")
    public void user_goes_to_the_homepage() {
       driver.get(LINKS.EXPECTED_LINKS.getUrbanicFarmTestUrl());
    }

    @When("User goes to the end of the page")
    public void user_goes_to_the_end_of_the_page() {
        JS_utilities.scrollToBottom();
    }

    @Then("About us button should be clickable")
    public void About_us_button_should_be_clickable() {
        getHomePage().assertAboutUsButtonIsClickable();
        getHomePage().aboutUsButtonOnTheFooter.click();
    }

    @And("About us page should be visible")
    public void about_us_page_should_be_visible() {
       getHomePage().assertAboutUsPageIsVisible("https://test.urbanicfarm.com/about");
    }

}
