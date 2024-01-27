package utilities;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static steps.Steps.*;
import static steps.Steps.bookingBody;

public class BeforeScenario {
    public static int bookingFromIdBefore;

    @Before(value = "@Cleaning")
    public static void cleaning() {
        System.out.println("CLEANING BOOKINGID");
    }

    @Before(value = "@CreateBooking")
    public static void createBooking() {
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
        response = RestAssured.
                given().
                contentType("application/json").
                body(bookingBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

        bookingFromIdBefore = response.jsonPath().getInt("bookingid");
    }
}
