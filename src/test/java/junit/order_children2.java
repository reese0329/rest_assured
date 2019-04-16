package junit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import restassured.order_inheritance;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class order_children2 extends order_inheritance {
    @BeforeClass
    public static void beforeClass_children(){
        System.out.println("BeforeClass_children");
    }

    @AfterClass
    public static void afterClass_children(){
        System.out.println("AfterClass_children");
    }

    @Before
    public  void before_children(){
        System.out.println("Before_children");
    }


//    @After
//    public  void after_children(){
////        System.out.println("After_children");
//    }

    @Test
    public void demo0_children2(){
        System.out.println("demo_children");
    }
    @Test
    public void demo1_children2(){
        System.out.println("demo1_children");
        assertThat(1,equalTo(2));
    }
    @Test
    public void demo2_children2(){
        System.out.println("demo2_children");
    }

}
