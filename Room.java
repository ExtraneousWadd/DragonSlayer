public class Room {
    // instance variables
    private Player player;
    private String printMessage;
    private Dragon dragon;
    private String room;

    public Room(Dragon dragon, double toughness) {
        this.dragon = dragon;
        player = null;
        printMessage = "";
        room = "";
    }

    public String getInfo() {
        return printMessage;
    }

    public String getRoom(){
        return room;
    }

    public void playerArrives(Player player, int num) {
        this.player = player;
        if(num == 1) {
            printMessage = Colors.RED + "You have entered the lair." + Colors.RESET;
            room = "lair";
        }
    }



}
