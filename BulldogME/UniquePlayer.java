package BulldogME;
public class UniquePlayer extends Player {
    public UniquePlayer(String name) {
        super(name);
    }

    @Override
    public int play() {
        int turnScore = 0;
        int rolls = 0;
        while (rolls < 3) { // Stops after 3 rolls
            int roll = (int) (Math.random() * 6 + 1);
            rolls++;
            System.out.println("Rolled: " + roll);
            if (roll == 6) {
                System.out.println("Turn over! Score for this turn: 0");
                return 0;
            }
            turnScore += roll;
            System.out.println("Turn score: " + turnScore);
        }
        System.out.println("Stopped after 3 rolls.");
        return turnScore;
    }
}