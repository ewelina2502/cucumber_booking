package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class StepsAssertions {

    RequestSpecification request;
    public static Response response;

    @Given("Add path, post request")
    public void addPathPostRequest() {
        request  =  RestAssured.given();
    }

    @And("Add parameters {string} {string} {string} {string} {string} {string} {string}")
    public void addParameters(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {

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

    @When("Check of booking ids")
    public void checkOfBookingIds() {
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Body: " + response.getBody().asString());
        int bookingid = response.jsonPath().getInt("bookingid");
        System.out.println("bookingId: " + bookingid);
        response = RestAssured.get(BDDStyledMethod.baseUrl() + "/" + bookingid);
    }

    @Then("Search new assertion")
    public void searchNewAssertion() {
        String firstname = response.jsonPath().get("lastname");
        Assert.assertEquals("Pajak", firstname);
        System.out.println("TEST PASSED, lastname = " + firstname );
    }

    @Then("Search new assertion of additionalneeds")
    public void searchNewAssertionOfAdditionalneeds() {
        String additionalneeds = response.jsonPath().get("additionalneeds");
        Assert.assertEquals("Breakfast", additionalneeds);
        System.out.println("TEST PASSED, Breakfast = " + additionalneeds );
    }

    @Then("Search new assertion of totalprice")
    public void searchNewAssertionOfTotalprice() {
        int totalprice = response.jsonPath().get("totalprice");
        Assert.assertEquals(199, totalprice);
        System.out.println("TEST PASSED, Totalprice = " + totalprice );
    }

    @Then("Search new assertion of depositpaid")
    public void searchNewAssertionOfDepositpaid() {
        boolean depositpaid = response.jsonPath().get("depositpaid");
        Assert.assertTrue(depositpaid);
        System.out.println("TEST PASSED, Totalprice = " + true);

    }

    @Then("Search new assertion of checkin")
    public void searchNewAssertionOfCheckin() {
        String checkin = response.jsonPath().get("bookingdates.checkin");
        Assert.assertEquals("2026-01-21", checkin);
        System.out.println("TEST PASSED, Checkin = " + checkin );
    }


}

