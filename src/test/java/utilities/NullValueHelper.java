package utilities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class NullValueHelper {
    public static Boolean ifBooleanNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || "-".equalsIgnoreCase(value)) {
            return null;
        } else return Boolean.valueOf(value);
    }

    public static String ifNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || "-".equalsIgnoreCase(value) || "".equalsIgnoreCase(value) || Objects.isNull(value)) {
            return null;
        } else return value.trim();
    }

    public static String ifContainsNull(String value) {
        if (value.toUpperCase().contains("NULL") || value.toUpperCase().contains("-")) {
            return null;
        } else return value;
    }

    public static Integer ifIntegerNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || "-".equalsIgnoreCase(value) || "".equalsIgnoreCase(value)) {
            return null;
        } else return Integer.valueOf(value.trim());
    }

    public static Long ifLongNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || value.equalsIgnoreCase("-")) {
            return null;
        } else return Long.valueOf(value);
    }

    public static UUID ifUuidNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || "-".equalsIgnoreCase(value) || Objects.isNull(value)) {
            return null;
        } else return UUID.fromString(value);
    }

    public static List<String> ifListIsNull(List<String> value) {
        Optional<String> aNull = value.stream()
                .filter(i -> i.contains("NULL") || i.contains("-"))
                .findFirst();

        if (aNull.isPresent()) {
            return new ArrayList<>();
        }
        return value;
    }

//    public static List<Integer> ifIntegerListIsNull(List<String> value) {
//        Optional<String> aNull = value.stream()
//                .filter(i -> i.contains("NULL") || i.contains("-"))
//                .findFirst();
//
//        if (aNull.isPresent()) {
//            return new ArrayList<>();
//        }
//        return value.stream().map(Integer::valueOf)
//                .toList();
//    }

    public static Map<String, Object> ifHashMapIsNull(Map<String, Object> value) {
        Optional<Map.Entry<String, Object>> aNull = value.entrySet().stream()
                .filter(i -> i.getKey().contains("NULL") || i.getKey().contains("-"))
                .findFirst();

        if (aNull.isPresent()) {
            return new HashMap<>();
        }
        return value;
    }

    public static BigDecimal ifBigDecimalIsNull(String value) {
        if (value.equalsIgnoreCase("NULL")|| value.equalsIgnoreCase("-") || value.equalsIgnoreCase("")) {
            return null;
        } else return new BigDecimal(value);
    }

    public static LocalDate isLocalDateIsNull(LocalDate value) {
        if (Objects.nonNull(value)) {
            return value;
        } else return null;
    }

    public static LocalDate isLocalDateIsNull(String value) {
        if ("NULL".equalsIgnoreCase(value) || "-".equalsIgnoreCase(value) || "".equalsIgnoreCase(value)) {
            return null;
        } else return LocalDate.parse(value.trim());
    }

    public static boolean isNonNull(String value) {
        return Objects.nonNull(ifNull(value));
    }
}
