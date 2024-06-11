package stepDefinitions.apiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.AddWeeklyOrder139Pojo;

import java.util.*;

import static baseUrl.BaseUrl.spec;

import static io.restassured.RestAssured.given;
import static utilities.Api_utilities.response;

public class US_139_CreateWeeklyOrder {
    Map<String, Object> createOrder = new HashMap<>();
    Map<String, Integer> avakado = new HashMap<>();
    Map<String, Integer> babanaPappers = new HashMap<>();
    Map<String, Integer> asparagus = new HashMap<>();
    List<Map> order = new ArrayList<>();
    String title = Faker.instance().name().name();
    AddWeeklyOrder139Pojo addWeeklyOrder139Pojo;


    @When("User create a new scheduled order")
    public void userCreateANewScheduledOrder() {
        /*

{"weeklyOrderId":"",
"title":"alisveris",
"subTotal":32.5,
"deliveryCost":5,
"tip":0,
"total":"37.50",
"type":"weekly",
"wo_products":
[
    {"id":7,"wo_productQuantity":6}, //banana pappers
{"id":43,"wo_productQuantity":1},  //avakado
{"id":38,"wo_productQuantity":3}//asparagus
]
}
         */

        babanaPappers.put("id", 7);
        babanaPappers.put("wo_productQuantity", 6);
        avakado.put("id", 43);
        avakado.put("wo_productQuantity", 1);
        asparagus.put("id", 38);
        asparagus.put("wo_productQuantity", 3);

        order.add(babanaPappers);
        order.add(avakado);
        order.add(asparagus);

        createOrder.put("weeklyOrderId", "");
        createOrder.put("title", title);
        createOrder.put("subTotal", 32.5);
        createOrder.put("deliveryCost", 5);
        createOrder.put("tip", 0);
        createOrder.put("total", "37.50");
        createOrder.put("type", "weekly");
        createOrder.put("wo_products", order);
//
//        response =given(spec).body(createOrder).when().post("account/weeklyorder/createWeeklyOrder");
//        response.prettyPrint();

        // 2. way ==>Pojo class
        AddWeeklyOrder139Pojo addWeekly = new AddWeeklyOrder139Pojo();
        addWeekly.setOrders(new ArrayList<>());
        addWeekly.getOrders().add(babanaPappers);
        addWeekly.getOrders().add(avakado);
        addWeekly.getOrders().add(asparagus);


        addWeeklyOrder139Pojo = new AddWeeklyOrder139Pojo("", title, 32.5, 5, 0, "37.50", "weekly", addWeekly.getOrders());



    }

    @Then("User verifies that response is as expected")
    public void userVerifiesThatResponseIsAsExpected() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(title, response.jsonPath().getString("weekly_order.title"));
        Assert.assertEquals("32.5", response.jsonPath().getString("weekly_order.subTotal"));
        //Assert.assertEquals(createOrder.get("total"),response.jsonPath().getString("weekly_order.total"));

    }
}
