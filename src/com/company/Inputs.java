package com.company;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Inputs {
    public static int inputPlayer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

        while (args.length < userInput || userInput < 0) {
            Menu.generateMenu(args);
            userInput = sc.nextInt();
        }

        return userInput;
    }

    public static int inputComputer(int range) {
        return new Random().nextInt(range);
    }
    public static int checkRepeats(String[] args) {
        Set<String> set = new HashSet<>();

        for (String arg : args) {
            if (!set.add(arg)) {
                return 0;
            }
        }
        return 1;
    }
}