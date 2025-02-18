package BulldogME;

import java.util.ArrayList;
import java.util.Scanner;

public class Prog6 {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Enter the number of players: ");
        int numPlayers = scnr.nextInt();
        scnr.nextLine(); 
        
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Choose player type for player " + (i + 1) + ":");
            System.out.println("1. HumanPlayer");
            System.out.println("2. RandomPlayer");
            System.out.println("3. FifteenPlayer");
            System.out.println("4. UniquePlayer");
            System.out.print("Enter choice: ");
            int choice = scnr.nextInt();
            scnr.nextLine();

            System.out.print("Enter player name: ");
            String name = scnr.nextLine();

            switch (choice) {
                case 1:
                    players.add(new HumanPlayer(name));
                    break;
                case 2:
                    players.add(new RandomPlayer(name));
                    break;
                case 3:
                    players.add(new FifteenPlayer(name));
                    break;
                case 4:
                    players.add(new UniquePlayer(name));
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to HumanPlayer.");
                    players.add(new HumanPlayer(name));
                    break;
            }
        }

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("It's " + player.getName() + "'s turn.");
                int turnScore = player.play();
                player.setScore(player.getScore() + turnScore);
                System.out.println("   " + player.getName() + "'s total score is now " + player.getScore() + ".");

                if (player.getScore() >= 104) {
                    System.out.println("   " + player.getName() + " has won the game!");
                    gameOver = true;
                    break;
                }
            }
        }

        scnr.close();
    }
}