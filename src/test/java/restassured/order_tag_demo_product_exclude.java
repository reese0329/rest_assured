package restassured;


import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(order_tag_product.class)
@Suite.SuiteClasses({
        order_tag1.class,order_tag2.class
})
public class order_tag_demo_product_exclude {
}
