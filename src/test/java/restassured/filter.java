package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.config.SessionConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Base64;
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
        //公司代理
//        RestAssured.proxy("10.231.21.240",8888);
        //home代理

        RestAssured.proxy("192.168.100.169",8888);

        RestAssured.filters();  //添加aip
        RestAssured.reset();  //清除filter
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
    @Test
    public void testFilterReponse(){

    }
    @Test
    public void testBase64(){
        RestAssured.reset(); //fileter等
        given().auth().basic("hogwarts","123456").log().all()
                .filter((req,res,ctx)->{
                    req.getQueryParams();
                    Response response0ri=ctx.next(req,res);
                    ResponseBuilder responseBuilder=new ResponseBuilder().clone(response0ri);
//                    System.out.println(response0ri.getBody().asString());
                    responseBuilder.setBody(Base64.getDecoder().decode(response0ri.getBody().asString().trim().replace("\n","")));
                    responseBuilder.setContentType(ContentType.JSON);
                    return responseBuilder.build();})
                .when()
//home
//                .get("http://localhost:8000/demo.json").then()
//                mi
                .get("http://localhost:8329/demo1.json").then()
                .log().all()
                .statusCode(200)
                .body("topics.id[0]",equalTo(18717));
    }

    @Test
    public void testJenkinsLogin(){
        //保存一个有效的session值，登录凭证
        RestAssured.config = RestAssured.config().sessionConfig(
                new SessionConfig().sessionIdName("JSESSIONID.ae379626"));
        SessionFilter sessionFilter = new SessionFilter();
        given().log().all()
                .filter(sessionFilter)
                .queryParam("j_username","reese")
                .queryParam("j_password","123456")
                .queryParam("Submit","Sign in")
                .when()
                .post("http://localhost:8080/j_acegi_security_check")
                .then()
                .statusCode(302);
        given().log().all()
                .filter(sessionFilter)
                .when().get("http://localhost:8080/login").prettyPeek()
                .then().statusCode(200);
    }

}
