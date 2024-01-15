package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.BookingBody;
import utilities.BookingDatesBody;
import utilities.Faker;
import utilities.Helper;

public class Steps {
    public static BookingBody bookingBody;
    RequestSpecification request;
    public static Response response;

    @Given("Get booking")
    public void getBooking() {
        response = RestAssured.get(BDDStyledMethod.baseUrl());
        System.out.println(response.getBody().prettyPrint().indexOf(0));
    }

    @Given("Add body with random parameters")
    public void addParameters() {
        bookingBody = BookingBody.builder()
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

        System.out.println(Helper.objectToJson(bookingBody));
    }

    @Then("Status code: {int}")
    public void statusCode(int Code) {
        Assert.assertEquals(response.getStatusCode(), Code);
        System.out.println(response.getBody().asString());
    }

    @Given("Post booking")
    public void postBooking() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                body(bookingBody).
//                body(BookingBody.builder().build()).
                    when().
                        post(BDDStyledMethod.baseUrl()).
                        then().
                        extract().
                        response();
    }

    @Given("Add firstname: {string}, lastname: {string}, totalprice: {string}, depositpaid: {string}, checkin: {string}, checkout: {string}, additionalneeds: {string}")

    public void add(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        bookingBody = BookingBody.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(totalprice)
                .depositpaid(depositpaid)
                .bookingdates(BookingDatesBody.builder()
                        .checkin(Faker.getTodaysDate())
                        .checkout(Faker.getTomorrowDate())
                        .build())
                .additionalneeds(additionalneeds)
                .build();

        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                body(bookingBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
    }
}








