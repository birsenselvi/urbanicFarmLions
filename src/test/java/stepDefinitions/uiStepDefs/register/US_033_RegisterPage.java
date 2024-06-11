package stepDefinitions.uiStepDefs.register;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import pages.RegisterPage;
import utilities.Driver;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitForVisibility;

public class US_033_RegisterPage extends CommonPage {

    static Faker faker = new Faker();
    public static String emailDB = faker.internet().emailAddress();


    @And("user clicks register button on the home page")
    public void userClicksRegisterButtonOnTheHomePage() {
        getHomePage().homeRegisterButton.click();
        //getRegisterPage().homeRegisterButton.click();
        ReusableMethods.waitFor(2);

    }
    @Then("The user enters first name {string}")
    public void theUserEntersFirstName(String firstName) {

        getRegisterPage().firstName.sendKeys(firstName);
        ReusableMethods.waitFor(2);

    }

    @Then("The user enters last name {string}")
    public void theUserEntersLastName(String lastName) {
        getRegisterPage().lastName.sendKeys(lastName);
        ReusableMethods.waitFor(2);
    }


    @Then("The user enters email {string}")
    public void theUserEntersEmail(String email) {
        getRegisterPage().email.sendKeys(emailDB);
        ReusableMethods.waitFor(2);
    }


    @And("The user enters password {string}")
    public void theUserEntersPassword(String password) {
        getRegisterPage().password.sendKeys(password);
        ReusableMethods.waitFor(2);
    }

    @And("The user enters confirmPassword {string}")
    public void theUserEntersConfirmPassword(String confirmPsw) {
        getRegisterPage().confirmPassword.sendKeys(confirmPsw);
        ReusableMethods.waitFor(2);
    }

    @And("The user click the Register Button on the register page.")
    public void theUserClickTheRegisterButtonOnTheRegisterPage() {
        waitForVisibility(getRegisterPage().registerButton,10);
        JS_utilities.clickElementByJS(getRegisterPage().registerButton);
    }
}
