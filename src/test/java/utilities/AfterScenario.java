package utilities;

import io.cucumber.java.After;
import io.restassured.RestAssured;
import steps.Steps;

public class AfterScenario {
    @After(value = "@DeleteBooking")
    public static void createBooking() {
        int beforeScenarioId = BeforeScenario.bookingId;
        Steps.response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                when().
                delete(BDDStyledMethod.baseUrl() + "/" + beforeScenarioId).
                then().
                extract().
                response();

        System.out.println("DELETING IS CORRECT and NOT FOUND bookingId: " + beforeScenarioId);
    }
}
