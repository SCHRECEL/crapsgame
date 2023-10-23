import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playing;

        do {
            int point = 0;
            int sum = rollDice(random);
            System.out.println("First roll: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                point = sum;
                System.out.println("Point is set to " + point);

                boolean tryingForPoint = true;
                while (tryingForPoint) {
                    sum = rollDice(random);
                    System.out.println("Roll: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost!");
                        break;
                    }
                }
            }

            System.out.print("Play again? (Y/N): ");
            String playAgain = scanner.next();
            playing = playAgain.equalsIgnoreCase("y");
        } while (playing);
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2);
        System.out.println("Total: " + sum);
        return sum;
    }
}
