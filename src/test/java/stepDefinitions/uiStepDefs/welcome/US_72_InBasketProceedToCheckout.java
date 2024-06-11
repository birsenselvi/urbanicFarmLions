package stepDefinitions.uiStepDefs.welcome;

import enums.USER_INFO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US_72_InBasketProceedToCheckout extends CommonPage {

    @And("user add product to the cart")
    public void userAddProductToTheCart() {
        JS_utilities.clickElementByJS(getWelcomePage().addToCartList.getFirst());

    }

    @When("user clicks Proceed to checkout button")
    public void userClicksProceedToCheckoutButton() {
        JS_utilities.clickElementByJS(getWelcomePage().proceedToCheckout);
        ReusableMethods.waitFor(2);
    }

    @And("user enters first name")
    public void userEntersFirstName() {
        getWelcomePage().firstname.clear();
        getWelcomePage().firstname.sendKeys("Shems", Keys.TAB, "Umarli", Keys.TAB, "+14053659712");
    }

    @And("user clicks Next button and verifies that give correct result")
    public void userClicksNextButtonAndGetProceedStepTexts() {
        getWelcomePage().clickNextAndVerifyReviewAndAddress(2);
        ReusableMethods.waitFor(3);
    }

    @Then("user clicks Prev button and verifies that give correct result")
    public void userClicksPrevButtonAndGetProceedStepTexts() {
        getWelcomePage().clickPrevAndVerifyReviewAndAddress(2);
        ReusableMethods.waitFor(5);
    }

    @When("user clicks Go to Payment for entering Payment information")
    public void userClicksGoToPayment() {
        JS_utilities.clickElementByJS(getWelcomePage().goToPayment);
        ReusableMethods.waitFor(5);
    }

    @When("user clicks login button for going to Paypall")
    public void userClicksLoginButtonForGoingToPaypall() {
        ReusableMethods.switchToWindow(1);
        try {
            JS_utilities.scrollAndClickWithJS(getWelcomePage().loginForLoginPaypal);
            ReusableMethods.waitFor(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @And("user clicks LoginPaypall")
    public void userClicksLoginPaypall() {

        JS_utilities.clickElementByJS(getWelcomePage().loginPaypal);
    }

    @And("user enters Email")
    public void userEntersEmail() {
        getWelcomePage().clearEmailField();
        getWelcomePage().emailPaypal.sendKeys(USER_INFO.PAYPAL_CREDENTIAL.getEmail());
    }

    @And("user enters password")
    public void userEntersPassword() {
        getWelcomePage().passwordPaypal.sendKeys(USER_INFO.PAYPAL_CREDENTIAL.getPassword());
    }

    @Then("user clicks loginButton")
    public void userClicksLoginButton() {
        JS_utilities.clickElementByJS(getWelcomePage().loginButton);

    }

    @Then("user completes purchase")
    public void userCompletesPurchase() {
        JS_utilities.scrollAndClickWithJS(getWelcomePage().completePurchase);
        ReusableMethods.waitFor(3);

    }

    @Then("user verifies that Payment successful is displayed")
    public void userVerifiesThatPaymentSuccessfulIsDisplayed() {
        ReusableMethods.switchToWindow(0);
        ReusableMethods.verifyElementDisplayed(getWelcomePage().paymentSuccessfull);
    }

    @When("user clicks Rate Our Service")
    public void userClicksRateOurService() {
        getWelcomePage().rateOurServices.click();

    }

    @And("user clicks stars")
    public void clicksStars() {
        getWelcomePage().clickStars();
    }

    @Then("clicks submit button")
    public void clicksSubmitButton() {

        JS_utilities.scrollAndClickWithJS(getWelcomePage().submitStar);
    }

    @When("user enters to the Order Detail Page")
    public void userClicksViewOrderDetail() {

        JS_utilities.clickElementByJS(getWelcomePage().viewOrderDetail);
    }

    @And("user clicks last added customer name and verifies that order detail is visible")
    public void clicksLastAddedCustomerNameAndVerifiesThatOrderDetailIsVisible() {
        JS_utilities.clickElementByJS(getWelcomePage().ordererName.getFirst());
        assertTrue("orderDetail listesinin ilk elementi görünür olmalıdır", getWelcomePage().orderDetail.getFirst().isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("user verifies that the status of the orders-In Progress-On Delivery-Completed are visible")
    public void userVerifiesThatTheStatusOfTheOrdersInProgressOnDeliveryCompletedAreVisible() {
        ReusableMethods.verifyElementDisplayed(getWelcomePage().orderStatus.getFirst());
    }

    @Then("user verifies that last added product is visible in buyer account")
    public void userVerifiesThatLastAddedProductIsVisibleInBuyerAccount() {
        ReusableMethods.verifyElementDisplayed(getWelcomePage().lastOrderDetail.getFirst());
    }

    @Then("user clicks last added order detail and verifies that last delivery info is visible")
    public void userClicksLastAddedOrderDetailAndVerifiesThatLastDeliveryInfoIsVisible() {
        JS_utilities.clickElementByJS(getWelcomePage().lastOrderDetail.getFirst());
        String CurrentText = "Your order is being prepared";
        assertTrue(getWelcomePage().deliveryInfo.getFirst().getText().contains(CurrentText));
    }

    @Then("user marks all notifications as read and get current notification count")
    public void userMarksAllNotificationsAsReadAndGetCurrentNotificationCount() {
        JS_utilities.clickElementByJS(getWelcomePage().markAsRead);
        JS_utilities.clickElementByJS(getWelcomePage().closeNotification);

    }

    @Then("user verifies that as a result of orders the number in the notifications button increases")
    public void userVerifiesThatAsAResultOfOrdersTheNumberInTheNotificationsButtonIncreases() {
        ReusableMethods.waitFor(5);
        int updatedNotificationCount = Integer.parseInt(getWelcomePage().notificationNumber.getText());
        assert updatedNotificationCount == 1 : "Notification count did not increase.";

    }
}

