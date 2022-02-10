package cave;

import java.util.Scanner;

public class dragonCave {
    public static String Cave(int choice){
        if (choice == 1) {
            return "You approach the cave..." + '\n' + "It is dark and spooky..." + "\n" + "A large dragon jumps out in front of you! He opens his jaws and..." + "\n" + "Gobbles you down in ine bite!";
        }
        if (choice == 2) {
            return "You got treasures from dragon!";
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will shar his treasure with you. The other dragon is greedy and hungry and will eat you insight.");
        System.out.println("Which cave will you go into?(1/2)");
        try {
            Scanner getInput = new Scanner(System.in);
            int choice = getInput.nextInt();
            System.out.println(Cave(choice));
        }catch(Exception e){
            System.out.println("Exception: wrong cave");
        }
    }
}
