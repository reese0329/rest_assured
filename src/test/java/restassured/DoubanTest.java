package restassured;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class DoubanTest {

    @Test
    public void testGetHtml() {
        useRelaxedHTTPSValidation();  //不强行校验http信息
        given()
                .log().all()
                .when()
                .get("https://www.douban.com")
                .then()
                .log().all()
                .statusCode(200).body("html.head.title",equalTo("豆瓣"));
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