package utilities;

import io.cucumber.java.ParameterType;
import steps.Steps;

import java.util.Arrays;
import java.util.List;

import static steps.Steps.*;

public class Parameters {

    @ParameterType(value = "RANDOM_BODY")
    public BookingBody randomBody(String value) {
        if (value.equals("RANDOM_BODY")) {
            createRandomBody();
        }
        return bookingBody;
    }

    @ParameterType(value = "DEFAULT_BODY")
    public BookingDefaultBody defaultBody(String value) {
        if (value.equals("DEFAULT_BODY")) {
            createDefaultBody();
        }
        return bookingDefaultBody;
    }

    public static void createRandomBody() {
        BookingBody.builder().build();
    }

    public static void createDefaultBody() {
        BookingDefaultBody.builder().build();
    }

    @ParameterType(value = "EXIST|RANDOM|NULL")
    public int existId(String value) {
        return switch (value) {
            case "EXIST" -> Steps.getId(bookingId);
            case "NULL" -> NullValueHelper.ifIntegerNull(null);
            case "RANDOM" -> Faker.getRandom() + 999999;
            default -> 0;
        };
    }

    @ParameterType(value = "RANDOM_BODY")
    public BookingBody bodys(String value) {
        if (value.equals("RANDOM_BODY")) {
            BookingBody.builder().build();
        }
        return bookingBody;
    }

    @ParameterType(value = "RANDOM|TODAY|TOMORROW")
    public String randomDates(String value) {
        return switch (value) {
            case "RANDOM" -> Faker.getRandomDates();
            case "TODAY" -> Faker.getTodaysDate();
            case "TOMORROW" -> Faker.getYesterdayDate();
            default -> Faker.getTomorrowDate();
        };
    }

    @ParameterType(value = "RANDOM|BREAKFAST")
    public String additionalNeeds(String value) {
        return switch (value) {
            case "RANDOM" -> Faker.getRandomAdditinalNeeds();
            case "BREAKFAST" -> "BREAKFAST";
            default -> null;
        };
    }

    @ParameterType(value = "RANDOM|NULL")
    public String totalPrice(String value) {
        return switch (value) {
            case "RANDOM" -> String.valueOf(Faker.getRandomPrice());
            case "NULL" -> null;
            default -> value;
        };
    }

    @ParameterType("(?:[^,]*)(?:,\\s?[^,]*)*")
    public List<String> stringListValue(String list) {
        return Arrays.asList(list.split(",\\s?"));
    }
}