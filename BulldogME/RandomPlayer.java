package BulldogME;

public class RandomPlayer extends Player {
    public RandomPlayer(String name) {
        super(name);
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
            boolean continueRoll;
            if (Math.random() < 0.5) {
                continueRoll = true;  
            } else {
                continueRoll = false;
            }
            System.out.println("Turn score: " + turnScore);
            if (continueRoll) {
                System.out.println("Decided to continue.");
            } else {
                System.out.println("Decided to stop.");
                return turnScore;
            }
        }
    }
}