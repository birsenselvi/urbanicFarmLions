package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Api_utilities.response;

public class US_116_AddAProductToHub {
    AddProductToHubPayload addProductToHubPayload = new AddProductToHubPayload("WORM_HUB",
            23, "WORM_MANURE", 12, "UNIT_LIBRE", true);

    @When("user sends a post request to add a product to the hub")
    public void userSendsAPostRequestToAddAProductToTheHub() {
        spec.pathParams("P1", "account", "P2", "hub", "P3", "product", "P4", "add");

        response = given(spec).body(addProductToHubPayload).when().post("{P1}/{P2}/{P3}/{P4}");
        response.prettyPrint();

    }

    record AddProductToHubPayload(String hubUniqueName, int price, String productUniqueName, int stock,
                                  String unit, boolean isOrganic) {
    }

    @And("user verifies descr is {string}")
    public void userVerifiesDescrIs(String expectedMessage) {
        String actualMessage = response.jsonPath().getString("descr");
        assertEquals(expectedMessage, actualMessage);

    }

    @And("product details should be as expected.")
    public void productDetailsShouldBeAsExpected() {
        response.then()
                .assertThat()
                .body("product.uniqueName", equalTo(addProductToHubPayload.productUniqueName))
                .body("product.price", equalTo(addProductToHubPayload.price))
                .body("product.stock", equalTo(addProductToHubPayload.stock))
                .body("product.unit", equalTo(addProductToHubPayload.unit))
                .body("product.isOrganic", equalTo(addProductToHubPayload.isOrganic))
                .body("product.product.hubTitle", equalTo(addProductToHubPayload.hubUniqueName));
    }

    @When("user send a request to delete the product")
    public void userSendARequestToDeleteTheProduct() {
        spec.pathParams("P1", "account", "P2", "hub", "P3", "product", "P4", "delete");
        Map<String, String> payload = new HashMap<>();
        payload.put("hubUniqueName", "WORM_HUB");
        payload.put("productUniqueName", "WORM_MANURE");
        response = given(spec).body(payload).when().post("{P1}/{P2}/{P3}/{P4}");

        response.prettyPrint();

    }
}
