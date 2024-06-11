package stepDefinitions.apiStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import java.util.List;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static utilities.Api_utilities.response;

public class US_138_Getting_Weekly_OrderList {
    @When("user gets WeeklyOrderList")
    public void userGetsWeeklyOrderList() {
        response=given(spec)
                .when()
                .post("account/weeklyorder/getWeeklyOrderList")
                .prettyPeek();

    }

    @And("the response body should contain details of all weekly orderlists")
    public void theResponseBodyShouldContainDetailsOfAllOrderlists() {
        JsonPath jsonPath = response.jsonPath();


        List<Object> weeklyOrder = jsonPath.getList("title");
        weeklyOrder.forEach(n -> Assert.assertNotNull(n));

       // System.out.println(weeklyOrder.toString());

        List<Object> id = jsonPath.getList("id");
        assertTrue(id.size() > 0);


    }


}
