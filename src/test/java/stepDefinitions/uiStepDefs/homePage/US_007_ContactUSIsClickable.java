package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;
public class US_007_ContactUSIsClickable extends CommonPage {


    @When("User click on the ContactUs button")
    public void iClickOnTheContactUs() {
        ReusableMethods.verifyElementEnabled(getHomePage().contacUsInHomePage);
        ReusableMethods.waitFor(3);
        getHomePage().contacUsInHomePage.click();
    }
    @Then("The relevant Contact Us page should be visible")
    public void theRelevantContactUsPageShouldBeVisibleGivenSomething() {
        ReusableMethods.waitFor(3);
        String  expectedAdressText="GET IN TOUCH";
        String actualAdressTextDisplayed=getHomePage().getInTouch.getText();
        Assert.assertEquals(expectedAdressText,actualAdressTextDisplayed);
    }
}
