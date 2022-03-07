package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

public class BDDStyledMethod {
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
