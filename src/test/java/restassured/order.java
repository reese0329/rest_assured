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
    @Test
    public void printTest(){
        System.out.println("Test");
    }

    @Before
    public void setUp(){
        System.out.println("Before setUp");
    }

    @After
    public void tearDown(){
        System.out.println("After tearDown");
    }

}
