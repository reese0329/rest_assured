package restassured;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class Json_Testerhome_timeout {

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
                .body("topics.find{it.id==18752}.title",
                equalTo("记一次基于 Robotium 改造的测试实践"))   //页面修改
                .time(lessThan(3000L));
    }
}
