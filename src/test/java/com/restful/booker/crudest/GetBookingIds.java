package com.restful.booker.crudest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetBookingIds {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        response = given()
                .when()
                .get("/booking")
                .then().statusCode(200);
    }

    //Extract all bookingid
    @Test
    public void test001() {
        List<Integer> allIds = response.extract().path("bookingid");
        System.out.println("------------------Test start---------------------------");
        System.out.println("List of bookingIds are : " + allIds);
        System.out.println("------------------End of Test---------------------------");

    }
}
