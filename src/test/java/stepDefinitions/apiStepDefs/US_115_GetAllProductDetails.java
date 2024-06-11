package stepDefinitions.apiStepDefs;

import enums.USER_INFO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import java.util.List;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static utilities.Api_utilities.response;

public class US_115_GetAllProductDetails {

    @When("user gets all product details")
    public void user_gets_all_product_details() {
//        response = RestAssured
//                .given()
//                .when()
//                .post("/public/product/getAllProducts")
//                .prettyPeek();
//        2.waywith spec
//        spec.pathParams("P1","public","P2","product","P3","getAllProducts"); // {P1}/{P2}/{P3}
        response= given(spec)
                .when().post("public/product/getAllProducts")
                .prettyPeek();
    }

    @Then("the response body should contain details of all products")
    public void the_response_body_should_contain_details_of_all_products() {
        JsonPath jsonPath = response.jsonPath();

        List<Object> uniqueName = jsonPath.getList("products.uniqueName");
        uniqueName.forEach(n -> Assert.assertNotNull(n));

        List<Object> id = jsonPath.getList("products.id");
        assertTrue(id.size() > 0);

        List<Object> title = jsonPath.getList("products.title");
        title.forEach(n -> assertNotNull(n));
    }

}
