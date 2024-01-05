public class Player {

    private String playerName;
    private int health;
    private int gold;
    private boolean pot;
    private Dragon dragon;
    private Sword sword;
    private Room currentRoom;


    public Player(String name){
        playerName = name;
        health = 100;
        this.sword = new Sword();
        pot = false;
        gold = 0;
        dragon = null;
        currentRoom = null;
    }

    public boolean hasPot(){
        return pot;
    }

    public void attack() {
        int dmg = sword.getDmg();
        dragon.takeDamage(dmg);
        System.out.println("You hit the dragon for " + dmg + " damage.");
    }

    public void searchPot(){
        if(Room.getRoom)
    }

}
