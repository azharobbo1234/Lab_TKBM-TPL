package com.example.labpertama;

import java.util.ArrayList;

public class Calculator {
    public static boolean validateCalculation(String value) {
        boolean result = value.matches("^(?:[+-][0-9]+)+|^[0-9]+(?:[+-][0-9]+)*");
        return result;
    }
    public static int calculate(String value) {
        int result = 0;
        String element = "";
        ArrayList<String> elementArr = new ArrayList<String>();

        for (int i = value.length() - 1; i >=0; i--) {
            char currentChar = value.charAt(i);
            element += String.valueOf(currentChar);
            if (currentChar == '+' || currentChar == '-' || i == 0) {
                elementArr.add(element);
                element = "";
            }
        }

        for (int j = 0; j < elementArr.size(); j++) {
            String reversedElement = new StringBuilder(elementArr.get(j)).reverse().toString();
            result += Integer.parseInt(reversedElement);
        }
        return result;
    }
}
