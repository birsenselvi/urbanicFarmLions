package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.CommonPage;
import utilities.Driver;
import utilities.JS_utilities;

import static utilities.JS_utilities.scrollAndClickWithJS;

public class US_011_SellYourProduceVisible extends CommonPage {

    @When("user scrolls down to {string} and Find the {string}")
    public void userScrollsDownToAndFindThe(String arg0, String arg1) {

        scrollAndClickWithJS(getHomePage().sellYourProduct);


    }

    @And("Assert title is {string}")
    public void assertTitleIs(String arg0) {

        String expectedText = "Sell Your Products";
        String actualTextDisplayed=getHomePage().sellYourProduct.getText();
        Assert.assertEquals(expectedText,actualTextDisplayed);

    }


}
