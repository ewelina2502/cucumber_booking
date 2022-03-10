package steps;

import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

public class BDDStyledMethod {

//    public static void PostBooking() {
//        HashMap<String, String, Integer, Boolean, String, String,String> postContent = new HashMap<>();
//        postContent.put("firstname", "Ewelina");
//        postContent.put("lastname", "Test");
//        postContent.put("totalprice", "123");
//        postContent.put("depositpaid", "True");
//        postContent.put("checkin", "2021-01-01");
//        postContent.put("checkout", "2021-01-01");
//        postContent.put("additionalneeds", "NOT");
//
//
//        given()
//                .contentType(ContentType.JSON).
//                with()
//                .body(postContent).
//                when()
//                .get("https://restful-booker.herokuapp.com/booking").
//                then()
//                .body("firstname", is("Ewelina"));
//
//    }



    public static void SimpleGETPost() {
        given().contentType(ContentType.JSON).
                when().get("https://restful-booker.herokuapp.com/booking").
                then().body("firstname", is("typicode"),
                            "lastname", is("lname")

                );
    }

    public static void PerformQueryParameter() {
        given()
                .contentType(ContentType.JSON)
                .with()
                .queryParam("id", 2)
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .body("author", hasItem("Ewelina"));
    }

}
