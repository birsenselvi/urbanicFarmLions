package pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ReusableMethods;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;

public class DeliveryPickupSeetingsPage extends CommonPage{

    @FindBy(linkText = "Delivery & Pick up settings")
    public WebElement deliverypicupsettings;
    @FindBy (xpath = "//input[@id='SELLER_FLEXIBLE']")
    public WebElement sellerFlexible;
    @FindBy(css = "#freeFlexibleDeliveryRange")
    public WebElement freeDeliveryRange;

    @FindBy(css="#freeDeliveryRange")
    public WebElement freeDeliveryRangeProduct;

    @FindBy(css = "#minFreeFlexibleDeliveryOrder")
    public WebElement minOrderAmountForFreeDelivery;
    @FindBy( css="#minFreeDeliveryOrder")
    public WebElement minOrderAmountForFreeDeliveryProduct;

    @FindBy(css = "#perMileCostFlex")
    public WebElement perMileCost;

    @FindBy(css="#perMileCost")
    public WebElement perMileCostProduct;

    @FindBy(css = "#maxFlexibleDeliveryRange")
    public WebElement maxDeliveryRange;
    @FindBy(css="#maxDeliveryRange")
    public WebElement maxDeliveryRangeProduct;

    @FindBy(css="#estimatedDeliveryTime")
    public WebElement estimatedDeliveryTimeProduct;

    @FindBy(css="#providingDistance")
    public WebElement upToMileProduct;

    @FindBy(css = "[type='submit']")
    public WebElement update;

    @FindBy(xpath="//div[@class='Toastify']")
    public WebElement updateAlert;

    @FindBy(xpath = "//a[@class='Navbar_textLink__f6_Al ml-2 mr-4']")
    public WebElement logout;

    @FindBy(css = "#_deliveryBeginDay")
    public WebElement orderBeginDay;
    @FindBy(css = "#_deliveryBeginTime")
    public WebElement orderBeginTime;
    @FindBy(css = "#_deliveryEndDay")
    public WebElement orderEndDay;
    @FindBy(css = "#_deliveryEndTime")
    public WebElement orderEndTime;
    @FindBy(css = "#_orderByDay")
    public WebElement deliveryByDay;
    @FindBy(css = "#_orderByTime")
    public WebElement deliveryByTime;

    @FindBy (xpath = "//input[@id='SELLER_DELIVERY']")
    public WebElement sellerDelivery;

    @FindBy(css = "#BUYER_PICKUP_FROM_BRANCH")
    public WebElement buyerPicksUpOnTheVineButton;

    @FindBy(css = "#startTime2")
    public WebElement startTimeOnTheFirstLine;

    @FindBy(css = "#endTime2")
    public WebElement endTimeOnTheFirstLine;

    @FindBy(css = ".custom-control-input.DeliverySettings_regular-checkbox__1gkSd")
    public List<WebElement> clickableButtons;

    @FindBy(css = "div>[role=\"alert\"]")
    public WebElement alertMessage;

    @FindBy(css = ".Toastify__toast-body.toastr_custom-toastr__iiU37")
    public WebElement lastAlert;


    @FindBy(css = "button.Toastify__close-button")
    public WebElement toastifyCloseButton;

    // for Hatice's steps
    public void loginAndGoToTheDeliveryPickUpSettingsPage(String email,String password){
        getHomePage().loginButton.click();
        getLoginPage().email_Text.sendKeys(email);
        getLoginPage().password_Text.sendKeys(password);
        getLoginPage().submitButton.click();
        ReusableMethods.waitForVisibility(getLoginPage().zipcodeGo,5);
        getLoginPage().zipcodeInput.sendKeys("95170");
        getLoginPage().goButton.click();
        deliverypicupsettings.click();
    }

    public void clickBuyerPicksUpOnTheVineButton() {
        for (WebElement button : clickableButtons) {
            if (button.equals(buyerPicksUpOnTheVineButton) && !(buyerPicksUpOnTheVineButton.isSelected())) {
                buyerPicksUpOnTheVineButton.click();
            } else if (!button.equals(buyerPicksUpOnTheVineButton) && button.isSelected()) {
                button.click();
            }
        }
    }

    public void assertIsClickablePicksUpOnTheVineButton() {
        clickBuyerPicksUpOnTheVineButton();
        Assert.assertTrue(buyerPicksUpOnTheVineButton.isSelected());
    }


    public void assertIsVisibleAndFunctionalYourAvailableHoursMenu(String startTime, String endTime) {
        chooseStartAndEndTime(startTime,endTime);
        Assert.assertEquals(startTime, startTimeOnTheFirstLine.getAttribute("value"));
        Assert.assertEquals(endTime, endTimeOnTheFirstLine.getAttribute("value"));
    }

    public void chooseStartAndEndTime(String startTime,String endTime){
        clickBuyerPicksUpOnTheVineButton();
        startTimeOnTheFirstLine.sendKeys(startTime);
        endTimeOnTheFirstLine.sendKeys(endTime);
    }

    public void clickUpdateButton(){
        update.click();
    }

    public void assertAvailableHoursCanBeSelectedFromTheMenu(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps();
        for (int i = 0; i < maps.size(); i++) {
            String startTime = maps.get(i).get("StartTime");
            String endTime = maps.get(i).get("EndTime");
            String alertMessage = maps.get(i).get("AlertMessage");

            waitForVisibility(getDeliveryPickupSeetingsPage().startTimeOnTheFirstLine, 7).sendKeys(startTime);
            waitForVisibility(getDeliveryPickupSeetingsPage().endTimeOnTheFirstLine, 7).sendKeys(endTime);
            getDeliveryPickupSeetingsPage().clickUpdateButton();
            waitForVisibility(getDeliveryPickupSeetingsPage().alertMessage, 5);
            assertEquals(alertMessage, getDeliveryPickupSeetingsPage().alertMessage.getText());

            if (getDeliveryPickupSeetingsPage().alertMessage.isDisplayed()) {
                getDeliveryPickupSeetingsPage().toastifyCloseButton.click();
                waitFor(2);
            }
        }
    }



    public void assertInputFreeDeliveryRange(List<String> a,List<String> b,List<String> c,WebElement webElement){

        for (int i = 0; i < a.size(); i++) {
            webElement.clear();
            webElement.click();
            waitFor(1);
            webElement.sendKeys(a.get(i));
            waitFor(1);
            String rgba = webElement.getCssValue("box-shadow");
            String actuelMessage = webElement.getAttribute("validationMessage");
            assertEquals(b.get(i), rgba);
            if ((c.get(i) != null) && c.get(i).equals(actuelMessage)) {
                assertEquals(c.get(i), actuelMessage);

            }
        }
    }








}
