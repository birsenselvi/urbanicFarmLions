package stepDefinitions.apiStepDefs;

import enums.USER_INFO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.apiSetup;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_101_Login_Send_Messages_To_Seller {

    @When("user sends a message to Contact Us")
    public void user_sends_a_message_to_contact_us() {
        //setURL
        ///public/contact
        spec.pathParams("P1","public","P2","contact");
        //set expected data
        /*
        {
  "email": "sellerNur@gmail.com",
  "message": "string",
  "name": "Hi i want to sell strawberries in spring parade.",
  "subject": "Parade"
}
         */
        Map<String,String> expectedData=new HashMap<>();
        expectedData.put("email", "sellerNur@gmail.com");
        expectedData.put("message", "Hi i want to sell strawberries in spring parade.");
        expectedData.put("name", "nur");
        expectedData.put("subject", "Parade");

        //send to request and get to responds
        response=given(spec)
                .body(expectedData)
                .post("{P1}/{P2}");
        response.prettyPrint();

    }
}
