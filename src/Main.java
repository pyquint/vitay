import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        /* VITAY
        A game where players guess the secret word by suggesting possible letters.
        If the letter is not in the secret word, an edge from the word "VITAY" would be drawn,
        until the whole word (VITAY) has been spelled, in which case the player loses.

        * Assume the secret word has no spaces, punctuations, or special characters. */
        System.out.println("""
                +-----------------------------+
                | \\    / ____ ____  /\\ \\\\  // |
                |  \\  /   ||   ||  /--\\ \\\\//  +-----------------+
                |   \\/   ----  || /    \\ ||    by Group Bitwise |
                +-----------------------------------------------+
                
                Welcome to VITAY!
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press ENTER to play.");
        scanner.nextLine();

        char guess;
        int correctGuesses;
        int incorrectGuesses;
        String guessedLetters;

        do {
            correctGuesses = incorrectGuesses = 0;
            guessedLetters = "";

            cls();
            System.out.print("Enter the secret word: ");
            String word = scanner.nextLine().toUpperCase();
            cls();

            while (correctGuesses < word.length()) {
                System.out.println("\nMistakes: " + incorrectGuesses + " out of 13.");

                System.out.println("Guesses: " + guessedLetters);
                for (int j = 0; j < word.length(); j++) {
                    System.out.print((j + 1) + ".\t");
                    if (guessedLetters.indexOf(word.charAt(j)) != -1) {
                        System.out.print(word.charAt(j));
                    } else {
                        System.out.print("_");
                    }
                    System.out.println();
                }

                System.out.print("\nGuess a letter: ");
                String input = scanner.nextLine();
                if (input.length() != 1) {
                    cls();
                    System.out.println("Invalid input. Please enter a letter.");
                    continue;
                }

                guess = input.toUpperCase().charAt(0);
                if (guess < 'A' || guess > 'Z') {
                    cls();
                    System.out.println("Input must be a single letter only.");
                    continue;
                }

                cls();

                if (guessedLetters.indexOf(guess) != -1) {
                    System.out.println("You already guessed with '" + guess + "'!");

                } else if (word.indexOf(guess) != -1) {
                    System.out.println("Found '" + guess + "' in the word!");
                    guessedLetters += guess;
                    correctGuesses++;
                } else {
                    System.out.println("Oopsies! '" + guess + "' is not in the word!");
                    guessedLetters += guess;
                    incorrectGuesses++;
                }

                if (incorrectGuesses == 13) {
                    cls();
                    System.out.println("\nVITAY! You lose! You didn't guess the secret word '" + word + "'!");
                    break;
                }
            }
            System.out.println("Huzzah! You guessed the secret word '" + word + "'! Congratulations!");
            System.out.print("Play another game? Enter any or no key if yes, `no` if you want to quit.");
        } while (!scanner.nextLine().equals("no"));
    }

    static void cls() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
