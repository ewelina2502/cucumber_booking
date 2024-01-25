package utilities;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import steps.Steps;

import static steps.Steps.bookingBody;

public class BeforeScenario {
    public static int bookingId;

    @Before(value = "@CreateBooking")
    public static void createBooking() {
        bookingBody = null;
        bookingBody = BookingBody.builder()
                .firstname(Faker.getFistname())
                .lastname(Faker.getLastname())
                .totalprice(String.valueOf(Faker.getRandomPrice()))
                .depositpaid("true")
                .bookingdates(BookingDatesBody.builder()
                        .checkin(Faker.getTodaysDate())
                        .checkout(Faker.getTomorrowDate())
                        .build())
                .additionalneeds(Faker.getRandomAdditinalNeeds())
                .build();

        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        Steps.response = RestAssured.
                given().
                contentType("application/json").
                body(bookingBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

        bookingId = Steps.response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingId);
    }
}
