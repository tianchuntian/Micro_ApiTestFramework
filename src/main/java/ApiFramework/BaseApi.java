package ApiFramework;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseApi {
    List<ApiObjectModel> apis= new ArrayList<>();


    /**
     * 加载所有的ApiObject对象,并保存在apis这个列表里.
     * @param dir:ApiObject对象文件存放的目录地址
     */
    //管理各Api_Object
    public void load(String dir){
        Arrays.stream(new File(dir).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return true;
            }
        })).forEach(path-> {
            try {
                apis.add(ApiObjectModel.load(dir+"/"+path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


    /**
     * 根据测试用例提供的apiObject和对应的method,从自己的数据中检索对应的Api,并调用对应的方法
     * @param name
     * @param method
     */
    //根据load读取的apiobject,读取每个object里的数据
    public void run(String name,String method){
        /*遍历每个apiObject文件中的数据,如果数据中的name和我们传进来指定执行的name相同,则执行该ApiObject文件,执行时调用ApiObjetMethod
        中的run方法*/
        apis.stream().filter(api->api.name.equals(name)).forEach(api->{
            api.methods.get(method).run();
        });
    }

}
