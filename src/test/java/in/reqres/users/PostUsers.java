package in.reqres.users;

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.UserPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Pradip
 */
public class PostUsers extends TestBase {

    String name = "Prad" + getRandomString(5);
    String job = "Leader" + getRandomString(2);
    String email = "eve.holt@reqres.in" + getRandomString(5);
    String password = "Leader12345@" + getRandomString(2);

    @Test
    public void createNewsUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();

    }

    @Test
    public void registerUserSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password);
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();

    }

    @Test
    public void UnsuccessfullyRegistration() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(400)
                .log().body();
    }

    @Test
    public void userShouldLoginSuccessfully() {

        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password);
        Response response = given()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();


    }
}
