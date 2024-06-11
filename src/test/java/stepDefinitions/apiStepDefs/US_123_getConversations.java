package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_123_getConversations {
    @When("User get all conversations")
    public void userGetAllConversations() {
        response = given(spec).when().post("/chat/getConversations");
        response.prettyPrint();
    }
    @Then("User verify response is expected")
    public void userVerifyResponseIsExpected() {
        Assert.assertEquals(200, response.getStatusCode());
        List<Object> id = response.jsonPath().getList("id");
        Assert.assertTrue(id.size()>1);

    }


}
