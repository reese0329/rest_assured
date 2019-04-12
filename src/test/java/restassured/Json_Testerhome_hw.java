package restassured;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.greaterThan;

public class Json_Testerhome_hw {

    @BeforeClass
    public static void BeforeClass(){
        useRelaxedHTTPSValidation();
    }

    @Test
    public void topic(){
         given()
                .when()
                .get("https://testerhome.com/api/v3/topics.json")
                .then()
                .body("topics.findAll{it.excellent==1}.size()",greaterThan(4));
    }
}
