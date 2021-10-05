package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String read(String key){

        return properties.getProperty(key);
    }

}
