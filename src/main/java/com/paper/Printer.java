package com.paper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Printer implements Interfaces.Application {
    public static final String sysLogEntry = "sys/log/log.log";
    public static void print(String content, int lvl) throws IOException {
        String logEntry;
        switch (lvl) {
            case 0 -> logEntry = content ;
            case 1 -> logEntry = "[WARNING] " + content + "\n";
            case 2 -> logEntry = "[ERROR] " + content;
            default -> logEntry = content;
        }
        System.out.println(logEntry);
        Files.writeString(Path.of(sysLogEntry), logEntry);
        if(Main.hasGui)com.paper.ui.Console.displayText(logEntry + "\n");
    }

    @Override
    public void call(String[] args) throws IOException {
        init();
    }

    @Override
    public void init() throws IOException {
        if (Files.exists(Path.of(sysLogEntry))){
            //DO NOTING
        } else {
            Path logFilePath = Path.of(sysLogEntry);
            Files.createDirectories(logFilePath.getParent());

            if (!Files.exists(logFilePath)) {
                Files.createFile(logFilePath);
            }
        }
    }

    @Override
    public int exit() {
        return 0;
    }
}
