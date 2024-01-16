package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Faker {

    public static String getTodaysDate() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        return ft.format(dNow);
    }

    public static String getRandomDates() {
        int year = fakePL().random().nextInt(1000);
        int month = fakePL().random().nextInt(1, 11);
        int day = fakePL().random().nextInt(1, 27);
        return year + "-" + month + "-" + day;
    }

    public static String getTomorrowDate() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.plusDays(1));
    }

    public static String getYesterdayDate() {
        LocalDate today = LocalDate.now();
        return String.valueOf(today.minusDays(1));
    }

    public static com.github.javafaker.Faker fakePL() {
        return new com.github.javafaker.Faker(new Locale("pl-PL"));
    }

    public static String getFullName() {
        return fakePL().name().firstName() + " " + fakePL().name().lastName();
    }

    public static String getFistname() {
        return fakePL().name().firstName();
    }

    public static String getLastname() {
        return fakePL().name().lastName();
    }

    public static int getRandomPrice() {
        return fakePL().random().nextInt(10);
    }

    public static int getRandom() {
        return fakePL().random().nextInt(10);
    }
}
