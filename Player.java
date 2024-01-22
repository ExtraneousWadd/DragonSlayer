public class Player {

    private String playerName;
    private int health;
    private int gold;
    private boolean pot;
    private Sword sword;

    public Player(String name){
        playerName = name;
        health = 100;
        this.sword = new Sword();
        pot = false;
        gold = 0;
    }


    public String getPlayerName(){
        return playerName;
    }
    public boolean hasPot(){
        return pot;
    }

    public int getHealth(){
        return health;
    }
    public int getGold(){
        return gold;
    }

    public void addGold(int newGold){
        gold += newGold;
    }

    public void addHealth(int newHealth){
        health += newHealth;
    }

    public void searchPot(){
        if(pot){
            System.out.println(Colors.YELLOW + playerName + "already have a health potion." + Colors.RESET);
        } else {
            int chance = (int)(Math.random() * 3 + 1);
            if(chance == 1){
                pot = true;
                System.out.println(Colors.YELLOW + playerName + " found a health potion." + Colors.RESET);
            } else {
                System.out.println(Colors.YELLOW + playerName + " wasn't able to find anything" + Colors.RESET);
            }
        }
    }

    public void usePot(){
        if(pot){
            health = 100;
            System.out.println("You have used your health potion and now have max health.");
        }
        pot = false;
    }

    public void playerGetInfo(){
        System.out.println(Colors.GREEN + "HP: " + health + " / 100");
        System.out.println("Has health potion: " + pot + Colors.RESET);
    }
}
