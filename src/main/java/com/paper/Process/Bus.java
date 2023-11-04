package com.paper.Process;

import java.nio.file.Path;

public class Bus {
    public static class Process {
        private String NAME; // Corrected field declaration
        private String ExecPath; // Corrected field declaration
        private int type;

        public Process(String name, String execpath, int i) {
            NAME = name;
            ExecPath = execpath;
            type = i;
        }

        public Path castPath() {
            return Path.of(ExecPath);
        }
        public String getExecPath(){
            return ExecPath;
        }

        public boolean Valid() {
            boolean valid = false;
            if (NAME != null && ExecPath != null) { // Corrected field references
                valid = true;
            }
            return valid;
        }

        public enum ProcessType {
            SYSTEM,
            STANDARD,
            SECURITY,
            PROTECTED,
            UNDEFINED
        }

        public ProcessType ProcessType() {
            switch (type) {
                case 0:
                    return ProcessType.STANDARD;
                case 1:
                    return ProcessType.SECURITY;
                case 2:
                    return ProcessType.PROTECTED;
                case 9:
                    return ProcessType.SYSTEM;
                default:
                    return ProcessType.UNDEFINED;
            }
        }

        public String getname() {
            return NAME;
        }
    }
}
