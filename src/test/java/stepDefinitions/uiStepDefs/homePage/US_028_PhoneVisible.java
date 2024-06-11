package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

public class US_028_PhoneVisible extends HomePage {
    @Given("user checks {string} text visible")
    public void user_checks_text_visible(String expected) {
        String  actual=getHomePage().phone.getText();
        Assert.assertEquals(expected, actual);

    }
    @Then("user checks {string} is visible")
    public void user_checks_is_visible(String expected) {
        String  actual=getHomePage().phoneNumber.getText();
        Assert.assertEquals(expected, actual);

    }

}
