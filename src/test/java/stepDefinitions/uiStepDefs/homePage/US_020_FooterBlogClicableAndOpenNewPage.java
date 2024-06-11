package stepDefinitions.uiStepDefs.homePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import utilities.JS_utilities;
import utilities.ReusableMethods;

public class US_020_FooterBlogClicableAndOpenNewPage extends CommonPage {

    @Given("user scroll down to footer and clicks Blog link")
    public void user_scroll_down_to_footer_and_clicks_blog_link() {
        JS_utilities.scrollAndClickWithJS(getHomePage().footerBlogBtn);
    }
    @Then("user validates {string} shown in new page")
    public void user_validates_shown_in_new_page(String expected) {
    String actual = getHomePage().textOfBlogPage.getText();
        Assert.assertEquals(actual, expected);
    }

}
