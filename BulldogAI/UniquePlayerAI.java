package BulldogAI;

/********************************************************/
/* UniquePlayerAI class - Implements a unique strategy by an AI   */
/********************************************************/
public class UniquePlayerAI extends Player {
    public UniquePlayerAI(String name) {
        super(name);
    }

    @Override
    public int play() {
        int turnScore = 0;

        // Ensure at least one roll before stopping
        do {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("  Rolled " + roll);

            if (roll == 6) {
                System.out.println("  Rolled 6 and lost all turn points.");
                return 0; // Lose the turn immediately
            }

            turnScore += roll;
        } while (turnScore < 12 && Math.random() > 0.3); // Stop at 12 or 30% chance

        // Print turn score
        System.out.println(getName() + " turn score: " + turnScore);

        return turnScore;
    }
}
