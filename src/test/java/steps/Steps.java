package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;



public class Steps {

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


    @Given("Add parameters")
    public void addParameters() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
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
    }
    @Then("Booking is exist")
    public void bookingIsExist() {
//        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().asString());
    }



    @Given("Add dates")
    public void addDates() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
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
    }


    @Then("Search assertions")
    public void searchAssertions() {

        String firstname = response.jsonPath().get("firstname");
        Assert.assertEquals("Maciej", firstname);
        System.out.println("TEST PASSED, firstname = " + firstname );
    }


}








