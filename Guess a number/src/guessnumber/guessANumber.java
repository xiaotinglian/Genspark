import java.util.Random;
import java.util.Scanner;

public class guessANumber {

    public static int setNum(){
        int input = 0;
        try {
            System.out.println("Take a guess.");
            Scanner getInteger = new Scanner(System.in);
            input = getInteger.nextInt();
            while (input < 1 || input > 20) {
                System.out.println("Wrong number, try numbers between 1 and 20.");
                input = getInteger.nextInt();
            }
            
        }catch(Exception e){
            System.out.println("exception in setNum");
        }
        return input;
    }
    public static String setName() {
        String name = null;
        try {
            Scanner getInput = new Scanner(System.in);
            name = getInput.nextLine();
        } catch (Exception o) {
            System.out.println("exception in setName");
        }
        return name;
    }
    public static int setRand(){
        int rando=0;
        try {
            Random rand = new Random();
            rando= rand.nextInt(20);
        }catch(Exception i){
            System.out.println("Exception in set random number");
        }
        return rando;
    }
    public static boolean replay(){
        char again ;
        System.out.println("Would you like to play again? (y/n)");
        try {
            Scanner choice = new Scanner(System.in);
            again = choice.next().charAt(0);
            if(again=='y'){
                return true;
            }else if(again =='n'){
                return false;
            }else{
                System.out.println("choose y or n");
                return false;
            }
        }catch(Exception w){
            System.out.println("exception in replay");
        }
        return false;
    }
    public static boolean winOrLost( int guessNum, String user, int randNum, int count){
        try{
            if(count==6){
                System.out.println("out of chance!");
                return false;
            }
            if (guessNum > randNum) {
                System.out.println("Your guess is too high");
                return true;
            } else if (randNum > guessNum) {
                System.out.println("Your guess is too low");
                return true;
            } else {
                System.out.println("Good job, " + user + "! Your guessed my number in " + count + " guesses!");
                return false;
            }

        }catch(Exception a){
            System.out.println("something goes wrong in winOrLost method");
        }

    }

    public static void main(String[] args){

        System.out.println("Hello! What is your name?");
        String user = setName();
        System.out.println("Well, " + user + ", I am thinking of a number between 1 and 20.");

        int randNum = setRand();
        int count = 0;
        boolean winOrLoose = true;

        while (winOrLoose) {
            count++;
            int guessNum = setNum();
            winOrLoose = winOrLost(guessNum, user, randNum, count);
            if(!winOrLoose){
                randNum = setRand();
                count =0;
                winOrLoose=replay();
            }
        }
        System.out.println("thank you for playing");
    }
}