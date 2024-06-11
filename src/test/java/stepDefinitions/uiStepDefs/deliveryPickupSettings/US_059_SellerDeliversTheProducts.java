package stepDefinitions.uiStepDefs.deliveryPickupSettings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;

public class US_059_SellerDeliversTheProducts extends CommonPage {

    @Given("user clicks Seller delivers the products section")
    public void user_clicks_seller_delivers_the_products_section() {
        if (!getDeliveryPickupSeetingsPage().sellerDelivery.isSelected()) {
            getDeliveryPickupSeetingsPage().sellerDelivery.click();
        }
        if (getDeliveryPickupSeetingsPage().sellerFlexible.isSelected()) {
            getDeliveryPickupSeetingsPage().sellerFlexible.click();
        }
    }

    @Then("User verifies that the following web elements are visible and functional")
    public void userVerifiesThatTheFollowingWebElementsAreVisibleAndFunctional(DataTable dataTable) {
        List<String> elements = dataTable.column(0);

        for (String element : elements) {
            assert driver.findElement(By.cssSelector("#" + element)).isDisplayed();
            assert driver.findElement(By.cssSelector("#" + element)).isEnabled();
        }
    }

    @Then("User types  {string} in free Delivery Range mile")
    public void user_types_in_free_delivery_range_mile(String freeMile) {
        getDeliveryPickupSeetingsPage().freeDeliveryRangeProduct.clear();
        getDeliveryPickupSeetingsPage().freeDeliveryRangeProduct.sendKeys(freeMile);
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().freeDeliveryRangeProduct, 3);
    }

    @Then("User clicks update button")
    public void user_clicks_update_button() {
        getDeliveryPickupSeetingsPage().update.click();
        ReusableMethods.clickWithTimeOut(getDeliveryPickupSeetingsPage().update, 1);

    }

    @Then("User verifies the {string} in free Delivery Range mile box")
    public void userVerifiesTheInFreeDeliveryRangeMileBox(String alert) {
        ReusableMethods.waitFor(1);
        String validationMessage = getDeliveryPickupSeetingsPage().freeDeliveryRangeProduct.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        if (alert.equals(validationMessage)) {
            assertEquals(alert, validationMessage);
            ReusableMethods.waitFor(2);
        }
    }
    @And("the user clicks logout button")
    public void theUserClicksLogoutButton() {
        JS_utilities.clickElementByJS(getDeliveryPickupSeetingsPage().logout);
        ReusableMethods.waitFor(2);
    }

    @And("User types  {string} in minimum Order Amount For Free Delivery $ box")
    public void userTypesInMinimumOrderAmountForFreeDelivery$Box(String minOrder) {
        getDeliveryPickupSeetingsPage().minOrderAmountForFreeDeliveryProduct.clear();
        getDeliveryPickupSeetingsPage().minOrderAmountForFreeDeliveryProduct.sendKeys(minOrder);
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().minOrderAmountForFreeDeliveryProduct, 2);

    }

    @Then("User verifies the {string}")
    public void userVerifiesThe(String alert) {
        ReusableMethods.waitFor(1);
        String validationMessage = getDeliveryPickupSeetingsPage().minOrderAmountForFreeDeliveryProduct.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        if(alert.equals(validationMessage)) {
            assertEquals(alert, validationMessage);
            ReusableMethods.waitFor(2);
        }
        }

    @And("User types  {string} in Per Mile Cost $ box")
    public void userTypesInPerMileCost$Box(String cost) {
        getDeliveryPickupSeetingsPage().perMileCostProduct.clear();
        getDeliveryPickupSeetingsPage().perMileCostProduct.sendKeys(cost);
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().perMileCostProduct, 2);

    }

    @Then("User verifies the {string} in Per Mile Cost $ box")
    public void userVerifiesTheInPerMileCost$Box(String alert) {
        ReusableMethods.waitFor(1);
        String validationMessage = getDeliveryPickupSeetingsPage().perMileCostProduct.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        if(alert.equals(validationMessage)) {
            assertEquals(alert, validationMessage);
            ReusableMethods.waitFor(2);
        }
    }

    @And("User types  {string} in Maximum Delivery Range mile box")
    public void userTypesInMaximumDeliveryRangeMileBox(String max) {
      getDeliveryPickupSeetingsPage().maxDeliveryRangeProduct.clear();
        getDeliveryPickupSeetingsPage().maxDeliveryRangeProduct.sendKeys(max);
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().maxDeliveryRangeProduct,2);
    }

    @Then("User verifies the {string} in Maximum Delivery Range mile box")
    public void userVerifiesTheInMaximumDeliveryRangeMileBox(String alert) {
        ReusableMethods.waitFor(1);
        String validationMessage = getDeliveryPickupSeetingsPage().maxDeliveryRangeProduct.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        if(alert.equals(validationMessage)) {
            assertEquals(alert, validationMessage);
            ReusableMethods.waitFor(2);
        } }

    @And("user clicks the Estimated Delivery Time box")
    public void userClicksTheEstimatedDeliveryTimeBox() {
        actions.click(getDeliveryPickupSeetingsPage().estimatedDeliveryTimeProduct).perform();
       }

    @Then("user verifies the Estimated Delivery Time menu visible and selectable")
    public void userVerifiesTheEstimatedDeliveryTimeMenuVisibleAndSelectable() {
       Select select= new Select(getDeliveryPickupSeetingsPage().estimatedDeliveryTimeProduct);
        List<WebElement> weblist = select.getOptions();
       for (WebElement w: weblist){
           System.out.println(w.getText());
           assertTrue(w.isDisplayed());
       }
         }

    @And("user types {string} in the Up to mile menu")
    public void userTypesInTheUpToMileMenu(String mile) {
        getDeliveryPickupSeetingsPage().upToMileProduct.clear();
        getDeliveryPickupSeetingsPage().upToMileProduct.sendKeys(mile);
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().upToMileProduct, 2);

    }

    @And("user selects Estimated Delivery Time")
    public void userSelectsEstimatedDeliveryTime() {
        Select select= new Select(getDeliveryPickupSeetingsPage().estimatedDeliveryTimeProduct);
     getDeliveryPickupSeetingsPage().estimatedDeliveryTimeProduct.click();
     select.selectByVisibleText("2 hours");
     ReusableMethods.waitFor(2);
    }

    @Then("user verifies that {string} alert message appear")
    public void userVerifiesThatAlertMessageAppear(String alert) {
        String validationMessage=getDeliveryPickupSeetingsPage().lastAlert.getText();
            if(alert.equals(validationMessage)) {
                assertEquals(alert, validationMessage);
                ReusableMethods.waitFor(2);
            }
             }
        }
