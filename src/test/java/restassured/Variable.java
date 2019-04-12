package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

public class Variable {

    @Test
    public void topic(){
        RestAssured.baseURI="https://testerhome.com";
        Response response = given()
                .when()
                .get("/api/v3/topics.json")
                .then()
                .body("topics.id",hasItems(18392,18756))
                .extract().response();
        Integer id1=response.path("topics.id[0]");
        Integer id2=response.path("topics.id[1]");
        assertEquals(id1,id2);
    }
}
