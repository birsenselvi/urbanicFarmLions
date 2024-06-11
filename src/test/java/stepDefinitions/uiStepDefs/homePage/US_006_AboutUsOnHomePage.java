package stepDefinitions.uiStepDefs.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.waitFor;
import static utilities.ReusableMethods.waitForVisibility;

public class US_006_AboutUsOnHomePage extends CommonPage {


    @When("user clicks the About Us icon")
    public void user_click_the_about_us_icon() {
    getHomePage().accountUsOfTheHeader.click();
    }

    @And("the About Us icon should be clickable")
    public void theAboutUsIconShouldBeClickable() {
        ReusableMethods.verifyElementDisplayed(getHomePage().accountUsOfTheHeader);
    }
    @And("When it is clicked and relevant page should be displayed.")
    public void whenItIsClickedRelevantPageShouldBeDisplayed() {
        waitForVisibility(getHomePage().accountUsOfTheHeader,5);
        getHomePage().accountUsOfTheHeader.click();
        waitFor(3);
        String  expectedTextAfterClick="OUR SERVICES";
        String actualTexAfterClick=getHomePage().ourServicestxt.getText();
        Assert.assertEquals("There is a mistake",expectedTextAfterClick,actualTexAfterClick);

    }
}
