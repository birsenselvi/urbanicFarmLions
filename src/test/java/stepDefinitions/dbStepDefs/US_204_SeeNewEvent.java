package stepDefinitions.dbStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DB_utilities;
import java.sql.SQLException;
import static stepDefinitions.apiStepDefs.US_133_CreateEvent.eventTitle;
import static utilities.DB_utilities.resultSet;

public class US_204_SeeNewEvent {
    String QUERY = "SELECT id,address_id,owner_id, title,date,fee,duration,attendee_limit,schedule,description ,tac ,status ,created ,updated ,is_active, is_refundable,refundable_up_to_day FROM event ORDER BY id DESC limit 1;";

    @When("user should be able to see event that user created")
    public void user_should_be_able_to_see_event_that_user_created() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()) {
            System.out.println("event's id " + resultSet.getString("id"));
            System.out.println("event's title " + resultSet.getString("title"));

        }
    }

    @Then("user verifies the created user an event")
    public void userVerifiesTheCreatedUserEvent() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()) {
            String actualTitle = resultSet.getString("title");
            if (eventTitle.equals(actualTitle)) {
                System.out.println("user created an event successfully in database");
                break;

            }
        }
    }

    @And("user deletes last record for event")
    public void userDeletesLastRecordForEvent() {
       // DB_utilities.updateQueryStatement("delete from urbanicfarm.`event` where title= '"+eventTitle+"'");
    }
}