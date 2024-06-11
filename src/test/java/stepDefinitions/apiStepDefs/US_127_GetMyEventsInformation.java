package stepDefinitions.apiStepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utilities.Api_utilities.response;
import static baseUrl.BaseUrl.spec;



public class US_127_GetMyEventsInformation {

    @When("user receives the all my events info")
    public void userReceivesTheAllMyEventsInfo() {
        response=given(spec)
                .when()
                .post("account/event/getMyEvents")
                .prettyPeek();
    }

    @And("the response body should contain details of all my events")
    public void theResponseBodyShouldContainDetailsOfAllMyEvents() {
        JsonPath jsonPath = response.jsonPath();
        List<Object> id = jsonPath.getList("events.id");
        assertTrue(id.size()>0);

        List<Object> title = jsonPath.getList("events.title");
        title.forEach(n -> assertNotNull(n));

//        System.out.println("title.toString() = " + title.toString());
    }


}
