package com.paper;

import java.io.InputStream;
import java.util.Scanner;

public class ResourceLoader {
    public static String ReadSource(String resourcePath) {
        InputStream inputStream = ResourceLoader.class.getResourceAsStream(resourcePath);

        if (inputStream != null) {
            try (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")) {
                return scanner.hasNext() ? scanner.next() : "";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
