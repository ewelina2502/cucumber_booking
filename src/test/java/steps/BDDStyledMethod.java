package steps;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

public class BDDStyledMethod {
    public static void Post() {
        given()
                .contentType(ContentType.JSON).
        when()
                .get("https://restful-booker.herokuapp.com/booking").
        then()
                .body("firstname", is("Adam"),
                        "lastname", is("Nowak"),
                        "totalprice", is(123),
                        "depositpaid", is("True"),
                        "checkin", is("2022-01-14"),
                        "checkout", is("2022-01-15"),
                        "additionalneeds", is("Breakfast")

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
