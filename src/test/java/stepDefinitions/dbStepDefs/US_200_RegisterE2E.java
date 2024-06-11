package stepDefinitions.dbStepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DB_utilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import static stepDefinitions.apiStepDefs.US_133_CreateEvent.eventTitle;
import static stepDefinitions.uiStepDefs.register.US_033_RegisterPage.emailDB;
import static utilities.DB_utilities.resultSet;

public class US_200_RegisterE2E {
    @Given("user verifies following column names are present in {string} table")
    public void user_verifies_following_column_names_are_present_in_table(String string, DataTable dataTable) throws SQLException {
        List<String> namesColumn = dataTable.column(0);
        DB_utilities.selectQueryStatement("select email ,first_name, id from urbanicfarm.`user`");
       resultSet.next();
        for (int i = 0; i < namesColumn.size(); i++) {
            ResultSetMetaData rsmd= resultSet.getMetaData();//rmsd bize colon isimlerini getirir result set ile calisir
            System.out.println("rsmd.getColumnName(i+1) = " + rsmd.getColumnName(i + 1));
            Assert.assertEquals(namesColumn.get(i),rsmd.getColumnName(i+1));

        }

    }
    @When("user verifies the added user exists")
    public void user_verifies_the_added_user_exists() throws SQLException {
        DB_utilities.selectQueryStatement("select * from urbanicfarm.`user`  order by id desc");
        while (resultSet.next()){
            String actuelEmail= resultSet.getString("email");
            String actuelFirstname= resultSet.getString("first_name");
            String expectedFirstname="Andrew";
           
            if(emailDB.equals(actuelEmail)&&expectedFirstname.equals(actuelFirstname)){
                System.out.println("user add successfully in database");
                break;
            }
        }
    }

    @Then("user deletes last record")
    public void user_deletes_last_record() {
        //  DB_utilities.updateQueryStatement("delete from urbanicfar.`user` where email= '"+emailDB+"'");

    }

}
