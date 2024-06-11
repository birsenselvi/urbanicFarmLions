package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;

public class US_030_FacebookIconIsClickable extends CommonPage {

    @When("User click on the Facebook icon")
    public void ClickOnfacebookicon() {
        ReusableMethods.verifyElementEnabled(getHomePage().facebookIcon);
        ReusableMethods.waitFor(3);
        getHomePage().facebookIcon.click();
    }
    @Then("The relevant Facebook page should be visible")
    public void theRelevantFacebookIconIsVisible() {
        ReusableMethods.waitFor(3);
        ReusableMethods.switchToWindow(1);
        waitFor(2);
       // getHomePage().closeButtonOfRelevantWindowOfFacebook.click();
        System.out.println(driver.getCurrentUrl());
Assert.assertEquals("https://www.facebook.com/urbanicfarmstead", driver.getCurrentUrl());
    }
}

