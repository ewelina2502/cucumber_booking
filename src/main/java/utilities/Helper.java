package utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.messages.internal.com.google.gson.GsonBuilder;

public class Helper {

    private static final ObjectMapper mapper = new ObjectMapper()
            .findAndRegisterModules()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String serializeToJson(Object o) {
        String json = null;
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static final Gson gson = new GsonBuilder().
            setPrettyPrinting().
            serializeNulls().
            create();

    public static String objectToJson(Object o) {
        return gson.toJson(o);
    }
//
//    public static <T> T jsonToObject(String json, Type type) {
//        Gson gson = new Gson();
//        return gson.fromJson(json, type);
//    }
//
//    public Object readFromJson(String json, Class<T> clazz) {
//        return gson.fromJson(json, clazz);
//    }
//
//    public Object readFromJson(String json, Type type) {
//        return gson.fromJson(json, type);
//    }
}
