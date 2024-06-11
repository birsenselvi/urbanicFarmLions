package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_131_GoToPayment {
    @When("user submits a post request to go to payment")
    public void userSubmitsAPostRequestToGoToPayment() {
        spec.pathParams("P1", "account", "P2", "event", "P3", "attendance", "P4", "gotopayment");
        Map<String, Integer> payload = new HashMap<>();
        payload.put("attendanceId", US_130_RegisterEvent.attandanceId);
        response = given(spec).body(payload).when().post("{P1}/{P2}/{P3}/{P4}");
        response.prettyPrint();
    }
}
