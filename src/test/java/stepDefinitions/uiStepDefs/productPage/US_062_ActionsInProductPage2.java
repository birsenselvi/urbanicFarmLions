package stepDefinitions.uiStepDefs.productPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;

public class US_062_ActionsInProductPage2 extends CommonPage {
    int eskiBoyut;

    @When("user proceeds forward, retrieves the count of products in the list, then returns back")
    public void userProceedsForwardRetrievesTheCountOfProductsInTheListThenReturnsBack() {
        driver.navigate().back();
        ReusableMethods.waitFor(2);
        eskiBoyut = getProductPage().eklenmisUrunlerinIsimleri.size();
        driver.navigate().forward();
    }

    @When("user clicks Delete button")
    public void userClicksDeleteButton() {
        JS_utilities.clickElementByJS(getProductPage().delete);
        ReusableMethods.waitFor(2);
    }

    @And("user verifies that Yes options is visible")
    public void userVerifiesThatYesNoOptionsAreVisible() {
        ReusableMethods.verifyElementDisplayed(getProductPage().yes);
    }

    @And("user verifies that No options is visible")
    public void userVerifiesThatNoOptionsIsVisible() {
        ReusableMethods.verifyElementDisplayed(getProductPage().no);
    }

    @And("user selects no option and verifies that No option cancel the operation")
    public void userVerifiesThatNoOptionCancelTheOperation() {
        getProductPage().no.click();
        System.out.println("After clicking No button last approved product is still here :" + getProductPage().lastApprovedProduct.getText());
    }

    @When("user selects the Yes option and verifies that the last added product has been removed")
    public void userSelectsYesOption() {
        JS_utilities.clickElementByJS(getProductPage().yes);
        ReusableMethods.waitFor(5);
        int yeniBoyut = getProductPage().eklenmisUrunlerinIsimleri.size();
        assertEquals("Listede bir eleman eksik", yeniBoyut, eskiBoyut - 1);
    }

    @Then("user verifies that deleting alert is displayed")
    public void userVerifiesThatDeletingAlertIsDisplayed() {
        ReusableMethods.verifyElementDisplayed(getProductPage().deleteAlert);
    }

}
