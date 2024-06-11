package stepDefinitions.uiStepDefs.productPage;

import enums.STATE;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import utilities.DB_utilities;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepDefinitions.Hooks.driver;

public class US_061_ActionsInYourProductPage extends CommonPage {
    String eklenecekUrun;

    @And("user logs in as a Buyer")
    public void userLogsInAsASeller() {
        getProductPage().Login();
    }

    @And("user goes to Your products-services")
    public void userGoesToYourProductsServices() {
        JS_utilities.scrollAndClickWithJS(getProductPage().yourProductService_navbar);
    }

    @And("user click on random Hubs")
    public void userClickOnRandomHubs() {
        getProductPage().allhubs.getFirst().click();
        ReusableMethods.waitFor(3);
    }

    @And("user verifies that Product Name, Price, Stock, Unit information  is displayed.")
    public void userVerifiesThatProductNamePriceStockUnitInformationIsDisplayed() {
        getProductPage().assertProductNamePriceStockUnit();
    }

    @And("user verifies that APPROVED, IN_REVIEW, REJECTED options for each product should be visible")
    public void userVerifiesThatAPPROVEDIN_REVIEWREJECTEDOptionsForEachProductShouldBeVisible() {
        getProductPage().allProductsStatus
                .stream()
                .forEach(t -> {
                    assertTrue(
                            t.getText().equals(STATE.APPROVED.name()) ||
                                    t.getText().equals(STATE.IN_REVIEW.name()) ||
                                    t.getText().equals(STATE.REJECTED.name())
                    );
                });
    }

    @And("user add new product")
    public void userAddNewProduct() {
        eklenecekUrun = getProductPage().eklenebilecekUrun();
        getProductPage().addNewProduct_Name.sendKeys(eklenecekUrun);
        getProductPage().addNewProduct_Price.sendKeys("20");
        getProductPage().addNewProduct_Stock.sendKeys("20");

        Select select = new Select(getProductPage().addNewProduct_Unit);
        select.selectByIndex(0);
        JS_utilities.scrollAndClickWithJS(getProductPage().addNewProduct_Submit);
        ReusableMethods.waitFor(2);
    }

    @Then("In-Review should be visible on the added product.")
    public void inReviewShouldBeVisibleOnTheAddedProduct() {
        String actualState = getProductPage().getState(eklenecekUrun);
        String expectedState = STATE.IN_REVIEW.name();
       assertEquals(expectedState, actualState);
    }

    @When("User approve last added product from database")
    public void userApproveLastAddedProductFromDatabase() {
        DB_utilities.approvedLastProduct();
    }

    @Then("Approved should be visible on the added product.")
    public void approvedShouldBeVisibleOnTheAddedProduct() {
        driver.navigate().back();
        ReusableMethods.waitFor(2);
        driver.navigate().forward();
        String actualState = getProductPage().getState(eklenecekUrun);
        String expectedState = STATE.APPROVED.name();
        assertEquals(expectedState, actualState);

    }

    @And("user clicks previously added product name")
    public void userClicksProductName() {
        getProductPage().Clickname();
    }
    @And("user verifies that Update button is visible")
    public void userVerifiesThatUpdateButtonIsVisible() {

        assertTrue(getProductPage().update.isDisplayed());
    }

    @And("user verifies that Delete button is visible")
    public void userVerifiesThatDeleteButtonIsVisible() {
        assertTrue(getProductPage().delete.isDisplayed());
    }

    @And("user verifies that Trade button is functional")
    public void userVerifiesThatTradeButtonIsFunctional() {
        getProductPage().selectCheckBox(getProductPage().organic, true);
    }
    @And("user verifies that Trade description is visible")
    public void tradeDescriptionInputIsVisible() {
        ReusableMethods.verifyElementDisplayed(getProductPage().tradeDescription);
    }
    @And("user sends Selam to Trade input  description")
    public void userSendsSelamToTradeInputDescription() {
        getProductPage().tradeDescription.clear();
        getProductPage().tradeDescription.sendKeys("Selam");
        ReusableMethods.waitFor(2);
    }
    @And("user changes Price,Stocks,Unit type")
    public void userChangesPriceStocksUnitType() {
        getProductPage().price.clear();
        ReusableMethods.waitFor(2);
        getProductPage().price.sendKeys("12", Keys.TAB, "12");
        Select select = new Select(getProductPage().unitType);
        select.selectByVisibleText("Pound");
    }
    @And("user clicks Update button")
    public void userClicksUpdateButton() {
        JS_utilities.clickElementByJS(getProductPage().update);
        ReusableMethods.waitFor(3);
    }
    @Then("user verifies that Updated alert is visible")
    public void userVerifiesThatUpdatedAlertIsVisible() {
        ReusableMethods.waitForVisibility(getProductPage().updatedAlert, 4);
        ReusableMethods.verifyElementDisplayed(getProductPage().updatedAlert);
    }
}
