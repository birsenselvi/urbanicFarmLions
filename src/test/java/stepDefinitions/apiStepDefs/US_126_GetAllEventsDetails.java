package stepDefinitions.apiStepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utilities.Api_utilities.response;

public class US_126_GetAllEventsDetails {
    @When("user gets the all events details")
    public void userGetsTheAllEventsDetails() {
        //set the url
        response=given(spec)
                .when()
                .post("public/getAllEvents")
                .prettyPeek();


    }


    @And("the response body should contain details of all events")
    public void theResponseBodyShouldContainDetailsOfAllEvents() {
        JsonPath jsonPath = response.jsonPath();
        List<Object> id = jsonPath.getList("events.id");
        assertTrue(id.size()>0);

        List<Object> title = jsonPath.getList("events.title");
        title.forEach(n -> assertNotNull(n));




    }
}
