package MyGame;

public class Goblin extends Character
{
private int damage;
    public Goblin(String Name, int HP, int Level, int damage)
    {
        super(Name, HP, Level);
        this.damage = damage;

    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}
