package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitFor;

public class US_031_ClickLinkedinIcon extends CommonPage {
    @When("User scroll down footer")
    public void userScrollDownFooter() {
        JS_utilities.scrollToBottom();

    }

    @And("the user clicks the LinkedIn icon")
    public void theUserClicksTheLinkedInIcon() throws InterruptedException {
        JS_utilities.clickElementByJS(getHomePage().linkedinButton);

    }

    @And("the user close the  window")
    public void theUserCloseTheWindow() {
        ReusableMethods.switchToWindow(1);
        waitFor(2);
    }

    @And("the user should be redirected to the LinkedIn page")
    public void theUserShouldBeRedirectedToTheLinkedInPage() {
        getHomePage().assertLinkedin();

    }

}









