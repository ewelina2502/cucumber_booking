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

import static utilities.AfterScenario.getCorrectId;
import static utilities.Faker.*;

public class Steps {
    public static int bookingId;
    public static BookingBody bookingBody;
    public static BookingDefaultBody bookingDefaultBody;
    RequestSpecification request;
    public static Response response;
    public static String firstname;
    public static String lastname;

    @Given("Get bookings")
    public void getBookings() {
        response = RestAssured.get(BDDStyledMethod.baseUrl());
        System.out.println(response.getBody().prettyPrint().indexOf(0));
    }

    @Given("Add body with random parameters")
    public void addRandomParameters() {
        bookingBody = BookingBody.builder()
                .firstname(getFistname())
                .lastname(getLastname())
                .totalprice(String.valueOf(getRandomPrice()))
                .depositpaid("true")
                .bookingdates(BookingDatesBody.builder()
                        .checkin(getTodaysDate())
                        .checkout(getTomorrowDate())
                        .build())
                .additionalneeds(getRandomAdditinalNeeds())
                .build();
    }

    @Given("Add body with default parameters")
    public void addDefaultParameters() {
        bookingDefaultBody = BookingDefaultBody.builder()
                .firstname(getFistname())
                .lastname(getLastname())
                .totalprice(String.valueOf(getRandomPrice()))
                .depositpaid("true")
                .bookingdates(BookingDatesBody.builder()
                        .checkin(getTodaysDate())
                        .checkout(getTomorrowDate())
                        .build())
                .additionalneeds(getRandomAdditinalNeeds())
                .build();
    }

    @Then("Status code: {int}")
    public void statusCode(int Code) {
        Assert.assertEquals(response.getStatusCode(), Code);
        System.out.println("Staus code: " + response.getStatusCode());
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

    @Given("Add firstname: {string}, lastname: {string}, totalprice: {totalPrice}, depositpaid: {string}, " +
            "checkin: {randomDates}, checkout: {randomDates}, additionalneeds: {additionalNeeds}")
    public void addBookingOutline(String newFirstname, String newLastname, String totalprice, String depositpaid,
                                  String checkin, String checkout, String additionalneeds) {
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

    @Given("{existId} booking after created")
    public void existBookingAfterCreated(int id) {
        bookingId = id;
        System.out.println("correctId: " + getCorrectId());
    }

    @And("Get {existId} id from booking")
    public void getIdFromExistingBooking(int id) {
        bookingId = id;
        bookingId = response.jsonPath().getInt("bookingid");

        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/" + bookingId;
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "/" + bookingId);

        assert bookingId == response.jsonPath().getInt("bookingid");

        System.out.println("bookingId: " + bookingId);
        System.out.println(response.getBody().asPrettyString());

        getId(id);
        System.out.println(id);
    }

    @And("Get information for no {existId} booking")
    public void getNoEXISTBooking(int id) {
        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/:" + getId(id);
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "/:" + getId(id));
        System.out.println("get response path: " + BDDStyledMethod.baseUrl() + "/:" + getId(id));
        System.out.println(response.getBody().asPrettyString());
    }

    @When("Put {existId} booking")
    public void putBooking(int id) {
        bookingId = id;
        int corrrectId = getCorrectId();

        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/:" + corrrectId;
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                body(bookingBody).
                when().
                put(BDDStyledMethod.baseUrl() + "/" + corrrectId).
                then().
                extract().
                response();
        System.out.println(RestAssured.baseURI);
    }

    @When("Patch {existId} booking")
    public void patchBooking(int id) {
        bookingId = id;
        int corrrectId = getCorrectId();

        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "/:" + corrrectId;
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                body(bookingBody).
                when().
                patch(BDDStyledMethod.baseUrl() + "/" + corrrectId).
                then().
                extract().
                response();
        System.out.println(RestAssured.baseURI);
    }

    @And("Delete {existId} booking")
    public void deleteBooking(int id) {
        bookingId = id;
        assert bookingId == response.jsonPath().getInt("bookingid");

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

    @And("Booking with random parameters firstname: {string}, lastname: {string}")
    public void putExistBookingWithRandomParameters(String firstName, String lastname) {
        bookingBody.setFirstname(firstName);
        bookingBody.setLastname(lastname);
        System.out.println(Helper.objectToJson(bookingBody));
    }

    public static String getFirstName(String name) {
        firstname = name;
        if (name.equals("RANDOM")) {
            return getFistname();
        }
        return name;
    }

    public static String getLastName(String name) {
        lastname = name;
        if (name.equals("RANDOM")) {
            return getLastname();
        }
        return name;
    }

    public static int getId(int id) {
        System.out.println("bookingFromIdBefore: " + BeforeScenario.bookingFromIdBefore);

        if (BeforeScenario.bookingFromIdBefore == 0) {
            return bookingId;
        } else
            assert BeforeScenario.bookingFromIdBefore != bookingId || bookingId == id;
        System.out.println("bookingId: " + bookingId);
        return bookingId;
    }

    @When("Post booking with {randomBody}")
    public void postBookingWithRANDOM_BODY(BookingBody randomBody) {
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

    @When("Post booking with {defaultBody}")
    public void postBookingWithRANDOM_BODY(BookingDefaultBody defaultBody) {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request = RestAssured.given();
        response = RestAssured.
                given().
                contentType("application/json").
                body(defaultBody).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
    }
}