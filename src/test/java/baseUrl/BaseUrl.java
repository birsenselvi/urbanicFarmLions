package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utilities.Api_utilities.generateToken;


public class BaseUrl {
    public static RequestSpecification spec;

    public static void apiSetup(String email, String password){
        spec=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer " +generateToken(email, password))
                .setBaseUri("https://test.urbanicfarm.com/api/")
                .setRelaxedHTTPSValidation()
                .build();
    }

}
