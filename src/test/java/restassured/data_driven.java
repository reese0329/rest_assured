package restassured;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(Parameterized.class)
//参数化运行类
public class data_driven {
//    @Parameterized.Parameters(name ="{0}vs{1}")
//    //创建一个静态方法，用于提供数据
//    public static Iterable<Object[]> data(){
//        return Arrays.asList(new Integer[][]{
//                {0,0},{1,1},{2,3}
//        });
//    }


//    这个方法有问题！！！
    @Parameterized.Parameters
    //创建一个静态方法，用于提供数据
    public static Integer[][] data(){
        return new Integer[][]{
                {0,0},{1,1},{2,3}
        };
    }

    //借助parameter对于数据进行命名
    @Parameterized.Parameter
    public int first;

    @Parameterized.Parameter(1)
    public int second;

    @Test
    public void testDemo(){
        assertThat(first,equalTo(second));
    }

    //用于接口测试的实例
    @Test
    public void testBaidu(){
        given()
                .get("http://www.baidu.com/s?wd=201"+first).then().statusCode(200)
                .body("html.head.title",equalTo("201"+second+"_百度搜索"));
    }
}
