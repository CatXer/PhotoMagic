package com.sergprog.utils;

public class Utils {

    public static void invokeProcedure(Procedure procedure, boolean printStacTrace){
        try {
            procedure.invoke();
        }catch (Exception e){
            if (printStacTrace)
                e.printStackTrace();
        }
    }
}
