package com.restful.booker.crudest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends TestBase {
    static ValidatableResponse response;
    @Test
    public void verifyBookingUpdatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("viral13");
        bookingPojo.setLastname("patel23");
        bookingPojo.setTotalprice(111);
        bookingPojo.setDepositpaid(true);
        bookingPojo.setCheckin("2018-01-01");
        bookingPojo.setCheckout("2019-01-01");
        bookingPojo.setAdditionalneeds("super bowls");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                //.header("Authorization","YWRtaW46cGFzc3dvcmQxMjM=] ")
                //.header("Postman-Token","1c87482672292e2")
                .when()
                .body(bookingPojo)
                .put("/booking/532");

        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
