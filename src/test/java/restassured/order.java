package restassured;

import org.junit.*;

public class order {
    @BeforeClass
    public static void  setUpClass(){
        System.out.println("BeforeClass setUpClass");
    }
    @AfterClass
    public static void  tearDownClass(){
        System.out.println("AfterClass tearDownClass");
    }

    private void println(String string){
        System.out.println(string);
    }



    @Before
    public void setUp(){
        this.println("Before setUp");
    }

    @After
    public void tearDown(){
        this.println("After tearDown");
    }

    @Test
    public void test1(){
        this.println("Test1");
    }


    @Test
    public void test2(){
        this.println("Test2");
    }

}
