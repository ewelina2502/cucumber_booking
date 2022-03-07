package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Booking {

//    RequestSpecBuilder builder = new RequestSpecBuilder();
//        builder.setBaseUri("https://restful-booker.herokuapp.com/booking");
//        builder.setContentType(ContentType.JSON);
//        var requestSpec = builder.build();
//        Request = RestAssured.given().spec(requestSpec);
//}
//    @Test
//    public void postBooking() {
//
//        String contentType = "application/json";
//        String names = "fname";
//        String lnames = "";
//        String needs = printNeeds();
//        int generator = printGenerator();
//        String date = printDate();
//        String datetomorrow = printTomorrow();
//
//        return "{" +
//                " \"firstname\": " + '"' + names + '"' + ","+
//                " \"lastname\": " +  '"' + lnames + '"' + "," +
//                " \"totalprice\": "  + generator + "," +
//                " \"depositpaid\": \"true\"," +
//                " \"bookingdates\":"  +
//                " { \"checkin\": " + '"' + date + '"'+ "," +
//                " \"checkout\": " + '"' + datetomorrow + '"' + "}," +
//                " \"additionalneeds\": " + '"' + needs + '"' +
//                "}";
//        Response response = RestAssured.
//                given().
//                contentType(contentType).
//                body(printJsonBooking()).
//                when().
//                post(urlBooking()).
//                then().
//                extract().
//                response();
//
//        Assert.assertEquals(response.getStatusCode(),200);
//        System.out.println("Body :" + response.getBody().asString());
//    }

}

