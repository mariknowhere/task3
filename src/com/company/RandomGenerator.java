package com.company;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class RandomGenerator {
    private static String DICTIONARY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String createRandomCode(int codeLength) {
        return new SecureRandom()
                .ints(codeLength, 0, DICTIONARY.length())
                .mapToObj(DICTIONARY::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}