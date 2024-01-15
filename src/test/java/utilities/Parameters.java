package utilities;

import io.cucumber.java.ParameterType;
import steps.Steps;

public class Parameters {

    @ParameterType(value = "EXIST|RANDOM|NULL")
    public int existId(String value) {
        return switch (value) {
            case "EXIST" -> Steps.getId();
            case "NULL" -> NullValueHelper.ifIntegerNull(null);
            case "RANDOM" -> Faker.getRandom();
            default -> 0;
        };
    }
}
