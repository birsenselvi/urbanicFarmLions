package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Then;
import pages.LoginPage;

import static stepDefinitions.Hooks.driver;

public class US_008_HomePageOperations {
    LoginPage loginPage=new LoginPage();

    @Then("Click on the login button")
    public void click_on_the_login_button() {

        loginPage.loginButton.click();
    }

    @Then("Confirms that the login page has been opened")
    public void confirms_that_the_login_page_has_been_opened() {
        String expectedUrl = "https://test.urbanicfarm.com/auth/login";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Login page has been opened. URL: " + actualUrl);
        } else {
            System.out.println("Login page has not been opened. Actual URL: " + actualUrl);
        }
    }
}
