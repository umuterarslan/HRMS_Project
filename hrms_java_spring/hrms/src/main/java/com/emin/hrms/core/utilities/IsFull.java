package com.emin.hrms.core.utilities;

import java.util.List;

import static java.lang.String.valueOf;

public class IsFull {

    static final int MIN_LENGTH = 1;

    public static boolean inputController(String input) {
        if (input.length() >= MIN_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean inputController(int input) {
        int inputLength = (int) (Math.log10(input) + 1);
        if (inputLength >= MIN_LENGTH) {
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
        if (inputLength >= MIN_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean listController(List input) {
        if (input.stream().count() >= MIN_LENGTH) {
            return true;
        } else {
            return false;
        }
    }

}
