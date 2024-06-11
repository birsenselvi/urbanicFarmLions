package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_122_Orders {
    @When("the user connects to the getmyBuys api")
    public void the_user_connects_to_the_getmy_buys_api() {
        response=given(spec).when().post("account/order/get/myBuys");
        response.prettyPrint();
    }
    @Then("the user verifies buyer ids numbers more than one")
    public void the_user_verifies_buyer_ids_numbers_more_than_one() {

        List<Object> id = response.jsonPath().getList("id");
        Assert.assertTrue(id.size()>1);

    }


}
