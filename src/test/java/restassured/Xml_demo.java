package restassured;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class Xml_demo {
    @Test
    public void  testXML(){
        given().log().all()
                //配置代理
                .proxy("10.231.21.240",8888)
                .get("http://localhost:8329/demo.xml").prettyPeek()
                .then()
                //断言category的数量为3
                .body("shopping.category.size()",equalTo(3))
                //断言category中type为supplies的数量为1
                .body("shopping.category.find{it.@type=='supplies'}.size()",equalTo(1))
                //断言category中type为supplies的第一个item中的price为5
                .body("**.find{it.@type=='supplies'}.item[0].price",equalTo("5"));

    }
}
