package ApiFramework;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


/**
 * 代表一个单一的http接口
 */
public class ApiObjectMethodModel {
    public String method="get";
    public String url;
    public HashMap<String,Object> params;
    public String get;
    public String post;
    public String put;
    public String delete;


    /**
     * 发送具体的http请求
     * @return
     */
    public  Response run(){
        if (get!=null){
            Response response=given().log().all().queryParams(params).when().get(get).then().log().all().extract().response();
            return response;
        }
        if (post!=null){
            Response response=given().log().all().queryParams(params).when().post(post).then().log().all().extract().response();
            return response;
        }else {
            Response response=given().log().all().queryParams(params).when().request(method,url).then().log().all().statusCode(200)
                    .extract().response();
            return response;
        }
    };

}
