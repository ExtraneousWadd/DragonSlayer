public class Sword {
    private int dmg;
    private int dodge;

    public Sword(){
        dmg = 1;
        dodge = 18;
    }

    public void setDmg(int newDmg){
        dmg = newDmg;
    }
    public void setDodge(int newDodge){
        dodge = newDodge;
    }

    public int getDmg(){
        return (int)((Math.random() * 10) + 1) * dmg;
    }

    public int getDodge(){
        return (int)((Math.random() * 3) + 1) + dmg;
    }
}
