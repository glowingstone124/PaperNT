package com.paper;
import com.paper.Process.Proc;
import com.paper.system.*;

import java.io.IOException;

public class CommandHandler {
    public static void CMD(String in) throws Exception {
        Printer pr = new Printer();
        String command[] = in.split(" ");
        switch(command[0]){
            case "help":
                help help = new help();
                help.call(command);
                break;
            case "info":
                sysinfo sys = new sysinfo();
                sys.call(command);
                break;
            case "error":
                gerr err = new gerr();
                err.call(command);
                break;
            case "stop":
                Main.exit();
            case "pkg":
                pkg pkg = new pkg();
                pkg.inst(command);
                break;
            case "service":
                service service = new service();
                service.call(command);
                break;
            case "ps":
                Proc.getProcs();
                break;
            default:
                pr.print("\"" + in + "\"" + "isn't a executable file or a command.", 0);
        }

    }
}
