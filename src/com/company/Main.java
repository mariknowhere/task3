package com.company;

public class Main {
    public static void main(String[] args) {
        int computerInput = Inputs.inputComputer(args.length);

        if (args.length % 2 == 0 || args.length == 1 || Inputs.checkRepeats(args) == 0) {
            System.out.println("You entered an incorrect number of arguments, " +
                    "please enter an odd number of non-duplicate arguments greater than or equal to three");
            return;
        }

        HMAC.generateKey();

        Menu.generateMenu(args);

        int userInputs = Inputs.inputPlayer(args);
        if (userInputs == 0) {
            return;
        }
        String userChoice = args[userInputs - 1];

        Player[] players = Player.createPlayers(args);
        String computerChoice = args[computerInput];

        Menu.printResult(args, userInputs, computerInput);

        Player.findMatchResult(players, userChoice, computerChoice);

        String secretKey = RandomGenerator.createRandomCode(10);
        System.out.println("HMAC key: " + secretKey);
    }
}