package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

public class US_017_FooterFarmers extends CommonPage {
    @And("user clicks on the farmers market")
    public void userClicksOnTheFarmersMarket() {
        getHomePage().farmersMarketFooter.click();

    }



    @Then("user should see relevant page and url {string}")
    public void userShouldSeeRelevantPageAndTitle(String expectedurl) {

        ReusableMethods.waitFor(2);
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(expectedurl,url);


    }


}



