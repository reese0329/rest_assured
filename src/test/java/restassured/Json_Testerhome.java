package restassured;

import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Json_Testerhome {


    @BeforeClass
    public static void BeforeClass(){
        useRelaxedHTTPSValidation();
    }

    @Test
    public void topic(){
        Response response = given()
                .when()
                .get("https://testerhome.com/api/v3/topics.json")
                .then()
                //获取第一个topic的id
//                .body("topics.id[0]",equalTo(18756))
////                获取最后一个topic的user的login信息
//                .body("topics[-1].user.login",equalTo("cmlanche-github"))
////                获取id为18316的topic的title
//                .body("topics.find{it.id==18316}.title",
//                equalTo("[深圳] 微众银行内部人才招聘高级测试工程师 / 测试工程师"))   //页面修改
//                hasItems实例
                .body("topics.id",hasItems(18392,18756))
                .extract().response();
        Integer id1=response.path("topics.id[0]");
        Integer id2=response.path("topics.id[1]");
         assertEquals(id1,id2);
    }
    @Test
    public void baidu() {
//        topic();  //此处直接调用即可
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
