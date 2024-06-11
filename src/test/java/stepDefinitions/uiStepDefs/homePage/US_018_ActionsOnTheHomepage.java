package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;
import static utilities.ReusableMethods.waitFor;

public class US_018_ActionsOnTheHomepage {
    HomePage homePage=new HomePage();
    @Then("Click on Discover Local Vendors near you and see the relevant page")
    public void click_on_discover_local_vendors_near_you_and_see_the_relevant_page() {
        ReusableMethods.waitForClickability(homePage.DiscoverLocalVendors,3);
        JS_utilities.clickElementByJS(homePage.DiscoverLocalVendors);
        ReusableMethods.switchToWindow(1);
        waitFor(2);
        String expectedUrl = "https://wefunder.com/urbanicfarm";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("The relevant page has clicked and opened. URL: " + actualUrl);
        } else {
            System.out.println("The relevant page has not clicked and opened. Actual URL: " + actualUrl);
        }
    }

}









