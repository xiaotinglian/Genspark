import java.util.Scanner;

public class dragonCave {
    public static void main(String[] args){
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will shar his treasure with you. The other dragon is greedy and hungry and will eat you onsight.");
        System.out.println("Which cave will you go into?(1/2)");
        Scanner getInput = new Scanner(System.in);
        int choice = getInput.nextInt();
        if(choice==1){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in ine bite!");
        }
        if(choice==2){
            System.out.println("You got treasures from dragon!");
        }
    }
}
