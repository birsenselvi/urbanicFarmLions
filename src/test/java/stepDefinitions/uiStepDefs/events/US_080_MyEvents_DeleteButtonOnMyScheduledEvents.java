package stepDefinitions.uiStepDefs.events;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_080_MyEvents_DeleteButtonOnMyScheduledEvents extends CommonPage {
    @And("user clicks on My Scheduled Events button")
    public void userClicksOnMyScheduledEventsButton() {
        getMyEventsPage().clickMyScheduledEventsButton();
    }

    @And("user creates a new event for USA")
    public void user_creates_a_new_event_for_USA() {
    getMyEventsPage().createNewEventsForUSA();
    }

    @And("User goes to relevant events and clicks on Delete button")
    public void user_goes_to_relevant_events_and_clicks_on_delete_button() {
    getMyEventsPage().clickOnDeleteForSelectedEvent();
    }

    @Then("User should see popup message")
    public void user_should_see_popup_message(DataTable popUpMessage) {
        getMyEventsPage().verifyPopUpMessageForDelete(popUpMessage);
    }

    @Then("User verifies that there is {string} button after clicking delete button")
    public void userVerifiesThatThereIsButtonAfterClickingDeleteButton(String expectedButton) {
        getMyEventsPage().verifyThereIsNoButton(expectedButton);
    }

    @When("User deletes relevant event")
    public void user_deletes_relevant_event() {
      getMyEventsPage().clickYesForDelete();
    }

    @Then("User should see {string} toast message")
    public void user_should_see_toast_message(String expectedToastMessage) {
    getMyEventsPage().verifyToastMessageAfterDelete(expectedToastMessage);
    }

    @Then("The event should not be on the list of My Scheduled Events")
    public void theEventShouldNotBeOnTheListOfMyScheduledEvents() {
     getMyEventsPage().verifyThereIsNoEventAnymoreOnTheListOfEvent(getMyEventsPage().eventTitle);
    }
}
