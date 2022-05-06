package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Faker {

    public static String printDate() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(dNow);
    }

    public static String printTomorrow() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.plusDays(1));
    }
}
