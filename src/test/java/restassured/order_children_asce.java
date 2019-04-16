package restassured;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class order_children_asce extends order_inheritance {
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
    public void demo0_children(){
        System.out.println("demo_children");
    }
    @Test
    public void demo1_children(){
        System.out.println("demo1_children");
    }
    @Test
    public void demo2_children(){
        System.out.println("demo2_children");
    }

}
