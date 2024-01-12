public class Player {

    private String playerName;
    private int health;
    private int gold;
    private boolean pot;
    private Dragon dragon;
    private Sword sword;

    public Player(String name){
        playerName = name;
        health = 100;
        this.sword = new Sword();
        pot = false;
        gold = 0;
        dragon = null;
    }

    public boolean hasPot(){
        return pot;
    }

    public int getHealth(){
        return health;
    }

    public void addGold(int newGold){
        gold += newGold;
    }

    public void addHealth(int newHealth){
        health += newHealth;
    }

    public void searchPot(){
        if(pot){
            System.out.println(playerName + "already have a health potion.");
        } else {
            int chance = (int)(Math.random() * 3 + 1);
            if(chance == 1){
                pot = true;
                System.out.println(playerName + " found a health potion.");
            } else {
                System.out.println(playerName + " weren't able to find anything");
            }
        }
    }

    public void playerGetInfo(){
        System.out.println("HP: " + health + "/100");
        System.out.println("Has health potion: " + pot);
    }
}
