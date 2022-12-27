package com.restful.booker.crudest;

import com.restful.booker.model.LoginPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginTest extends TestBase {
    @Test
    public void verifyUserCanLoginSuccessfully(){
        LoginPojo loginPojo=new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");

        Response response=given().log().all()
                .header("Content-Type","application/json")
                //.header("token","bbd304b448a5369")
                .when()
                .body(loginPojo)
                .post("/booking");
        response.then().log().all().statusCode(201);
        response.prettyPrint();

    }
    }

