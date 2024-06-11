package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.AddAdressPojo;

import java.util.HashMap;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US_106_UpdateAddress {
    Response response;
    int id;
    @When("the user add new address")
    public void theUserAddNewAddress() {
        /* account/address/addAddress
        address: "171 Thorn St, Apollo, PA 15613, USA"
        city: "Apollo"
        isDefault: true
        isSellerAddress: false
        postal: "15613"
        state:"Westmoreland County"
        title:"Home"
         */
        AddAdressPojo addAdressPojo = new AddAdressPojo("171 Thorn St, Apollo, PA 15613, USA", "Apollo", true, false, "15613", "Westmoreland County", "Home");
        spec.pathParams("P1", "account", "P2", "address", "P3", "addAddress");
        response = given(spec).body(addAdressPojo).post("{P1}/{P2}/{P3}");
//        response.prettyPrint();
        id = response.jsonPath().getInt("address.id");
        System.out.println("id = " + id);
    }


    @And("user update address")
    public void userUpdateAddress() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("addressId", id);
        data.put("title","Home");
        data.put("address","street45");
        spec.pathParams("P1", "account", "P2", "address", "P3", "update");
        response = given(spec).body(data).when().post("{P1}/{P2}/{P3}");
        response.prettyPrint();
    }

    @Then("the user verifies that success is True")
    public void theUserVerifiesThatSuccessIsTrue() {
        JsonPath jsonPath = response.jsonPath();
        assertEquals(true, jsonPath.getBoolean("success"));
        assertEquals("Address updated", jsonPath.getString("descr"));
    }
}
