package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.CommonPage;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;

public class US_118_Product_Delete_In_Hub extends CommonPage {
    Response response;

    @When("User deletes an existing product.")
    public void user_deletes_an_existing_product() {
        //delete product



            Map<Object, Object> map = new HashMap<>();

            map.put("hubUniqueName","DAIRY_HUB");
            map.put("productUniqueName","DAIRY_EGG");

            response= given(spec).when().body(map).post("account/hub/product/delete");

            response.prettyPrint();


    }
}
