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

public class US_128_UserAttendanceInformation {

    @When("user gets the attendance information")
    public void userGetsTheAttendanceInformation() {
        response=given(spec)
                .when()
                .post("account/event/getMyAttendances")
                .prettyPeek();
    }

    @And("the response body should contain details of attendance information")
    public void theResponseBodyShouldContainDetailsOfAttendanceInformation() {
        JsonPath jsonPath = response.jsonPath();
        List<Object> id = jsonPath.getList("attendances.id");
        assertTrue(id.size()>0);


        System.out.println("id.toString() = " + id.toString());
    }
}
