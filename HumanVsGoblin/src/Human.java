public class Human {
    public int health;
    public int strength;

    public Human(){
//        default constructor
    }

    public Human(int health, int strength) {
        this.health = health;
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public String toString(){
        return "\uD83D\uDC68";
    }
}
