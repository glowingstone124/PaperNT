package com.paper.inst;

import com.paper.inst.Printer;
import com.paper.Sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class start {
    public static void start() throws IOException {
        Printer pr = new Printer();
        Scanner sc = new Scanner(System.in);
        pr.print(Sources.SETUP_LOGO, 0);
        if (Files.exists(Path.of("sys"))) {
            System.out.println("We detected that you have been already installed PaperOS. Would you like to upgrade or just wipe and re-install? (e(exit)/u(upgrade)/w(wipe))");
            String selection = sc.nextLine();
            switch (selection) {
                case "e":
                    System.exit(0);
                case "w":
                    break;
                case "u":
                    break;
                default:
                    System.out.println("error: unspecified operation. Aborted.");
                    System.exit(0);
            }
        } else {
            System.out.println("Install PaperOS now? (e(exit)/y(yes))");
            String selection = sc.nextLine();
            switch (selection) {
                case "e":
                    System.exit(0);
                case "y":
                    Resource.export();
                    break;
                default:
                    System.out.println("error: unspecified operation. Aborted.");
                    System.exit(0);
            }
        }
    }
}
