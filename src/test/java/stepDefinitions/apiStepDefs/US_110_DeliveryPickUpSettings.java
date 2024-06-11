package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class US_110_DeliveryPickUpSettings {
    Response response;

    @When("user sends a post request to change the availability of delivering the products")
    public void userSendsAPostRequestToChangeTheAvailabilityOfDeliveringTheProducts() {
        spec.pathParams("P1", "account", "P2", "change", "P3", "delivery");
        String payload = "{\n" +
                "  \"deliveryType\": [\n" +
                "    \"SELLER_DELIVERY\"\n" +
                "  ],\n" +
                "  \"freeDeliveryRange\": 100,\n" +
                "  \"maxDeliveryRange\": 15,\n" +
                "  \"minFreeDeliveryOrder\": 20,\n" +
                "  \"perMileCost\": 3,\n" +
                "  \"estimatedDeliveryTime\": [\n" +
                "    \"60_8\"\n" +
                "  ]\n" +
                "}";
             //  response = given(spec).body(payload).post("{P1}/{P2}/{P3}");
//        response.prettyPrint();

        //2.way
        String[] deliveryType = {"SELLER_DELIVERY"};
        String[] estimatedDeliveryTime = {"60_8"};
//        Map<String, Object> payload2 = new HashMap<>();
//        payload2.put("deliveryType", deliveryType);
//        payload2.put("freeDeliveryRange", 120);
//        payload2.put("maxDeliveryRange", 20);
//        payload2.put("minFreeDeliveryOrder", 25);
//        payload2.put("perMileCost", 3);
//        payload2.put("estimatedDeliveryTime", estimatedDeliveryTime);
//        response = given(spec).body(payload2).post("{P1}/{P2}/{P3}");
//        response.prettyPrint();

        //3.way Recordclass kullanarak payload alma
        DeliveryProductsRequestBody deliveryProductsRequestBody=new DeliveryProductsRequestBody(deliveryType,180,
                30,20,4,estimatedDeliveryTime);
        response = given(spec).body(deliveryProductsRequestBody).post("{P1}/{P2}/{P3}");
        response.prettyPrint();



    }
    private record DeliveryProductsRequestBody(String[] deliveryType,int freeDeliveryRange,
                                    int maxDeliveryRange,int minFreeDeliveryOrder,
                                    int perMileCost ,String[] estimatedDeliveryTime){}

    @And("user verifies that response has success {string}")
    public void userVerifiesThatResponseHasSuccess(String expectedSuccess) {
        assertEquals(expectedSuccess, response.jsonPath().getString("success"));
//        response.then().assertThat()
//                .statusCode(200).
//                and().assertThat()
//                .body(expectedSuccess, equalTo(true));
    }
}
