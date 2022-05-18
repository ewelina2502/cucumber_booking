package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;


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

        response = RestAssured.
                given().
                contentType("application/json").
                body(BDDStyledMethod.body()).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();
    }

    @Then("Booking is exist")
    public void bookingIsExist() {
        Assert.assertEquals(response.getStatusCode(), 200);
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

    @Given("Add bad url")
    public void addBadUrl() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl() + "badUrl";
    }

    @Then("I have response bad request")
    public void iHaveResponseBadRequest() {
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "badUrl");
        Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println("Status code: " + response.getStatusCode());
    }

    @When("I put firstname and add cookies and authorization")
    public void iPutFirstnameAndAddCookiesAndAuthorization() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request  =  RestAssured.given();
        int bookingid = response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingid);
        String baseUrlId = BDDStyledMethod.baseUrl() + "/" + bookingid;
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "/" + bookingid);

        response = RestAssured.
                given().
                contentType("application/json").
                body(BDDStyledMethod.newBody()).
                cookie(BDDStyledMethod.cookies()).
                header("Authorization", BDDStyledMethod.authorization()).
                header("Cookie", BDDStyledMethod.cookies()).
                when().
                put(baseUrlId).
                then().
                extract().
                response();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body: " + response.getBody().asString());
    }

    @Then("Booking has a new firstname")
    public void bookingHasANewFirstname() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
        request  =  RestAssured.given();
        String firstname = response.jsonPath().get("firstname");
        Assert.assertEquals("Update", firstname);
        System.out.println("TEST PASSED, firstname = " + firstname );
    }

    @When("I find Booking and Delete")
    public void iFindBookingAndDelete() {
        request = RestAssured.given();
        int bookingid = response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingid);
        String baseUrlId = BDDStyledMethod.baseUrl() + "/" + bookingid;

        response = RestAssured.
                given().
                contentType("application/json").
                cookie(BDDStyledMethod.cookies()).
                header("Authorization", BDDStyledMethod.authorization()).
//                header("Cookie", BDDStyledMethod.cookies()).
                when().
                delete(baseUrlId).
                then().
                extract().
                response();
        Assert.assertEquals(response.getStatusCode(),201);
        response = RestAssured.get(baseUrlId);
        System.out.println(response.statusCode() + " Not found id: " + bookingid);
    }

    @Then("I have response not found Booking")
    public void iHaveResponseNotFoundBooking() {
        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Given("Add url")
    public void addUrl() {
        RestAssured.baseURI = BDDStyledMethod.baseUrl();
    }

    @Then("Add json file to body")
    public void addJsonFileToBody() {
        request  =  RestAssured.given();
//        var responseBody = response.getBody().asString();
        File file = new File("C:\\Users\\Ewelina\\IdeaProjects\\cucumber_booking\\src\\main\\java\\utilities\\bookingJson.json");

        response = RestAssured.
                given().
                contentType("application/json").
//                body(file).
                body(file).
                when().
                post(BDDStyledMethod.baseUrl()).
                then().
                extract().
                response();

//        assertThat(responseBody, matchesJsonSchemaInClasspath("booking.Json.json"));
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body :" + response.getBody().asString());
    }
}








