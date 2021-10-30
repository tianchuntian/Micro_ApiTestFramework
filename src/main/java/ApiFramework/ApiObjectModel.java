package ApiFramework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


/**
 *代表每个ApiObject对象
 */
public class ApiObjectModel {
    //反序列化:将api文件中的数据反序列化为ApiObjectModel类型数据
    public String name;
    public String description;
    public HashMap<String,ApiObjectMethodModel> methods;


    /**
     * api object对象支持从yaml文件中读取,然后反序列化
     * @param path:yaml文件地址
     * @return
     * @throws IOException
     */
    public static ApiObjectModel load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        //把从yaml文件中读取出的数据强转成ApiObjectModel类型

        return objectMapper.readValue(new File(path), ApiObjectModel.class);


    }

        /*
         * 运行这个ApiObject对象中封装的某个method方法,比如department这个接口中有create,update,list,delete这四个method,可能yaml中
         * 封装的就是要我们调用create方法
         * */
        public void run (ApiObjectMethodModel method){
            method.run();
        }

}
