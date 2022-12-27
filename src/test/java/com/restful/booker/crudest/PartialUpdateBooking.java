package com.restful.booker.crudest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBooking extends TestBase {
    @Test
    public void verifyBookingUpdatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("viral11233");
        bookingPojo.setLastname("patel223233");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                //.header("Authorization","YWRtaW46cGFzc3dvcmQxMjM=] ")
                //.header("Postman-Token","1c87482672292e2")
                .when()
                .body(bookingPojo)
                .patch("/booking/532");

        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
