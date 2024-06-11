package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

public class US_027_AdressIsVisibleOnHomePage extends CommonPage {

        @Then("User should see the address displayed on the page")
        public void checkAddressVisibilityOnHomePage() {
            ReusableMethods.waitFor(3);
            String  expectedAdressText="UrbanicFarm Inc., 1159 Kelez Dr San Jose, California, 95120, United States";
            String actualAdressTextDisplayed=getHomePage().insideOfAddress.getText();
          Assert.assertEquals(expectedAdressText,actualAdressTextDisplayed);
        }




}
