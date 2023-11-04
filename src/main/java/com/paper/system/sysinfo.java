package com.paper.system;

import com.paper.Interfaces.Application;
import com.paper.Printer;
import com.paper.Utils;

import java.io.IOException;

public class sysinfo implements Application {
    @Override
    public void call(String[] args) throws IOException {
        Printer pr = new Printer();
        // Implement the functionality of your sysinfo application here
        pr.print("System Information:", 0);

        // Example: Get and print the Java version
        String javaVersion = System.getProperty("java.version");
        pr.print("Java Version: " + javaVersion, 0);
        if (exit() == 0){
            //do nothing
        } else {
            Utils.error(Utils.errorcode.SYSERR);
        }
    }

    @Override
    public void init() {
        // This application doesn't need initialization, but you can add code here if needed.
    }

    @Override
    public int exit() {
        return 0;
    }
}
