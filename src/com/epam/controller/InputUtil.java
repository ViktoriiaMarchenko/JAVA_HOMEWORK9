package com.epam.controller;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        return sc.nextInt();
    }

    public static double inputDouble() {
        return sc.nextDouble();
    }

    public static String inputString() {
        return sc.nextLine();
    }
}
