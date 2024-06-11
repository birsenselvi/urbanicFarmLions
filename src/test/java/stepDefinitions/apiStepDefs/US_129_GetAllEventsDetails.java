package stepDefinitions.apiStepDefs;

import groovy.json.JsonOutput;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;

import java.util.HashMap;
import java.util.Map;

import static utilities.Api_utilities.response;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_129_GetAllEventsDetails {


    @When("User gets access to all events details")
    public void user_gets_access_to_all_events_details() {

        // Payload oluşturma
        Map<String, Object> payload = new HashMap<>();
        Map<String, Object> innerMap = new HashMap<>();
        Map<String, Object> emptyMap = new HashMap<>();

        innerMap.put("promise", emptyMap);
        payload.put("cancelToken", innerMap);

        // Etkinlik detaylarını almak için HTTP isteği yapılıyor
        response=given(spec).
                body(payload).
                when().post("public/getEvent/427");

        // Payload'ı ve yanıtı yazdırma
        System.out.println(payload);
        response.prettyPrint();
    }
}
