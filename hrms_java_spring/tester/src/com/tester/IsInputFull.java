package com.tester;

import static java.lang.String.valueOf;

public class IsInputFull {

    public static boolean inputController(String input) {
        if (input.length() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inputController(int input) {
        int inputLength = (int)(Math.log10(input)+1);
        if (inputLength <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inputController(double input) {
        int inputLength = 0;
        String temp = valueOf(input);
        String[] div = temp.split("\\.");
        inputLength = div[0].length() + div[1].length();
        if (inputLength >= 1) {
            return true;
        } else {
            return false;
        }
    }

}