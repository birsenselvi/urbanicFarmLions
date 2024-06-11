package stepDefinitions.uiStepDefs.register;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

public class US_035_ScenarioOutline extends CommonPage {



    @When("user clicks register")
    public void userClicksRegister() {
        ReusableMethods.waitForVisibility(getRegisterPage().Register,2);
getRegisterPage().Register.click();
        ReusableMethods.waitFor(2);
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String name) {
        getRegisterPage().firstName.sendKeys(name);
        ReusableMethods.waitFor(1);
    }

    @And("user enters last name {string}")
    public void userEntersLastName(String lastName) {
        getRegisterPage().lastName.sendKeys(lastName);
        ReusableMethods.waitFor(1);
    }

    @And("User enters email {string}")
    public void userEntersEmail(String email) {

        Faker faker=new Faker();
        String mail = faker.internet().emailAddress();
        getRegisterPage().email.sendKeys(mail);
        ReusableMethods.waitFor(1);

    }

    @And("user enters password {string}")
    public void userEntersPassword(String passWord) {
        getRegisterPage().password.sendKeys(passWord);
        ReusableMethods.waitFor(1);
    }

    @And("user enters confirmPassword {string}")
    public void userEntersConfirmPassword(String confirm) {
        getRegisterPage().confirmPassword.sendKeys(confirm);
        ReusableMethods.waitFor(1);
    }


//    @And("user clicks register button")
//    public void userClicksRegisterButton() {
//    }

    @And("user clicks reg-button")
    public void userClicksRegbutton() {
       // getRegisterPage().registerButton.click();
        JS_utilities.clickElementByJS(getRegisterPage().registerButton);
        ReusableMethods.waitFor(2);

    }


    @Then("user verifies the alert visible {string}")
    public void userVerifiesTheAlertVisible(String alert) {
        ReusableMethods.waitFor(1);
        String validationMessage = getRegisterPage().password.getAttribute("validationMessage");
        System.out.println("alertMessage=" + validationMessage);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(validationMessage.contains(alert));
        ReusableMethods.waitFor(2);

    }

    @Then("user verifies the confirm box alert visible {string}")
    public void userVerifiesTheConfirmBoxAlertVisible(String alert) {
        ReusableMethods.waitFor(1);
        String confirmValidationMessage = getRegisterPage().confirmPassword.getAttribute("validationMessage");
        System.out.println("alertMessage=" + confirmValidationMessage);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(confirmValidationMessage.contains(alert));
        ReusableMethods.waitFor(2);
    }
}
