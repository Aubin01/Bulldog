package BulldogAI;

public class UniquePlayerme extends Player {
    public UniquePlayerme(String name) {
        super(name);
    }

    @Override
    public int play() {
        int turnScore = 0;
        int rolls = 0;

        while (rolls < 3) { // Stops after 3 rolls
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("  Rolled " + roll);
            rolls++;

            if (roll == 6) {
                System.out.println("  Rolled 6 and lost all turn points.");
                return 0; // End turn with 0 points
            }

            turnScore += roll;
        }

        // Print only turn score (not total score, since Prog6 handles it)
        System.out.println(getName() + " turn score: " + turnScore);

        return turnScore;
    }
}
