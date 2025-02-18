package BulldogAI;

/********************************************************/
/* FifteenPlayer class - Stops rolling after 15 points  */
/********************************************************/
class FifteenPlayer extends Player {

    /**
     * Constructor for FifteenPlayer.
     * @param name Name of the player.
     */
    public FifteenPlayer(String name) {
        super(name);
    }

    /**
     * Plays the turn for the FifteenPlayer.
     * The player rolls a die and continues rolling until their total score reaches 15 or more.
     * If a 6 is rolled, the player loses all points for the turn and returns 0.
     * @return The total score for the turn (0 if a 6 is rolled, otherwise the sum of rolls up to 15 or more).
     */
    @Override
    public int play() {
        int totalScore = 0;

        // Continue rolling until the total score reaches at least 15
        while (totalScore < 15) {
            int roll = (int) (Math.random() * 6 + 1); // Roll a six-sided die
            System.out.println(getName() + " rolled: " + roll);

            // If the player rolls a 6, they lose all points for the turn
            if (roll == 6) {
                System.out.println(getName() + " lost all points this turn!");
                return 0;
            }

            totalScore += roll; // Add roll value to total score
        }

        return totalScore; // Return the final score for the turn
    }
}
