package com.restful.booker.crudest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostBooking extends TestBase {
    @Test
    public void verifyBookingCreatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("viral123");
        bookingPojo.setLastname("patel123");
        bookingPojo.setTotalprice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setCheckin("2018-01-01");
        bookingPojo.setCheckout("2019-01-01");
        bookingPojo.setAdditionalneeds("super bowls");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                //.header("token","fd58c17d9fa821c")
                .when()
                .body(bookingPojo)
                .post("/booking");
        response.then().log().all().statusCode(200);
        response.prettyPrint();

    }

}



