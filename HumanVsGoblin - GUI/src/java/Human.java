
public class Human {

    String name = "";
    String symbol = "\uD83E\uDDB8";
    int strength = 8;
    int intelligence = 8;
    int stamina = 8;
    int constitution = 8;
    int exp = 0;
    int lvl = 1;
    int health = constitution*5+(3*lvl);
    int armor = 0+(stamina/4);
    int shield = 0+(intelligence/4);
    int potions = 3;

    public int setHealth(int health) {
        this.health = health;
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getExp(){
        return exp;
    }

    public int getStamina(){
        return stamina;
    }

    public int getConstitution() {
        return constitution;
    }
    public int getIntelligence(){
        return intelligence;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public int getLvl() {
        return lvl;
    }

    public int getPotions() {
        return potions;
    }

    public int getShield() {
        return shield;
    }

    public String getName() {
        return name;
    }

    public void setArmor(int armor, int gearVal) {
        this.armor = armor + gearVal;
    }

    public int setConstitution(int constitution) {
        this.constitution = constitution;
        return constitution;
    }

    public int setExp(int expAdd) {
        this.exp = exp+expAdd;
        return exp;
    }

    public int setIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return intelligence;
    }

    public int setLvl(int lvl, int exp) {
        int expNeed = 0;
        if(lvl == 1) {
            expNeed = 2;
        } else if(lvl == 3) {
            expNeed = 5;
        } else if(lvl == 4) {
            expNeed = 10;
        } else if(lvl == 5) {
            expNeed = 15;
        } else if(lvl == 6) {
            expNeed = 23;
        } else if(lvl ==7) {
            expNeed = 35;
        } else if(lvl ==8) {
            expNeed = 50;
        } else {
            expNeed = getExp() + 50;
        }
        if (exp > expNeed){
            lvl++;
            setConstitution(getConstitution()+1);
            setIntelligence(getIntelligence()+1);
            setStamina(getStamina()+1);
            setStrength(getStrength()+1);
            setHealth(constitution*5+(3*lvl));
        } else {
            return lvl;
        }
        this.lvl = lvl;
        return lvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int setPotions(int potions) {
        this.potions = potions;
        return potions;
    }

    public int setShield(int shield) {
        this.shield = shield;
        return shield;
    }

    public int setStamina(int stamina) {
        this.stamina = stamina;
        return stamina;
    }

    public int setStrength(int strength) {
        this.strength = strength;
        return strength;
    }
}
