
import java.util.Random;
import java.util.Scanner;

public class guessANumber {
    public class
    public static void main(String[] args){

            System.out.println("Hello! What is your name?");
            Scanner getInput = new Scanner(System.in);
            String name = getInput.nextLine();
            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");

            Random rand = new Random();
            int num = rand.nextInt(20);
            int count = 0;

            while (true) {
                System.out.println("Take a guess.");
                Scanner getInteger = new Scanner(System.in);
                int number = getInteger.nextInt();
                count++;
                if ((number - num) > 6) {
                    System.out.println("Your guess is too high");
                } else if ((num - number) > 6) {
                    System.out.println("Your guess is too low");
                } else {
                    System.out.println("Good job, " + name + "! Your guessed my number in " + count + " guesses!");
                    System.out.println("Would you like to play again? (y/n)");
                    Scanner choice = new Scanner(System.in);
                    String play = choice.nextLine();
                    if (play.equals("y")) {
                        System.out.println("Hello! What is your name?");
                        getInput = new Scanner(System.in);
                        name = getInput.nextLine();
                        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
                        rand = new Random();
                        num = rand.nextInt(20);
                        count = 0;
                    }
                    if (play.equals("n")) {
                        break;
                    }
                }
            }


    }
}
