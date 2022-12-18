package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class LoginStepDef {

    Response response;

    @Given("Kullanici gecerli datalarla request yapar")
    public void kullanici_gecerli_datalarla_request_yapar() {

        response = given().contentType(ContentType.JSON).body("{\n" +
                "  \"password\": \"Batch81+\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"Batch81\"\n" +
                "}").when().post("https://medunna.com/api/authenticate");

        response.prettyPrint();

    }

    @Then("Kullanici status code {int} oldugunu dogrular")
    public void kullanici_status_code_oldugunu_dogrular(Integer int1) {
        Assert.assertEquals(200, response.getStatusCode());

    }

    @Then("Kullanici Api ile login dogrulamasi yapar")
    public void kullaniciApiIleLoginDogrulamasiYapar() {

        Assert.assertTrue(response.asString().contains("id_token"));
    }
}
