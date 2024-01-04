public class Sword {
    private int dmg;

    public Sword(){
        dmg = 8;
    }

    public void setDmg(int newDmg){
        dmg = newDmg;
    }

    public int getDmg(){
        return (int)((Math.random() * 3) + 1) + dmg;
    }
}
