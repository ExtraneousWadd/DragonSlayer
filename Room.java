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



    public Room(Player player) {
        this.player = player;
        dragonCount = 0;
        room = "";
        deadCount = 0;
        roomsCleared = 1;
        sword = new Sword();
        lair = new Dragon(1,this);
        cave = new Dragon(2,this);
        temple1 = new Dragon(1,this);
        temple2 = new Dragon(2,this);
        hatchery1 = new Dragon(1,this);
        hatchery2 = new Dragon(2,this);
        hatchery3 = new Dragon(2,this);
        vault1 = new Dragon(2,this);
        vault2 = new Dragon(2,this);
        vault3 = new Dragon(3,this);
    }

    public int getRoomsCleared(){
        return roomsCleared;
    }

    public String getInfo() {
        String str = Colors.RED + room;
        str += " dragons left: " + dragonCount + Colors.RESET;
        return str;
    }

    public String getRoom(){
        return room;
    }
    public void deadIncrement(){
        deadCount++;
    }

    private Dragon currentDragon(){
        if(room.equals("cave")){
            return cave;
        }
        if(room.equals("temple")){
            if(deadCount == 2){
                return temple1;
            } else {
                return temple2;
            }
        }
        if(room.equals("vault")){
            if(deadCount == 3){
                return vault1;
            } else if (deadCount == 2){
                return vault2;
            } else {
                return vault3;
            }
        }
        if(room.equals("hatchery")){
            if(deadCount == 3){
                return hatchery1;
            } else if (deadCount == 2){
                return hatchery2;
            } else {
                return hatchery3;
            }
        }
       return lair;
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
            System.out.println(cave.state());
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

    public void playerAttack() {
        int dmg = sword.dmgCalc();
        currentDragon().takeDamage(dmg);
        System.out.println(Colors.BLUE + "You hit the dragon for " + dmg + " damage." + Colors.RESET);
    }

    public void dragonAttack() {
        int dmg = currentDragon().attack();
        player.addHealth(dmg);
        if (dmg == 0) {
            System.out.println(Colors.BLUE + "You dodged the dragon's attack!" + Colors.RESET);
        } else {
            System.out.println(Colors.BLUE + "The dragon hit you for " + dmg * -1 + " damage." + Colors.RESET);
        }
    }

    public void deadEvent(){
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
        if(isRoomCleared()){
            playerArrives(roomsCleared);
        }
    }
}
