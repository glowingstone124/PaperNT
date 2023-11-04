package com.paper.system;

import com.paper.Printer;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;

public class pkg {
    public static class DeploymentTask implements Runnable {
        private String classFilePath;
        private String className;

        public DeploymentTask(String classFilePath, String className) {
            this.classFilePath = classFilePath;
            this.className = className;
        }

        @Override
        public void run() {
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(classFilePath).getParentFile().toURI().toURL()}, systemClassLoader);
                Class<?> loadedClass = classLoader.loadClass(className);
                Object instance = loadedClass.getDeclaredConstructor().newInstance();
                Method installMethod = loadedClass.getMethod("install");
                installMethod.invoke(instance);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void inst(String[] args) throws Exception {
        if (args.length != 3) {
            Printer pr = new Printer();
            pr.print("[Package Installer] ERROR: Incorrect number of parameters", 2);
        } else {
            String cmd = args[1];
            if (cmd.equals("deploy")) {
                String[] instParam = args[2].split("\\.");
                Runnable task = new DeploymentTask(instParam[0], instParam[1]);
                Thread.startVirtualThread(task);
            }
        }
    }
}
