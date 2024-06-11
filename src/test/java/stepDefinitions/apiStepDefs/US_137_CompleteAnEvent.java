package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.Map;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_137_CompleteAnEvent {
    @When("user completes an event")
    public void user_completes_an_event() {
        //set url
        // /account/event/complete
        spec.pathParams("P1","account","P2","event","P3","complete");


        //set expectedData
        //{
        // "eventId":243
        // }
        Map<String,Integer> expectedData=new HashMap<>();
        expectedData.put("eventId",243);


        //send the request and get the response
        response=given(spec)
                .body(expectedData)
                .when()
                .post("{P1}/{P2}/{P3}")
                .prettyPeek();



    }

}
