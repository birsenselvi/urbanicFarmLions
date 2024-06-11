package stepDefinitions.uiStepDefs.welcomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;

import java.util.List;


public class US_067_SellerAndProductRatingFunctionality extends CommonPage {
    
        @And("the user clicks on the search options button")
        public void theUserClicksOnTheSearchOptionsButton() {
                getWelcomePage().searchBarOptions.click();
        }
        @Then("the user finds the Any seller rating icon and clicks on it")
        public void theUserFindsTheAnySellerRatingIconAndClicksOnIt() {
                getWelcomePage().sellerRatingDropdown.click();
        }
        @Then("the seller should be able to select a rating option")
        public void theSellerShouldBeAbleToSelectARatingOption() {
            Assert.assertTrue(getWelcomePage().sellerRatingDropdown.isEnabled());
        }
        @And("the user selects a rating number {int} from the dropdown menu")
        public void theUserSelectsARatingNumberFromTheDropdownMenu(int arg0) {
            WebElement dropdownElement = getWelcomePage().sellerRatingDropdown;
            dropdownElement.click();
            Select select = new Select(dropdownElement);
            select.selectByIndex(4);
        }

    @Then("the selected rating {int} should be visible on the screen")
    public void theSelectedRatingShouldBeVisibleOnTheScreen(int expectedRating) {
        WebElement dropdownElement = getWelcomePage().sellerRatingDropdown;
        dropdownElement.click();

        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();

        // Select the option based on the expected rating
        select.selectByValue(String.valueOf(expectedRating));

        // Get the selected option text
        String selectedOptionText = select.getFirstSelectedOption().getText();

        // Print the selected option text on the console
        System.out.println("Selected option text: " + selectedOptionText);

        // Assert that the selected option matches the expected rating
        Assert.assertEquals("Selected option should match expected rating", String.valueOf(expectedRating), selectedOptionText);
    }

        @Then("the user finds the Any Product rating icon and clicks on it")
        public void theUserFindsTheAnyProductRatingIconAndClicksOnIt() {
            getWelcomePage().productRatingDropdown.click();
        }

    @Then("the seller should be able to select a rating option from the product icon dropDown")
    public void theSellerShouldBeAbleToSelectARatingOptionFromTheProductIconDropDown() {
            Assert.assertTrue(getWelcomePage().productRatingDropdown.isEnabled());
    }
}


