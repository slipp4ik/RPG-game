package MyGame;

public class Hero extends Character
{
    private int experience;
    private int mana;
    private int damage;

    public Hero(String Name, int HP, int Level, int experience, int mana, int damage)
    {
        super(Name, HP, Level);
        this.experience = experience;
        this.mana = mana;
        this.damage = damage;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    
    
}
