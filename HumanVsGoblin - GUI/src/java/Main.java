import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int worldSize = 10;
        String play = "y";
        Scanner input = new Scanner(System.in);
        while (play.equals("y")) {
            WorldGrid map = new WorldGrid();
            map.createGrid(worldSize);
            Human player = map.player;


            System.out.println("""
                    Welcome to the Human vs Goblin game.
                    Here you will try to survive and kill all 10 goblins.
                    You start off with lower stats but each lvl up increases your stats.
                    To begin, you need to name your character...""");




            player.setName(input.next());
            TimeUnit.MILLISECONDS.sleep(250);// add pause for effect

            System.out.println("World being created...");
            TimeUnit.MILLISECONDS.sleep(350);// add pause for effect


            String gotoNext = ("\n Where do you want to go next? (w = up, s = down, a = left, d= right, status = your stats, exit = end adventure)\n");


            System.out.println("World created.");
            TimeUnit.MILLISECONDS.sleep(300); // add pause for effect
            map.printMap();

            System.out.println("\nYou have started at " + "(" + map.getHumanLocation().getX() + ", " + map.getHumanLocation().getY() + ")");
            TimeUnit.MILLISECONDS.sleep(300); // add pause for effect
            while (player.getHealth() > 0) {
                System.out.print(gotoNext);
                String text = input.next();
                if (text.equals("exit")) {
                    break;
                }
                map.moveHuman(text);
                map.printMap();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("\nYou moved to " + "(" + map.getHumanLocation().getY() + ", " + map.getHumanLocation().getX() + ")");

                if(map.getGoblinsToKill() == 0){
                    System.out.println("Congratulations! You killed all the goblins and won!");
                    text = "status";
                    map.moveHuman(text);
                    break;
                }
            }
            System.out.println("Would you like to play again? (y/n)");
            play = input.next();
        }
        System.out.println("Thanks for playing. \n\n\n");
        input.close();
    }
}