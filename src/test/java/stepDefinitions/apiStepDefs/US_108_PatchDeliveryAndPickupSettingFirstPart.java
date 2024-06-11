package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_108_PatchDeliveryAndPickupSettingFirstPart {
    @When("user sends a post request to change the availability for buyer picks up from branch")
    public void userSendsAPostRequestToChangeTheAvailabilityForBuyerPicksUpFromBranch() {
        //set the url
        // /account/change/delivery
        spec.pathParams("P1", "account", "P2", "change", "P3", "delivery");

        //set the expected data
        //"availabilityBranch":"16:00-21:05","deliveryType":["BUYER_PICKUP_FROM_BRANCH"],
        Map<String, String> expectedData1= new HashMap<>();
        expectedData1.put("availabilityBranch", "16:00-21:05");
        Map<String, String> expectedData2= new HashMap<>();
        expectedData2.put("deliveryType", "BUYER_PICKUP_FROM_BRANCH");
        List<Map> order = new ArrayList<>();
        order.add(expectedData1);
        order.add(expectedData2);


        //send the request get the response
        response = given(spec)
                .body(order)
                .post("{P1}/{P2}/{P3}");
        response.prettyPrint();

    }
}
