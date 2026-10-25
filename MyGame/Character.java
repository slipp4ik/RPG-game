package MyGame;

public class Character 
{
  private String Name;
  private int HP;
  private int Level;

  public Character(String Name, int HP, int Level)
  {
    this.Name = Name;
    this.HP = HP;
    this.Level = Level;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public int getHP() {
    return HP;
  }

  public void setHP(int hP) {
    HP = hP;
  }

  public int getLevel() {
    return Level;
  }

  public void setLevel(int level) {
    Level = level;
  }

  public void takeDamage(int damage)
  {
    HP -= damage;
    if(HP < 0)
    {
        HP = 0;
    }
  }

  public boolean isAlive()
  {
    return HP > 0;
  }
  
}

