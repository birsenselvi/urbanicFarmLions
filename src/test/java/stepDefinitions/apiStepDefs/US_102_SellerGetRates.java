package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static utilities.Api_utilities.response;

public class US_102_SellerGetRates {
    @When("user gets rates for sellers")
    public void user_gets_rates_for_sellers() {
        //set the url
        //        /account/feedback/seller/getRates
        spec.pathParams("P1", "account", "P2", "feedback", "P3", "seller", "P4", "getRates");

        //set expected data

        //{
        //  "sellerId": 1180
        //}

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("sellerId", 1180);

        //send the request and get the response


        response=given(spec).
                body(expectedData)
                .when()
                .post("{P1}/{P2}/{P3}/{P4}")
                .prettyPeek();

    }

    @Then("user verifies success true")
    public void user_verifies_success_true() {
        //do assertion

        //1.way

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(true, jsonPath.getBoolean("success"));

        //2.way

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("success", equalTo(true));

    }


}
