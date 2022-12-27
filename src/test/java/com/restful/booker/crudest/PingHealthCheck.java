package com.restful.booker.crudest;

import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PingHealthCheck extends TestBase {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

       }
    @Test
    public void test001() {
        System.out.println("------------------Test start---------------------------");
        given().when().get("/ping").then().statusCode(201);
        System.out.println("API endpoint is responding");
        System.out.println("------------------End of Test---------------------------");

    }
}
