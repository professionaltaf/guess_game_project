import java.util.Random;
import java.util.Scanner;

public class guessgame {
    private static final int min_range = 1;
    private static final int max_range = 100;
    private static final int max_attempts = 10;
    private static final int max_rounds = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("NUMBER GUESSING GAME");
        System.out.println("Total Number Of Rounds : 3");
        System.out.println("Attempts To Guess Number In Each Round : 10\n");
        for (int i = 1; i <= max_rounds; i++) {
            int number = random.nextInt(max_range) + min_range;
            int attempts = 0;

            System.out.printf("Round %d: Guess the number between %d and %d in %d attempts.\n", i, min_range, max_range,
                    max_attempts);
            while (attempts < max_attempts) {
                System.out.println("Enter your guess : ");
                int guess_number = scanner.nextInt();
                attempts = attempts + 1;

                if (guess_number == number) {
                    int score = max_attempts - attempts;
                    totalScore = totalScore + score;
                    System.out.printf("Hurray! Number Guessed Successfully. Attempts = %d. Round Score = %d\n",
                            attempts, score);
                    break;
                }

                else if (guess_number < number) {
                    System.out.printf("The number is greater than %d. Attempts Left = %d.\n", guess_number,
                            max_attempts - attempts);
                }

                else if (guess_number > number) {
                    System.out.printf("The number is less than %d. Attempts Left = %d.\n", guess_number,
                            max_attempts - attempts);
                }

            }

            if (attempts == max_attempts) {
                System.out.printf("\nRound = %d\n", i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random Number Is : %d\n\n", number);
            }
        }
        System.out.printf("Game Over. Total Score = %d\n", totalScore);
        scanner.close();
    }
}
