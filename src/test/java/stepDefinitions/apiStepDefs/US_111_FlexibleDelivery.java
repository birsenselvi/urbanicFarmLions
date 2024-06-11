package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.CoreMatchers.equalTo;
import static utilities.Api_utilities.response;


public class US_111_FlexibleDelivery {
    @When("user updates the seller flexible delivery option")
    public void user_updates_the_seller_flexible_delivery_option() {
        //set the url
        spec.pathParams("P1", "account", "P2", "change", "P3", "delivery");
        //set expected data
        List<String> listDeliveryType = new ArrayList<>();
        Map<String,Integer> listFlexibleDeliveryOptions = new HashMap<String, Integer>();

        listFlexibleDeliveryOptions.put("deliveryBy", 9370);
        listFlexibleDeliveryOptions.put("orderBegin", 2167);
        listFlexibleDeliveryOptions.put("orderEnd", 6549);
        listDeliveryType.add("SELLER_FLEXIBLE");
        Map<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("deliveryType",listDeliveryType);
        expectedData.put("freeDeliveryRange", 200);
        expectedData.put("maxDeliveryRange", 30);
        expectedData.put("minFreeDeliveryOrder", 30);
        expectedData.put("perMileCost", 4);
        expectedData.put("flexibleDeliveryOptions",listFlexibleDeliveryOptions);

        //send the request and get the request
        response = given(spec).body(expectedData).post("{P1}/{P2}/{P3}");
        response.prettyPrint();


    }

    @Then("the user verifies success is TRUE")
    public void theUserVerifiesSuccessIsTrue() {
        //do assertion
        JsonPath jsonPath = response.jsonPath();
        Assert.assertTrue("true",jsonPath.getBoolean("success"));
//        Assert.assertTrue("true",jsonPath.getBoolean("success"));

    }
}
