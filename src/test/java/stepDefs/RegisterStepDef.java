package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class RegisterStepDef {
    Response response;

    @Given("Kullanici gecerli verileri girerek request yapar")
    public void kullaniciGecerliVerileriGirerekRequestYapar() {

        response =given().contentType(ContentType.JSON).body("{\n" +
                "  \"activated\": true,\n" +
                "  \"authorities\": [\n" +
                "    \"Roosevelt76\"\n" +
                "  ],\n" +
                "  \"createdBy\": \"Pat Kirlin\",\n" +
                "  \"createdDate\": \"2022-12-19T06:31:15.783Z\",\n" +
                "  \"email\": \"Dallin5512@yahoo.com\",\n" +
                "  \"firstName\": \"Marjorie\",\n" +
                "  \"id\": 0,\n" +
                "  \"imageUrl\": \"http://placeimg.com/640/480.\",\n" +
                "  \"langKey\": \"Turkish\",\n" +
                "  \"lastModifiedBy\": \"Clyde Davis\",\n" +
                "  \"lastModifiedDate\": \"2022-12-19T06:31:15.783Z\",\n" +
                "  \"lastName\": \"Leuschke\",\n" +
                "  \"login\": \"Jerome28\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"ssn\": \"692-44-1463\"\n" +
                "}").when().post("https://medunna.com/api/register");

        response.prettyPrint();
        //System.out.println(response.getStatusCode());

    }

    @Then("Kullanici Status Code {int} oldugunu dogrular")
    public void kullaniciStatusCodeOldugunuDogrular(int statusCode) {

        Assert.assertEquals(statusCode,response.getStatusCode());
    }


    @And("Kullanici register data dogrulamasi yapar")
    public void kullaniciRegisterDataDogrulamasiYapar() {
        Assert.assertTrue(response.asString().contains("id"));
        response.then().assertThat().body("login", Matchers.equalTo("jerome28"));
        response.then().assertThat().body("firstName", Matchers.equalTo("Marjorie"));
        response.then().assertThat().body("lastName",Matchers.equalTo("lastName"));
        response.then().assertThat().body("ssn",Matchers.equalTo("652-44-3333"));
        response.then().assertThat().body("email",Matchers.equalTo("dallin55@yahoo.com"));
        response.then().assertThat().body("imageUrl",Matchers.equalTo("http://placeimg.com/640/480."));
        response.then().assertThat().body("activated",Matchers.equalTo(false));
        response.then().assertThat().body("langKey",Matchers.equalTo("Turkish"));
        response.then().assertThat().body("createdBy",Matchers.equalTo("anonymousUser"));
        response.then().assertThat().body("createdDate",Matchers.equalTo("2022-12-19T07:04:34.963590Z"));
        response.then().assertThat().body("lastModifiedBy",Matchers.equalTo("anonymousUser"));
        response.then().assertThat().body("lastModifiedDate",Matchers.equalTo("2022-12-19T07:04:34.963590Z"));
        response.then().assertThat().body("authorities",Matchers.equalTo(null));

    }
}
/*
{
    "id": 413953,
    "login": "jerome28",
    "firstName": "Marjorie",
    "lastName": "lastName",
    "ssn": "652-44-3333",
    "email": "dallin55@yahoo.com",
    "imageUrl": "http://placeimg.com/640/480.",
    "activated": false,
    "langKey": "Turkish",
    "createdBy": "anonymousUser",
    "createdDate": "2022-12-19T07:04:34.963590Z",
    "lastModifiedBy": "anonymousUser",
    "lastModifiedDate": "2022-12-19T07:04:34.963590Z",
    "authorities": []
}
 */