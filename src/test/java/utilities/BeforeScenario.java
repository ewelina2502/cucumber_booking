package utilities;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import steps.Steps;

public class BeforeScenario {
    public static int bookingId;

    @Before(value = "@CreateBooking")
    public static void createBooking() {
        Steps.bookingBody = BookingBody.builder()
                .firstname(Faker.getFistname())
                .lastname(Faker.getLastname())
                .totalprice(String.valueOf(Faker.getRandomPrice()))
                .depositpaid("true")
                .bookingdates(BookingDatesBody.builder()
                        .checkin(Faker.getTodaysDate())
                        .checkout(Faker.getTomorrowDate())
                        .build())
                .additionalneeds("Breakfast")
                .build();

        System.out.println(Helper.objectToJson(Steps.bookingBody));
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        Steps.response = RestAssured.
                given().
                contentType("application/json").
                body(Steps.bookingBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

        bookingId = Steps.response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingId);
    }
}
