package stepDefinitions;

import enums.USER_INFO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import utilities.ConfigurationReader;
import utilities.DB_utilities;
import utilities.Driver;
import utilities.ReusableMethods;

public class Hooks {
    public static WebDriver driver;
    public static CommonPage commonPage;
    public static Actions actions;

    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {
        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }




         Driver.closeDriver();

    }

    /**
     * This method for login as a buyer
     *
     * @author Yasemin
     * since 19.02.2024
     */
    @Before("@BuyerLogin")
    public void buyerLogin() {
        driver.get(ConfigurationReader.getProperty("url"));
        ReusableMethods.waitForVisibility(commonPage.getLoginPage().loginButton, 5);
        commonPage.getLoginPage().loginButton.click();
        commonPage.getLoginPage().loginMethod(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());

    }
    @Before("@SellerLogin")
    public void sellerLogin() {
        driver.get(ConfigurationReader.getProperty("url"));
        ReusableMethods.waitForVisibility(commonPage.getLoginPage().loginButton, 5);
        commonPage.getLoginPage().loginButton.click();
        commonPage.getLoginPage().loginMethod(USER_INFO.SELLEROMER_CREDENTIALS.getEmail(), USER_INFO.SELLEROMER_CREDENTIALS.getPassword());
    }

    @Before("@DB")
    public void setupDatabase() {
        DB_utilities.createConnection();

    }

    @After("@DB")
    public void closeDatabase() {
        DB_utilities.closeConnection();
    }


}