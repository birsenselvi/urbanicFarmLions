package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_130_RegisterEvent {
    List<Integer> eventIds;
    static int attandanceId;
    @When("user get all existing events thorough api")
    public void userGetAllExistingEventsThoroughApi() {
        spec.pathParams("P1", "public", "P2", "getAllEvents");
   String payload="{\n" +
           "  \"cancelToken\": {\n" +
           "    \"promise\": {}\n" +
           "  }\n" +
           "}";
        response = given(spec).body(payload).when().post("{P1}/{P2}");
        response.prettyPrint();
        eventIds =response.jsonPath().getList("events.id");
        System.out.println("eventIds = " + eventIds);
    }

    @And("user sends a post request to register an existing event")
    public void userSendsAPostRequestToRegisterAnExistingEvent() {
        spec.pathParams("P1", "account", "P2", "event", "P3", "register");
        int randomEventId=new Random().nextInt(eventIds.size());
        Map<String,Integer> requestBody=new HashMap<>();
        requestBody.put("eventId",randomEventId);
        requestBody.put("numberOfAttendees",1);

        response = given(spec).body(requestBody).when().post("{P1}/{P2}/{P3}");
        response.prettyPrint();
        attandanceId=response.jsonPath().getInt("attendanceId");

    }
}
