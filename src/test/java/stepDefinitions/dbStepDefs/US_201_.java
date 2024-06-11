package stepDefinitions.dbStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DB_utilities;

import java.sql.SQLException;

import static stepDefinitions.apiStepDefs.US_133_CreateEvent.eventTitle;
import static utilities.DB_utilities.resultSet;

public class US_201_ {
String QUERY = "select id, title, address, city from address order by id desc limit 1";

    @When("user is able to see the created new address")
    public void user_should_be_able_to_see_address_that_user_created() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()) {
            System.out.println("address's city " + resultSet.getString("city"));

        }


    }


    @Then("user verifies the created address details")
    public void userVerifiesTheCreatedUserAnAddress() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);

        while (resultSet.next()) {
String expectedCity = "Troys";
            String actualCity = resultSet.getString("city");

            if (expectedCity.equals(actualCity)) {

                System.out.println("user created an address successfully in database");

                break;



            }

        }
    }
}
