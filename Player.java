public class Player {

    private String playerName;
    private int health;
    private int gold;
    private boolean hasPot;
    private Dragon dragon;
    private Sword sword;

    public Player(String name){
        playerName = name;
        health = 100;
        this.sword = new Sword();
        hasPot = false;
        gold = 0;
        dragon = null;
    }

    public void attack() {
        dragon.takeDamage(sword.getDmg());
    }

}
