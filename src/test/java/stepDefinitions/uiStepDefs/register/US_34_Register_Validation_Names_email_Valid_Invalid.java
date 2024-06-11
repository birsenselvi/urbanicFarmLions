package stepDefinitions.uiStepDefs.register;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_34_Register_Validation_Names_email_Valid_Invalid extends CommonPage {
    Faker faker = new Faker();
    String password = "Ufarm.123";

    @Then("The user enters first name")
    public void theUserEntersFirstName() {

        String firstname = null;

        while (true) {
            firstname = faker.name().firstName();

            if (firstname.length() >= 2 && firstname.length() <= 161) {
                System.out.println("Valid First Name: " + firstname);
                ReusableMethods.waitFor(2);
                getRegisterPage().firstName.sendKeys(firstname);
                break;
            }
        }
    }

    @And("The user enters middle name")
    public void theUserEntersMiddleName() {
        String MiddleName = null;

        while (true) {
            MiddleName = faker.name().firstName();

            if (MiddleName.length() >= 2 && MiddleName.length() <= 160) {
                System.out.println("Valid First Name: " + MiddleName);
                ReusableMethods.waitFor(3);
                getRegisterPage().middleName.sendKeys(MiddleName);
                break;
            }
        }
    }


    @And("The user enters last name")
    public void theUserEntersLastName() {

        String lastName = null;

        while (true) {
            lastName = faker.name().lastName();

            if (lastName.length() >= 2 && lastName.length() <= 161) {
                System.out.println("Valid First Name: " + lastName);
                ReusableMethods.waitFor(2);
                getRegisterPage().lastName.sendKeys(lastName);
                break;
            }
        }
    }

    @And("The user enters email")
    public void theUserEntersEmail() {
        ReusableMethods.waitFor(1);
        String email = faker.internet().emailAddress();
        getRegisterPage().email.sendKeys(email);
    }

    @And("The user enters password")
    public void theUserEntersPassword() {
        ReusableMethods.waitFor(1);
        getRegisterPage().password.sendKeys(password);
    }

    @And("The user enters confirmPassword")
    public void theUserEntersConfirmPassword() {
        ReusableMethods.waitFor(1);
        getRegisterPage().confirmPassword.sendKeys(password);
    }

    @Then("The user see the Welcome message by a pop-up window")
    public void theUserSeeTheWelcomeMessageByAPopUpWindow() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue("Welcome message is not displayed", getRegisterPage().alertWelcome.isDisplayed());
    }

    @And("The user enters middle name {string}")
    public void theUserEntersMiddleName(String middleName) {
        ReusableMethods.waitFor(2);
        getRegisterPage().middleName.sendKeys(middleName);
    }

    @And("User enters first name {int}")
    public void userEntersFirstName(int x) {
        String fName = "";
        for (int i = 1; i <= x; i++) {
            fName += "a";
        }
        ReusableMethods.waitFor(2);
        getRegisterPage().firstName.sendKeys(fName);
    }

    @And("user enters email {string}")
    public void userEntersEmail(String email) {
        ReusableMethods.waitFor(1);
        getRegisterPage().email.sendKeys(email);
    }

    @And("user enters last name {int}")
    public void userEntersLastName(int x) {
        String lName = "";
        for (int i = 1; i <= x; i++) {
            lName += "a";
        }
        ReusableMethods.waitFor(2);
        getRegisterPage().lastName.sendKeys(lName);
    }

    @Then("The user verifies the alert visible lastName {string}")
    public void theUserVerifiesTheAlertVisiblelastName(String alert) {
        ReusableMethods.waitForVisibility(getRegisterPage().lastName, 2);
        String validationMessage = getRegisterPage().lastName.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        if (validationMessage != null) {
            Assert.assertEquals(alert, validationMessage);
        }
    }

    @Then("The user verifies the alert visible firstName {string}")
    public void theUserVerifiesTheAlertVisibleFirstName(String alert) {
        ReusableMethods.waitForVisibility(getRegisterPage().firstName, 2);
        String validationMessage = getRegisterPage().firstName.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        if (validationMessage != null) {
            Assert.assertEquals(alert, validationMessage);
        }
    }

    @Then("The user verifies the alert visible {string} and {string}")
    public void theUserVerifiesTheAlertVisibleAnd(String alert, String xPath) {
        WebElement element = driver.findElement(By.xpath(xPath));
        ReusableMethods.waitForVisibility(element, 1);
        String validationMessage = element.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        if (validationMessage != null) {
            Assert.assertEquals(alert, validationMessage);
        }
    }

    @And("Users enters first name {string}")
    public void usersEntersFirstName(String firstName) {
        ReusableMethods.waitForVisibility(getRegisterPage().firstName, 1);
        getRegisterPage().firstName.sendKeys(firstName);
    }
}





