package restassured;

import org.junit.*;
import org.junit.experimental.categories.Category;

public class order_tag1 extends order_inheritance {
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
    @Ignore("just for show")
    @Test
    public void demo0_children(){
        System.out.println("demo_children");
    }
    @Test
    @Category(order_tag_stage.class)
    public void demo1_children(){
        System.out.println("demo1_children");
    }

    @Test
    @Category(order_tag_product.class)
    public void demo2_children(){
        System.out.println("demo2_children");
    }

}
