package com.paper.system;

import com.paper.Interfaces;
import com.paper.Utils;

import javax.print.DocFlavor;
import java.io.IOException;

public class gerr implements Interfaces.Application {
    @Override
    public void call(String[] args) throws IOException {
        init();
    }

    @Override
    public void init() throws IOException {
        switch (exit()){
            case 1 -> Utils.error(Utils.errorcode.SYSERR);
        }
    }

    @Override
    public int exit() {
        return 1;
    }
}
