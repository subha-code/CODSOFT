package codesoft.project.p1;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumberGuessingGame {
    final static int minAttempt = 1;
    final static int maxAttempt = 100;
    final static int totalAttemptsLimit = 5;

  public  int totalRounds = 0;
  public  int totalRoundsWon = 0;

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            totalRounds++;
            int target = random.nextInt(maxAttempt - minAttempt + 1) + minAttempt;
            totalRoundsWon += playRound(scanner, target);
            playAgain = askToPlayAgain(scanner);
        }

    }

    public  int playRound(Scanner scanner, int target) {
        Set<Integer> guessedNumbers = new HashSet<>();
        int attempts = 0;

        System.out.println("\nRound " + totalRounds + ":");
        System.out.println("I've selected a number between " + minAttempt + " and " + maxAttempt + ". Try to guess it!");
        System.out.println("You have " + totalAttemptsLimit + " attempts.");

        while (attempts < totalAttemptsLimit) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guessedNumbers.contains(guess)) {
                System.out.println("You've already guessed this number. Try again.");
                continue;
            }

            guessedNumbers.add(guess);

            System.out.println(guess < target ? "Too low! Try again." : (guess > target ? "Too high! Try again." : ("Congratulations! You've guessed the number " + target + " correctly!\n")));
            return guess == target ? 1 : 0;
        }

        if (attempts == totalAttemptsLimit) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + target);
        }
        return 0;
    }

    public boolean askToPlayAgain(Scanner scanner) {
        System.out.print("Do you want to play again? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }


}
