package stepDefinitions.uiStepDefs.welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.DB_utilities;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import java.util.List;

import static stepDefinitions.Hooks.*;
import static utilities.ReusableMethods.waitFor;

public class US_071_WelcomepagepromoCode extends CommonPage {

    double toplam = 0;
    double subtotal = 0;

    @Given("delete used promocode")
    public void deleteUsedPromocode() {
        DB_utilities.deleteUsedPromoCode();
    }

    @When("user logs in as buyer")
    public void userLogsInAsBuyer() {
        ReusableMethods.waitForVisibility(getLoginPage().loginButton, 5);
        getLoginPage().loginButton.click();
        getLoginPage().loginMethod(ConfigurationReader.getProperty("email2"), ConfigurationReader.getProperty("password2"));
    }

    @And("Cart empty")
    public void cartEmpty() {
        if (!getHomePage().go_to_cart_button.getText().equals("0")) {
            getHomePage().go_to_cart_button.click();
            waitFor(2);

            while (!getHomePage().go_to_cart_button.getText().equals("0")) {

                getWelcomePage().removeProductFromCart.get(0).click();
                waitFor(2);
                actions.sendKeys(Keys.TAB, Keys.ENTER).perform();
                waitFor(2);
            }
            driver.navigate().back();
            waitFor(2);
        }
    }

    @And("Add product to cart")
    public void addProductToCart() {
        getWelcomePage().urbanicFarmIcon.click();
        List<WebElement> addToCart = getWelcomePage().addToCartBtnList;
        for (int i = 6; i < addToCart.size(); i++) {
            getWelcomePage().addToCartBtnList.get(i).click();
        }
    }

    @And("user calcule total and subtotal")
    public void userCalculeTotalAndSubtotal() {
        waitFor(2);
        ReusableMethods.waitForVisibility(getWelcomePage().cartTotal_total, 20);
        toplam = Double.parseDouble(getWelcomePage().cartTotal_total.getText().substring(1));
        System.out.println("toplam = " + toplam);
        waitFor(2);
        ReusableMethods.waitForVisibility(getWelcomePage().cartTotal_subtotal, 20);
        subtotal = Double.parseDouble(getWelcomePage().cartTotal_subtotal.getText().substring(1));
        System.out.println("subtotal = " + subtotal);
    }

    @Then("Enter promo code menu should be functional")
    public void enterPromoCodeMenuShouldBeFunctional() {

        ReusableMethods.waitForClickability(getWelcomePage().enterPromoCode_button, 10);
        JS_utilities.clickElementByJS(getWelcomePage().enterPromoCode_button);
        ReusableMethods.waitForVisibility(getWelcomePage().enterPromoCode_apply, 10);
        Assert.assertTrue(getWelcomePage().enterPromoCode_apply.isDisplayed());
    }

    @When("Code enter in the Enter {string} menu")
    public void codeEnterInTheEnterMenu(String promocode) {

        ReusableMethods.waitForClickability(getWelcomePage().enterPromoCode_text, 20);
        getWelcomePage().enterPromoCode_text.sendKeys(promocode);
        waitFor(5);
    }

    @And("Click the Apply button.")
    public void clickTheApplyButton() {
        ReusableMethods.waitForClickability(getWelcomePage().enterPromoCode_apply, 10);
        JS_utilities.clickElementByJS(getWelcomePage().enterPromoCode_apply);
    }

    @Then("assert toast message {string} if it is {string}")
    public void assertToastMessageIfItIs(String expectedToastMessage, String valid) {
        if (!Boolean.parseBoolean(valid)) {
            ReusableMethods.waitForVisibility(getWelcomePage().toastMessage, 10);
            String actualToastMesaj = getWelcomePage().toastMessage.getText();
            System.out.println("actualToastMesaj = " + actualToastMesaj);
            Assert.assertEquals(expectedToastMessage, actualToastMesaj);
        }
    }

    @Then("After the code is entered, the code rate should give results has {string} and amount is {string} if it is {string}")
    public void afterTheCodeIsEnteredTheCodeRateShouldGiveResultsHasAndAmountIsIfItIs(String type, String amount, String valid) {
        waitFor(2);
        double total = Double.parseDouble(getWelcomePage().cartTotal_total.getText().substring(1));
        System.out.println("total = " + total);

        if (type.equals("money") && Boolean.parseBoolean(valid)) {

            Assert.assertEquals(toplam - Double.parseDouble(amount), total, 0.1);
        }  else if(type.equals("percentage")) {
            waitFor(1);
            double actuelSubTotal = Double.parseDouble(getWelcomePage().cartTotal_subtotal2.getText().substring(1));
            System.out.println("actuelSubTotal = " + actuelSubTotal);
            Assert.assertEquals(subtotal * (1 - Double.parseDouble(amount) * 0.01), actuelSubTotal, 0.1);
        }
    }

    @Then("proceed from the Proceed to checkout button and complete the payment.")
    public void proceedFromTheProceedToCheckoutButtonAndCompleteThePayment() {
        if(!getWelcomePage().toastMessage.isDisplayed()){

        }
    }
}


