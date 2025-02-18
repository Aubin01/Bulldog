package BulldogAI;
import java.util.Random;
/********************************************************/
/* RandomPlayer class - Randomly decides to continue    */
/********************************************************/
class RandomPlayer extends Player {
    private Random rand = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public int play() {
        int totalScore = 0;
        while (true) {
            int roll = rand.nextInt(6) + 1;
            System.out.println(getName() + " rolled: " + roll);
            
            if (roll == 6) {
            	System.out.println(getName() + " lost all points this turn!");
                return 0;
            }
            totalScore += roll;
            
            if (rand.nextBoolean()) {
                break;
            }
        }
        return totalScore;
    }
}