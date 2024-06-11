package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public record US_124_GetUnreadMessagesCount() {
    @When("User get unread message count")
    public void userGetUnreadMessageCount() {
        response = given(spec).when().post("chat/getUnreadMessagesCount");
        response.prettyPrint();
    }

    @Then("User verify  message response is expected")
    public void userVerifyMessageResponseIsExpected() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));


    }

}
