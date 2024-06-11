package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_132_CheckOrderStatus {

    //{
    //    "success": true,
    //    "state": "WAITING_PAYMENT"
    //}

    Response response;

    @When("user gets the order status")
    public void user_gets_the_order_status() {
        //set the base URL (/account/event/attendance/checkOrder)
        spec.pathParams("P1","account","P2","event","P3","attendance","P4","checkOrder");

        //set the expected data
        Map<String,Object> expectedData= new HashMap<>();
        expectedData.put("success", true);
        expectedData.put("state", "WAITING_PAYMENT");

        //send request and get the responses
        response = given(spec).post("{P1}/{P2}/{P3}/{P4}");
        response.prettyPrint();

    }
    @Then("user verifies order status id")
    public void user_verifies_order_status_id() {

        //do assertion
        JsonPath jsonPath = response.jsonPath();
        assertEquals(true, jsonPath.getBoolean("success"));


    }


}
