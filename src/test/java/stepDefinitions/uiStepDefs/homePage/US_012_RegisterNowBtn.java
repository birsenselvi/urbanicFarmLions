package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

public class US_012_RegisterNowBtn extends CommonPage {


    @Given("User clicks Register Now button under Backyard gardeners and farmers join the Movement For Free!")
    public void user_clicks_register_now_button_under_backyard_gardeners_and_farmers_join_the_movement_for_free() {

     JS_utilities.scrollAndClickWithJS(getHomePage().registerNowBtn);
     ReusableMethods.waitFor(3);
    }
    @Then("User verifies that register page is displayed")
    public void user_verifies_that_register_page_is_displayed() {
     Assert.assertTrue(getHomePage().signInWithGoogle.isDisplayed());
     ReusableMethods.waitFor(3);
    }

}
