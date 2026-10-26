package MyGame;

import java.util.Scanner;

import java.util.Random;

public class PlayGame {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String ORANGE = "\u001B[38;5;166m";
    public static void Menu() {
        System.out.println(
                "\n" + "Welcome to my RPG game!\n" + "Select:\n" + "1. Start game\n" + "2. Settings\n" + "3. Quit\n");
    }

    public static void StGame() throws InterruptedException {

        System.out.println("Game starting");
        for (int i = 0; i < 15; i++) {
            Thread.sleep(55);
            System.out.print(GREEN + "." + RESET);
            Thread.sleep(55);
            System.out.print(RED + "." + RESET);
            Thread.sleep(55);
            System.out.print(GREEN + "." + RESET);

        }
        System.out.println("\n");
        System.out.print(GREEN + "Game started successfully!" + RESET);
    }

    public static void SettingGame() throws InterruptedException {
        System.out.println("Opening settings");
        for (int i = 0; i < 15; i++) {
            Thread.sleep(55);
            System.out.print(GREEN + "." + RESET);
            Thread.sleep(55);
            System.out.print(RED + "." + RESET);
            Thread.sleep(55);
            System.out.print(GREEN + "." + RESET);
        }
        System.out.println("Nothing to change here :), going back to main menu");
        Menu();
    }

    public static void ExitGame() {
        System.out.println("see you next time <:)");
    }

    public static void OptMenu(int option) throws InterruptedException {
        switch (option) {
            case 1:
                StGame();
                break;
            case 2:
                SettingGame();
                break;
            case 3:
                ExitGame();
                break;
        }
    }

    public static void fight(Hero hero, Goblin goblin) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        do
        {
        System.out.println("\n");
        System.out.println("Enter how many attacks you want to make: "+"\n");
        int NumAttack = sc.nextInt();
        int hits = 0;
        for (int i = 0; i <= NumAttack-1; i++) 
        {
            int chance = random.nextInt(10);
            System.out.println("\n"+"Attacking.."+"\n");
            if (chance <= 6) 
               {
                goblin.takeDamage(hero.getDamage());
                hero.setHits(hero.getHits() + 1);
                Thread.sleep(500);
                System.out.println(GREEN+"Hero " + hero.getName()+RESET + " hits goblin " + goblin.getName() + " for "
                        +RED+ hero.getDamage()+RESET + " and the HP after attack is " +ORANGE+ goblin.getHP()+RESET);
                if (!goblin.isAlive()) 
                {
                    System.out.println("\n"+GREEN+"Hero "+hero.getName()+" won"+RESET);
                    break;
                }
            } 
            else if (chance > 6) 
            {
                hero.takeDamage(goblin.getDamage());
                Thread.sleep(500);
                System.out.println(RED+"Goblin " + goblin.getName()+RED + " hits hero " + hero.getName() + " for "
                        +RED+ goblin.getDamage() +RESET+ " and the HP after attack is " +ORANGE+ hero.getHP()+RESET);
                if (!hero.isAlive()) 
                {
                    System.out.println(RED+"Hero "+hero.getName()+" lost, retry fight"+RESET);
                    break;
                }
            }
        }
        }while(hero.isAlive() && goblin.isAlive());

    }
    public static void XpGain(Hero hero, Goblin goblin)
    {
        int hits = hero.getHits();
        int gain = 0;
        if(hits <= 5)
            {
                gain=hero.getExperience()+50;
                hero.setExperience(gain);
            }
        else if (hits >5) 
            {
                gain = hero.getExperience()+25;
                hero.setExperience(gain);
            }
        
    }
    

    public static void main(String[] args) throws InterruptedException {
        Hero hero = new Hero("Albin", 100, 1, 0, 100, 10);
        Goblin goblin = new Goblin("Heb", 80, 1, 8);
        Scanner sc = new Scanner(System.in);

        Menu();
        int option = sc.nextInt();
        OptMenu(option);
        fight(hero, goblin);
        XpGain(hero,goblin);
        System.out.println(hero.getHits());
        hero.ShowStats();
        
        
    }
}
