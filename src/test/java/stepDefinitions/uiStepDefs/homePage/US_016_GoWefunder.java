package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_016_GoWefunder extends CommonPage {

    @When("user scrolls down the home page to  find the heading Invest in Urbanic Farm")
    public void user_scrolls_down_the_home_page_to_find_the_heading_invest_in_urbanic_farm() {
        JS_utilities.scrollAndClickWithJS(getHomePage().investInUrbanicFarmButton);
    }

    @Then("the GO WEFUNDER button should be visible and clickable")
    public void the_go_wefunder_button_should_be_visible_and_clickable() {
        // Check if the element is visible and clickable
        ReusableMethods.waitForVisibility(getHomePage().goWefunderButton, 10);
        Assert.assertTrue(getHomePage().goWefunderButton.isDisplayed());
      JS_utilities.clickElementByJS(getHomePage().goWefunderButton);
    }


    @When("the user clicks on the GO WEFUNDER button")
    public void theUserClicksOnTheGOWEFUNDERButton() {
        JS_utilities.clickElementByJS(getHomePage().goWefunderButton);
        
    }
    @Then("the user is directed to the relevant WEFUNDER page")
    public void theUserIsDirectedToTheRelevantWEFUNDERPage() {
        ReusableMethods.switchToWindow(1);
        Assert.assertEquals("https://wefunder.com/urbanicfarm",driver.getCurrentUrl());
    }


}
