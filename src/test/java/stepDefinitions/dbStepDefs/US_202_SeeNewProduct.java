package stepDefinitions.dbStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DB_utilities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static utilities.DB_utilities.resultSet;

public class US_202_SeeNewProduct {

    @Given("user creates new product from db")
    public void user_creates_new_product_from_db() {
        DB_utilities.insertStatement("INSERT INTO product_request (requester_id,title,is_completed,description,related_hub,product_listing_state) VALUES ('1180','RoseDataBase',0,'flower','HERBS_AND_FLOWERS_HUB','IN_REVIEW') ");

    }

    @When("user sees the product from database")
    public void user_sees_the_product_from_database() throws SQLException {
        DB_utilities.selectQueryStatement("select requester_id,title ,related_hub, from product_request");
        while (resultSet.next()) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            System.out.println("resultSet.getInt(\"requester_id\") = " + resultSet.getInt("requester_id"));
            System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
            if (resultSet.getString(2).contains("RoseDataBase")) {
                System.out.println("RoseDateBase is created");
            }
        }
    }

    @When("user changes status the product as approved")
    public void user_changes_status_the_product_as_approved() {
        DB_utilities.approvedRequestLastProduct();
    }

    @Then("user deletes the product")
    public void user_deletes_the_product() {
        DB_utilities.deleteQuery("delete from product_request where title='RoseDataBase'");
    }
}


