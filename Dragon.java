public class Dragon {
    private int health;
    private int level;
    private boolean dead;
    private Player player;
    private Room room;
    private Sword sword;

    public Dragon(int level, Room room){
        health = 100;
        this.level = level;
        dead = false;
        sword = new Sword();
        player = null;
        this.room = room;
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
            room.deadEvent();
        } else {
            System.out.println("The dragon takes " + dmg + " damage and now has " + health + " health.");
        }
    }

    public int attack(){
        int dmg = (int)(Math.random() * 20 + 1);
        boolean dodge = sword.dodgeCalc();
        if(dodge) {
            return 0;
        } else {
            return level * dmg * -1;
        }
    }

    public String state(){
        String str = Colors.RED + "Dragon: " + "\n";
        str += "Health: " + health + "\n";
        str += "Level: " + level + "\n" + Colors.RESET;
        return str;
    }

}

