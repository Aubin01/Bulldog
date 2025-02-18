package BulldogME;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner enter;

    public HumanPlayer(String name) {
        super(name);
        enter = new Scanner(System.in);
    }

    @Override
    public int play() {
    	
        int turnScore = 0;
        while (true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("Rolled: " + roll);
            if (roll == 6) {
                System.out.println("Turn over! Score for this turn: 0");
                return 0;
            }
            turnScore += roll;
            System.out.println("Turn score: " + turnScore);
            System.out.print("Continue? (y/n): ");
            String input = enter.nextLine().trim().toLowerCase();
            if (!input.equals("y")) {
                return turnScore;
            }
        }
    }
}