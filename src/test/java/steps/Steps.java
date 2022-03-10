package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;
import utilities.RestAssureExtension;

import java.util.HashMap;

public class Steps {

    public static ResponseOptions<Response> response;

    @Given("Get booking")
    public void getBooking() {
            String get_url = "https://restful-booker.herokuapp.com/booking";
            Response response = RestAssured.get(get_url);
            Assert.assertEquals(response.getStatusCode(),200);
            System.out.println("Body :" + response.getBody().asString());
        }

    @When("I use get in request")
    public void iUseGetInRequest() {

    }

    @Then("I will get bookings")
    public void iWillGetBookings() {
    }

    @Given("Add parameters")
    public void addParameters() {
        String get_url = "https://restful-booker.herokuapp.com/booking";
        String body = "{" +
                " \"firstname\":  \"John\"," +
                " \"lastname\":  \"Badminton\"," +
                " \"totalprice\":  \"123\"," +
                " \"depositpaid\": \"true\"," +
                " \"bookingdates\":"  +
                " { \"checkin\":  \"2022-01-14\"," +
                " \"checkout\":  \"2022-01-15\" }" + "," +
                " \"additionalneeds\":  \"Lunch\"" +
                "}";

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

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Body :" + response.getBody().asString());
    }

    @Then("I have booking")
    public void iHaveBooking() {
    }

    @Given("Add dates")
    public void addDates() {

    }
    @When("Add {string} {string} {string} {string} {string} {string} {string}")
    public void add(String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout, String additionalneeds) {

        int number = Integer.parseInt(totalprice);


        String get_url = "https://restful-booker.herokuapp.com/booking";
        String body = "{" +
                " \"firstname\": " + '"' + firstname + '"' + ","+
                " \"lastname\": " +  '"' + lastname + '"' + "," +
                " \"totalprice\": "  + number + "," +
                " \"depositpaid\": " +  '"' + depositpaid + '"' + "," +
                " \"bookingdates\":"  +
                " { \"checkin\": " + '"' + checkin + '"'+ "," +
                " \"checkout\": " + '"' + checkout + '"' + "}," +
                " \"additionalneeds\": " + '"' + additionalneeds + '"' +
                "}";

        Response response = RestAssured.
                given().
                contentType("application/json").
                body(body).
                when().
                post(get_url).
                then().
                extract().
                response();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Body :" + response.getBody().asString());



    }




    @Then("Booking is added")
    public void bookingIsAdded() {
    }



}

//        var data = table.row(7);
//        HashMap<String, String> body = new HashMap<>();
//        body.put("firstname", data.get(0));
//        body.put("lastname", data.get(1));
//        body.put("totalprice", data.get(2));
//        body.put("depositpaid", data.get(3));
//        body.put("checkin", data.get(4));
//        body.put("checkout", data.get(5));
//        body.put("additionalneeds", data.get(6));
//
//        response = RestAssureExtension.PostOpsWithBodyAndPathParams("https://restful-booker.herokuapp.com/booking", body);

// ;;;;;;;;;;;;;;;;;



//
//    @When("Add <firstname> and <lastname> and <totalprice> and <depositpaid> and <checkin> and <checkout> and <additionalneeds>")
//    public void addFirstnameAndLastnameAndTotalpriceAndDepositpaidAndCheckinAndCheckoutAndAdditionalneeds(String firstname, String lastname, Integer totalprice,  Boolean depositpaid, String checkin, String checkout, String additionalneeds, DataTable table) {

//        String get_url = "https://restful-booker.herokuapp.com/booking";
//        String body = "{" +
//                " \"firstname\": " + '"' + firstname + '"' + ","+
//                " \"lastname\": " +  '"' + lastname + '"' + "," +
//                " \"totalprice\": "  + totalprice + "," +
//                " \"depositpaid\": " + depositpaid +"," +
//                " \"bookingdates\":"  +
//                " { \"checkin\": " + '"' + checkin + '"'+ "," +
//                " \"checkout\": " + '"' + checkout + '"' + "}," +
//                " \"additionalneeds\": " + '"' + additionalneeds + '"' +
//                "}";
//
//        Response response = RestAssured.
//                given().
//                contentType("application/json").
//                body(body).
//                when().
//                post(get_url).
//                then().
//                extract().
//                response();
//
//        Assert.assertEquals(response.getStatusCode(),200);
//        System.out.println("Body :" + response.getBody().asString());



//    }



