package stepDefinitions.dbStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static utilities.DB_utilities.*;

public class US_203_AddPromoCode {
    Faker faker = new Faker();
    String promoCodeName = faker.name().firstName();
    String startDate = startAndEndDate(-4);
    String endDate = startAndEndDate(5);


    public String startAndEndDate(int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, amount);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    public void createPromoCode(String promoCodeName, String startDate, String endDate, int numberOfUsers, int discount, String discountType) {
        updateQueryStatement("INSERT INTO `promo_code`(`id`, `code`, `starts_at`, `ends_at`, `number_of_users`," +
                " `discount`, `discount_type`)" +
                " VALUES (" + "NULL, '" +  promoCodeName + "','" + startDate + "','" + endDate + "','" + numberOfUsers + "'," +
                "'" + discount + "','" + discountType + "')");
    }

    public record AllPromoCode(int id, String code, String discount) {
    }

        public List<AllPromoCode> readPromoCode() throws SQLException {
          selectQueryStatement("select * from promo_code");
            List<AllPromoCode> list=new ArrayList<>();
            while(resultSet.next()){
                list.add(new AllPromoCode(
                        resultSet.getInt("id"),
                        resultSet.getString("code"),
                        resultSet.getString("discount")
                ));
            }
            return list;
        }

        public void verifyColumnNames() throws SQLException {
            selectQueryStatement("select * from promo_code");
            while (resultSet.next()) {
                String actualPromoCodeName = resultSet.getString("code");
                int actualDiscount = resultSet.getInt("discount");
                if (promoCodeName.equals(actualPromoCodeName) && (12==actualDiscount)) {
                    System.out.println("promo code created successfully in database");
                    System.out.println("actualDiscount = " + actualDiscount);
                    System.out.println("actualPromoCodeName = " + actualPromoCodeName);
                    break;
                }
            }
        }


            @When("Add new promo code")
            public void add_new_promo_code () {
                createPromoCode(promoCodeName, startDate, endDate, 120, 12, "special");
            }

            @Then("verify that new promo code is in the DataBase")
            public void verify_that_new_promo_code_is_in_the_DataBase () throws SQLException {
             Assert.assertTrue(readPromoCode()
                     .stream()
                     .anyMatch(t -> t.code().equals(promoCodeName)));

             verifyColumnNames();
            }



        }





