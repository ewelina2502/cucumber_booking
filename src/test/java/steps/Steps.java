package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static java.nio.file.Paths.get;

public class Steps {

//    public static ResponseOptions<Response> response;
    RequestSpecification request;
    public static  Response response;

    @Given("Get booking")
    public void getBooking() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
    }
    @When("I use get in request")
    public void iUseGetInRequest() {
        response = RestAssured.get(BDDStyledMethod.baseUrl());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
//    @Then("I will get bookings")
//    public void iWillGetBookings() {
//        System.out.println("Body Ids:" + response.getBody().asString());
//        List<Object> bookingId = response.jsonPath().getList("bookingid");
//        System.out.println(bookingId);
//    }

    @Given("Add parameters")
    public void addParameters() {
        request  =  RestAssured.given();
        request.header("ContentType",  "application/json");

        response = RestAssured.
                given().
                body(BDDStyledMethod.body()).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().asString());
    }

    @Then("I have booking")
    public void iHaveBooking() {
        String firstname = response.jsonPath().get("firstname");
        Assert.assertEquals("John", firstname);
        System.out.println("Test PASSED becouse firstname = " + firstname);
    }

    @Given("Add dates")
    public void addDates() {
        BDDStyledMethod.baseUrl();
    }

    @When("Add {string} {string} {string} {string} {string} {string} {string}")
    public void add(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        int number = Integer.parseInt(totalprice);

        String body = "{" +
                " \"firstname\": " + '"' + firstname + '"' + "," +
                " \"lastname\": " + '"' + lastname + '"' + "," +
                " \"totalprice\": " + number + "," +
                " \"depositpaid\": " + '"' + depositpaid + '"' + "," +
                " \"bookingdates\":" +
                " { \"checkin\": " + '"' + checkin + '"' + "," +
                " \"checkout\": " + '"' + checkout + '"' + "}," +
                " \"additionalneeds\": " + '"' + additionalneeds + '"' +
                "}";

        response = RestAssured.
                given().
                contentType("application/json").
                body(body).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

    }

    @Then("Booking is added")
    public void bookingIsAdded() {
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body: " + response.getBody().asString());
    }


    @Given("Add path and post request")
    public void addPathAndPostRequest() {
        request  =  RestAssured.given();
    }


    @And("Add new parameters {string} {string} {string} {string} {string} {string} {string}")
    public void addNewParameters(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {
        int number = Integer.parseInt(totalprice);
        String body = "{" +
                " \"firstname\": " + '"' + firstname + '"' + "," +
                " \"lastname\": " + '"' + lastname + '"' + "," +
                " \"totalprice\": " + number + "," +
                " \"depositpaid\": " + '"' + depositpaid + '"' + "," +
                " \"bookingdates\":" +
                " { \"checkin\": " + '"' + checkin + '"' + "," +
                " \"checkout\": " + '"' + checkout + '"' + "}," +
                " \"additionalneeds\": " + '"' + additionalneeds + '"' +
                "}";

        response = RestAssured.
                given().
                contentType("application/json").
                body(body).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

    }

    @When("Check new booking ids")
    public void checkNewBookingIds() {
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body: " + response.getBody().asString());
        int bookingid = response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingid);
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "/" + bookingid);
//        System.out.println("Body2: " + response.getBody().asString());
    }


    @Then("Search assertions")
    public void searchAssertions() {

        String firstname = response.jsonPath().get("firstname");
        Assert.assertEquals("Maciej", firstname);
        System.out.println("Test PASSED becouse firstname = " + firstname );
    }
}








