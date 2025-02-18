package BulldogAI;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
/********************************************************/
/* Prog6 - Runs the Bulldog game                        */
/********************************************************/
class Prog6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();
        
        List<Player> players = new ArrayList<>();
        
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            System.out.println("Choose player type: (human/random/fifteen/unique-me/unique-ai/wimp)");
            String type = scanner.nextLine().toLowerCase();
            
            switch (type) {
                case "human": players.add(new HumanPlayer(name, scanner)); break;
                case "random": players.add(new RandomPlayer(name)); break;
                case "fifteen": players.add(new FifteenPlayer(name)); break;
                case "unique-me": players.add(new UniquePlayerme(name)); break;
                case "unique-ai": players.add(new UniquePlayerAI(name)); break;
                case "wimp": players.add(new WimpPlayer(name)); break;
                default: System.out.println("Invalid type, skipping player.");
            }
        }
        
        int winningScore = 104;
        boolean gameOver = false;
        
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("\n" + player.getName() + "'s turn");
                int roundScore = player.play();
                player.setScore(player.getScore() + roundScore);
                
                System.out.println(player.getName() + " total score: " + player.getScore());
                if (player.getScore() >= winningScore) {
                    System.out.println(player.getName() + " wins the game!");
                    gameOver = true;
                    break;
                }
            }
        }
        
        scanner.close();
    }
}
