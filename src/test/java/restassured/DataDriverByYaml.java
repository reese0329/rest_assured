package restassured;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
//参数化运行类
public class DataDriverByYaml {
    @Parameterized.Parameters
    //创建一个静态方法，用于提供数据
    public static List<DataClass> data() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//        ArrayList<DataClass> data = new ArrayList<DataClass>();
        List<DataClass> data=mapper.readValue(
                new File(DataDriverByYaml.class.getResource("../data/input.yaml").getFile()),
                new TypeReference<List<DataClass>>() {}
                );
        return data;
    }


    @Parameterized.Parameter
    public DataClass data;


    @Test
    public void testDemo(){
        assertThat(data.getCount(),equalTo(Integer.parseInt(data.getKey())));
    }


}
