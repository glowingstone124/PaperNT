package com.paper;

import java.io.IOException;

public class Interfaces {
    public interface Application {
        void call(String[] args) throws IOException;
        void init() throws IOException;
        int exit();
    }
    public interface Service {
        default void reg(String name, int lvl, Utils.user user){

        }
    }
}
