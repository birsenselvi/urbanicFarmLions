package stepDefinitions.apiStepDefs;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.AddAdressPojo;
import pojos.DeleteAdrssPojo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Api_utilities.convertJsonToJawa;



public class US_107_DeleteAdress {

    Response response;
    int id;

    @When("user add new address")
    public void userAddNewAddress() {
//        {
//            "address": "45 rue elaenor",
//                "city": "nice",
//                "isDefault": true,
//                "isSellerAddress": false,
//                "postal": "66450",
//                "state": "France",
//                "title": "Online"
//        }
        AddAdressPojo addAdressPojo = new AddAdressPojo("45 rue tony", "Nice", true, false, "66450", "France", "Online");
        spec.pathParams("P1", "account", "P2", "address", "P3", "addAddress");
        response = given(spec).body(addAdressPojo).post("{P1}/{P2}/{P3}");
        response.prettyPrint();
        id = response.jsonPath().getInt("address.id");
        System.out.println("id = " + id);
    }

    @When("user get the adress")
    //https://test.urbanicfarm.com/api/acount/address/getAddress
    public void userGetTheAdress() {
        spec.pathParams("P1", "account", "P2", "address", "P3", "getAddress");
        response = given(spec).when().post("{P1}/{P2}/{P3}");
        response.prettyPrint();
        List<Object> ids = response.jsonPath().getList("addresses.findAll{it.id=" + id + "}.id");// address ten sonra list vardi
        System.out.println("ids.get(0) = " + ids.get(0));
        Assert.assertEquals(id, ids.get(0));
        //grovy ornekkk======>>>>>>>> List<String> kadinsayisi = jsonPath.getList("data.findAll{it.gender=='female'}.gender")
        //List<String>listtitle=jsonPath.getList("findAll{it.id<5}.title");
    }

    @And("user delete address")
    public void userDeleteAddress() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("addressId", id);
        spec.pathParams("P1", "account", "P2", "address", "P3", "delete");
        response = given(spec).body(data).when().post("{P1}/{P2}/{P3}");
        response.prettyPrint();

    }

    @Then("User verifies that success is true")
    public void userVerifiesThatSuccessIsTrue() {
        //        {
//            "success": true,
//                "descr": "Address deleted"
//        }

        //1.a validadion
        response.then().statusCode(200)
                .contentType(ContentType.JSON).
                body("success", equalTo(true))
                .body("descr", equalTo("Address deleted"));
        //1.b way ==> bu yol soft assertion gibidir.
        //Tek body() methodu içerisinde çoklu assertion yaparak soft assertion oluşturabilirsiniz. Fail durumunda body() içerisinde Java çalışmayı durdurmaz.
        //Çoklu body() methodu ile assertion yapıldığında fail durumunda Java bir sonraki body() methodu öncesi çaılışmayı durdurur.
        response.then().statusCode(200)
                .contentType(ContentType.JSON).
                body("success", equalTo(true), "descr", equalTo("Address deleted"));

        //2.validadion
        JsonPath jsonPath = response.jsonPath();
        assertEquals(true, jsonPath.getBoolean("success"));
        assertEquals("Address deleted", jsonPath.getString("descr"));

        //3.validadion ==>hashmap
        Map<String,Object> expectedData= new HashMap<>();
        expectedData.put("success", true);
        expectedData.put("descr", "Address deleted");

        Map<String, Object> actuelData = response.as(HashMap.class);
        assertEquals(expectedData.get("succes"), actuelData.get("succes"));
        assertEquals(expectedData.get("descr"), actuelData.get("descr"));

        //4.validadion ==>Pojo
        DeleteAdrssPojo expectedDataDelete = new DeleteAdrssPojo(true, "Address deleted");
        DeleteAdrssPojo actualData = response.as(DeleteAdrssPojo.class);
        assertEquals(expectedDataDelete.isSuccess(), actualData.isSuccess());
        assertEquals(expectedDataDelete.getDescr(), actualData.getDescr());

        //5. validation ==>object mapper
        //DeleteAdrssPojo actualObjectMapper=new ObjectMapper().readValue(response.asString(),DeleteAdrssPojo.class);
        DeleteAdrssPojo actualObjectMapper = convertJsonToJawa(response.asString(), DeleteAdrssPojo.class);
        assertEquals(expectedDataDelete.isSuccess(), actualObjectMapper.isSuccess());
        assertEquals(expectedDataDelete.getDescr(), actualObjectMapper.getDescr());

        //6. Validation ==>Gson
        DeleteAdrssPojo actualDataGson = new Gson().fromJson(response.asString(), DeleteAdrssPojo.class);
        assertEquals(expectedDataDelete.isSuccess(), actualDataGson.isSuccess());
        assertEquals(expectedDataDelete.getDescr(), actualDataGson.getDescr());

    }
}
