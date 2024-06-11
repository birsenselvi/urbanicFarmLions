package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Api_utilities.response;

public class US_136_DeleteEvent {
    @When("user deletes event for api")
    public void user_deletes_event_for_api() {
       response=given(spec)
               .contentType(ContentType.MULTIPART)
               .multiPart("eventId",US_133_CreateEvent.eventId)
               .when()
               .post("/account/event/delete")
               .prettyPeek();

    }

    @Then("user verifies that the event has been deleted")
    public void user_verifies_that_the_event_has_been_deleted() {
        response.then()
                .statusCode(200)
                .body("success", equalTo(true), "descr", equalTo("Event deleted"));

        response.prettyPrint();
    }
}
