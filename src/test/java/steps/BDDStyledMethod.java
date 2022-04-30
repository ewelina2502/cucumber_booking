package steps;


public class BDDStyledMethod {

    public static String baseUrl(){
        return "https://restful-booker.herokuapp.com/booking";
    }
    public static String cookies() {
        return "token=f61416de503d436";
    }

    public static String authorization() {
        return "Basic YWRtaW46cGFzc3dvcmQxMjM=";
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

    public static String newBody() {
        return "{" +
                " \"firstname\":  \"Update\"," +
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
