package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Api_utilities.response;

public class US_135_CancelEvent {
    @When("user cancels event for api")
    public void user_cancels_event_for_api() {
      response= given(spec)
              .contentType(ContentType.MULTIPART)
              .multiPart("eventId",US_133_CreateEvent.eventId)
              .when()
              .post("/account/event/cancel")
              .prettyPeek();
    }

    @Then("user verifies that the event has been canceled")
    public void user_verifies_that_the_event_has_been_canceled() {
      response.then()
              .statusCode(200)
              .body("success",equalTo(true),"descr",equalTo("Event canceled"));

        response.prettyPrint();
    }

}
