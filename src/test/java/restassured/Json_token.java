package restassured;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Json_token {
    public static String token;
    @Test
    public void baidu() {
        Response response =given()
                .log().all()
                .queryParam("wd", "mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200)
                .body("html.head.title", equalTo("mp3_百度搜索"))
                .time(lessThan(2L), TimeUnit.SECONDS)
                .extract().response();
        token = response.path("topics.id[0]");
    }
    @Test
    public void  Test2(){
        given().
                param("token",token);
    }
}
