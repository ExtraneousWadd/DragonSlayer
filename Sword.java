import java.sql.SQLOutput;

public class Sword {
    private int dmg;
    private int dodge;

    public Sword(){
        dmg = 1;
        dodge = 20;
    }

    public void setDmg(int newDmg){
        dmg = newDmg;
    }
    public void setDodge(int newDodge){
        dodge = newDodge;
    }

    public int getDmg(){
        return dmg;
    }

    public int getDodge(){
        return dodge;
    }

    public int dmgCalc(){
        return (int)((Math.random() * 30) + 1) * dmg;
    }

    public boolean dodgeCalc(){
        int chance = 100 / dodge;
        int dodgeChance = (int)(Math.random() * chance) + 1;
        if(dodgeChance == 1){
            return true;
        } else {
            return false;
        }
    }

    public void swordGetInfo(){
        System.out.println(Colors.BLUE + "Sword damage multipler: " + dmg);
        System.out.println("Sword dodge chance: " + dodge + Colors.RESET);
    }

}
