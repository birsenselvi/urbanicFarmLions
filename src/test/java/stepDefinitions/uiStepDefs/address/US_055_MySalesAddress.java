package stepDefinitions.uiStepDefs.address;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.CommonPage;
import utilities.ReusableMethods;

public class US_055_MySalesAddress extends CommonPage {

    @When("the user clicks on Add New Address button for My Sales Address")
    public void theUserClicksOnAddNewAddressButtonForMySalesAddress() {
        ReusableMethods.waitFor(2);
        getAddressPage().addNewAddressButton.click();
        getAddressPage().searchPlacesButton.click();
        getAddressPage().searchPlacesButton.sendKeys("London");
        getAddressPage().mySalesAddressBtn.click();
        ReusableMethods.waitFor(5);
        ReusableMethods.selectCheckBox(getAddressPage().markAsASalesAddress, true);
        getAddressPage().submitButton.click();

    }

    @And("the user clicks on the Edit button in the My Sales Address section")
    public void theUserClicksOnTheEditButtonInTheMySalesAddressSection() {
        getAddressPage().editButton.click();
    }

    @When("the user clicks on the Remove button in the My Sales Address section")
    public void theUserClicksOnTheRemoveButtonInTheMySalesAddressSection() {
        getAddressPage().removeButton.click();
    }


}
