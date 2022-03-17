import java.util.ArrayList;
import java.util.Random;

public class Goblin {

    Random j = new Random();
    Random l = new Random();
    String gSymbol = "\uD83D\uDC7A";
    int statLimit = 7;
    int goblinCount;
    int goblinLv = l.nextInt(7)+1;
    int goblinExp = goblinLv*2;
    int strength = j.nextInt(statLimit)+goblinLv;
    int intelligence = j.nextInt(statLimit)+5;
    int stamina = j.nextInt(statLimit)+5;
    int constitution = j.nextInt(statLimit)+5;
    int health = constitution*5+(2*goblinLv);

    ArrayList<String> nameList = new ArrayList<>() {
        {
            add("Glurb");
            add("Globbo");
            add("Globbette");
            add("Glumi");
            add("Glower");
            add("Glisch");
            add("Gluck");
            add("Glack");
            add("Glint");
            add("Glamo");
            add("Gloop");
            add("Gleen");
            add("Glast");
            add("Glescape");
            add("Glight");
            add("Glandom");
            add("Glinal");
            add("Glust");
            add("Gloog");
            add("Glafacafakacus");
            add("Glymp");
            add("Glimpy");
            add("Halbert");
        }
    };

    ArrayList<String> colorList = new ArrayList<>() {
        {
            add("Green");
            add("Red");
            add("Orange");
            add("Yellow");
            add("Brown");
            add("Purple");
            add("White");
            add("Blue");
            add("Black");
        }
    };
    Random i = new Random();
    Random k = new Random();

    String name = nameList.get(k.nextInt(nameList.size()));
    String color = colorList.get(i.nextInt(colorList.size()));

    public String getColor() {
        return color;
    }

    public int getGoblinHealth() {
        return health;
    }

    public int getGoblinLv() {
        return goblinLv;
    }

    public int getGoblinExp() {
        return goblinExp;
    }

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getGoblinName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }
}
