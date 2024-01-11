public class Room {
    // instance variables
    private Player player;
    private int deadCount;
    private int dragonCount;
    private Dragon dragon;
    private String room;
    private int roomsCleared;

    public Room() {
        this.dragon = dragon;
        player = null;
        dragonCount = 0;
        room = "";
        deadCount = 0;
    }

    public int getRoomsCleared(){
        return roomsCleared;
    }

    public String getInfo() {
        String str = room;
        str += " dragons Left: " + dragonCount;
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
            Dragon lair = new Dragon(1);
            dragonCount = 1;
        } else if (num == 2){
            System.out.println(Colors.RED + "You have entered the cave." + Colors.RESET);
            room = "cave";
            Dragon cave = new Dragon(2);
            dragonCount = 1;
        } else if (num == 3){
            System.out.println(Colors.RED + "You have entered the temple." + Colors.RESET);
            room = "temple";
            Dragon temple1 = new Dragon(1);
            Dragon temple2 = new Dragon(2);
            dragonCount = 2;
        } else if (num == 4){
            System.out.println(Colors.RED + "You have entered the hatchery." + Colors.RESET);
            room = "hatchery";
            Dragon hatchery1 = new Dragon(1);
            Dragon hatchery2 = new Dragon(2);
            Dragon hatchery3 = new Dragon(2);
            dragonCount = 3;
        } else if (num == 5){
            System.out.println(Colors.RED + "You have entered the vault." + Colors.RESET);
            room = "vault";
            Dragon vault1 = new Dragon(2);
            Dragon vault2 = new Dragon(2);
            Dragon vault3 = new Dragon(3);
            dragonCount = 3;
        }
    }
}
