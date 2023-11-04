package com.paper.system;

import com.paper.Interfaces;
import com.paper.Printer;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Enumeration;
import java.util.Properties;

import static com.paper.system.ServiceRegister.SERVICEPATH;

public class service implements Interfaces.Application {
    public static String getServiceStatus(String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(SERVICEPATH)) {
            properties.load(fis);
            StringBuilder sb = new StringBuilder();
            String servicestatus = properties.getProperty(key);
            if (servicestatus != null){
                sb.append("[SERVICE] SERVICE ").append(key).append(" status is: ").append(servicestatus);
            } else {
                return "this service isn't exist or its status is null.";
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void call(String[] args) throws IOException {
        Printer pr =new Printer();
        if (args.length > 1 && args[1] != null) {
            String arg = args[1];
            switch (arg) {
                case "list":
                    Properties properties = new Properties();
                    try (FileInputStream fis = new FileInputStream(SERVICEPATH)) {
                        properties.load(fis);
                        pr.print("""
                                ------------------------------------
                                SERVICE LIST
                                ------------------------------------
                                Service       Status
                                """,0);
                        Enumeration<?> propertyNames = properties.propertyNames();
                        while (propertyNames.hasMoreElements()) {
                            String key = (String) propertyNames.nextElement();
                            String value = properties.getProperty(key);
                            pr.print(key + "        " + value, 0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "query":
                    if (args.length == 3 && !args[2].equals(null)) {
                        String result = getServiceStatus(args[2]);
                        if (result != null && !result.equals("")) {
                            pr.print(result, 0);
                        } else {
                            pr.print("[SERVICE] INVALID PARAM.", 0);
                            exit();
                        }
                    }
                    break;
                case "add":
                    if (args.length == 3 && !args[2].equals(null)) {
                        ServiceRegister.reg(args[2], "false");
                        pr.print("[SERVICE] COMPLETE.", 0);
                        exit();
                    }
                    break;
                default:
                    break;
            }
        }
        init();
    }


    @Override
    public void init() throws IOException {

    }

    @Override
    public int exit() {
        return 0;
    }
}
