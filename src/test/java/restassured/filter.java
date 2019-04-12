package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class filter {

    @BeforeClass
    public static void BeforeClass(){
        useRelaxedHTTPSValidation();
        RestAssured.filters((req, res, ctx)->{
            req.cookie("testerhome","severniruby");
            return ctx.next(req,res);});
        RestAssured.proxy("10.231.21.240",8888);
    }

    @Test
    public void topic(){
//        RestAssured.baseURI="https://testerhome.com";
            Response response =given()
//                    .proxy("10.231.21.240",8888)
//                    .filter((req, res, ctx)->{
//                        req.cookie("testerhome","severniruby");
//                        return ctx.next(req,res);})
////                    .contentType(ContentType.JSON)
                    .when()
                    .get("https://testerhome.com/api/v3/topic.json")
                    .then()
                    .statusCode(200).extract().response();
        }

    @Test
    public void Testbaidu(){
        Map<String,Object> data=new HashMap<>();
        data.put("x",1);
        data.put("y","xxxx");
        given()
//                .proxy("10.231.21.240",8888)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("http://www.baidu.com/s")
                .then()
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
                .time(lessThan(2L), TimeUnit.SECONDS);}

}
