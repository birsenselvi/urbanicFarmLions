package stepDefinitions.uiStepDefs.homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;

public class US_025_PrivacyPolicy extends CommonPage{

    @And("the user finds the Privacy Policy link")
    public void theUserFindsThePrivacyPolicyLink() {
        Assert.assertTrue(getHomePage().privacyPolicyLink.isDisplayed());
    }

    @Then("the Privacy Policy link should be clickable")
    public void thePrivacyPolicyLinkShouldBeClickable() {

        getHomePage().privacyPolicyLink.click();
        Assert.assertEquals("ONLINE PRIVACY POLICY AGREEMENT",getHomePage().PrivacyPolicyPage.getText());
    }

    @And("the user clicks on the Privacy Policy link")
    public void theUserClicksOnThePrivacyPolicyLink() {
        getHomePage().privacyPolicyLink.click();
    }

    @Then("Then the ONLINE PRIVACY POLICY AGREEMENT page opens")
    public void thenTheONLINEPRIVACYPOLICYAGREEMENTPageOpens() {
        //  ReusableMethods.switchToWindow(1);
        // Assert.assertEquals("https://urbanicfarm.com/privacy-policy",driver.getCurrentUrl()); //Bu calismadi
        Assert.assertEquals("ONLINE PRIVACY POLICY AGREEMENT", getHomePage().PrivacyPolicyPage.getText());

    }

}

