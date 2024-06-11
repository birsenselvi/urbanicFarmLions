package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import pages.HomePage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import javax.swing.*;

import static utilities.JS_utilities.scrollAndClickWithJS;

public class US_019_GetTheAppIsClickable extends CommonPage {

    @Then("user click on the Get The App")
    public void userClickOnTheGetTheApp() {

        ReusableMethods.waitForVisibility(getHomePage().getTheApp,5);
        JS_utilities.clickElementByJS(getHomePage().getTheApp);
    }

    @And("user assert the page Social networking and marketplace - on iOS and Android")
    public void userAssertThePageSocialNetworkingAndMarketplaceOnIOSAndAndroid() {

        String expectedText = "Social networking and marketplace - on iOS and Android";
        String actualTextDisplayed=getHomePage().socialNetworking.getText();
        Assert.assertEquals(expectedText,actualTextDisplayed);

    }
}
