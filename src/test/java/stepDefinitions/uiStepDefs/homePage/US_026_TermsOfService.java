package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;
public class US_026_TermsOfService extends CommonPage{

@Given("User goes the end of page")
    public void userGoesTheEndOfPage() {
ReusableMethods.hover(getHomePage().TermsOfService);
ReusableMethods.waitFor(2);
    }

    @And("User clicks Terms Of Service button")
    public void userClicksTermsOfServiceButton(){
        actions.click(getHomePage().TermsOfService).perform();
        ReusableMethods.waitFor(2);
    }

    @Then("User verifies the relevant page changed")
    public void userVerifiesTheRelevantPageChanged() {
        String expectedUrl= "https://test.urbanicfarm.com/terms-of-service";
        System.out.println("expectedUrl= " + expectedUrl);
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl= "+ actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
        ReusableMethods.waitFor(2);
    }

}
