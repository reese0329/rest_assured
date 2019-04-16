package restassured;

import org.junit.*;

public class order_inheritance {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }


//    @After
//    public void after(){
//        System.out.println("After");
//    }



    @Test
    public void demo0(){
        System.out.println("demo");
    }
    @Test
    public void demo1(){
        System.out.println("demo1");
    }
    @Test
    public void demo2(){
        System.out.println("demo2");
    }



}
