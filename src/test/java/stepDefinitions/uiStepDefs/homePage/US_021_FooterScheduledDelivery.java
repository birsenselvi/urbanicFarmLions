package stepDefinitions.uiStepDefs.homePage;

import enums.LINKS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;

public class US_021_FooterScheduledDelivery extends CommonPage {
    @Given("user goes to the home page")
    public void userGoesToTheHomePage() {
        driver.get(LINKS.EXPECTED_LINKS.getUrbanicFarmTestUrl());

    }

    @When("user scrolls down to the footer")
    public void userScrollsDownToTheFooter() {
        ReusableMethods.waitFor(2);
        JS_utilities.scrollToBottom();
        ReusableMethods.waitFor(2);
    }

    @Then("user should see Scheduled Delivery link under Features")
    public void userShouldSeeScheduledDeliveryLinkUnderFeatures() {
        ReusableMethods.verifyElementDisplayed(getHomePage().footer_ScheduledDelivery);

    }

    @And("link should be clickable")
    public void linkShouldBeClickable() {
        ReusableMethods.verifyElementEnabled(getHomePage().footer_ScheduledDelivery);
    }

    @And("when it is clicked relevant page should be displayed.")
    public void whenItIsClickedRelevantPageShouldBeDisplayed() {
        waitForVisibility(getHomePage().footer_ScheduledDelivery,5);
        getHomePage().footer_ScheduledDelivery.click();
        waitFor(3);
        getHomePage().verifyFooterLinks(LINKS.EXPECTED_LINKS.getScheduledDeliveryUrl());

    }
}