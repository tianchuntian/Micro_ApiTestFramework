package ApiFramework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

class BaseApiTest {

    private static BaseApi baseApi;

    @BeforeAll
    static void BeforAll(){
        baseApi=new BaseApi();
        baseApi.load("src/main/resources/ApisData/Apis");
    }

    @Test
    void load() {

        assertThat(baseApi.apis.size(),greaterThan(1));
        System.out.println(baseApi.apis.size());
    }

    @Test
    void run() {

        baseApi.run("Token","getAccessToken");
        baseApi.run("department","list");

    }
}