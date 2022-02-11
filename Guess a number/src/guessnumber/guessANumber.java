import java.util.Random;
import java.util.Scanner;

public class guessANumber {

    public static int setNum(){
        System.out.println("Take a guess.");
        Scanner getInteger = new Scanner(System.in);
        int input = getInteger.nextInt();
        while (input < 1 || input > 20) {
            System.out.println("Wrong number, try numbers between 1 and 20.");
            input = getInteger.nextInt();
        }
        return input;
    }
    public static String setName(){
        Scanner getInput = new Scanner(System.in);
        return getInput.nextLine();
    }
    public static int setRand(){
        Random rand = new Random();
        return rand.nextInt(20);
    }
    public static char replay(){
        Scanner choice = new Scanner(System.in);
        return choice.next().charAt(0);
    }


    public static void main(String[] args){

        System.out.println("Hello! What is your name?");
        String user = setName();
        System.out.println("Well, " + user + ", I am thinking of a number between 1 and 20.");

        int randNum = setRand();
        int count = 0;
        int time = 6;

        while (time!=0) {
            int guessNum = setNum();
            count++;
            time--;
            if (guessNum > randNum) {
                System.out.println("Your guess is too high");
            } else if (randNum > guessNum) {
                System.out.println("Your guess is too low");
            } else {
                System.out.println("Good job, " + user + "! Your guessed my number in " + count + " guesses!");
                System.out.println("Would you like to play again? (y/n)");
                char play =replay();
                if (play=='y') {
                    System.out.println("Well, " + user + ", I am thinking of a number between 1 and 20.");
                    randNum = setRand();
                    count = 0;
                    time = 7;
                }
                if (play=='n') {
                    break;
                }
            }
        }
    }
}