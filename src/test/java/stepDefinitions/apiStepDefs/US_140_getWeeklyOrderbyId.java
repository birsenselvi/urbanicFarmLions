package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;

import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_140_getWeeklyOrderbyId {
    @When("user gets the WeeklyOrderbyId")
    public void userGetsTheWeeklyOrderbyId() {
        //set the url
        ///account/weeklyorder/getWeeklyOrderbyId

        // spec.pathParams("P1","account","P2","weeklyorder","P3","getWeeklyOrderbyId");

        //set expected data
        //"id":377
        Map<String, Integer> expectedData = new HashMap<>();
        expectedData.put("id", 377);

        //send request and get the response
        response = given(spec)
                .body(expectedData)
                .post("/account/weeklyorder/getWeeklyOrderbyId");
        response.prettyPrint();
    }

    @Then("user verifies order id")
    public void userVerifiesOrderId() {
        //do assertion

        JsonPath jsonPath = response.jsonPath();
        int actualData = jsonPath.getInt("0.id");
        Assert.assertEquals(377, actualData);


    }


}
