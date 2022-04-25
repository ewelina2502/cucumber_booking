package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

import java.io.File;

import static io.restassured.RestAssured.get;

public class Steps {

    public static ResponseOptions<Response> response;

    @Given("Get booking")
    public void getBooking() {
       BDDStyledMethod.baseUrl();

    }

    @When("I use get in request")
    public boolean iUseGetInRequest() {
        Response response = RestAssured.get(BDDStyledMethod.baseUrl());
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body :" + response.getBody().asString());
        return false;
    }

    @Then("I will get bookings")
    public void iWillGetBookings() {
        System.out.println(iUseGetInRequest());
    }

    @Given("Add parameters")
    public void addParameters() {
        String get_url = BDDStyledMethod.baseUrl();
        String body = BDDStyledMethod.body();
        String contentType = "application/json";

        Response response = RestAssured.
                given().
                contentType(contentType).
                body(body).
                when().
                post(get_url).
                then().
                extract().
                response();

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body :" + response.getBody().asString());
    }

    @Then("I have booking")
    public void iHaveBooking() {
        System.out.println("Booking is added");
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

        Response response = RestAssured.
                given().
                contentType("application/json").
                body(body).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body :" + response.getBody().asString());

    }


    @Then("Booking is added")
    public void bookingIsAdded() {
        System.out.println("Booking is added");

    }

}





