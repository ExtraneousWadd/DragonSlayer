public class Dragon {
    private int health;
    private int level;
    private boolean dead;
    private Player player;
    private Room room;
    private Sword sword;

    public Dragon(int level){
        health = 100;
        this.level = level;
        dead = false;
        sword = new Sword();
        player = null;
        room = null;
    }

    public int getHealth(){
        return health;
    }

    public int getLevel(){
        return level;
    }

    public boolean isDead(){
        return dead;
    }


    public void takeDamage(int dmg){
        if(health <= 0){
            System.out.println("The dragon is already dead.");
        }
        health -= dmg;
        if(health <= 0){
            System.out.println("The dragon has been slain!");
            health = 0;
            dead = true;
            room.deadIncrement();
            deadEvent();
        } else {
            System.out.println("The dragon takes " + dmg + " damage and now has " + health + " health.");
        }
    }

    public int attack(){
        int dmg = (int)(Math.random() * 10 + 1);
        boolean dodge = sword.dodgeCalc();
        if(dodge) {
            return 0;
        } else {
            return level * dmg * -1;
        }
    }

    public String state(){
        String str = "Dragon: " + "\n";
        str += "Health: " + health + "\n";
        str += "Level: " + level + "\n";
        return str;
    }

    private void deadEvent(){
        int num = (int)(Math.random() * 4 + 1);
        if(num == 1){
            System.out.println("You got nothing from the dead body.");
        } else if (num == 2){
            System.out.println("You found a better sword inside the dragon's body.");
            sword.setDmg(sword.getDmg() + 1);
            sword.setDmg(sword.getDodge() + 10);
        } else if(num == 3){
            int gold = (int)(Math.random() * 50 + 20) ;
            player.addGold(gold);
            System.out.println("You gained " + gold + " gold.");
        } else {
            int health = (int)(Math.random() * 50 + 20) ;
            player.addGold(health);
            System.out.println("You gained " + health + " HP.");
        }
    }
}

