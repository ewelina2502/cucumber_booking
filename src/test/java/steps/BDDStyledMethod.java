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

}
