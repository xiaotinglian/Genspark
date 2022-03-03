public class Goblin extends Humanoid{
    public int health;
    public int strength;


    public Goblin(int health, int strength,int x, int y) {
        super(x,y);
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
        return "\uD83D\uDC7A";
    }
}
