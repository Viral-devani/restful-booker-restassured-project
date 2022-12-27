package com.restful.booker.crudest;

import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteBooking extends TestBase {
    @Test
    public void verifyBookingDeletedSuccessfully() {
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .delete("/booking/532");

        response.then().log().all().statusCode(200);
        response.prettyPrint();
    }
}
