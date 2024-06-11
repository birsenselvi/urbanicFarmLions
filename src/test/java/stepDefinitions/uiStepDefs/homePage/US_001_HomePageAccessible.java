package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import pages.HomePage;

public class US_001_HomePageAccessible extends HomePage {

    @Then("User verifies that home page is accessible")
    public void userVerifiesThatHomePageIsAccessible() {
        getHomePage().assertUrlHompage();

    }
}


