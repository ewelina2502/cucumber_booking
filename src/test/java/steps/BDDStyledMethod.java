package steps;


public class BDDStyledMethod {

    public static String baseUrl(){
        return "https://restful-booker.herokuapp.com/booking";

    }

    public static String body() {
        return "{" +
                " \"firstname\":  \"John\"," +
                " \"lastname\":  \"Badminton\"," +
                " \"totalprice\":  \"123\"," +
                " \"depositpaid\": \"true\"," +
                " \"bookingdates\":" +
                " { \"checkin\":  \"2022-01-14\"," +
                " \"checkout\":  \"2022-01-15\" }" + "," +
                " \"additionalneeds\":  \"Lunch\"" +
                "}";
            }

}
