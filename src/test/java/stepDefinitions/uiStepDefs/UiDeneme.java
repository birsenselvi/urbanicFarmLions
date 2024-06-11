package stepDefinitions.uiStepDefs;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.Given;

import pages.CommonPage;
import utilities.ConfigurationReader;

import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;


public class UiDeneme extends CommonPage {
    @Given("user goes to home page and logs in")
    public void user_goes_to_home_page() {
        driver.get(ConfigurationReader.getProperty("url"));



        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();


        //getLoginPage().loginMethod(ConfigurationReader.getProperty("buyerEmail"), ConfigurationReader.getProperty("buyerPassword"));
        // from enum class
        //getLoginPage().loginMethod(USER_INFO.BUYER_CREDENTIAL.getEmail(), USER_INFO.BUYER_CREDENTIAL.getPassword());


        getLoginPage().loginMethod(USER_INFO.SELLER_CREDENTIALS.getEmail(), USER_INFO.SELLER_CREDENTIALS.getPassword());

    }



}

