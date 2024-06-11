package stepDefinitions.uiStepDefs.address;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import java.util.List;
import static org.junit.Assert.*;
import static stepDefinitions.Hooks.*;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;


public class US_052_AddressSection extends CommonPage {

    @When("user clicks Address")
    public void user_clicks_addressin() {
        ReusableMethods.waitForVisibility(getAddressPage().address1,10);
        getAddressPage().address1.click();

    }

    @When("the user clicks only on Add New Address button and enter a city1")
    public void the_user_clicks_only_on_add_new_address_button_and_enter_a_city1() {


        getAddressPage().addNewAddressButton.click();
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("walmart");
        ReusableMethods.waitFor(3);
        getAddressPage().walmart.click();

    }
    @When("remove")
    public void remove() {
        getAddressPage().othersHeader.click();
        waitFor(3);
        JS_utilities.scrollToBottom();
        waitFor(2);
        actions.moveToElement(getAddressPage().removeButton2).build().perform();
        waitFor(3);
        actions.doubleClick(getAddressPage().removeButton2).build().perform();
        ReusableMethods.waitFor(2);
        getAddressPage().yesButton.click();
        waitFor(8);
    }
    @When("the user clicks only on Add New Address button and enter a city")
    public void the_user_clicks_only_on_add_new_address_button_and_enter_a_city() {

        waitFor(8);;
        JS_utilities.scrollAndClickWithJS(getAddressPage().addNewAddressButton);
        ReusableMethods.waitForVisibility(getAddressPage().searchPlacesButton,3);
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("walmart");
        getAddressPage().walmart.click();
        ReusableMethods.waitFor(5);
        getAddressPage().markAsASellerAddressCheckBox.click();
        ReusableMethods.waitFor(5);
        getAddressPage().submitButton.click();
    }

    @Then("user verifies that the following web elements are visible and functional")
    public void userVerifiesThatTheFollowingWebElementsAreVisibleAndFunctional(DataTable datatable) {
        List<String>elements=datatable.row(0);
        for(int i=0;i< elements.size();i++){
            assert driver.findElement(By.cssSelector("#" + elements.get(i))).isDisplayed();
            assert driver.findElement(By.cssSelector("#" + elements.get(i))).isEnabled();
            assert driver.findElement(By.xpath("//button[@type='"+elements.get(i)+"']")).isEnabled();
            assert driver.findElement(By.xpath("//button[@type='"+elements.get(i)+"']")).isDisplayed();
        }
    }

    @Then("user verifies that the following web elements are not functional")
    public void userVerifiesThatTheFollowingWebElementsAreNotFunctional(DataTable dataTable) {
        List<String> elements=dataTable.row(0);
        for (int i = 0; i < elements.size() ; i++) {
          assertTrue(driver.findElement(By.cssSelector("#"+elements.get(i))).isDisplayed());

        }
    }

    @Then("verify input home,office etc. in Adress Title")
    public void verify_input_home_office_etc_in() {
        getAddressPage().inputAddressTitle.clear();
        getAddressPage().inputAddressTitle.sendKeys("Office");
    }
    @Then("verify input an adress in Address")
    public void verify_input_an_adress_in_address() {
        getAddressPage().inputAddress.clear();
        getAddressPage().inputAddress.sendKeys("ny,ny");
    }

    @Then("verify input a postalzip in PostalZip")
    public void verify_input_a_postal_zip_in_postal_zip() {
        assertTrue(getAddressPage().inputPostalZip.isEnabled());
        getAddressPage().inputPostalZip.clear();
        getAddressPage().inputPostalZip.sendKeys("07026");
    }
    @Then("verify title as State is not enabled")
    public void verify_title_as_state_is_not_enabled() {

        getAddressPage().assertBackroundColor(getAddressPage().states,"rgba(233, 236, 239, 1)");
    }
    @Then("verify title as City is not enabled")
    public void verify_title_as_city_is_not_enabled() {
        getAddressPage().assertBackroundColor(getAddressPage().city,"rgba(233, 236, 239, 1)");
    }

    @Then("verify titles")
    public void verifyTitles(DataTable dataTable) {
        List<String> elements = dataTable.row(0);
        for (int i = 0; i < elements.size(); i++) {

            assert driver.findElement(By.xpath("//label[text()='" + elements.get(i) + "']")).isDisplayed();

        }
    }
    @And("check off Mark as a delivery address")
    public void checkOffMarkAsADeliveryAddress() {
       // ReusableMethods.waitForVisibility(getAddressPage().markAsADeliveryAddressButton,3);
//        waitFor(5);
        getAddressPage().markAsADeliveryAddressCheckBox.click();
    }
        @And("clicks on the Submit button1")
    public void clicksOnTheSubmitButton1() {
        getAddressPage().submitButton.click();
    }

    @Then("verify address in relevant section for delivery")
    public void verify_address_in_relevant_section_for_delivery() {
        getAddressPage().myDeliveryAddressHeader.click();
        String  expectedTextAfterClick="ADDRESSES";
        String actualTexAfterClick=getAddressPage().relevantAddressPagetxt.getText();
        assertEquals("There is a mistake",expectedTextAfterClick,actualTexAfterClick);
    }

    @Then("verify address in relevant section for sales")
    public void verify_address_in_relevant_section_for_sales() {
        getAddressPage().mySalesAddressHeader.click();
        String  expectedTextAfterClick="My sales address";
        String actualTexAfterClick=getAddressPage().relevantAddressPagetxtsales.getText();
        assertEquals("There is a mistake",expectedTextAfterClick,actualTexAfterClick);
    }
    @Then("the user clicks on the Remove button in the My Delivery Adress")
    public void the_user_clicks_on_the_remove_button_in_the_My_Delivery_Adress() {
        waitForVisibility(getAddressPage().myDeliveryAddressHeader, 5);
        getAddressPage().myDeliveryAddressHeader.click();

        if(!getAddressPage().removeButton2.isDisplayed()) {
//            waitForVisibility(getAddressPage().myDeliveryAddressHeader, 5);
//            getAddressPage().myDeliveryAddressHeader.click();
            waitFor(3);
            JS_utilities.scrollToBottom();
            waitForVisibility(getAddressPage().removeButton2, 3);
            getAddressPage().removeButton2.click();
            waitForVisibility(getAddressPage().yesButton, 3);
            actions.click(getAddressPage().yesButton).perform();
        }else{
            System.out.println("hello");

        }
    }
    @Then("verify the {string} should appear in address page")
    public void verifyTheShouldAppearInAddressPage(String expectedmsg) {
        waitForVisibility(getAddressPage().toastmsg,8);
        String actualTexAfterClick=getAddressPage().toastmsg.getText();
        assertEquals(expectedmsg,actualTexAfterClick);
    }

    @And("check off Mark as a sales address")
    public void checkOffMarkAsASalesAddress() {

        waitForVisibility(getAddressPage().markAsASellerAddressCheckBox,3);
        getAddressPage().markAsASellerAddressCheckBox.click();
    }

    @And("user enters a zipcode")
    public void userEntersAZipcode() {
        getAddressPage().inputPostalZip.sendKeys("07013");
    }

}




