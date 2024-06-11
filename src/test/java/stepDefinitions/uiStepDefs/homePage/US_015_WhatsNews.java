
    package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.ReusableMethods;


import static stepDefinitions.Hooks.driver;
import static utilities.JS_utilities.*;

    public class US_015_WhatsNews extends CommonPage {



        @When("the user scrolls down the home page to see Whats Near You under the Reduce waste, strengthen your community heading")
        public void theUserScrollsDownTheHomePageToSeeUnderTheHeading() {
            //scrollDownByJS();
            scrollAndClickWithJS(getHomePage().whatsNewsButton);

            ReusableMethods.waitFor(2);
        }



        @And("the relevant page should open")
        public void theRelevantPageShouldOpen() {
            Assert.assertEquals("Get Your Locally Sourced Veggies&Fruits from neighbors | Urbanic Farm",driver.getTitle());
        }

        @When("the user scrolls down the home page to see Post Your Goods under the Reduce waste, strengthen your community heading")
        public void theUserScrollsDownTheHomePageToSeePostYourGoodsUnderTheReduceWasteStrengthenYourCommunityHeading() {
            scrollAndClickWithJS(getHomePage().postYourGoodsButton);

        }



        @And("the relevant page should open and visible")
        public void theRelevantPageShouldOpenAndVisible() {
            Assert.assertEquals("https://test.urbanicfarm.com/auth/register",driver.getCurrentUrl());


        }



        @And("user enters {string},{string},{string},{string},{string}")
        public void userEnters(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) {
            ReusableMethods.waitFor(2);
            getRegisterPage().firstName.sendKeys(FirstName, Keys.ENTER);
            getRegisterPage().lastName.sendKeys(LastName,Keys.ENTER);
            getRegisterPage().email.sendKeys(Email,Keys.ENTER);
            getRegisterPage().password.sendKeys(Password,Keys.ENTER);
            getRegisterPage().confirmPassword.sendKeys(ConfirmPassword,Keys.ENTER);





        }

        @And("user verifies the message")
        public void userVerifiesTheMessage() {
            Assert.assertEquals("Register and start selling your produce! | Urbanic Farm",driver.getTitle());
        }


    }


