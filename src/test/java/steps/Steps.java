package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;
import utilities.Booking;

public class Steps {

    public static ResponseOptions<Response> response;

    @Given("Add dates")
    public void addDates() {
        BDDStyledMethod.Post();
    }
    @When("Add <firstname> and <lastname> and <totalprice> and <depositpaid> and <checkin> and <checkout> and <additionalneeds>")
    public void addFirstnameAndLastnameAndTotalpriceAndDepositpaidAndCheckinAndCheckoutAndAdditionalneeds() {
    }

    @Then("Booking is added")
    public void bookingIsAdded(String url) {
//        response = Booking("https://restful-booker.herokuapp.com/booking");
    }

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


}
