package stepDefinitions.uiStepDefs.address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_054_DeliveryAddress extends CommonPage {
    @Given("user clicks on the address button")
    public void userClicksOnTheAddressButton() {
        getAddressPage().adressButton.click();

    }

    @When("the user clicks on Add New Address button")
    public void theUserClicksOnAddNewAddressButton() {
        ReusableMethods.waitFor(2);
        getAddressPage().addNewAddressButton.click();
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("Loughborough");
        getAddressPage().myAddressButton.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.selectCheckBox(getAddressPage().markAsADeliveryAddressButton, true);
        // ReusableMethods.selectCheckBox(getAddressPage().markAsADeliveryAddressButton,false);
        // clickElementByJS(getAddressPage().markAsADeliveryAddressButton);
        //getAddressPage().markAsADeliveryAddressButton.click();
        getAddressPage().submitButton.click();


    }

    @And("the user clicks on the Edit button in the Delivery Address section")
    public void theUserClicksOnTheEditButtonInTheDeliveryAddressSection() {
        ReusableMethods.waitFor(2);
        getAddressPage().editButton.click();
    }

    @And("updates the address details")
    public void updatesTheAddressDetails() {
        getAddressPage().UpdatesAddressDetailsButton.sendKeys("Office");

    }

    @And("clicks on the Submit button")
    public void clicksOnTheSubmitButton() {
        getAddressPage().submitButton.click();
    }

    @Then("user verifies the success alert {string} should appear")
    public void userVerifiesTheSuccessAlertShouldAppear(String expectedAlert) {
        Assert.assertEquals("Your Address successfully updated", expectedAlert);
    }

    @When("the user clicks on the Remove button in the Delivery Address section")
    public void theUserClicksOnTheRemoveButtonInTheDeliveryAddressSection() {
        getAddressPage().removeButton.click();
    }

    @Then("a confirmation dialog with the message {string} should appear")
    public void aConfirmationDialogWithTheMessageShouldAppear(String message) {
        Assert.assertEquals("Are you sure to delete the address?", message);
        //Assert.assertEquals("Are you sure to delete the address?",driver.getTitle);
    }

    @When("the user selects the No option")
    public void theUserSelectsTheNoOption() {
        getAddressPage().noButton.click();
    }

    @And("the address should still be displayed")
    public void theAddressShouldStillBeDisplayed() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/address", driver.getCurrentUrl());
    }

    @When("the user clicks on the Remove button in the Delivery Address section again")
    public void theUserClicksOnTheRemoveButtonInTheDeliveryAddressSectionAgain() {
        getAddressPage().removeAgainButton.click();
        ReusableMethods.waitFor(2);
    }

    @When("the user selects the Yes option")
    public void theUserSelectsTheYesOption() {
        getAddressPage().yesButton.click();
        //ReusableMethods.selectCheckBox(getAddressPage().yesButton,true);
        //clickElementByJS(getAddressPage().yesButton);

    }

    @And("a success alert saying {string} should appear")
    public void aSuccessAlertSayingShouldAppear(String message) {
        //Assert.assertTrue(getAddressPage().successAlertButton2.isDisplayed());
        //Assert.assertEquals("Address deleted",driver.getTitle());

            Assert.assertEquals("Address deleted", message);

        }

    }
