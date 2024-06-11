package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;

public class US_024_ContactUsFooter extends CommonPage {
    @When("user clicks the Contact Us icon")
    public void user_clicks_the_contact_us_icon() {
       getHomePage().contactUsOfFooter.click();
    }
    @When("the Contact Us icon should be clickable")
    public void the_contact_us_icon_should_be_clickable() {
        ReusableMethods.verifyElementDisplayed(getHomePage().contactUsOfFooter);
    }

    @Then("When it is clicked and relevant page should be displayed for the Contact Us on the footer")
    public void whenItIsClickedAndRelevantPageShouldBeDisplayedForTheContactUsOnTheFooter() {

            waitForVisibility(getHomePage().contactUsOfFooter,5);
            getHomePage().contactUsOfFooter.click();
            waitFor(3);
        String getInTouchtext=getHomePage().getInTouchTxt.getText();
        Assert.assertTrue(getInTouchtext.contains("GET IN TOUCH"));
    }
    }


