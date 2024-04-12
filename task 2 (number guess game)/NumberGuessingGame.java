import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 0;
        int score = 0;
        int rounds = 1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Can you guess it?");

        while (true) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nRound " + rounds);
            System.out.println("Score: " + score);

            for (attempts = 1; attempts <= 5; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess (1-100): ");
                int guess = scanner.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    score += (6 - attempts) * 10; // Award points based on number of attempts
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("The number is higher than " + guess + ".");
                } else {
                    System.out.println("The number is lower than " + guess + ".");
                }
            }

            System.out.println("The correct number was: " + targetNumber);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            rounds++;
        }

        System.out.println("\nFinal Score: " + score);
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
