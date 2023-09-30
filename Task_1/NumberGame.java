package Task_1;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int lowLimit = 1;
        int uppLimit = 100;
        int guessedNum;
        int userGuess;
        int attempts = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;
        String user;

        System.out.print("Enter your name: ");
        user = sc.nextLine();

        System.out.println("Hello, "+user+" Welcome to the 'Guess the Number' game!");

        while (playAgain) {
            roundsPlayed++;
            guessedNum = random.nextInt(uppLimit - lowLimit + 1) + lowLimit;
            attempts = 0;
            System.out.println("\nRound " + roundsPlayed);
            System.out.println("Guess the number between " + lowLimit + " to " + uppLimit);

            while (true) {
                System.out.print("Enter your guess: ");
                userGuess = sc.nextInt();
                attempts++;

                if (userGuess == guessedNum) {
                    System.out.println("Wow..! Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                } else if (userGuess < guessedNum) {
                    System.out.println("Ooph... The number is too low. Try again.");
                } else {
                    System.out.println("Ooph...The number is too high. Try again.");
                }
            }

            System.out.print("Do you want to play again? ('y' for yes / any other input can close the game): ");
            String playAgainResponse = sc.next().toLowerCase();
            playAgain = playAgainResponse.equals("y");
        }

        System.out.println("\nNice to play with you "+ user);
        System.out.println("Thank you for playing! You played " + roundsPlayed + " rounds.");
        sc.close();
    }
}
