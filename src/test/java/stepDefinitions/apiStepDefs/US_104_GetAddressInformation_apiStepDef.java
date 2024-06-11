package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import java.util.List;
import java.util.Map;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_104_GetAddressInformation_apiStepDef {
    @When("User gets access to addrress information")
    public void userGetsAccessToAddrressInformation() {
        //1.Set the Url
        //        /account/address/getAddress
        spec.pathParams("P1","account","P2","address","P3","getAddress");

        //2.Set the expected data

        //3. Send the request and get the response
        response=given(spec).
                post("{P1}/{P2}/{P3}");
        response.prettyPrint();

    }

    //4. do assertion:
    //Then user verifies success true - And user verifies address details

    @Then("user verifies address details")
    public void user_verifies_address_details() {

        // Extract address details from the JSON response
        JsonPath jsonPath = response.jsonPath(); // Create JsonPath object
        int addressId = jsonPath.getInt("addresses[0].id");
        String addressTitle = jsonPath.getString("addresses[0].title");
        String address = jsonPath.getString("addresses[0].address");
        String city = jsonPath.getString("addresses[0].city");
        String state = jsonPath.getString("addresses[0].state");
        String postal = jsonPath.getString("addresses[0].postal");

        // Perform assertions
        Assert.assertTrue("Address ID is not null or zero", addressId > 0);
        Assert.assertEquals("Address title is", "Emily's Shop", addressTitle);
        Assert.assertEquals("Address", "California, MD, Amerika Birleşik Devletleri", address);
        Assert.assertEquals("City is ", "California", city);
        Assert.assertEquals("State is ", "St. Mary's County", state);
        Assert.assertEquals("Postal code is", "95170", postal);

        // Extract address details from the JSON response for all addresses
        List<Map<String, ?>> addressesList = jsonPath.getList("addresses");
        for (Map<String, ?> addressMap : addressesList) {
            int addressIdEach = (Integer) addressMap.get("id");
            String addressTitleEach = (String) addressMap.get("title");
            // Extract other details as needed...

            // Perform assertions for each address
        }
    }
}
