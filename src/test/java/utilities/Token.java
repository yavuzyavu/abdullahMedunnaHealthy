package utilities;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Token {

    public static String tokenOlusturma() {

        Map<String, Object> loginRequestBody = new HashMap<>();

        loginRequestBody.put("password", "Batch81+");
        loginRequestBody.put("username", "Batch81");
        // System.out.println("loginRequestBody = " + loginRequestBody);
        Response response = given().contentType(ContentType.JSON).body(loginRequestBody).when().post("https://medunna.com/api/authenticate");
        // response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        String token = jsonPath.getString("id_token");
        return token;
    }

    public static void main(String[] args) {
        System.out.println("token = " + tokenOlusturma());

    }

}
