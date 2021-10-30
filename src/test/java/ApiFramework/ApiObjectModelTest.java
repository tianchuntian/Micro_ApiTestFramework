package ApiFramework;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ApiObjectModelTest {

    private static ApiObjectModel apiObject;


    @BeforeAll
    static void BeforeAll() throws IOException {
        apiObject=ApiObjectModel.load("src/main/resources/ApisData/Apis/getToken_Object.yaml");
    }

    @Test
    void load() {

        assertThat(apiObject.name,equalTo("Token"));
    }

    @Test
    void run() {

        Response response=apiObject.methods.get("getAccessToken").run();



    }
}