package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_105_AddingNewAddress {

    Response response;

       @Given("user logs in api as a Seller")
       public void user_logs_in_api_as_a_seller() {
        /*
        /account/address/addAddress
             {
            "address": "15 Nyroy Dr.",
            "city": "Troy",
            "isDefault": true,
            "isSellerAddress": true,
            "postal": "12180",
            "state": "NY",
            "title": "Online"
        }
     */

    }
        @When("user add new Address")
        public void userAddNewAddress () {

           //AddAddress105Pojo addAddress105Pojo = new AddAddress105Pojo("15 Nyroy Dr.", "Troy", true, true , "12180", "NY", "Online");

            //set the URL
            spec.pathParams("P1", "account", "P2", "address", "P3", "addAddress");

            //set the expected data
            Map<String, Object> addingData = new HashMap<>();
            addingData.put("address", "15 Nyroy Dr.");
            addingData.put("city", "Troys");
            addingData.put("isDefault", true);
            addingData.put("isSellerAddress", true);
            addingData.put("postal", "12181");
            addingData.put("state", "NY");
            addingData.put("title", "Online");

            //send the request, get the response
            response = given(spec).body(addingData).post("{P1}/{P2}/{P3}");
            response.prettyPrint();
        }

        @Then("User verifies that success is True")
        public void userVerifiesThatSuccessIsTrue() {

            JsonPath jsonPath = response.jsonPath();
            assertEquals(true, jsonPath.getBoolean("success"));
    }


}
