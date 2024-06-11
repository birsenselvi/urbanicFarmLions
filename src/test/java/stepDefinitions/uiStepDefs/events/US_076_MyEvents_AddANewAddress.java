package stepDefinitions.uiStepDefs.events;

import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;


public class US_076_MyEvents_AddANewAddress extends CommonPage {

    @Given("user clicks My Events button")
    public void userClicksMyEventsButton() {
        JS_utilities.clickElementByJS(getEventsPage().myEventsButton);

    }

    @Then("user clicks Create New Event button")
    public void userClicksCreateNewEventButton() {
        getEventsPage().createNewEvent.click();
    }

    @And("user enter a Title")
    public void userEnterATitle() {
        getEventsPage().title.sendKeys("Orange Festival");

    }

    @Then("user clicks on Add button")
    public void userClicksOnAddButton() {
        getEventsPage().addButton.click();
    }

    @Then("user enter an Address and click Enter")
    public void userEnterAnAddressAndClickEnter() {
        getEventsPage().searchPlacesBox.sendKeys("Troy,Ny"+ Keys.SPACE+Keys.ENTER);
    }

    @Then("user enter a zipcode")
    public void userEnterAZipcode() {
        getEventsPage().zipCode.sendKeys("12180");
    }

    @And("user clicks Submit button")
    public void userClicksSubmitButton() {
        getEventsPage().submitButton.click();
    }

//    @And("user verifies {string}")
//    public void userVerifies(String expectedAlert) {
//        Assert.assertEquals(expectedAlert, getEventsPage().toastAlert.getText());
//        Assert.assertEquals("Your address successfully added",getEventsPage().toastAlert.getText());


    }

