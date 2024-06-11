package stepDefinitions.dbStepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.DB_utilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import static stepDefinitions.apiStepDefs.US_133_CreateEvent.eventTitle;
import static stepDefinitions.uiStepDefs.register.US_033_RegisterPage.emailDB;
import static utilities.DB_utilities.*;

public class US_205_SeeAllEvents extends CommonPage {
    String QUERY="SELECT id,title FROM event ORDER BY id DESC;";

    @Given("user connects to the database")
    public void userCreatesAConnecitonWithDbUsingAnd() {
        //open connection
        DB_utilities.createConnection();
    }

    @When("user should be able to see all events that user created")
    public void iShouldBeAbleToSeeAllEventsThatICreated() throws SQLException {
        //query queries
        DB_utilities.selectQueryStatement(QUERY);
        //display value
        while (resultSet.next()) {
            System.out.println("events' title " + resultSet.getString("title") + "\n");

        }
    }

    @Then("user verifies following column names are present in DB {string} table")
    public void userShouldSeeAllEventsInCorrectSchemaAndColumnsInDB(String string, DataTable dataTable) throws SQLException {
        List<String> namesColumn=dataTable.column(0);
        resultSet.next();
        for (int i=0; i < namesColumn.size(); i++) {
            ResultSetMetaData rsmd=resultSet.getMetaData();
            System.out.println("rsmd.getColumnName(i+1) = " + rsmd.getColumnName(i + 1));
            Assert.assertEquals(namesColumn.get(i), rsmd.getColumnName(i + 1));

        }

    }
    @Then("user verifies the created user events")
    public void userVerifiesTheCreatedUserEvents() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()) {
            String actuelTitle=resultSet.getString("title");
            if (eventTitle.equals(actuelTitle)) {
                System.out.println("user created event successfully in database");
                break;

            }
        }
    }
    @Then("user deletes last event")
    public void user_deletes_last_record() {
        //  DB_utilities.updateQueryStatement("delete from urbanicfarm.`event` where title= '"+eventTitle+"'");

    }
}