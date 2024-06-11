package stepDefinitions.uiStepDefs.deliveryPickupSettings;

import enums.USER_INFO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.waitForVisibility;

public class US_057_BuyerPicksUpOnTheVineButton extends CommonPage {

    @When("User logs in and goes to the delivery pickup settings")
    public void userLogsInAndGoesToTheDeliveryPickupSettings() {
        getDeliveryPickupSeetingsPage().loginAndGoToTheDeliveryPickUpSettingsPage
                (USER_INFO.BUYER_CREDENTIAL.getEmail(), USER_INFO.BUYER_CREDENTIAL.getPassword());
    }

    @When("User clicks on the Buyer picks up on the vine checkbox button")
    public void user_clicks_on_the_Buyer_picks_up_on_the_checkbox_button() {
     getDeliveryPickupSeetingsPage().clickBuyerPicksUpOnTheVineButton();
    }

    @Then("Verify that Buyer picks up on the vine button should be clickable")
    public void verify_that_buyer_picks_up_on_the_vine_button_should_be_clickable() {
     getDeliveryPickupSeetingsPage().assertIsClickablePicksUpOnTheVineButton();
    }

    @Then("Verify that Your available hours menu is functional and visible")
    public void verify_that_your_available_hours_menu_is_functional_and_visible() {
    getDeliveryPickupSeetingsPage().assertIsVisibleAndFunctionalYourAvailableHoursMenu("14:00","15:00");
    }

    @When("User chooses {string} and {string} for start and end time")
    public void userChoosesAndForStartAndEndTime(String startTime, String endTime) {
        getDeliveryPickupSeetingsPage().chooseStartAndEndTime(startTime,endTime);
    }

    @When("User clicks on update button")
    public void user_clicks_on_update_button() {
     getDeliveryPickupSeetingsPage().clickUpdateButton();
    }

    @Then("Verify that the alert message is {string}")
    public void verifyThatTheAlertMessageIs(String expectedAlertMessage) {
        waitForVisibility(getDeliveryPickupSeetingsPage().alertMessage,5);
        assertEquals(getDeliveryPickupSeetingsPage().alertMessage.getText(),expectedAlertMessage);
    }

    @Then("Verify that start and end time and alert message")
    public void verifyThatStartAndEndTimeAndAlertMessage(DataTable dataTable) {
        getDeliveryPickupSeetingsPage().assertAvailableHoursCanBeSelectedFromTheMenu(dataTable);
        }
    }
