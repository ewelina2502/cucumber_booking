package utilities;

import io.cucumber.java.ParameterType;
import steps.Steps;

import java.util.Arrays;
import java.util.List;

import static steps.Steps.bookingBody;

public class Parameters {

    @ParameterType("(?:[^,]*)(?:,\\s?[^,]*)*")
    public List<String> stringListValue(String list) {
        return Arrays.asList(list.split(",\\s?"));
    }

    @ParameterType(value = "EXIST|RANDOM|NULL")
    public int existId(String value) {
        return switch (value) {
            case "EXIST" -> Steps.getId();
            case "NULL" -> NullValueHelper.ifIntegerNull(null);
            case "RANDOM" -> Faker.getRandom();
            default -> 0;
        };
    }

    @ParameterType(value = "RANDOM_BODY")
    public BookingBody randomBody(String value) {
        if (value.equals("RANDOM_BODY")) {
            createRandomBody();
        }
        return bookingBody;
    }

    public static void createRandomBody() {
        BookingBody.builder().build();
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

    @ParameterType(value = "RANDOM")
    public String getFirstName(String value) {
        return switch (value) {
            case "RANDOM" -> Faker.getFistname();
            case "NULL" -> "NULL";
            default -> bookingBody.getFirstname();
        };
    }

    @ParameterType(value = "RANDOM")
    public String getLastName(String value) {
        return switch (value) {
            case "RANDOM" -> Faker.getLastname();
            case "NULL" -> "NULL";
            default -> bookingBody.getLastname();
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
}
