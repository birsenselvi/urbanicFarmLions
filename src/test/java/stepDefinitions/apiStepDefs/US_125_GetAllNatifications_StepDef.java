package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_125_GetAllNatifications_StepDef {
    @When("user gets access to all notificatins")
    public void userGetsAccessToAllNotificatins() {
        //1.Set the url
        //             /account/notifications/getAll
        spec.pathParams("P1","account","P2","notifications","P3","getAll");
        //2.Set the expected data

        //3. Send the request and get the response
        response=given(spec).
                post("{P1}/{P2}/{P3}");
        response.prettyPrint();

    }

    @And("user verifies Notification details")
    public void userVerifiesNotificationDetails() {
        JsonPath jsonPath = response.jsonPath();
        String title = jsonPath.getString("notifications[0].title");
        System.out.println("Title from JSON response: " + title);
        Assert.assertEquals("Event Published", title);
    }
}
