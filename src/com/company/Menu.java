package com.company;

public class Menu {
    public static void generateMenu(String[] args) {
        System.out.println("Available moves:");

        for (int i = 0; i < args.length; i++) {
            System.out.printf("%s) %s%n", i + 1, args[i]);
        }

        System.out.println("0) exit");
        System.out.print("Enter your move: ");
    }

    public static void printResult(String[] args, int userInput, int computerInput) {
        System.out.println("Your move:" + args[userInput - 1]);
        System.out.println("Computer move:" + args[computerInput]);
    }
}
