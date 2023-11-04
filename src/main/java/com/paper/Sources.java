package com.paper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sources {
    public static String LOGO = """
             ____                        ___  ____ \s
            |  _ \\ __ _ _ __   ___ _ __ / _ \\/ ___|\s
            | |_) / _` | '_ \\ / _ \\ '__| | | \\___ \\\s
            |  __/ (_| | |_) |  __/ |  | |_| |___) |
            |_|   \\__,_| .__/ \\___|_|   \\___/|____/\s
                       |_|                         \s
            """;
    public static String SETUP_LOGO = """
            ██████╗  █████╗ ██████╗ ███████╗██████╗  ██████╗ ███████╗    ███████╗███████╗████████╗██╗   ██╗██████╗\s
            ██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔═══██╗██╔════╝    ██╔════╝██╔════╝╚══██╔══╝██║   ██║██╔══██╗
            ██████╔╝███████║██████╔╝█████╗  ██████╔╝██║   ██║███████╗    ███████╗█████╗     ██║   ██║   ██║██████╔╝
            ██╔═══╝ ██╔══██║██╔═══╝ ██╔══╝  ██╔══██╗██║   ██║╚════██║    ╚════██║██╔══╝     ██║   ██║   ██║██╔═══╝\s
            ██║     ██║  ██║██║     ███████╗██║  ██║╚██████╔╝███████║    ███████║███████╗   ██║   ╚██████╔╝██║    \s
            """;
    public static double Version = 30.0;
    public static String greeting;

    static {
        try {
            if (Files.exists(Path.of("sys/motd"))) {
                greeting = Files.readString(Path.of("sys/motd"));
            } else {

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Generate() throws IOException {
        if (!Files.exists(Path.of("sys"))) {
            Files.createDirectory(Path.of("sys"));
            Utils.CAW("sys/motd", "Welcome.");
            Utils.CAW("sys/init", "0x000000f");
        }
    }
}
