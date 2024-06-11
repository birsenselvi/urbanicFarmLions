package stepDefinitions.uiStepDefs.events;

import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;


public class US_075_EventCreationWithInvalidData extends CommonPage {

//    @And("the user clicks on my events tab on the left side.")
//    public void theUserClicksOnMyEventsTabOnTheLeftSide(){
//        waitForVisibility(getMyEventsPage().myEventsOnSidebar,5);
//        getMyEventsPage().myEventsOnSidebar.click();
//    }

    @And("the user clicks on Create New Event button.")
    public void theUserClicksOnCreateNewEventButton() {
        getMyEventsPage().eventCreation();
        getMyEventsPage().submitEventButton.click();

    }

    @And("the user must see the related warning message for the required fields.")
    public void theUserMustSeeTheRelatedWarningMessageForTheRequiredFields() {
        waitFor(3);
        String  expectedTextAfterClick1="Please enter a valid title.";
        String actualTexAfterClick1=getMyEventsPage().WarningMessageForTitle.getText();
        Assert.assertEquals("Please enter a valid title.",expectedTextAfterClick1,actualTexAfterClick1);
        waitFor(2);
        String  expectedTextAfterClick2="Please select an address.";
        String actualTexAfterClick2=getMyEventsPage().WarningMessageForAddress.getText();
        Assert.assertEquals("Please select an address.",expectedTextAfterClick2,actualTexAfterClick2);
        waitFor(2);
        String  expectedTextAfterClick3="Please fill this field";
        String actualTexAfterClick3=getMyEventsPage().WarningMessageForDate.getText();
        Assert.assertEquals("Please fill this field",expectedTextAfterClick3,actualTexAfterClick3);
        waitFor(2);
        String  expectedTextAfterClick4="Please fill this field";
        String actualTexAfterClick4=getMyEventsPage().WarningMessageForTime.getText();
        Assert.assertEquals("Please fill this field",expectedTextAfterClick4,actualTexAfterClick4);
        waitFor(2);
        String  expectedTextAfterClick5="Please enter a valid duration.";
        String actualTexAfterClick5=getMyEventsPage().WarningMessageForDuration.getText();
        Assert.assertEquals("Please enter a valid title.",expectedTextAfterClick5,actualTexAfterClick5);
        waitFor(2);
        String  expectedTextAfterClick6="Please enter a valid attendee limit.";
        String actualTexAfterClick6=getMyEventsPage().WarningMessageForAttendeeLimit.getText();
        Assert.assertEquals("Please enter a valid attendee limit.",expectedTextAfterClick6,actualTexAfterClick6);
        waitFor(2);
        String  expectedTextAfterClick7="Please enter valid terms and conditions.";
        String actualTexAfterClick7=getMyEventsPage().WarningMessageForTermsAndConditions.getText();
        Assert.assertEquals("Please enter valid terms and conditions.",expectedTextAfterClick7,actualTexAfterClick7);
    }

    @And("user clicks on GO BACK button")
    public void userClicksOnGOBACKButton() {
        getMyEventsPage().goBackButtonVisibility();
        getMyEventsPage().GoBackButton.click();
    }

    @Then("user verifies that it is navigated to event organize page.")
    public void userVerifiesThatItIsNavigatedToEventOrganizePage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/events-i-organize", driver.getCurrentUrl());
    }

    @Given("The user goes to home page and logs in as a seller")
    public void theUserGoesToHomePageAndLogsInAsASeller() {
        driver.get(ConfigurationReader.getProperty("url"));
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(USER_INFO.SELLER_CREDENTIALS.getEmail(), USER_INFO.SELLER_CREDENTIALS.getPassword());
    }

    @When("The user clicks on My Events subtab")
    public void theUserClicksOnMyEventsSubtab() {
        waitForVisibility(getMyEventsPage().myEventsOnSidebar,5);
        getMyEventsPage().myEventsOnSidebar.click();
    }
}
