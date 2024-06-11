package utilities;

import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class Api_utilities {
    public static Response response;

public static String generateToken(String email, String password){
    String urlswagger = "https://test.urbanicfarm.com/api/public/login";
    Map<String, String> token = new HashMap<>();
    token.put("email", email);
    token.put("password", password);


    response = given().
            formParams(token).
            when().post(urlswagger);
    response.prettyPrint();
    return response.jsonPath().getString("token");


}
     //<T> T ==> Herhangi bir data tipi
    //ObjectMapper().readValue(json, cls) methodu birinci parametrede aldığı String
    // formatındaki Json datyı ijkinci parametrede belitilen Java objesine çevirir.

    public static <T> T convertJsonToJawa(String json, Class<T> cls) {

        try {
            return new ObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
