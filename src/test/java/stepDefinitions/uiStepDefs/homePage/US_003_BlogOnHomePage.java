
    package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.ReusableMethods;

import static stepDefinitions.Hooks.driver;

    public class US_003_BlogOnHomePage extends CommonPage {


        @Given("user goes to homepage")
        public void userGoesToHomepage() {
            driver.get(ConfigurationReader.getProperty("url"));
            ReusableMethods.waitFor(2);

        }

        @When("the user clicks on the Blog button")
        public void theUserClicksOnTheBlogButton() {

            getHomePage().blogButton.click();
            ReusableMethods.waitFor(2);
        }

        @Then("the relevant Blog page should be visible")
        public void theRelevantBlogPageShouldBeVisible() {
            Assert.assertEquals("https://urbanicfarm.com/blog/",driver.getCurrentUrl());
        }
    }


