package restassured;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class BaiduTest {
    @Test
    public void testGetHtml() {
        given()
                .log().all()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void testMp3() {
        given()
                .log().all()
                .queryParam("wd", "mp3")
                .when()
                .get("http://www.baidu.com/s")
                .then()
                .log().all()
                .statusCode(200)
                .body("html.head.title", equalTo("mp3_百度搜索"))
                .time(lessThan(2L), TimeUnit.SECONDS);
    }


}