package stepDefinitions.uiStepDefs.events;

import com.github.javafaker.Faker;
import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class US_078_AttenToEvents extends CommonPage {

    @And("user creates a new event Dilek")
    public void userCreatesANewEventDilek() {
        getMyEventsPage().createEventDilek();
    }

    @And("user closes the window")
    public void userClosesTheWindow() {
        driver.close();

    }

    @And("user logs in with a BuyerOmer")
    public void userLogsInWithABuyerOmer() {
        getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());
    }
    @And("user clicks on Event")
    public void userClicksOnEvent() {
        ReusableMethods.waitForVisibility(getEventsPage().eventButton,5);
                getEventsPage().eventButton.click();
        ReusableMethods.waitForClickability(getEventsPage().eventButton,4);

    }

    @When("user clicks register button in the event at Scheduled Events")
    public void userClicksRegisterButtonInTheEventAtScheduledEvents() {
    getEventsPage().registerBtn.click();
    }


    @And("user sends number in number of attendee")
    public void userSendsNumberInNumberOfAttendee() {
        ReusableMethods.waitForVisibility(getEventsPage().NumberOfAttendees,3);
        getEventsPage().NumberOfAttendees.clear();
        getEventsPage().NumberOfAttendees.sendKeys("3");
        ReusableMethods.waitFor(4);
        ReusableMethods.waitForVisibility(getEventsPage().NumberOfAttendees,3);
    }

    @And("user clicks Terms and conditions box approve button")
    public void userClicksTermsAndConditionsBoxApproveButton() {
        ReusableMethods.waitForVisibility(getEventsPage().checkBoxTerms,3);
        actions.click(getEventsPage().checkBoxTerms).perform();
        ReusableMethods.waitFor(3);
    }
    @And("user clicks Approve button")
    public void userClicksApproveButton() {
        ReusableMethods.waitForVisibility(getEventsPage().approveButton,1);
        getEventsPage().approveButton.click();
    }

    @Then("user verifies the message {string}")
    public void userVerifiesTheMessage(String message) {
        String confirmValidationMessage =  getEventsPage().approveButton.getAttribute("validationMessage");
        if(message.equals(confirmValidationMessage)) {
            assertEquals(message, confirmValidationMessage);
            ReusableMethods.waitFor(2);
        }
    }


    @Given("User goes to relevant dilek event and clicks on Delete button")
    public void userGoesToRelevantDilekEventAndClicksOnDeleteButton() {
        driver.navigate().refresh();
        getMyEventsPage().deleteDilekEvent();

    }
}
