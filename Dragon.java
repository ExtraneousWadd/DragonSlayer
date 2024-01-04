public class Dragon {
    private int health;
    private int strength;
    private int level;
    private int attackDmg;
    private boolean dead;




    public Dragon(int health){
        this.health = health;
        level = 1;
        strength = 1;
        dead = false;
        attackDmg = 0;
    }


    public int getHealth(){
        return health;
    }




    public int getStrength(){
        return strength;
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
        } else {
            System.out.println("The dragon takes " + dmg + " damage and now has " + health + " health.");
        }
    }




    public int attack(){
        int dmg = level * strength;
        attackDmg += dmg;
        if (attackDmg > 50){
            attackDmg = 0;
            level++;
            System.out.println("The dragon has leveled up to level " + level + "!");
        }
        System.out.println("The dragon attacks for " + dmg + " hit points.");
        return dmg;
    }




    public void powerUp(int choice){
        if(choice == 1){
            health *= 2;
            System.out.println("The dragon has powered up to " + health + " health.");
        }
        if(choice == 2){
            strength *= 2;
            System.out.println("The dragon has powered up to " + strength + " strength.");
        }
    }




    public String state(){
        String str = "Dragon: " + "\n";
        str += "Strength: " + strength + "\n";
        str += "Health: " + health + "\n";
        str += "Level: " + level + "\n";
        str += "Dead: " + dead + "\n";
        str += "Attack Damage: " + attackDmg;
        return str;
    }
}

