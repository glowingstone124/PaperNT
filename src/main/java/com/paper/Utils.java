package com.paper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    public static void CAW(String path, String content) throws IOException {
        Files.createFile(Path.of(path));
        Files.writeString(Path.of(path), content);
    }
    public static void error(errorcode error) throws IOException {
        Printer pr = new Printer();
        switch (error){
            case SYSERR -> pr.print("SYSTEM ERROR: Uncaught error code 0x00000", 2);
            case SYSERR_CODE1 -> pr.print("SYSTEM ERROR: error code 1: application end with code 1.",2);
            case SYSERR_CODE2 -> pr.print("SYSTEM ERROR: error code 2: application end with code 2.",2);
            case SYSERR_CODE3 -> pr.print("SYSTEM ERROR: error code 3: application end with code 3.",2);
        }
    }
    public enum errorcode{
        SYSERR_CODE1,
        SYSERR_CODE2,
        SYSERR_CODE3,
        SYSERR,
    }
    public enum user{
        USER,
        SU,
        SYSTEM,
        TRUSTEDINSTALLER
    }
}
