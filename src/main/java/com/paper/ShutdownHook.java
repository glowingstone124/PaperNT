package com.paper;

public class ShutdownHook implements Runnable{
    @Override
    public void run() {
        System.out.println("Shutdown.");
    }
}
