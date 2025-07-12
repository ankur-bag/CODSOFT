import java.util.Random;
import java.util.Scanner;

public class NumberGame
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int tol_score = 0;

        System.out.println("Welcome to the Game!");
        System.out.println("Guess a number between 1 and 100 ");
        System.out.println("You will get 5 attempts.");


        boolean play_more = true;

        while (play_more)
        {
            int secret_num = rand.nextInt(100) + 1;
            int attempts = 5;
            boolean guessed = false;

            while (attempts > 0)
            {
                System.out.print("\nYour guess: ");
                int guess = sc.nextInt();

                if (guess == secret_num)
                {
                    System.out.println("Correct! You guessed the number.");
                    tol_score++;
                    guessed = true;
                    break;
                }
                else if (guess < secret_num)
                {
                    System.out.println("Too low. Try again.");
                }
                else
                {
                    System.out.println("Too high. Try again.");
                }

                attempts--;
                System.out.println("Attempts left: " + attempts);
            }

            if (!guessed)
            {
                System.out.println("You are out of attempts. The correct number was: " + secret_num);
            }

            System.out.print("\nDo you want to play another round? (Y/N): ");
            String reply = sc.next();
            play_more = reply.equalsIgnoreCase("Y");
        }

        System.out.println("\nGame over. Your final score: " + tol_score);
        sc.close();
    }
}
