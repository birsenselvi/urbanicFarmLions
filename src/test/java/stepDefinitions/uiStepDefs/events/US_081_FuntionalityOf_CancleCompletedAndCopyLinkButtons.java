package stepDefinitions.uiStepDefs.events;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;


public class US_081_FuntionalityOf_CancleCompletedAndCopyLinkButtons extends CommonPage {

    @And("user creates an event")
    public void userCreatesAnEvent() {
        getMyEventsPage().CreatesAnEvent();
    }

    @When("the user clicks on the Cancel button")
    public void the_user_clicks_on_the_cancel_button() {
        getMyEventsPage().CancelButton.click();

    }
    @When("a confirmation pop-up should appear asking Are you sure you want to cancel this event?")
    public void a_confirmation_pop_up_should_appear_asking_are_you_sure_you_want_to_cancel_this_event() {
        getMyEventsPage().ConfirmationPopupMSJ.click();
         Assert.assertEquals("Are you sure you want to cancel this event ?",getMyEventsPage().ConfirmationPopupMSJ.getText());
      Assert.assertTrue(getMyEventsPage().ConfirmationPopupMSJ.isDisplayed());

    }
    @When("the user confirms by clicking Yes")
    public void the_user_confirms_by_clicking_yes() {
        getMyEventsPage().yesButton.click();

    }

    @Then("the Cancelled Message should be visible")
    public void the_cancelled_Message_should_be_visible() {
        Assert.assertTrue(getMyEventsPage().canceledMaessage.isDisplayed());

    }
    @Then("the event status should be updated to Cancelled")
    public void the_event_status_should_be_updated_to_cancelled() {
        Assert.assertEquals("CANCELED",getMyEventsPage().canseledLableOnEvent.getText());
        Assert.assertTrue(getMyEventsPage().canseledLableOnEvent.isDisplayed());
    }

    @When("the user clicks on the Mark as Completed button")
    public void the_user_clicks_on_the_mark_as_completed_button() {
        getMyEventsPage().markAsCompletedButton.click();

    }
    @Then("a message should appear stating Event marked as completed")
    public void a_message_should_appear_stating_event_marked_as_completed() {
        ReusableMethods.waitForVisibility(getMyEventsPage().completedMassage, 10);
        Assert.assertEquals("Event marked as completed", getMyEventsPage().completedMassage.getText());
        Assert.assertTrue(getMyEventsPage().completedMassage.isDisplayed());

    }
    @When("the user clicks on the Copy Link button")
    public void the_user_clicks_on_the_copy_link_button() {
        getMyEventsPage().copyLinkButton.click();

    }
    @Then("a message should appear stating {string}")
    public void a_message_should_appear_stating(String string) {
      //  ReusableMethods.waitFor(2);
        getMyEventsPage().eventLinkCopiedMSJ.click();
        Assert.assertTrue(getMyEventsPage().eventLinkCopiedMSJ.isDisplayed());
    }

    @Then("the user decides to keep the event by clicking on {string}")
    public void the_user_decides_to_keep_the_event_by_clicking_on(String string) {
        getMyEventsPage().noButton.click();

    }
    @Then("the event remains visible with the {string} label on it")
    public void the_event_remains_visible_with_the_label_on_it(String string) {
        Assert.assertEquals("NEW",getMyEventsPage().newLableOnEvent.getText());
        Assert.assertTrue(getMyEventsPage().newLableOnEvent.isDisplayed());

    }



}
