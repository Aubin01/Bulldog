package BulldogAI;

/********************************************************/
/* Bulldog Game - COS 420                                */
/* Implements different player strategies for Bulldog    */
/* Follows OOP principles, proper documentation, and     */
/* structured gameplay.                                  */
/********************************************************/

import java.util.*;

/********************************************************/
/* HumanPlayer class - Allows a human to play via input */
/********************************************************/
class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int play() {
        int totalScore = 0;
        while (true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled: " + roll);
            
            if (roll == 6) {
                System.out.println(getName() + " lost all points this turn!");
                return 0;
            }
            totalScore += roll;
            
            System.out.print("Continue rolling? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }
        return totalScore;
    }
}