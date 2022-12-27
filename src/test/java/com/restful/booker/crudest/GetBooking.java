package com.restful.booker.crudest;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetBooking {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        response = given()
                .when()
                .get("/booking/532")
                .then().statusCode(200);
    }

    //Extract all bookingid
    @Test
    public void test001() {
        String firstname = response.extract().path("firstname");
        String lastname = response.extract().path("lastname");
        System.out.println("------------------Test start---------------------------");
        System.out.println("Firstname & Lastname is: " + firstname +" "+lastname);
        System.out.println("------------------End of Test---------------------------");

    }
   }
