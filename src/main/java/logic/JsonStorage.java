package logic;

import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public final class JsonStorage {

    private static final Gson gson = new Gson();

    public static <T> void saveToFile(String filePath, List<T> data) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> loadFromFile(String filePath, Class<T> clazz) {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

