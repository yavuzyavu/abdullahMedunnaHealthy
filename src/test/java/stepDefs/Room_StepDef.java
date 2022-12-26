package stepDefs;

import baseUrl.MedunnaBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojos.RoomPost_Pojo;
import utilities.ConfigReader;
import utilities.Token;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.Token.tokenOlusturma;

public class Room_StepDef extends MedunnaBaseUrl {
    RoomPost_Pojo postPojoExpect = new RoomPost_Pojo();

    /* "price": 0,
            "roomNumber": 0,
            "roomType": "TWIN",
            "status": true

     */

    Response response;
    //RoomPost_Pojo expectedData = new RoomPost_Pojo(500, 56666, "DELUXE", true);

    //Map<String, Object> actualData1 = (Map<String, Object>) response.as(RoomPost_Pojo.class);
    RequestSpecification spec;

    @Given("Kullanici gereken andpoint ayarlanir")
    public void kullaniciGerekenAndpointAyarlanir() {


        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/").build();
        spec.pathParams("1","api","2","rooms");



    }

    @Then("Kullanici Room İcin Post Request Yapar")
    public void kullaniciRoomİcinPostRequestYapar() {
        postPojoExpect.setRoomNumber(222222);
        postPojoExpect.setRoomType("DELUXE");
        postPojoExpect.setPrice(23232323);
        postPojoExpect.setStatus(true);

        response = given().contentType(ContentType.JSON)
                .headers("Authorization", "Bearer",
                        tokenOlusturma(),
                        "Content-Type", ContentType.JSON)
                .body(postPojoExpect)
                .when().post("https://medunna.com/api/rooms");
        response.prettyPrint();

    }

    @And("Kullanici Requestin Dogrulamasini yapar")
    public void kullaniciRequestinDogrulamasiniYapar() {

        RoomPost_Pojo actualData = response.as(RoomPost_Pojo.class);

        Assert.assertEquals(postPojoExpect.getRoomNumber(),actualData.getRoomNumber());
        Assert.assertEquals(postPojoExpect.getRoomType(),actualData.getRoomType());
        Assert.assertEquals(postPojoExpect.getPrice(),actualData.getPrice());
        Assert.assertEquals(postPojoExpect.isStatus(),actualData.isStatus());

    }

}
