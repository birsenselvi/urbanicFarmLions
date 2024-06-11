package stepDefinitions.uiStepDefs.events;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import static utilities.ReusableMethods.*;

public class US_077_CreateEventVerification  extends CommonPage {
    Select select;
    @When("user clicks on the My Event")
    public void user_clicks_on_the_my_event() {
        getMyEventsPage().myEventsOnSidebar.click();
    }
    @When("user clicks on the Create New Event")
    public void user_clicks_on_the_create_new_event() {
        ReusableMethods.waitForVisibility(getEventsPage().createNewEvent,5);
        getEventsPage().createNewEvent.click();
    }
    @And("user enters a character in the Title* box and fills other input boxes out")
    public void userEntersACharacterInTheTitleBoxAndFillsOtherInputBoxesOut() {
        getMyEventsPage().sendACharacterforTitle();
    }
    @And("user leaves blank in the Title box and fills other input boxes out")
    public void userLeavesBlankInTheTitleBoxAndFillsOtherInputBoxesOut() {
        getMyEventsPage().blankTitle();
    }

    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {
        waitForClickability(getMyEventsPage().submitEventButton, 5);
        JS_utilities.scrollAndClickWithJS(getMyEventsPage().submitEventButton);
        }

    @Then("user should see warning message {string} under Title box")
    public void user_should_see_warning_message_under_title_box(String string) {
        ReusableMethods.waitForVisibility(getMyEventsPage().invalidTitleText,10);
        assert getMyEventsPage().invalidTitleText.getText().contains(string);
    }

    @And("user leaves blank in the Address* box and fills other input boxes out")
    public void userLeavesBlankInTheAddressBoxAndFillsOtherInputBoxesOut() {
        getMyEventsPage().blankAddress();
    }
    @Then("user should see warning message {string} under Address box")
    public void user_should_see_warning_message_under_address_box(String string) {
        ReusableMethods.waitForVisibility(getMyEventsPage().invalidAddressText,10);
        assert getMyEventsPage().invalidAddressText.getText().contains(string);
    }

    @And("user leaves blank in the Date* box and fills other input boxes out")
    public void userLeavesBlankInTheDateBoxAndFillsOtherInputBoxesOut() {
    }

    @When("user should see warning message {string} under Date box")
    public void user_should_see_warning_message_under_date_box(String string) {
        ReusableMethods.waitForVisibility(getMyEventsPage().invalidDateText,10);
        assert getMyEventsPage().invalidDateText.getText().contains(string);
    }

    @And("user leaves blank  in the Time* box and fills other input boxes out")
    public void userLeavesBlankInTheTimeBoxAndFillsOtherInputBoxesOut() {

    }
    @When("user should see warning message {string} under Time box")
    public void user_should_see_warning_message_under_time_box(String string) {
        ReusableMethods.waitForVisibility(getMyEventsPage().invalidTimeText,10);
        assert getMyEventsPage().invalidTimeText.getText().contains(string);
    }
    }

