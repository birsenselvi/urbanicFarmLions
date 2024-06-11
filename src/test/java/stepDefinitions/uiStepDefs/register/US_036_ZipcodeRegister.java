package stepDefinitions.uiStepDefs.register;

import io.cucumber.java.en.When;
import pages.CommonPage;
import pages.RegisterPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;



public class US_036_ZipcodeRegister extends CommonPage {
    RegisterPage   rp=new RegisterPage();
    @When("user scrolls down")
    public void user_scrolls_down() {
        JS_utilities.scrollDownByJS();
//nur deneme
    }
    @When("user enters a zipcode {string}")
    public void user_enters_a_zipcode(String zipcode) {

        getRegisterPage().zipCode.sendKeys(zipcode);
    }

    @When("user enters a zipcode {int}")
    public void user_enters_a_zipcode(int zipcode){
        getRegisterPage().zipCode.sendKeys();
        ReusableMethods.waitFor(1);
    }

}
