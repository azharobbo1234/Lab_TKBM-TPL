package com.example.labpertama.utilities;

import java.util.Random;

public class StringRandomizer {
    public static String generateRandomString() {
        String resultCharacters = "abcdefghijklmnopqrstuvwxyz";
        int resultSize = 10;
        Random random = new Random();
        StringBuilder result = new StringBuilder(resultSize);
        for (int i = 0; i < resultSize; i++) {
            result.append(resultCharacters.charAt(random.nextInt(resultCharacters.length())));
        }
        return result.toString();
    }
}