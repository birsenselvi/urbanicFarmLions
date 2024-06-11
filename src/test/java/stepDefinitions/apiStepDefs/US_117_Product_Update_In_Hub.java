package stepDefinitions.apiStepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.CommonPage;
import pages.ProductPage;
import utilities.DB_utilities;
import utilities.ReusableMethods;
import io.restassured.path.json.JsonPath;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static stepDefinitions.Hooks.driver;
import static utilities.DB_utilities.updateQueryStatement;

public class US_117_Product_Update_In_Hub extends CommonPage {
    Response response;
    int eskiBoyut;
    @When("User updates an existing product.")
    public void user_updates_an_existing_product() {
     // set URL --->account/hub/product/update

//     {
//  "success": true,
//  "descr": "Product added.",
//  "product": {
//    "id": 57519,
//    "uniqueName": "SEED_TOMATO_MINT",
//    "price": 4.99,
//    "stock": 7,
//    "unit": "EACH",
//    "packQuantity": null,
//    "isActive": true,
//    "sellerDescription": null,
//    "isOrganic": true,
//    "isTrade": false,
//    "tradeDescription": null,
//    "productListingState": "IN_REVIEW",
//    "hubProductImages": [],
//    "product": null
//  }

//hubUniqueName: SEED_HUB
//price: 4.99
//productUniqueName: SEED_TOMATO_GOLD_CHERRY
//sellerDescription: %Organic
//tradeDescription:
//stock: 7
//unit: UNIT_LIBRE
//isOrganic: false
//isTrade: false
//packQuantity: NaN
        //hubUniqueName: SEED_HUB
        //price: 3
        //productUniqueName: SEED_CUCUMBER_AMERICAN_SLICING
        //sellerDescription:
        //tradeDescription:
        //stock: 5
        //unit: UNIT_LIBRE
        //isOrganic: false
        //isTrade: false
        //packQuantity: NaN

        //delete product
        eskiBoyut = getProductPage().eklenmisUrunlerinIsimleri.size();

        if (eskiBoyut>8){
            Map<Object, Object> map = new HashMap<>();

            map.put("hubUniqueName","DAIRY_HUB");
            map.put("productUniqueName","DAIRY_EGG");

            response= given(spec).when().body(map).post("account/hub/product/delete");

            response.prettyPrint();
        }
        //add product
        Map<String,Object>addProduct=new HashMap<>();
        addProduct.put("hubUniqueName","DAIRY_HUB");
        addProduct.put("price",2.99);
        addProduct.put("productUniqueName","DAIRY_EGG");
        addProduct.put("sellerDescription","");
        addProduct.put("tradeDescription","");
        addProduct.put("stock",7);
        addProduct.put("unit","EACH");
        addProduct.put("isOrganic",true);
        addProduct.put("isTrade",false);
        addProduct.put("packQuantity","");
        response = given(spec).body(addProduct).when().post("account/hub/product/add");
        response.prettyPrint();

        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("productUniqueName","DAIRY_EGG");
        expectedData.put("hubUniqueName","DAIRY_HUB");
        expectedData.put("price",15);
        expectedData.put("stock",20);

        response = given(spec).body(expectedData).when().post("account/hub/product/update");
        response.prettyPrint();























    }
}
