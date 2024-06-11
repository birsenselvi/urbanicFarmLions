package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;


public class US_121_GetBasketDetail {

    Response response;
/*
{
  "id": 1,
  "quantity": [],
  "sessionId": "",
  "deliveryTypes": null,
  "products": []
}
 */

    @When("user gets the basket details")
    public void user_gets_the_basket_details() {
        //set the URL (/public/basket/getBasketDetails)
        spec.pathParams("P1","public","P2","basket","P3","getBasketDetails");

        //set the expected data

       Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("id",1);
        expectedData.put("quantity","");
        expectedData.put("sessionId","");
        expectedData.put("deliveryTypes", null);
        expectedData.put("products", "");


        //send the request and get the response
        response = given(spec).post("{P1}/{P2}/{P3}");
        response.prettyPrint();

    }
    @Then("user verifies basket details id")
    public void user_verifies_basket_details_id() {
        //do assertion
       JsonPath jsonpath= response.jsonPath();
       int actualData = jsonpath.getInt("id");
        Assert.assertEquals(1,actualData);

    }

}
