package stepDefinitions.uiStepDefs.account;

import com.github.javafaker.Faker;
import enums.LINKS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.Dimension;
import pages.CommonPage;
import utilities.JS_utilities;

import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.*;

public class US_050_AccountFileUpload extends CommonPage {
    @Then("Account module should be clickable")
    public void accountModuleShouldBeClickable() {
        verifyElementEnabled(getAccountPage().accountOnTheSideBar);
       
    }

    @When("user clicks on Account module on the left hand side of Home page")
    public void userClicksOnAccountModuleOnTheLeftHandSideOfHomePage() {
        getAccountPage().accountOnTheSideBar.click();
    }

    @Then("user should be navigated to the account page")
    public void userShouldBeNavigatedToTheAccountPage() {
        assertEquals(LINKS.EXPECTED_LINKS.getAccountUrl(), driver.getCurrentUrl());

    }

    @And("user should be able to see full name,email,QR code and edit button on this page")
    public void userShouldBeAbleToSeeFullNameEmailQRCodeAndEditButtonOnThisPage() {
        assertTrue(getAccountPage().fullNameOnAccountPage.isDisplayed() &
                getAccountPage().emailOnAccountPage.isDisplayed() &
                getAccountPage().QRCode.isDisplayed() &
                getAccountPage().editButton.isDisplayed());
    }

    @Then("Copy button should be functional")
    public void copyButtonShouldBeFunctional() {
        verifyElementEnabled(getAccountPage().copyButton);

    }

    @And("Download Button should be functional")
    public void downloadButtonShouldBeFunctional() {
        verifyElementEnabled(getAccountPage().downloadButton);
    }

    @Then("user verifies that Edit button is functional")
    public void userVerifiesThatEditButtonIsFunctional() {
        verifyElementEnabled(getAccountPage().editButton);
    }

    @And("user clicks on Edit button on this page")
    public void userClicksOnEditButtonOnThisPage() {
        getAccountPage().editButton.click();
    }

    @Then("user verifies that choose file button is functional")
    public void userVerifiesThatChooseFileButtonIsFunctional() {
        verifyElementEnabled(getAccountPage().chooseFileButton);
    }

    @And("user uploads an image thorough Choose file")
    public void userUploadsAnImageThoroughChooseFile() {
        getAccountPage().uploadFile();
    }

    @Then("user verifies that image was uploaded successfully")
    public void userVerifiesThatImageWasUploadedSuccessfully() {
        // getAccountPage().verifyFileUploaded();
    }

    @And("user clicks on Save button")
    public void userClicksOnSaveButton() {
        waitForVisibility(getAccountPage().saveButton,10);
        JS_utilities.clickElementByJS(getAccountPage().saveButton);
//        getAccountPage().saveButton.click();
    }


    @Then("user verifies that account picture has been changed")
    public void userVerifiesThatAccountPictureHasBeenChanged() {
        assertNotEquals("Profile picture is not updated", getAccountPage().profilePicture.getAttribute("src"), getAccountPage().profilePicture.getAttribute("src"));

    }


    @And("user enters an invalid phone number")
    public void userEntersAnInvalidPhoneNumber() {
        getAccountPage().phoneNumberInput.sendKeys("12345");

    }

    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String expectedWarningMessage) {
        assertTrue(getAccountPage().invalidPhoneNumberMessage.getText().contains(expectedWarningMessage));

        waitForVisibility(getAccountPage().cancelButton, 5);
        getAccountPage().cancelButton.click();
    }

    @And("user enters many zeros to  phone number input")
    public void userEntersManyZerosToPhoneNumberInput() {
        getAccountPage().phoneNumberInput.sendKeys("000000");
    }

    @Then("warning message should contain {string}")
    public void warningMessageShouldContain(String warningMissingCountryCode) {
        assertTrue(getAccountPage().invalidPhoneNumberMessage.getText().contains(warningMissingCountryCode));
        waitForVisibility(getAccountPage().cancelButton, 7);
        getAccountPage().cancelButton.click();

    }
    Faker faker=new Faker();
    String expectedPhoneNumber = faker.phoneNumber().cellPhone();
    @And("user enters a valid phone number")
    public void userEntersAValidPhoneNumber() {


        getAccountPage().phoneNumberInput.sendKeys(expectedPhoneNumber);
    }

    @Then("Save button should be functional")
    public void saveButtonShouldBeFunctional() {
        verifyElementEnabled(getAccountPage().saveButton);
    }

    @Then("{string} alert should be displayed.")
    public void alertShouldBeDisplayed(String expectedUpdateSuccessMessage) {
        waitForVisibility(getAccountPage().updateSuccessMessage,5);
        assertEquals(expectedUpdateSuccessMessage,getAccountPage().updateSuccessMessage.getText());
    }

    @Then("user verifies that phone number has been updated")
    public void userVerifiesThatPhoneNumberHasBeenUpdated() {
        waitForVisibility(getAccountPage().phoneNumberText,5);
        assertEquals(expectedPhoneNumber,getAccountPage().phoneNumberText.getText());
    }

    @Then("toggle menu should be functional on account page")
    public void toggleMenuShouldBeFunctionalOnAccountPage() {
        verifyElementEnabled(getAccountPage().toggleMenu);
    }
    Dimension initialDimensions;
    @When("user clicks on toggle menu")
    public void userClicksOnToggleMenu() {
         driver.manage().window().getSize();
        getAccountPage().toggleMenu.click();
        waitFor(2);
    }

    @Then("menu dimensions should be changed")
    public void menuDimensionsShouldBeChanged() {
        Dimension updatedDimensions = driver.manage().window().getSize();
        assertNotEquals(initialDimensions, updatedDimensions);

    }
}
