package stepDefinitions.uiStepDefs.address;

import enums.COLOR;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class US_053_AddressPageEditingAndDeleting extends CommonPage {
    private WebElement expectedEditButton;

    @Then("the user clicks on add New Address button")
    public void theUserClicksOnAddNewAddressButton() {
        getAddressPage().addNewAddressButton2.click();
    }

    @And("the user write address in the Search Place section.")
    public void theUserWriteAddressInTheSearchPlaceSection() {
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("Troy,Ny"+Keys.SPACE+Keys.ENTER);
        getAddressPage().zipCode.sendKeys("12180");
        ReusableMethods.waitFor(3);
    }

    @Then("clicks Submit button")
    public void clicksSubmitButton() {
       // ReusableMethods.waitForVisibility(getAddressPage().submitButton2, 1);
        JS_utilities.clickElementByJS(getAddressPage().submitButton);

    }

    @Then("the user clicks the My Sales Address button")
    public void the_user_clicks_the_my_sales_address_button() {
       // getAddressPage().mySalesAddressButton.click();
        //actions.click(getAddressPage().mySalesAddressButton).perform();
        //ReusableMethods.waitForVisibility(getAddressPage().mySalesAddressButton,2);
        JS_utilities.clickElementByJS(getAddressPage().mySalesAddressButton);
        //ReusableMethods.waitFor(4);

    }

    @Then("Assert the {string}")
    public void assert_the(String expectedMessage) {
       // ReusableMethods.waitForVisibility(getAddressPage().alerts, 3);
        Assert.assertEquals(expectedMessage , getAddressPage().alerts.getText());
    }

    @Then("user clicks on the Other button")
    public void user_clicks_on_the_other_button() {
       // getAddressPage().othersButton.click();
        JS_utilities.clickElementByJS(getAddressPage().othersButton);

    }

//    @Then("user assert the Edit and Remove button is operational.")
//    public void user_assert_the_edit_and_remove_button_is_operational() {
//        Assert.assertEquals(getAddressPage().expectedEditButton,expectedEditButton);
//        }
    @And("user assert the {string} button is operational.")
    public void userAssertTheButtonIsOperational(String expectedEditButton) {
        Assert.assertEquals(expectedEditButton, getAddressPage().editButton.getText());
    }



    @Then("the user clicks the Mark as a sales address.")
    public void the_user_clicks_the_mark_as_a_sales_address() {
//        getAddressPage().editButton.click();
//        getAddressPage().markAsASalesAddress.click();
//        getAddressPage().submitButton.click();

        JS_utilities.clickElementByJS(getAddressPage().editButton);
        JS_utilities.clickElementByJS(getAddressPage().markAsASalesAddress);
        JS_utilities.clickElementByJS(getAddressPage().submitButton);


    }

    @And("Assert {string} alert.")
    public void assertAlert(String expectedAlert) {
        ReusableMethods.waitForVisibility(getAddressPage().toastAlert, 10);
        Assert.assertEquals(expectedAlert , getAddressPage().toastAlert.getText());
    }



    @Given("the user clicks the My Sales Address button.")
    public void the_user_clicks_the_my_sales_address_buttonA() {
        getAddressPage().mySalesAddressButton.click();
    }

    @And("Assert the {string} alert.")
    public void assertTheAlert(String expectedNote) {
        ReusableMethods.waitForVisibility(getAddressPage().removeButton, 10);
        Assert.assertEquals(expectedNote , getAddressPage().removeButton.getText());
    }

    @Then("user clicks the No option and turn back to My Sales Address page.")
    public void user_clicks_the_no_option_and_turn_back_to_my_sales_address_page() {
        getAddressPage().noButton.click();
        Assert.assertEquals("Rensselaer County / Troy",driver.getTitle());

    }

    @And("the user clicks on the Other button")
    public void theUserClicksOnTheOtherButton() {
        getAddressPage().othersButton.click();
    }

    @Then("the user clicks Yes button.")
    public void the_user_clicks_yes_button() {
        getAddressPage().yesButton.click();

    }

    @And("user verifies the {string} alert.")
    public void userVerifiesTheAlert(String expectedDeletedToast) {
        ReusableMethods.waitForVisibility(getAddressPage().deletedToastAlert, 10);
        Assert.assertEquals(expectedDeletedToast , getAddressPage().deletedToastAlert.getText());


    }



}
