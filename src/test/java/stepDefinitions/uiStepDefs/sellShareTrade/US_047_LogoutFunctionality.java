package stepDefinitions.uiStepDefs.sellShareTrade;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;

public class US_047_LogoutFunctionality extends CommonPage {
    @And("the user clicks onto the Sell-Share-Trade button")
    public void theUserClicksOntoTheSellShareTradeButton() {
        getSellShareTrade().sellShareTradeButton.click();
    }

    @Then("the user clicks onto the logout button")
    public void theUserClicksOntoTheLogoutButton() {
        getSellShareTrade().logOutButton.click();

    }


    @Then("the relevant page with a  header Join the Movement! should apear")
    public void theRelevantPageWithAHeaderJoinTheMovementShouldapear() {
        Assert.assertEquals("Join the Movement!", getSellShareTrade().logOutPage.getText());

    }
}
