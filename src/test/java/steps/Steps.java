package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;

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
                " \"checkout\":  \"2022-01-15\"," +
                " \"additionalneeds\":  \"Lunch\"" +
                    "}" +
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
}
