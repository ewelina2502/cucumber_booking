package utilities;

import io.cucumber.java.ParameterType;
import steps.Steps;

import java.util.Arrays;
import java.util.List;

import static steps.Steps.*;

public class Parameters {

    @ParameterType(value = "RANDOM_BODY|DEFAULT_BODY|EXIST_BODY")
    public Object switchBodys(String value) {
        return switch (value) {
            case "RANDOM_BODY" -> createRandomBody();
            case "DEFAULT_BODY" -> createDefaultBody();
            case "EXIST_BODY" -> bookingBody;
            default -> BookingBody.builder().build();
        };
    }

    public static BookingBody createRandomBody() {
        BookingBody.builder().build();
        return bookingBody;
    }

    public static BookingDefaultBody createDefaultBody() {
        BookingDefaultBody.builder().build();
        return bookingDefaultBody;
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