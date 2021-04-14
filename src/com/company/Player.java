package com.company;

import java.util.ArrayList;

public class Player {
    public final String name;
    public final String[] whoWinIt;
    public final String[] whoLoseIt;

    public Player(String name, String[] whoWinIt, String[] whoLoseIt) {
        this.name = name;
        this.whoWinIt = whoWinIt;
        this.whoLoseIt = whoLoseIt;

    }

    public static Player[] createPlayers(String[] names) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int halfOfLength = (names.length - 1) / 2;
            ArrayList<String> whoWinIt = new ArrayList<String>();
            ArrayList<String> whoLoseIt = new ArrayList<String>();

            for (int j = 1; j < halfOfLength + 1; j++) {
                int a = j + i;
                if (a < names.length) {
                    whoLoseIt.add(names[a]);
                } else {
                    whoLoseIt.add(names[a - names.length]);
                }
            }
            for (int j = 1; j < halfOfLength + 1; j++) {
                int a = i - j;
                if (a >= 0) {
                    whoWinIt.add(names[a]);
                } else {
                    whoWinIt.add(names[a + names.length]);
                }
            }

            String[] whoWinItArray = whoWinIt.toArray(new String[0]);
            String[] whoLoseItArray = whoLoseIt.toArray(new String[0]);
            players.add(new Player(names[i], whoWinItArray, whoLoseItArray));
        }

        return players.toArray(new Player[0]);
    }

    public static void findMatchResult(Player[] players, String userChoice, String computerChoice) {
        for (Player player : players) {
            if (player.name.equals(userChoice)) {
                for (String itWinCurrentPlayer : player.whoWinIt) {
                    if (itWinCurrentPlayer.equals(computerChoice)) {
                        if (itWinCurrentPlayer.equals(userChoice)) {
                            System.out.println("Draw");
                        } else {
                            System.out.println("You lose.");
                        }
                        break;
                    }
                }

                for (String itLooseCurrentPlayer : player.whoLoseIt) {
                    if (itLooseCurrentPlayer.equals(computerChoice)) {
                        if (itLooseCurrentPlayer.equals(userChoice)) {
                            System.out.println("Draw");
                        } else {
                            System.out.println("You win.");
                        }
                        break;
                    }
                }
            }
        }
    }
}
