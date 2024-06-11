package stepDefinitions.uiStepDefs.sellShareTrade;


import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_043_ContactUsClickableOnTheSellShareTrade extends CommonPage {
    //    @When("user clicks on Sell Share Trade on the navbar")
//    public void userClicksOnSellShareTradeOnTheNavbar() {
//        getSellShareTrade().sellShareTrade.click();
//    }

//    @Then("user verifies that it is navigated to Sell Share Trade page")
//    public void userVerifiesThatItIsNavigatedToSellShareTradePage() {
//    }
//    @And ("User click on the ContactUs button")
//    public void userClickOnTheContactUsButton(){
//        getHomePage().contacUsInHomePage.click();
//
//    }

    @Then("relevant page should be displayedA")
    public void theRelevantPageShouldOpenAndVisible() {
        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());
    }

    @Given("The user goes to home page and logs in")
    public void theUserGoesToHomePageAndLogsIn() {
        driver.get(ConfigurationReader.getProperty("url"));



        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();


        //getLoginPage().loginMethod(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
        // from enum class
        getLoginPage().loginMethod(USER_INFO.BUYER_CREDENTIAL.getEmail(), USER_INFO.BUYER_CREDENTIAL.getPassword());


//        getLoginPage().loginMethod(USER_INFO.SELLER_CREDENTIALS.getEmail(), USER_INFO.SELLER_CREDENTIALS.getPassword());
    }

    @Then("the user verifies that it is navigated to Sell Share Trade page")
    public void theUserVerifiesThatItIsNavigatedToSellShareTradePage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/home", driver.getCurrentUrl());
    }

    @When("the user clicks on Sell Share Trade on the navbar")
    public void theUserClicksOnSellShareTradeOnTheNavbar() {
        getSellShareTrade().sellShareTrade2.click();
    }

    @And("the user click on the ContactUs button")
    public void theUserClickOnTheContactUsButton() {
        getSellShareTrade().ContactUs1.click();
    }

    @Then("the relevant page should be displayed")
    public void theRelevantPageShouldBeDisplayed() {
        Assert.assertEquals("https://test.urbanicfarm.com/contact-us", driver.getCurrentUrl());
    }
}
