package ApiFramework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


//代表测试用例,提供读取测试用例和执行测试用例的功能
public class ApiTestCaseModel {
    //将TestCase.yaml中的数据反序列化为ApiTestCaseModel类型
    public String name;
    public String description;
    public List<HashMap<String, Object>> steps;


    /**
     * 加载一个yaml文件,并将该文件内的数据转成测试用例模型类
     *
     * @param path:测试用例文件路径
     * @return
     * @throws IOException
     */
    //将TestCase.yaml中的数据加载出来,反序列化为ApiTestCaseModel类型
    public static ApiTestCaseModel load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        //把从yaml文件中读取出的数据强转成ApiObjectModel类型
        return objectMapper.readValue(new File(path), ApiTestCaseModel.class);
    }


    /**
     * 借助于baseApi,去运行对应的测试用例,主要是运行用例其中的steps,//todo:用例中增加断言
     *
     * @param baseApi:执行测试用例
     */
    public void run(BaseApi baseApi) {

        steps.stream().forEach(step -> {
            if (step.containsKey("api")) {
                baseApi.run(step.get("api").toString(), step.get("action").toString());
            } else {
                step.entrySet().forEach(entry -> {
                    baseApi.run(entry.getKey(), (String) entry.getValue());
                });
            }


        });
    }

}
