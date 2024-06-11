package stepDefinitions.apiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Api_utilities.response;

public class US_134_UpdateEvent {
    ResponseSpecification responseSpecification;
    Faker faker= new Faker();
    static String newEventTitle;

    public  String updateEventName() {
        String newEventTitle = faker.name().title();
        return newEventTitle;
    }

    @When("user updates event for api")
    public void user_updates_event_for_api() {
        newEventTitle=updateEventName();

        HashMap<String,Object> datasForUpdateEvent = new HashMap<>();
        datasForUpdateEvent.put("eventId",US_133_CreateEvent.eventId);
        datasForUpdateEvent.put("title",newEventTitle);

        response=given(spec)
                .contentType(ContentType.JSON)
                .body(datasForUpdateEvent)
                .when()
                .post("account/event/update")
                .prettyPeek();
    }

    @Then("user verifies that the event has been updated")
    public void user_verifies_that_the_event_has_been_updated() {
        String expectedTextForUpdate="Event updated";
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("event.title", equalTo(newEventTitle),"descr",equalTo(expectedTextForUpdate));

        response.prettyPrint();

//        System.out.println("response.jsonPath().getString(\"descr\") = " + response.jsonPath().getString("descr"));

        //2.way
        //responseSpecification icine assert etmek istediklerimizi ekliyoruz. sonra bunu cagirinca otomatik test ediyor
        // ama buna ortak verify olacaklari yazsak daha iyi olur api utilities classinda vs.
//        responseSpecification= RestAssured.expect();
//        responseSpecification.statusCode(200);
//        responseSpecification.body("success",equalTo(true),"event.title",equalTo(newEventTitle));
//        responseSpecification.body("descr",equalTo(expectedTextForUpdate));
//        response.then().spec(responseSpecification);

    }

}
