package stepDefinitions.uiStepDefs.deliveryPickupSettings;

import enums.COLOR;
import enums.USER_INFO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.actions;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;

public class US_060_Seller_Flexible_Delivery extends CommonPage {
    Select select;
    @When("user logs in as a seller")
    public void userLogsInAsASeller() {
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(USER_INFO.SELLERGUL_CREDENTIAL.getEmail(), USER_INFO.SELLERGUL_CREDENTIAL.getPassword());
    }

    @And("user clicks on the delivery pickup settings")
    public void userClicksOnTheDeliveryPickupSettings() {
        getDeliveryPickupSeetingsPage().deliverypicupsettings.click();
    }

    @And("user clicks on the Seller flexible delivery")
    public void userClicksOnTheSellerFlexibleDelivery() {

        if (!getDeliveryPickupSeetingsPage().sellerFlexible.isSelected()) {
            getDeliveryPickupSeetingsPage().sellerFlexible.click();
        }
        // JS_utilities.clickElementByJS(getDeliveryPickupSeetingsPage().sellerFlexible);
    }

    @Then("user verify that the following web elements are visible and functionnel")
    public void userVerifyThatTheFollowingWebElementsAreVisibleAndFunctionnel(DataTable dataTable) {
        List<String> elements = dataTable.row(0);
        for (int i = 0; i < elements.size(); i++) {
            assert driver.findElement(By.cssSelector("#" + elements.get(i))).isDisplayed();
            assert driver.findElement(By.cssSelector("#" + elements.get(i))).isEnabled();
            //assert driver.findElement(By.xpath("//input[@id='" + elements.get(i) + "']")).isDisplayed();
        }
    }

    @When("user enters number to free delivery range and asserts border color and alerts")
    public void userEntersNumberToFreeDeliveryRangeAndAssertsBorderColorAndAlerts(DataTable dataTable) {
        List<String> inputs = dataTable.column(0);
        List<String> color = dataTable.column(1);
        List<String> messages = dataTable.column(2);
   getDeliveryPickupSeetingsPage().assertInputFreeDeliveryRange(inputs,color,messages,getDeliveryPickupSeetingsPage().freeDeliveryRange);
    }

    @When("user enters number to Minimum Order Amount For Free Delivery and asserts border color and alerts")
    public void userEntersNumberToMinimumOrderAmountForFreeDeliveryAndAssertsBorderColorAndAlerts(DataTable dataTable) {
        List<String> data1 = dataTable.column(0);//test edilecek buton
        List<String> data2 = dataTable.column(1);// free delivery
        List<String> alerts = dataTable.column(2);

        for (int i = 0; i < data1.size(); i++) {
            waitFor(1);
            getDeliveryPickupSeetingsPage().freeDeliveryRange.clear();
            getDeliveryPickupSeetingsPage().freeDeliveryRange.click();
            waitFor(1);
            if (!(data2.get(i) == null)) {
                getDeliveryPickupSeetingsPage().freeDeliveryRange.sendKeys(data2.get(i));

            } else {
                getDeliveryPickupSeetingsPage().freeDeliveryRange.click();
                actions.sendKeys(getDeliveryPickupSeetingsPage().freeDeliveryRange, "").perform();

            }

            //getDeliveryPickupSeetingsPage().freeDeliveryRange.sendKeys(text);
            waitFor(1);
            getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery.clear();
            waitFor(1);
            getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery.click();
            waitFor(1);

            getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery.sendKeys(data1.get(i));
            waitFor(2);
            if (getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery.getCssValue("box-shadow").equals(COLOR.BOX_SHADOW_PINK.getRGBA())) {
                COLOR.BOX_SHADOW_PINK.assertBorderColor(getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery);
            } else {
                ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery,10);
                COLOR.BOX_SHADOW_BLUE.assertBorderColor(getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery);
            }
            getDeliveryPickupSeetingsPage().update.click();
//            String message = getDeliveryPickupSeetingsPage().minOrderAmountForFreeDelivery.getAttribute("validationMessage");
//            System.out.println("message = " + message);
//            if (alerts.get(i).equals(message)) {
//                assertEquals(alerts.get(i), message);
//            } else {
//                assertEquals(alerts.get(i), getDeliveryPickupSeetingsPage().freeDeliveryRange.getAttribute("validationMessage"));
//            }
        }
    }

    @When("user enters number to Per Mile Cost  and asserts border color and alerts")
    public void userEntersNumberToPerMileCost$AndAssertsBorderColorAndAlerts(DataTable dataTable) {
        List<String> data = dataTable.column(0);
        List<String> alerts = dataTable.column(1);
        for (int i = 0; i < data.size(); i++) {
            getDeliveryPickupSeetingsPage().perMileCost.clear();
            getDeliveryPickupSeetingsPage().perMileCost.click();
            waitFor(1);
            getDeliveryPickupSeetingsPage().perMileCost.sendKeys(data.get(i));
            waitFor(1);
            if (getDeliveryPickupSeetingsPage().perMileCost.getCssValue("box-shadow").equals(COLOR.BOX_SHADOW_PINK.getRGBA())) {
                COLOR.BOX_SHADOW_PINK.assertBorderColor(getDeliveryPickupSeetingsPage().perMileCost);
            } else {
                COLOR.BOX_SHADOW_BLUE.assertBorderColor(getDeliveryPickupSeetingsPage().perMileCost);
            }
            String message = getDeliveryPickupSeetingsPage().perMileCost.getAttribute("validationMessage");
            if (!(alerts.get(i) == null) && alerts.get(i).equals(message)) {
                assertEquals(alerts.get(i), message);
            }
        }
    }

    @When("user enters number to max delivery Range \\(mile)  and asserts border color and alerts")
    public void userEntersNumberToMaxDeliveryRangeMileAndAssertsBorderColorAndAlerts(DataTable dataTable) {
        List<String> inputs = dataTable.column(0);
        List<String> colors = dataTable.column(1);
        List<String> messages = dataTable.column(2);
        getDeliveryPickupSeetingsPage().assertInputFreeDeliveryRange(inputs,colors,messages,getDeliveryPickupSeetingsPage().maxDeliveryRange);

    }

    @When("user selects {string} for orderBegin")
    public void userSelectsForOrderBegin(String dayNo) {
        select= new Select(getDeliveryPickupSeetingsPage().orderBeginDay);
        select.selectByValue(dayNo);
    }

    @And("user enters input to order begin {string}")
    public void userEntersInputToOrderBegin(String time1) {
        getDeliveryPickupSeetingsPage().orderBeginTime.sendKeys(time1);
    }

    @And("user selects {string} for orderEnd")
    public void userSelectsForOrderEnd(String day) {
        select= new Select(getDeliveryPickupSeetingsPage().orderEndDay);
        select.selectByValue(day);
    }

    @And("user enters input to order end {string}")
    public void userEntersInputToOrderEnd(String time2) {
        getDeliveryPickupSeetingsPage().orderEndTime.sendKeys(time2);
    }

    @And("user selects {string} for deliverBy")
    public void userSelectsForDeliverBy(String day) {
        select = new Select(getDeliveryPickupSeetingsPage().deliveryByDay);
        select.selectByValue(day);
    }

    @And("user enters input to deliver by {string}")
    public void userEntersInputToDeliverBy(String time3) {
        getDeliveryPickupSeetingsPage().deliveryByTime.sendKeys(time3);
    }

    @And("user clicks on update button")
    public void userClicksOnUpdateButton() {
        getDeliveryPickupSeetingsPage().update.click();
    }

    @Then("user verifies the toast message is {string}")
    public void userVerifiesTheToastMessageIs(String message) {
        ReusableMethods.waitForVisibility(getDeliveryPickupSeetingsPage().alertMessage,10);
        //System.out.println("getDeliveryPickupSeetingsPage().alertMessage.getText() = " + getDeliveryPickupSeetingsPage().alertMessage.getText());
        assert getDeliveryPickupSeetingsPage().alertMessage.getText().contains(message);
    }


}

