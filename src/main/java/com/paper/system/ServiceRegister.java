package com.paper.system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ServiceRegister {
    public static final String SERVICEPATH = "sys/services/services.properties";

    public static void reg(String name, String value) {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(SERVICEPATH);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty(name, value);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SERVICEPATH);
            properties.store(fileOutputStream, "");
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
