package utilities;

import io.cucumber.java.ParameterType;

public class CommonParameters {
    @ParameterType(value = "true|True|TRUE|T|false|False|FALSE|F")
    public Boolean booleanValue(String value) {
        return Boolean.valueOf(value);
    }
}
