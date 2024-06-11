package stepDefinitions.uiStepDefs.welcomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import pages.WelcomePage;
import utilities.ConfigurationReader;
import utilities.JS_utilities;
import utilities.ReusableMethods;


public class US_066_WelcomePage extends CommonPage {
    @And("User logs in as buyer")
    public void userLogsInAsBuyer() {
        getLoginPage().loginMethod(ConfigurationReader.getProperty("email2"), ConfigurationReader.getProperty("password2"));
    }

    @And("the user clicks on the UrbanicFarm icon on the nowbar")
    public void TheUserClicksOnTheUrbanicFarmIconOnTheNowbar() {
        getWelcomePage().urbanicFarmIcon.click();
    }


    @Then("the Welcome Page should appear")
    public void the_welcome_page_should_appear() {
        Assert.assertEquals("Urbanic Farm", getWelcomePage().UrbanicFarmBanner.getText());

    }

    @Then("the What are you looking for icon should be visible and functional")
    public void theWhatAreYouLookingForiconShouldBeVisibleAndFunctional() {
        Assert.assertEquals("What are you looking for ?",getWelcomePage().whatRULooking4Icon.getText());
        getWelcomePage().searchBox.click();
    }

    @Then("the Search in miles icon should be visible and functional")
    public void theSearchInMilesIconShouldBeVisibleAndFunctional() {
        ReusableMethods.waitForVisibility(getWelcomePage().searchInMilesIcon,10);
        Assert.assertEquals("Search in miles",getWelcomePage().searchInMilesIcon.getText());
        JS_utilities.clickElementByJS(getWelcomePage().searchInMilesDropdown);

    }

    @Then("the categories icon should be visible and funtional")
    public void theCategoriesIconShouldBeVisibleAndFuntional() {

        ReusableMethods.waitForVisibility(getWelcomePage().categoriesIcon,10);
        Assert.assertTrue(getWelcomePage().categoriesIcon.isDisplayed());
        JS_utilities.clickElementByJS((getWelcomePage().categoriesDropdownMenu));

    }

    @Then("the Only in organic Produce option should be visible and functional")
    public void theOnlyInOrganicProduceOptionShouldBeVisibleAndFunctional() {
        Assert.assertEquals("Search only in organic produce",getWelcomePage().OrganicProduceIcon.getText());
        getWelcomePage().OrganicProduceRadioBTN.click();


    }


    @And("the user searches for an item from the What Are you Looking For search box")
    public void theUserSearchesForAnItemFromTheWhatAreYouLookingForSearchBox() {
        getWelcomePage().searchBox.sendKeys("Apple");
        getWelcomePage().searchBox.sendKeys(Keys.ENTER);


    }

    @And("the user selects a distance from the Search in miles dropdown menu")
    public void theUserSelectsADistanceFromTheSearchInMilesDropdownMenu() {
        WebElement dropdownElement = getWelcomePage().searchInMilesDropdown;
        // Click to open the dropdown menu
        dropdownElement.click();
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select option by index (0-based)
        select.selectByIndex(4);


    }

    @And("the user selects a category from the Categories dropdown menu")
    public void theUserSelectsACategoryFromTheCategoriesDropdownMenu() {
        WebElement dropdownElement = getWelcomePage().categoriesDropdownMenu;
        // Click to open the dropdown menu
        dropdownElement.click();
        // Create a Select object
        Select select = new Select(dropdownElement);
        // Select option by index (0-based)
        select.selectByIndex(1);

    }

    @And("the user switches to the option Only in organic Produce")
    public void theUserSwitchesToTheOptionOnlyInOrganicProduce() {
        getWelcomePage().OrganicProduceRadioBTN.click();
    }

    @And("the user clicks on the Search button")
    public void theUserClicksOnTheSearchButton() {
        getWelcomePage().searchButton.click();
    }

    @Then("information about price should be visible")
    public void informationAboutPriceShouldBeVisible() {
        getWelcomePage().priceInfo.isDisplayed();
    }


    @Then("delivery type options should be visible")
    public void deliveryTypeOptionsShouldBeVisible() {
        getWelcomePage().deliveryOption.isDisplayed();
    }

    @Then("unit type options should be visible")
    public void unitTypeOptionsShouldBeVisible() {
        getWelcomePage().unitType.isDisplayed();
    }

    @Then("the displayed search results should match the selected criteria")
    public void theDisplayedSearchResultsShouldMatchTheSelectedCriteria() {
        Assert.assertTrue(getWelcomePage().displayedResult4Apple.isDisplayed());
        Assert.assertTrue(getWelcomePage().unitType.isDisplayed());

    }
}
