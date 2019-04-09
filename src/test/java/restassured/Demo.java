package restassured;

import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.params.CoreConnectionPNames;
import org.junit.*;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Demo {
    @Test
    public void baidu() {
        given()
                .log().all()
                .queryParam("wd", "mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200)
                .body("html.head.title", equalTo("mp3_百度搜索"));
    }


}