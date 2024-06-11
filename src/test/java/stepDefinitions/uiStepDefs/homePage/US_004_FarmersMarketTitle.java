package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_004_FarmersMarketTitle extends CommonPage {


    @Given("User clicks Farmers Market sign")
    public void userClicksFarmersMarketSign() {

        getHomePage().FarmersMarket.click();
        ReusableMethods.waitFor(1);
    }

    @And("User closes the pop up")
    public void userClosesThePopUp() {
        getHomePage().PopUpClose.click();
        ReusableMethods.waitFor(2);
    }

    @Then("User verifies the page title changing")
    public void userVerifiesThePageTitleChanging() {
        String expectedUrl= "https://test.urbanicfarm.com/auth/login?route=/account/weekly-order";
        System.out.println("expectedUrl= " + expectedUrl);
        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl= "+ actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
