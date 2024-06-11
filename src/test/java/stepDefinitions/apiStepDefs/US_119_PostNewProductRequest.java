package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import manifold.ext.props.rt.api.get;
import pages.CommonPage;
import utilities.DB_utilities;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_119_PostNewProductRequest extends CommonPage {

    @When("user requests a new product")
    public void user_requests_a_new_product() {
        //set the url
      //  /account/newProductRequest
        spec.pathParams("P1","account", "P2","newProductRequest");

        Map<String,String> expectedData= new HashMap<>();
        expectedData.put( "description", "flower");
        expectedData.put("relatedHub", "HERBS_AND_FLOWERS_HUB");
        expectedData.put("title", "RedRose");

        response = given(spec)
                .body(expectedData)
                .post("{P1}/{P2}");
        response.prettyPrint();


    }

    @And("user goes to Your requested products-services")
    public void userGoesToYourRequestedProductsServices() {
        ReusableMethods.waitFor(2);
        getProductPage().yourRequestedProductsServices.click();
        ReusableMethods.waitFor(2);

    }

    @When("User approve last added request product from database")
    public void userApproveLastAddedRequestProductFromDatabase() {
        DB_utilities.approvedRequestLastProduct();
        ReusableMethods.waitFor(2);
    }

    @When("user delete the approved a new product")
    public void userDeleteTheApprovedANewProduct() {

    }
}
