package restassured;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        order_suite.class,order_children.class
})
public class order_suite_demo {
}
