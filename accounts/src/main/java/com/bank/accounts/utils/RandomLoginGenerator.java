package com.bank.accounts.utils;

import java.util.Random;

public class RandomLoginGenerator {
    public static Long generate10DigitNumber() {
        Random random = new Random();
        Long min = 1000000000L; // Smallest 10-digit number
        Long max = 9999999999L; // Largest 10-digit number
        // Generate a random long within the range
        Long randomNumber = min + (long) (random.nextDouble() * (max - min + 1));
        return randomNumber;
    }
}
