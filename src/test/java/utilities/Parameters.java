package utilities;

import io.cucumber.java.ParameterType;
import steps.Steps;

public class Parameters {
    public static BookingBody bookingBody;

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
        return switch (value) {
            case "RANDOM" -> createRandomBody();
            default -> Steps.bookingBody;
        };
    }

    public static BookingBody createRandomBody() {
        return BookingBody.builder().build();
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
}
