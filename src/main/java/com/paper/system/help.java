package com.paper.system;

import com.paper.Interfaces;
import com.paper.Printer;
import com.paper.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class help implements Interfaces.Application {
    @Override
    public void call(String[] args) throws IOException {
        Printer pr = new Printer();
        pr.print("Command list: \n" + ResourceLoader.ReadSource("/help"),0);
    }

    @Override
    public void init() {

    }

    @Override
    public int exit() {
        return 0;
    }
}
