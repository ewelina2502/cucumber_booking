package utilities;

import io.cucumber.java.After;
import io.restassured.RestAssured;

import static steps.Steps.*;

public class AfterScenario {
    @After(value = "@DeleteBooking")
    public static void createBooking() {
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                when().
//                delete(BDDStyledMethod.baseUrl() + "/" + bookingId).
                delete(BDDStyledMethod.baseUrl() + "/" + getCorrectId()).
                then().
                extract().
                response();

        System.out.println("DELETING IS CORRECT and NOT FOUND bookingId: " + getCorrectId());
    }

    public static int getCorrectId() {
        if (getId(bookingId) != 0) {
            return bookingId;
        } else return BeforeScenario.bookingFromIdBefore;
    }
}
