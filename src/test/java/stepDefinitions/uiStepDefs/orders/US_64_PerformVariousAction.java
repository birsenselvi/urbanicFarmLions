package stepDefinitions.uiStepDefs.orders;

import com.github.javafaker.Faker;
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

public class US_64_PerformVariousAction extends CommonPage {
    @Then("user verifies the Order button is clickable")
    public void verifies_the_order_button_is_clickable() {

        getOrdersPage().verifyOrderButtonIsClickable();
    }

    @When("user clicks Orders button from dropdown menu")
    public void user_clicks_orders_button_from_dropdown_menu() {
        getOrdersPage().clickOrdersButton();
    }

    @Then("user verifies to see relevant page is visible is Order List")
    public void user_verifies_to_see_relevant_page_is_visible_is_order_list() {
        getOrdersPage().clickOrdersButton();
        Assert.assertEquals("https://test.urbanicfarm.com/account/orders", driver.getCurrentUrl());
    }

    @Then("user verifies to see Order QuickOverview field")
    public void user_verifies_to_see_order_quick_overview_field() {
        getOrdersPage().variousContentInTheOrderQuickView();
    }

    @Then("user verifies to see Product Name, Price, Stock, Unit, Image should be seen")
    public void user_verifies_to_see_product_name_price_stock_unit_image_should_be_seen() {
        getOrdersPage().productNamePriceStockUnitImage();
    }

    @When("verify Rate the product button is  functional")
    public void click_rate_the_product_to_check_functionality() {

        getOrdersPage().rateOfProductButtonIsFunctional();
    }

    @When("click View order detail and then click Rate The Seller")
    public void click_view_order_detail_and_click_rate_the_seller() {
        getOrdersPage().ClickViewOrderDetailsButtonAndRateTheSeller();

    }

    @Then("assert Rate the Seller is clickable")
    public void assert_rate_the_seller_is_clickable() {

        getOrdersPage().verifyRateTheSellerIsClickable();
    }

    @When("the user enters a zip code nihan")
    public void theUserEntersAZipCodeNihan() {

        getLoginPage().fillFullZipcode();
        ReusableMethods.waitFor(2);

    }

    @When("user goes farmers market")
    public void userGoesFarmersMarket() {

        getOrdersPage().clickFarmersMarketButton();
    }

    @Given("user goes to home page and logs in with different ENUM")
    public void userGoesToHomePageAndLogsInWithDifferentENUM() {

        driver.get(ConfigurationReader.getProperty("url"));

        Faker faker=new Faker();

        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);

        getLoginPage().loginButton.click();

        //getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());
         getLoginPage().loginMethod(USER_INFO.SELLEROMER_CREDENTIALS.getEmail(), USER_INFO.SELLEROMER_CREDENTIALS.getPassword());

    }

    @Then("user verifies that verify Rate the Seller screen is opened")
    public void userVerifiesThatVerifyRateTheSellerScreenIsOpened() {
        getOrdersPage().verifyRatetheSellerScreenIsOpened();

    }

    @And("check rating stars")
    public void checkRatingStars() {
        getOrdersPage().verifyClickRatingStarsToSee();
    }
}

