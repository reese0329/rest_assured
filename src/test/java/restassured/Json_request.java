package restassured;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Json_request {
    @Test
    public void Testbaidu(){
        Map<String,Object> data=new HashMap<>();
        data.put("x",1);
        data.put("y","xxxx");
        given()
                .proxy("10.231.21.240",8888)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("http://www.baidu.com/s")
                .then()
        .statusCode(200);
    }
}
