package stepDefinitions.uiStepDefs.sellShareTrade;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.ReusableMethods;

public class US_046_UserNameSellShareTrade extends CommonPage {
    @When("the user clicks on the Login button")
    public void theUserClicksOnTheButton() {
        getSellShareTrade().loginButton.click();
    }

    @Then("completes the login form with valid {string} and {string}")
    public void completesTheLoginFormWithValidAnd(String email, String password) {
        ReusableMethods.waitFor(2);
      getSellShareTrade().emailButton.sendKeys(ConfigurationReader.getProperty("sellerEmail"));
       getSellShareTrade().passwordButton.sendKeys(ConfigurationReader.getProperty("sellerPassword2"));

    }

//    @And("completes the login form with valid email and password")
//    public void completesTheLoginFormWithValidEmailAndPassword() {
//        getSellShareTrade().emailButton.sendKeys();
//        getSellShareTrade().passwordButton.sendKeys();
//    }

    @And("clicks on the Login button")
    public void clicksOnTheButton() {
        ReusableMethods.waitFor(10);

       getSellShareTrade().LoginButton.click();
    }

    @Then("the user enters a valid zip code")
    public void theUserEntersAValidZipCode() {
        ReusableMethods.waitFor(4);
        //getSellShareTrade().zipCodeButton.sendKeys(ConfigurationReader.getProperty("zipCode"));
        getSellShareTrade().zipCodeButton.sendKeys("95170");

    }


    @And("clicks on the GO button")
    public void clicksOnTheGOButton() {
      getSellShareTrade().goButton.click();

    }




    @When("the user is on the Sell-Share-Trade page")
    public void theUserIsOnTheSellShareTradePage() {
       // Assert.assertEquals("https://test.urbanicfarm.com/account/home",driver.getCurrentUrl());
    }

    @Then("the username on the page should be clickable")
    public void theUsernameOnThePageShouldBeClickable() {
    }



}
