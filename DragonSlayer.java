import java.util.Scanner;

public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Room currentRoom;
    private Player player;
    private boolean gameOver;

    public DragonSlayer() {
        currentRoom = new Room();
        player = null;
        gameOver = false;
    }
    public void play() {
        welcomePlayer();
        enterRoom();
        showMenu();
    }

    private void welcomePlayer() {
        System.out.println("Welcome to Dragon Slayer!");
        System.out.print("What is your name before we embark on this quest?: ");
        String name = SCANNER.nextLine().toLowerCase();
        player = new Player(name);
    }

    private void enterRoom() {
        int roomNum = 1;
        currentRoom.playerArrives(roomNum);
    }

    private void showMenu() {
        String choice = "";
        while (!gameOver) {
            System.out.println();
            System.out.println(currentRoom.getInfo());
            System.out.println("***");
            player.playerGetInfo();
            System.out.println("(A)ttack the dragon.");
            System.out.println("(S)earch for health potions.");
            System.out.println("***");

            if(player.hasPot()){
                System.out.println("(U)se a health potion");
            }
            System.out.println();
            if(player.getHealth() == 0){
                    System.out.println("You have been killed by the dragon.");
                    gameOver = true;
            } else {
                System.out.print("What's your next move? ");
                choice = SCANNER.nextLine().toLowerCase();
                processChoice(choice);
            }
        }
        System.out.println("You have slain all the dragons.");
    }

    private void processChoice(String choice) {
        if (choice.equals("a")) {
            player.attack();
        } else if (choice.equals("s")) {
           player.searchPot();
        } else if (choice.equals("l")) {
        } else {
            System.out.println("Yikes! That's an invalid option! Try again.");
        }
        if(currentRoom.getRoomsCleared() == 5){
            gameOver = true;
        }
    }
}
