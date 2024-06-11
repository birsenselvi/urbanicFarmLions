package stepDefinitions.uiStepDefs.welcome;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_070_PerformVariousActionsInTheWelcomePage extends CommonPage {

    @Then("user verifies to see Orders in buyer-seller account")
    public void user_verifies_to_see_orders_in_buyer_seller_account() {

    }
    @When("user hovers basket icon")
    public void user_hovers_basket_icon() {

    }
    @Then("user verifies to see order message in mutual buyer-seller accounts")
    public void user_verifies_to_see_order_message_in_mutual_buyer_seller_accounts() {

    }
    @When("user clicks on basket icon with seller information")
    public void user_clicks_on_basket_icon_with_seller_information() {

    }
    @When("user selects any product with seller information")
    public void user_selects_any_product_with_seller_information() {

    }
    @When("user clicks on {string} button with seller information")
    public void user_clicks_on_button_with_seller_information(String string) {

    }
    @When("user clicks on all {string} buttons with seller information")
    public void user_clicks_on_all_buttons_with_seller_information(String string) {

    }
    @When("user clicks on all {string} button with seller information")
    public void user_clicks_on_all_button_with_seller_information(String string) {

    }
    @Then("user verifies to update order status with payment succesful with seller information")
    public void user_verifies_to_update_order_status_with_payment_succesful_with_seller_information() {

    }
    @When("user clicks on basket icon with buyer information")
    public void user_clicks_on_basket_icon_with_buyer_information() {

    }
    @When("user selects any product with buyer information")
    public void user_selects_any_product_with_buyer_information() {

    }
    @When("user clicks on {string} button with buyer information")
    public void user_clicks_on_button_with_buyer_information(String string) {

    }
    @When("user clicks on all {string} buttons with buyer information")
    public void user_clicks_on_all_buttons_with_buyer_information(String string) {

    }
    @When("user clicks on all {string} button with buyer information")
    public void user_clicks_on_all_button_with_buyer_information(String string) {

    }
    @Then("user verifies to update order status with payment succesful with buyer information")
    public void user_verifies_to_update_order_status_with_payment_succesful_with_buyer_information() {

    }

    @Then("user verifies is enable the Mark all as read button")
    public void user_verifies_is_enable_the_mark_all_as_read_button() {

    }
    @When("user clicks Notification bell")
    public void user_clicks_notification_bell() {

    }
    @When("user clicks Mark all as read button")
    public void user_clicks_mark_all_as_read_button() {

    }
    @Then("user verifies to see Notification empty container after click Mark all as read button and X button")
    public void user_verifies_to_see_notification_empty_container_after_click_mark_all_as_read_button_and_x_button() {

    }

    @Given("user goes to home page and logs in with Buyer ENUM")
    public void userGoesToHomePageAndLogsInWithBuyerENUM() {
     getWelcomePage().userGoesToHomePageAndLogsInWithBuyerENUM();
    }

    @Given("user goes to home page and logs in with Seller ENUM")
    public void userGoesToHomePageAndLogsInWithSellerENUM() {
        getWelcomePage().userGoesToHomePageAndLogsInWithSellerENUM();
    }
}
