package in.reqres.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Pradip
 */
public class TestBase {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api";
    }
}
