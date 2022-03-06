import java.util.*;

public class WorldGrid {
    String empty = "\uD83C\uDF32";
    String human = "\uD83E\uDDB8";
    String goblin = "\uD83D\uDC7A";
    String mountain = "⛰";
    String water = "\uD83C\uDF0A";
    public Coordinates humanLocation;
    public Coordinates goblinLocation;
    public ArrayList<MapLocation> currentMap;
    Human player;
    int humanIndex;
    int goblinsToKill = 10;

    public WorldGrid() {
    }

    public ArrayList<MapLocation> createGrid(int gridSize){
        int mountainCount = 12;
        int waterCount = 12;
        int humanCount = 1;
        int goblinCount = 10;
        int emptyCount = (gridSize*gridSize)-(mountainCount+waterCount+goblinCount+1);

        new Coordinates();
        Coordinates coord;
        MapLocation<Coordinates, String> mapSpot = new MapLocation<>();
        ArrayList<MapLocation> map = new ArrayList<>();
        Random pop = new Random();
        int limit = 7;
        int index = -1;

        for (int i = 0; i <gridSize; i++){
            for(int j = 0; j< gridSize;j++){
                index++;
                int a = pop.nextInt(limit);
                mapSpot = new MapLocation<>();
                coord = new Coordinates();
                coord.setX(i);
                coord.setY(j);
                if(a == 1 && waterCount !=0){
                    mapSpot.setMapValue(water);
                    waterCount--;
                } else if(a == 2 && mountainCount !=0){
                    mapSpot.setMapValue(mountain);
                    mountainCount--;
                }else if (a == 3 && humanCount !=0){
                    mapSpot.setMapValue(human);
                    humanLocation = coord;
                    humanIndex = index;
                    humanCount--;
                }else if(a == 4 && goblinCount !=0){
                    mapSpot.setMapValue(goblin);
                    //goblinLocation = coord;
                    goblinCount--;
                }else if(emptyCount !=0){
                    mapSpot.setMapValue(empty);
                    emptyCount--;
                }
                mapSpot.setCoordinate(coord);
                map.add(mapSpot);
            }
        }
        setMap(map);
        this.currentMap = map;
        this.player = new Human();
        return map;
    }

    public Coordinates setHumanLocation(Coordinates i) {
        humanLocation = i;
        return humanLocation;
    }

    public Coordinates getHumanLocation() {
        return humanLocation;
    }

    //method for moving the character based on input direction.
    public void moveHuman(String direction) throws InterruptedException {
        ArrayList<MapLocation> tempMap = getMap();
        int move = switch (direction) {
            case "w" -> 1;
            case "s" -> 2;
            case "a" -> 3;
            case "d" -> 4;
            case "status" -> 5;
            default -> 0;
        };
        Coordinates humanAt = new Coordinates();                                                //create new coordinate and set it's x and y values
        humanAt.setX(getHumanLocation().getX());
        humanAt.setY(getHumanLocation().getY());
        Coordinates humanWasAt = getHumanLocation();                                            //create new coordinate for previous location and set as human current
        MapLocation<Coordinates,String> oldHumanLocation = new MapLocation<>();                 //create two new mapLocation item with previous and new coordinates
        MapLocation<Coordinates,String> newHumanLocation = new MapLocation<>();
        oldHumanLocation.setCoordinate(humanAt);                                                //set new mapLocation for previous coordinate
        int humanWasIndex = humanIndex;                                                         //create index for current human index in main map array
        int humanNowIndex = humanIndex;                                                         //create index for previous human index set at current from main array
        String currentLocationValue;                                                            //create value string for current location
        oldHumanLocation.setMapValue(empty);                                                    //set previous human coordinate mapLocation value as empty
        int i = humanAt.getX();                                                                 //integers i and j are for coordinate altering
        int j = humanAt.getY();                                                                 //

        switch (move){
            case 1: //up
                if(humanAt.getX(i) == 0){
                    direction = "You can't move here. It's the top edge of the world and you'll fall off!";
                    System.out.println(direction);
                } else {
                    humanAt.setX(humanWasAt.getX(i)-1);                                         //update coordinate up one cell
                    humanNowIndex-=10;                                                          //increase index of human location accordingly
                    humanIndex = humanNowIndex;                                                 //increase index of human location accordingly
                    setHumanLocation(humanAt);                                                  //update human location
                    newHumanLocation.setCoordinate(humanAt);
                    newHumanLocation.setMapValue(human);
                    currentLocationValue = currentMap.get(humanNowIndex).getMapValue();         //gets value of new location before player icon moved
                    resolveLocation(currentLocationValue);                                      //resolves new location. See method resolveLocation on line 194.
                    currentMap.get(humanNowIndex).setMapValue(human);                           //update array index value to human icon
                    newHumanLocation.setMapValue(human);
                    currentMap.get(humanWasIndex).setMapValue(empty);                           //update array index value from previous spot to empty.
                }
                break;
            case 2: //down
                if(humanAt.getX(i) == 10){
                    direction = "You can't move here. It's the bottom edge of the world and you'll fall off!";
                    System.out.println(direction);

                } else {
                    humanAt.setX(humanAt.getX(i)+1);                                            //update coordinate down one cell
                    humanNowIndex+=10;                                                          //increase index of human location accordingly
                    humanIndex = humanNowIndex;                                                 //increase index of human location accordingly
                    setHumanLocation(humanAt);                                                  //update human location
                    newHumanLocation.setCoordinate(humanAt);
                    newHumanLocation.setMapValue(human);
                    currentLocationValue = currentMap.get(humanNowIndex).getMapValue();         //gets value of new location before player icon moved
                    resolveLocation(currentLocationValue);                                      //resolves new location. See method resolveLocation on line 194.
                    currentMap.get(humanNowIndex).setMapValue(human);                           //update array index value to human icon
                    newHumanLocation.setMapValue(human);
                    currentMap.get(humanWasIndex).setMapValue(empty);                           //update array index value from previous spot to empty.
                }
                break;
            case 3: //move left
                if(humanAt.getY(j) == 0){
                    direction = "You can't move here. It's the left edge of the world and you'll fall off!";
                    System.out.println(direction);
                } else {
                    humanAt.setY(humanAt.getY(j)-1);                                              //update coordinate left one cell
                    humanNowIndex-=1;                                                             //increase index of human location accordingly
                    humanIndex = humanNowIndex;                                                 //increase index of human location accordingly
                    setHumanLocation(humanAt);                                                    //update human location
                    newHumanLocation.setCoordinate(humanAt);
                    newHumanLocation.setMapValue(human);
                    currentLocationValue = currentMap.get(humanNowIndex).getMapValue();          //gets value of new location before player icon moved
                    resolveLocation(currentLocationValue);                                       //resolves new location. See method resolveLocation on line 194.
                    currentMap.get(humanNowIndex).setMapValue(human);                            //update array index value to human icon
                    newHumanLocation.setMapValue(human);
                    currentMap.get(humanWasIndex).setMapValue(empty);                            //update array index value from previous spot to empty.
                }
                break;
            case 4: //move right
                if(humanAt.getY(j) == 10){
                    direction = "You can't move here. It's the right edge of the world and you'll fall off!";
                    System.out.println(direction);
                } else {
                    humanAt.setY(humanAt.getY(j)+1);                                            //update coordinate right one cell
                    humanNowIndex+=1;                                                           //increase index of human location accordingly
                    humanIndex = humanNowIndex;                                                 //increase index of human location accordingly
                    setHumanLocation(humanAt);                                                  //update human location
                    newHumanLocation.setCoordinate(humanAt);
                    newHumanLocation.setMapValue(human);
                    currentLocationValue = currentMap.get(humanNowIndex).getMapValue();         //gets value of new location before player icon moved
                    resolveLocation(currentLocationValue);                                      //resolves new location. See method resolveLocation on line 194.
                    currentMap.get(humanNowIndex).setMapValue(human);                           //update array index value to human icon
                    newHumanLocation.setMapValue(human);
                    currentMap.get(humanWasIndex).setMapValue(empty);                           //update array index value from previous spot to empty.
                }
                break;
            case 5: //list human status
                System.out.println("Your Level is: " + player.getLvl());
                System.out.println("Your Exp is: " + player.getExp());
                System.out.println("Your Health is: " + player.getHealth() + "/" + ((player.getConstitution()*5)+(2*player.getLvl())));
                System.out.println("Your Strength is: " + player.getStrength());
                System.out.println("Your Stamina is: " + player.getStamina());
                System.out.println("Your Constitution is: " + player.getConstitution());
                System.out.println("Your Intelligence is: " + player.getIntelligence());
                System.out.println("Your Armor is: " + player.getArmor());
                System.out.println("Your Shield is: " + player.getShield());
                System.out.println("Your Potion count is: " + player.getPotions());
                break;
            case 0:
                direction = "You didn't input a correct direction command. (w = up, s = down, a = left, d= right)";
                System.out.println(direction);
                break;
        }
        setMap(tempMap);
    }

    //used to get a location value for resolving
    public String checkLocation(Coordinates checkLocation) {
        MapLocation<Coordinates, String> tempLocation = new MapLocation<>();
        tempLocation.setCoordinate(checkLocation);
        return tempLocation.getMapValue();

    }

    private ArrayList<MapLocation> setMap(ArrayList<MapLocation> updatedMap) {

        this.currentMap = updatedMap;
        return currentMap;
    }

    //used to resolve location that player is moving to
    public void resolveLocation(String s) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int lvNow = player.getLvl();

        //check if goblin. If so, ask for combat
        if(s.equals(goblin)){
            Goblin gob = new Goblin();

            //Choose to do combat or not.
            System.out.println("\nThere's a lv " + gob.getGoblinLv() + " " + gob.getColor() + " goblin named " + gob.getGoblinName() + " here! \nDo you want to battle? (y/n)");
            String choice = scan.next();
            if(choice.equals("y")) {
                System.out.println("\nBattle starting!");
                Combat fight = new Combat(gob, player);
                fight.Battle(gob,player);
                setGoblinsToKill(1);
            } else {
                System.out.println("\nYou have fled from battle.");
                setGoblinsToKill(1);
            }

            //check for mountain
        } else if (s.equals(mountain)){
            System.out.println("\nYou have entered some mountains. After some tough climbing you come out feeling rejuvenated from the fresh air and slightly stronger");
            player.setExp(2);
            player.setLvl(player.getLvl(), player.getExp());
            if(player.getLvl() > lvNow) {
                System.out.println("Congratulations! You leveled up! You are now level " + player.getLvl());
                System.out.println("You have " + player.getHealth() + " hp.");
            }

            //check for water
        } else if (s.equals(water)) {
            System.out.println("\nYou have found some fresh water. After drinking some you feel slightly healthier.");
            player.setHealth(player.getHealth() + 2);
        }
    }

    public int getGoblinsToKill() {
        return goblinsToKill;
    }

    public void setGoblinsToKill(int kill) {
        this.goblinsToKill -= kill;
    }

    public void printMap() {
        ArrayList<MapLocation> map = getMap();
        MapLocation<Coordinates,String> tempLocation2 = new MapLocation<>();
        Coordinates c = tempLocation2.getCoordinate();
        StringBuilder grid = new StringBuilder();

        for(int i = 0; i< 100; i++){
            if(i%10==0){
                grid.append("\n");
            }
            grid.append(" ").append(map.get(i).getMapValue()).append(" ");
        }

        System.out.print(grid);
    }

    public ArrayList<MapLocation> getMap() {
        return currentMap;
    }
}
