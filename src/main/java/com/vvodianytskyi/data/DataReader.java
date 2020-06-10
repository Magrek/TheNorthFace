package com.vvodianytskyi.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataReader {

    private DataReader() {
    }

    public static String readData(String path, String property) {
        Properties properties = new Properties();
        String data = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(path))) {
            properties.load(inputStream);
            data = properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String readDataBaseConfig(String property) {
        return readData("src/main/resources/config/db.properties", property);
    }
}
