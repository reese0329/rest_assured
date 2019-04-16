package restassured;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class order_tag2 extends order_inheritance {
    @BeforeClass
    public static void beforeClass_order_suite(){
        System.out.println("BeforeClass_order_suite");
    }

    @AfterClass
    public static void afterClass_order_suite(){
        System.out.println("AfterClass_order_suite");
    }

    @Before
    public  void before_order_suite(){
        System.out.println("Before_order_suite");
    }


//    @After
//    public  void after_children(){
////        System.out.println("After_children");
//    }

    @Test
    public void demo0_order_suite(){
        System.out.println("demo_order_suite");
    }
    @Test
    @Category(order_tag_product.class)
    public void demo1_order_suite(){
        System.out.println("demo1_corder_suite");
    }


    @Test
    @Category(order_tag_stage.class)
    public void demo2_order_suite(){
        System.out.println("demo2_order_suite");
    }

}
