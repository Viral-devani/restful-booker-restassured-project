package com.restful.booker.crudest;

import com.restful.booker.model.LoginPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @Test
    public void verifyUserCanLoginSuccessfully(){
        LoginPojo loginPojo=new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");

        Response response=given().log().all()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type","application/json")
                .when()
                .body(loginPojo)
                .post("/auth");
        response.then().log().all().statusCode(200);
        response.prettyPrint();
        String token = response.jsonPath().getString("token");
        System.out.println("Received Token is : " +token);

    }
    }

