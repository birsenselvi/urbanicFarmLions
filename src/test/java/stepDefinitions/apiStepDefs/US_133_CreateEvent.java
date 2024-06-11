package stepDefinitions.apiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import pojos.CreateEventPojo;
import java.util.HashMap;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_133_CreateEvent {
    CreateEventPojo createEventPojo;
    static Faker faker = new Faker();
    public static String eventTitle;
    public static int eventId;

    public  String eventName() {
        String eventName = faker.name().title();
        return eventName;
    }

    @When("user creates a new event for api")
    public void user_creates_a_new_event_for_api() {
        //set the url
        //set the expected data
        eventTitle = eventName();
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("title", eventTitle);
        expectedData.put("date", "2025-12-12T15:15");
        expectedData.put("fee", 30);
        expectedData.put("duration", 30);
        expectedData.put("attendeeLimit", 30);
        expectedData.put("addressId", 3194);
        expectedData.put("tac", "no");
        //send request/get the response
        response = given(spec)
                .body(expectedData)
                .post("account/event/create");
        response.prettyPrint();

        eventId = response.jsonPath().getInt("event.id");

        // pojo 2.Way
//        createEventPojo = new CreateEventPojo(eventTitle,"2025-12-12T15:15",40,40,40,3161,"NO");
//        response= given(spec).body(createEventPojo).when().post("account/event/create").prettyPeek();
//        eventId= response.jsonPath().getInt("event.id");
    }

    @Then("user verifies that the new event has been created")
    public void user_verifies_that_the_new_event_has_been_created() {
        //do assertion
        String expectedText = "Event created";
        // 1.way
        JsonPath jsonPath= response.jsonPath();
//        Assert.assertEquals(eventTitle,jsonPath.getString("event.title"));
        Assert.assertEquals(eventId,jsonPath.getInt("event.id"));
        Assert.assertEquals(expectedText,jsonPath.getString("descr"));

        //2.way
//        response.then().statusCode(200)
//                .contentType(ContentType.JSON)
//                .body("event.title", equalTo(eventTitle), "descr", equalTo(expectedText), "event.id", equalTo(eventId));
       // response.prettyPrint();
    }
}



