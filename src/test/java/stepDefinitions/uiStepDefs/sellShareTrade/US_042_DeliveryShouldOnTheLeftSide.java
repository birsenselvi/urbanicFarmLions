package stepDefinitions.uiStepDefs.sellShareTrade;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import pages.SellShareTrade;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_042_DeliveryShouldOnTheLeftSide {
    SellShareTrade sellShareTrade = new SellShareTrade();

    @Then("User Account-Address-Delivery and Pickup settings-Orders-Activities-My Activities-Planned Delivery\"\" headings on the left\"")
    public void user_account_address_delivery_and_pickup_settings_orders_activities_my_activities_planned_delivery_headings_on_the_left() {
     Assert.assertTrue(sellShareTrade.adress.isDisplayed());
     Assert.assertTrue(sellShareTrade.deliveryPickUpSettingsTitle.isDisplayed());
     Assert.assertTrue(sellShareTrade.ordersTitle.isDisplayed());
     Assert.assertTrue(sellShareTrade.eventsTitle.isDisplayed());
     Assert.assertTrue(sellShareTrade.myEventsTitle.isDisplayed());
     Assert.assertTrue(sellShareTrade.scheduledDeliveryTitle.isDisplayed());
     Assert.assertTrue(sellShareTrade.deliverySchedulerTitle.isDisplayed());
    }

    @When("User clicks on Sell Share Trade on the navbar")
    public void userClicksOnSellShareTradeOnTheNavbar() {
        ReusableMethods.waitForClickability(sellShareTrade.sellShareTradeTitle, 3);
    }
}

