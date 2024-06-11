package stepDefinitions.uiStepDefs.welcome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class US_069_WelcomePageCart extends CommonPage {
    @When("user clicks on Cart")
    public void userClicksOnCart() {
        getWelcomePage().clickOnCartIcon();
    }

    @When("user clicks on + sign under quantity of product")
    public void userClicksOnSignUnderQuantityOfProduct() {
        getWelcomePage().clickIncreaseOuantityButton();
    }

    @Then("quantity of product should be increased")
    public void quantityOfProductShouldBeIncreased() {
    }

    @When("user clicks on red x sign")
    public void userClicksOnRedXSign() {
    }

    @Then("user should see warning message {string}")
    public void userShouldSeeWarningMessage(String arg0) {
    }

    @When("user clicks No button")
    public void userClicksNoButton() {
    }

    @Then("user should not delete the product")
    public void userShouldNotDeleteTheProduct() {
    }

    @And("user clicks on Yes button")
    public void userClicksOnYesButton() {
    }

    @Then("user should see a message after deleting the product")
    public void userShouldSeeAMessageAfterDeletingTheProduct() {
    }

    @Then("user verifies that total price has changed accordingly.")
    public void userVerifiesThatTotalPriceHasChangedAccordingly() {
    }
}
