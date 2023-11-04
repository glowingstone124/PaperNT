package com.paper.Process;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Proc {
    public static Map<Bus.Process, Integer> PLIST = new HashMap<>();
    public static List<Integer> pidnum = new ArrayList<>();
    public static boolean Pull(@NotNull Bus.Process process){
        boolean valid = false;
        if (process.Valid() && !process.ProcessType().equals(Bus.Process.ProcessType.UNDEFINED)){
            int pid = pidnum.getLast();
            PLIST.put(process, pid);
            pidnum.add(pid + 1);
            valid = true;
            return valid;
        } else {
            return valid;
        }
    }
    public static int getPid(Bus.Process process) {
        int pid;
        if (PLIST.containsKey(process)) {
            pid = PLIST.get(process);
        } else pid = -1;
        return pid;
    }
    public static void init(){
        pidnum.add(0);
    }
    public static void getProcs() {
        int num = 1;
        for (Bus.Process process : PLIST.keySet()) {
            String name = process.getname();
            System.out.println(num + " "+ name + " | pid:" + getPid(process) + " | execpath: " + process.getExecPath());
            ++num;
        }
    }
    public static void Rel(Bus.Process process){
        if (PLIST.containsKey(process)){
            PLIST.remove(process);
        }
    }
}
