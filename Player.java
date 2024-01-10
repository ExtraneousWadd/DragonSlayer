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

    public void addGold(int newGold){
        gold += newGold;
    }

    public void addHealth(int newHealth){
        health += newHealth;
    }

    public void attack() {
        int dmg = sword.dmgCalc();
        dragon.takeDamage(dmg);
        System.out.println("You hit the dragon for " + dmg + " damage.");
    }

    public void searchPot(){
        if(pot){
            System.out.println("You already have a health potion.");
        } else {
            int chance = (int)(Math.random() * 3 + 1);
            if(chance == 1){
                pot = true;
                System.out.println("You found a health potion.");
            } else {
                System.out.println("You weren't able to find anything");
            }
        }
    }
}
