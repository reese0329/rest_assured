package restassured;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;

public class Testerhome {

    @BeforeClass
    public static void BeforeClass(){
        useRelaxedHTTPSValidation();
    }

    @Test
    public void topic(){
        given()
                .when()
                .get("https://testerhome.com/api/v3/topics.json").prettyPeek()
                .then()
                .body("topics.id[0]",equalTo(18728));
    }
}
