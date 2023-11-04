package com.paper;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import com.paper.Process.Bus;
import com.paper.Process.Proc;
import com.paper.inst.*;
import com.sun.jdi.request.ThreadStartRequest;

import javax.swing.*;

public class Main {
    public static boolean hasGui;
    public static void main(String[] args) throws Exception {

        if (args.length != 0) {
            if (args[0].equals("-setup")) {
                new start();
            } else if (args[0].equals("-normal-mode")) {
                hasGui = false;
                Sources.Generate();
                Thread.sleep(1000);
                init();
            }
        } else {
            hasGui = true;
            guiInit();
            Sources.Generate();
            Thread.sleep(1000);
            init();
        }
    }


    public static void init() throws Exception {
        String[] arg = null;
        Printer pr = new Printer();
        pr.call(arg);
        Proc.init();
        Bus.Process process = new Bus.Process("system", "~", 0);
        pr.print(Sources.LOGO + "\n" + "Version " + Sources.Version + " Starting.... ", 0);
        Thread.sleep(1000);
        pr.print("SERVICE system started. Booting........", 0);
        pr.print("Running on: " + System.getProperty("os.arch"), 0);
        pr.print(Sources.greeting + "\n", 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");  // Print the ">" prompt
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                CommandHandler.CMD(input);
            }
        }
    }
    public static void guiInit(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                com.paper.ui.Console terminal = new com.paper.ui.Console();
                terminal.setVisible(true);
            }
        });
    }
    public static void exit() {
        Thread startVirtualThread = Thread.startVirtualThread(new ShutdownHook());
        synchronized (startVirtualThread) {
            try {
                startVirtualThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

}
