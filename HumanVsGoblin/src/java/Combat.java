import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Combat{
    private Human player;
    private Goblin gob;


    public Combat(Goblin gob, Human player) {
    }

    public void Battle(Goblin gob, Human player) throws InterruptedException {
        Random humanHit = new Random();
        Random goblinHit = new Random();
        int drop = 0;
        int gobHP = gob.getGoblinHealth();
        int dmgToGoblin;
        int humanHP = player.getHealth();
        int dmgToHuman;
        int lvNow = player.getLvl();
        Scanner input = new Scanner(System.in);

        while(gobHP != 0 || humanHP !=0){
            dmgToHuman = (goblinHit.nextInt(gob.getStrength())+gob.getStrength()-5) - player.getArmor();
            dmgToGoblin = (humanHit.nextInt(player.getStrength()+3) + player.getStrength()-3) - (gob.getStamina()/2);

            TimeUnit.MILLISECONDS.sleep(200);// add pause for effect
            //humanHP = player.setHealth(player.getHealth() - dmgToHuman);
            if(dmgToHuman < 0){
                System.out.println("The goblin missed!");
            } else {
                humanHP = player.setHealth(player.getHealth() - dmgToHuman);
                System.out.println("You got hit for " + dmgToHuman);
            }

            //gobHP = gob.setHealth(gob.getGoblinHealth() - dmgToGoblin);
            if(dmgToGoblin <= 0){
                System.out.println("You missed!");
            } else {
                gobHP = gob.setHealth(gob.getGoblinHealth() - dmgToGoblin);
                System.out.println("You hit the goblin for "+ dmgToGoblin);
            }
            if(gobHP <= 0){
                player.setExp(gob.getGoblinExp());
                System.out.println("You killed " + gob.getGoblinName() +"! You get " + gob.getGoblinExp() + " exp.");
                player.setLvl(player.getLvl(), player.getExp());
                drop = goblinHit.nextInt(100)+1;
                if(drop >= 30){
                    System.out.println("You found a potion on the goblin.");
                    player.setPotions(player.getPotions()+1);
                    if(drop >= 95) {
                        System.out.println("You found a new sword!");
                        player.setStrength(player.getStrength()+3);
                    } else if(drop >= 80){
                        System.out.println("You found a new armor.");
                        player.setArmor(player.getArmor(), 2);
                    }
                } else {
                    System.out.println("You searched the goblin but found nothing valuable.");
                }

                if(player.getLvl() > lvNow) {
                    System.out.println("Congratulations! You leveled up! You are now level " + player.getLvl());
                    System.out.println("You have " + player.getHealth() + " hp.");
                } else {
                    System.out.println("You have " + player.getHealth() + " hp left.");
                    System.out.println("Do you want to use a potion to heal 15 health points? (y/n)");
                    if(input.next().equals("y")) {
                        player.setHealth(player.getHealth()+15);
                        player.setPotions(player.getPotions()-1);
                    }
                }
                break;
            } else if(humanHP <= 0){
                System.out.println("You have died. Better luck next time " + player.getName() + ".");
                break;
            }
        }
    }
}
