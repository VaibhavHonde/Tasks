import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        while (true) {
            System.out.println("Choose your move (Rock, Paper, Scissors) or type 'quit' to exit:");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("quit")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];

            System.out.println("Computer chose: " + computerChoice);

            if (userChoice.equals(computerChoice.toLowerCase())) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("Scissors")) ||
                    (userChoice.equals("paper") && computerChoice.equals("Rock")) ||
                    (userChoice.equals("scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }

        scanner.close();
    }
}
