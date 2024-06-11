package stepDefinitions.apiStepDefs;

import enums.USER_INFO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static baseUrl.BaseUrl.apiSetup;
import static org.junit.Assert.assertEquals;
import static utilities.Api_utilities.response;


public class US_100_Login_API {

    @Given("user logs in api as BUYER")
    public void userLogsInApiAsBUYER() {
        apiSetup(USER_INFO.BUYER_CREDENTIAL.getEmail(), USER_INFO.BUYER_CREDENTIAL.getPassword());
    }

    @Then("the user verifies that the status code is {int}")
    public void theUserVerifiesThatTheStatusCodeIs(int statusCode) {
        assertEquals(statusCode,response.statusCode());
        assertEquals(true,response.jsonPath().getBoolean("success") );

    }

    @Given("user logs in api as SELLER")
    public void userLogsInApiAsSELLER() {
        apiSetup(USER_INFO.SELLER_CREDENTIALS.getEmail(), USER_INFO.SELLER_CREDENTIALS.getPassword());
    }

    @Given("user logs in api as BUYEROMER")
    public void userLogsInApiAsBUYEROMER() {
        apiSetup(USER_INFO.BUYEROMER_CREDENTIAL.getEmail(), USER_INFO.BUYEROMER_CREDENTIAL.getPassword());
    }

    @Given("user logs in api as SELLEROMER")
    public void userLogsInApiAsSELLEROMER() {
        apiSetup(USER_INFO.SELLEROMER_CREDENTIALS.getEmail(), USER_INFO.SELLEROMER_CREDENTIALS.getPassword());
    }

    @Given("user logs in api as SELLERGUL")
    public void userLogsInApiAsSELLERGUL() {
        apiSetup(USER_INFO.SELLERGUL_CREDENTIAL.getEmail(), USER_INFO.SELLERGUL_CREDENTIAL.getPassword());
    }
}





































