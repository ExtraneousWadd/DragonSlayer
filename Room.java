public class Room {
    // instance variables
    private Player player;
    private int deadCount;
    private int dragonCount;
    private String room;
    private int roomsCleared;
    private Sword sword;
    public Dragon lair;
    public Dragon cave;
    public Dragon temple1;
    public Dragon temple2;
    public Dragon hatchery1;
    public Dragon hatchery2;
    public Dragon hatchery3;
    public Dragon vault1;
    public Dragon vault2;
    public Dragon vault3;



    public Room() {
        player = null;
        dragonCount = 0;
        room = "";
        deadCount = 0;
        sword = new Sword();
        lair = new Dragon(1);
        cave = new Dragon(2);
        temple1 = new Dragon(1);
        temple2 = new Dragon(2);
        hatchery1 = new Dragon(1);
        hatchery2 = new Dragon(2);
        hatchery3 = new Dragon(2);
        vault1 = new Dragon(2);
        vault2 = new Dragon(2);
        vault3 = new Dragon(3);
    }

    public int getRoomsCleared(){
        return roomsCleared;
    }

    public String getInfo() {
        String str = room;
        str += " dragons left: " + dragonCount;
        return str;
    }

    public String getRoom(){
        return room;
    }
    public void deadIncrement(){
        deadCount++;
    }

    public boolean isRoomCleared(){
        if(room.equals("lair") || room.equals("cave")){
            if(deadCount == 1){
                roomsCleared++;
                return true;
            } else {
                return false;
            }
        }
        if(room.equals("temple")){
            if(deadCount == 2){
                roomsCleared++;
                return true;
            } else {
                return false;
            }
        }
        if(room.equals("vault") || room.equals("hatchery")){
            if(deadCount == 3){
                roomsCleared++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void playerArrives(int num) {
        deadCount = 0;
        if(num == 1) {
            System.out.println(Colors.RED + "You have entered the lair." + Colors.RESET);
            room = "lair";
            dragonCount = 1;
        } else if (num == 2){
            System.out.println(Colors.RED + "You have entered the cave." + Colors.RESET);
            room = "cave";
            dragonCount = 1;
        } else if (num == 3){
            System.out.println(Colors.RED + "You have entered the temple." + Colors.RESET);
            room = "temple";
            dragonCount = 2;
        } else if (num == 4){
            System.out.println(Colors.RED + "You have entered the hatchery." + Colors.RESET);
            room = "hatchery";
            dragonCount = 3;
        } else if (num == 5){
            System.out.println(Colors.RED + "You have entered the vault." + Colors.RESET);
            room = "vault";
            dragonCount = 3;
        }
    }

    public void getDragonInfo() {
        if(room.equals("lair")) {
            System.out.println(lair.state());
        } else if (room.equals("cave")){
            cave.state();
        } else if (room.equals("temple")){
            if(!temple1.isDead()){
                System.out.println(temple1.state());
            } else {
                System.out.println(temple2.state());
            }
        } else if (room.equals("hatchery")){
            if(!hatchery1.isDead()){
                System.out.println(hatchery1.state());
            } else if (!hatchery2.isDead()) {
                System.out.println(hatchery2.state());
            } else {
                System.out.println(hatchery3.state());
            }
        } else if (room.equals("vault")){
            if(!vault1.isDead()){
                System.out.println(vault1.state());
            } else if (!vault2.isDead()) {
                System.out.println(vault2.state());
            } else {
                System.out.println(vault3.state());
            }
        }
    }
    public void attack() {
        int dmg = sword.dmgCalc();
        lair.takeDamage(dmg);
        System.out.println(player.getPlayerName() + " hit the dragon for " + dmg + " damage.");
    }
}
