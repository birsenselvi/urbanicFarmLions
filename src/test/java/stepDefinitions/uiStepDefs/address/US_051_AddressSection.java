package stepDefinitions.uiStepDefs.address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import pages.AddressPage;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.verifyElementEnabled;


public class US_051_AddressSection extends CommonPage {

    @And("User verifies that it is navigated to Address page.")
    public void userVerifiesThatItIsNavigatedToAddressPage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/address", driver.getCurrentUrl());
    }

    @And("the user clicks on Add New Address button and add a new city name.")
    public void theUserClicksOnAddNewAddressButtonAndAddANewCityName() {
        ReusableMethods.waitFor(2);
        getAddressPage().addNewAddressButton.click();
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("Minneapolis");
        getAddressPage().cityName.click();
        ReusableMethods.waitFor(15);

    }

    @And("The user clicks on cancel button.")
    public void theUserClicksOnCancelButton() {
        ReusableMethods.waitForClickability(By.xpath ("(//button[text()='Cancel'])[2]"), 10);
        getAddressPage().cancelButton.click();

    }

    @Then("After the user clicks on the cancel button, user returns to address page.")
    public void afterTheUserClicksOnTheCancelButtonUserReturnsToAddressPage() {
        Assert.assertEquals("https://test.urbanicfarm.com/account/address", driver.getCurrentUrl());

    }
    }

