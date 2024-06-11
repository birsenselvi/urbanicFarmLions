package stepDefinitions.dbStepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DB_utilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.apiStepDefs.US_133_CreateEvent.eventTitle;
import static utilities.DB_utilities.resultSet;

public class US_206_SendMessage {

    String QUERY = "SELECT id,content FROM message ORDER BY id DESC;";
    List<String>content = new ArrayList<>();
    List<Integer>id = new ArrayList<>();

    @When("user should be able to see all message that user send")
    public void user_should_be_able_to_see_all_message_that_user_send() throws SQLException {

        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()) {
            System.out.println("message' id " + resultSet.getString("id") + "\n");
            System.out.println("message' content " + resultSet.getString("content") + "\n");

        }
    }

    @Then("userela verifies following column names are present in DB {string} table")
    public void userelaVerifiesFollowingColumnNamesArePresentInDBTable(String string, DataTable dataTable) throws SQLException {
        List<String> namesColumn = dataTable.column(0);
        DB_utilities.selectQueryStatement(QUERY);
        for (int i = 0; i < namesColumn.size(); i++) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            resultSet.next();
            System.out.println("rsmd.getColumnName(i+1) = " + rsmd.getColumnName(i + 1));
            Assert.assertEquals(namesColumn.get(i), rsmd.getColumnName(i + 1));

        }
    }
    @Then("user verifies the message that user send")
    public void user_verifies_the_message_that_user_send() throws SQLException {
        DB_utilities.selectQueryStatement(QUERY);
        while (resultSet.next()){
            content.add(resultSet.getString("content"));
            id.add(resultSet.getInt("id"));
        }
        System.out.println(id);
        System.out.println(content);
        Assert.assertTrue(content.contains("Test 1-2-3"));

    }
}
