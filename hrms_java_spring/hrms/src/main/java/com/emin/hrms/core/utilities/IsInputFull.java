package com.emin.hrms.core.utilities;

public class IsInputFull {

    public static boolean inputController(String input) {
        if (input.length() >= 1) {
            return true;
        } else {
            return false;
        }
    }

}
