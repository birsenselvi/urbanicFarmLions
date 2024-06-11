package stepDefinitions.uiStepDefs.welcome;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;
import java.util.List;

public class US_068_WelcomePageOrders extends CommonPage {
    @Given("user clicks on Urbanic Farm icon on the left hand side of home page")
    public void userClicksOnUrbanicFarmIconOnTheLeftHandSideOfHomePage() {

        getWelcomePage().clickOnUrbanicFarmText();
    }

    @Then("user should navigate to welcome page")
    public void userShouldNavigateToWelcomePage() {

        getWelcomePage().verifyWelcomePageDisplayed();
    }

    @Then("user should see the list of sellers on the page")
    public void userShouldSeeTheListOfSellersOnThePage() {
        getWelcomePage().verifySellersNameDisplayedOnProductCardBox();
    }

    @When("user clicks on any seller next to any order \\(selectable)")
    public void userClicksOnAnySellerNextToAnyOrderSelectable() {
        getWelcomePage().clickOnRandomSellerFromWelcomePage();
    }

    @Then("user should go to the sellers page")
    public void userShouldGoToTheSellersPage() {
        getWelcomePage().verifySellerPageIsNavigated();
    }

    @Then("user should be able to see all product categories under categories dropdown")
    public void userShouldBeAbleToSeeAllProductCategoriesUnderCategoriesDropdown(DataTable dt) {
        List<String> expectedCategoriesList = dt.column(0);
        getWelcomePage().verifyAllCategories(expectedCategoriesList);
    }

    @When("user selects a product from categories")
    public void userSelectsAProductFromCategories() {
        getWelcomePage().selectaCategoryFromList();
    }

    @Then("selected category list should be displayed in the page")
    public void selectedCategoryListShouldBeDisplayedInThePage() {
        getWelcomePage().verifyExpectedCategorySelected();
    }

    @Then("Add to cart button should be functional")
    public void addToCartButtonShouldBeFunctional() {
        getWelcomePage().isAddToCardButtonFunctional();
    }

    @Then("Product quantity icons + - should be functional")
    public void productQuantityIconsShouldBeFunctional() {
        getWelcomePage().assertQuantityIconsonWelcomePageProductsCardBox();

    }

    @When("user clicks on Add to cart button for first product in the list")
    public void userClicksOnAddToCartButtonForFirstProductInTheList() {
        getWelcomePage().addToCartBtnList.getFirst().click();
    }

    @Then("user should see a toast message product {string}")
    public void userShouldSeeAToastMessageProduct(String expectedToastMessage) {
        //getWelcomePage().toastMessage.assertToastMessage(expectedToastMessage);
    }
}
