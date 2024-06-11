package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.lang.management.ManagementPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static utilities.Api_utilities.response;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_120_getProductRequest {
    @When("user get all requested products' information")
    public void user_get_all_requested_products_information() {
        // set the url
       // /account/getProductRequests
        spec.pathParams("P1","account", "P2","getProductRequests");

        //set the expected data
        //relatedHub":"HERBS_AND_FLOWERS_HUB
        Map<String,String> expectedData=new HashMap<>();
        expectedData.put("relatedHub","HERBS_AND_FLOWERS_HUB");

        //send request and get the response
        response = given(spec)
                .body(expectedData)
                .post("{P1}/{P2}");
        response.prettyPrint();


    }
    @Then("user verifies product request title {string}")
    public void user_verifies_product_request_title(String title) {
//do assertion
        JsonPath jsonpath=response.jsonPath();
        String actual=jsonpath.getString("productRequests.title");
        System.out.println("actual= "+ actual);
       Assert.assertTrue(actual.contains(title));
    }


}
