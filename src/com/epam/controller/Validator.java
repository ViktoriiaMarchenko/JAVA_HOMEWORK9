package com.epam.controller;

import com.epam.exceptions.NotANumberException;
import com.epam.exceptions.NotAPositiveNumberException;

public class Validator {
    public static int checkPositiveInt(String intStr) throws NotANumberException {
        int parsedInt = 0;
        try {
            parsedInt = Integer.parseInt(intStr);
        } catch (NumberFormatException nfe) {
            throw new NotANumberException(intStr);
        }
        if (parsedInt < 0) {
            throw new NotAPositiveNumberException(intStr);
        }
        return parsedInt;
    }
}
