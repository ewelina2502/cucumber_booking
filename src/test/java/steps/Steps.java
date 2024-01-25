package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.*;

public class Steps {
    public static int bookingId;
    public static BookingBody bookingBody;
    RequestSpecification request;
    public static Response response;
    public static String firstname;
    public static String lastname;

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
    }

    @Then("Status code: {int}")
    public void statusCode(int Code) {
        Assert.assertEquals(response.getStatusCode(), Code);
        System.out.println(response.getBody().asPrettyString());
    }

    @Given("Post booking")
    public void postBooking() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                body(bookingBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
    }

    @When("Post booking with {randomBody}")
    public void post_booking_random_body(BookingBody randomBody) {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                body(randomBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
    }

    @Given("Add firstname: {string}, lastname: {string}, totalprice: {totalPrice}, depositpaid: {string}, checkin: {randomDates}, checkout: {randomDates}, additionalneeds: {additionalNeeds}")
    public void addBokkingOutline(String newFirstname, String newLastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        firstname = newFirstname;
        lastname = newLastname;

        bookingBody = BookingBody.builder()
                .firstname(getFirstName(firstname))
                .lastname(getLastName(lastname))
                .totalprice(totalprice)
                .depositpaid(depositpaid)
                .bookingdates(BookingDatesBody.builder()
                        .checkin(checkin)
                        .checkout(checkout)
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

    @And("Get {existId} from booking")
    public void getIdFromExistingBooking(int id) {
        bookingId = id;
        System.out.println("bookingId: " + bookingId);
    }

    @And("Booking with random parameters firstname: {string}, lastname: {string}")
    public void putEXISTBookingWithRandomParameters(String firstName, String lastname) {
        bookingBody = BookingBody.builder()
                .firstname(firstName)
                .lastname(lastname)
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

    @When("Put {existId} booking")
    public void putBooking(int id) {
        bookingId = id;

        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/" + bookingId;
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                body(bookingBody).
                when().
                put(BDDStyledMethod.baseUrl() + "/" + bookingId).
                then().
                extract().
                response();
    }

    @When("Patch {existId} booking")
    public void patchBooking(int id) {
        bookingId = id;

        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/" + bookingId;
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                body(bookingBody).
                when().
                patch(BDDStyledMethod.baseUrl() + "/" + bookingId).
                then().
                extract().
                response();
    }

    @And("Delete booking")
    public void deleteBooking() {
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                when().
                delete(BDDStyledMethod.baseUrl() + "/" + bookingId).
                then().
                extract().
                response();
        System.out.println("DELETING IS CORRECT and NOT FOUND bookingId: " + bookingId);
    }

    public static int getId() {
        return (response.jsonPath().getInt("bookingid"));
    }

    public static String getFirstName(String name) {
        firstname = name;
        if (name.equals("RANDOM")) {
            return Faker.getFistname();
        }
        return name;
    }

    public static String getLastName(String name) {
        lastname = name;
        if (name.equals("RANDOM")) {
            return Faker.getLastname();
        }
        return name;
    }
}
