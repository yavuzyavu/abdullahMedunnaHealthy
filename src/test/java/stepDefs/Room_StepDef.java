package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.RoomPost_Pojo;
import utilities.Token;

import static io.restassured.RestAssured.given;
import static utilities.Token.tokenOlusturma;

public class Room_StepDef {
    RoomPost_Pojo postPojo = new RoomPost_Pojo();
    String actualToken ;
    Response response;
    @Given("Kullanici Token Alir")
    public void kullaniciTokenAlir() {

         actualToken = tokenOlusturma();

    }

    @Then("Kullanici Room İcin Post Request Yapar")
    public void kullaniciRoomİcinPostRequestYapar() {
         postPojo.setRoomNumber(222222);
         postPojo.setRoomType("DELUXE");
         postPojo.setPrice(23232323);
         postPojo.setStatus(true);

       response = given().contentType(ContentType.JSON)
                .headers("Authorization", "Bearer",
                        tokenOlusturma(),
                                "Content-Type", ContentType.JSON)
                .body(postPojo)
                .when().post("https://medunna.com/api/rooms");

    }

    @And("Kullanici Requestin Dogrulamasini yapar")
    public void kullaniciRequestinDogrulamasiniYapar() {

    }


}
