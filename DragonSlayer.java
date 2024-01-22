import java.util.Scanner;

public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Room currentRoom;
    private Player player;
    private Dragon dragon;
    private Sword sword;
    private int highScore;
    private boolean gameOver;

    public DragonSlayer() {
        player = null;
        gameOver = false;
        sword = new Sword();
    }
    public void play() {
        gameOver = false;
        welcomePlayer();
        showMenu();
    }

    private void welcomePlayer() {
        System.out.println("Welcome to Dragon Slayer!");
        System.out.print("What is your name before we embark on this quest?: ");
        String name = SCANNER.nextLine().toLowerCase();
        player = new Player(name);
        currentRoom = new Room(player);
    }

    public Player getPlayer(){
        return player;
    }

    private void enterRoom() {
        int roomNum = 1;
        currentRoom.playerArrives(roomNum);
        roomNum++;
    }

    private void showMenu() {
        String choice = "";
        enterRoom();
        while (!gameOver) {
            if(currentRoom.isRoomCleared()){
                enterRoom();
            }
            System.out.println();
            System.out.println(currentRoom.getInfo());
            System.out.println("***");
            player.playerGetInfo();
            sword.swordGetInfo();
            System.out.println("***");
            System.out.println(Colors.YELLOW + "(A)ttack the dragon.");
            System.out.println("(S)earch for health potions.");
            System.out.println("(U)se a health potion" + Colors.RESET);
            System.out.println("***");
            currentRoom.getDragonInfo();
            if(player.getHealth() <= 0){
                    System.out.println("You have been killed by the dragon.");
                    gameOver = true;
                    System.out.println("Current high score: " + highScore);
                System.out.println("Would you like to play again? y/n");
                String again = SCANNER.nextLine().toLowerCase();
                if(again.equals("y")){
                    play();
                }
                choice = "";
                break;
            } else {
                System.out.print("What's your next move? ");
                choice = SCANNER.nextLine().toLowerCase();
                processChoice(choice);
            }
        }
            System.out.println("You have slain all the dragons, you win!");
            if(player.getGold() > highScore){
                highScore = player.getGold();
                System.out.println("New gold high score!");
                System.out.println("Current high score: " + highScore);
            }
            System.out.println("Would you like to play again? y/n");
            String again = SCANNER.nextLine().toLowerCase();
            if(again.equals("y")){
                play();
            }
    }

    private void processChoice(String choice) {
        if (choice.equals("a")) {
            currentRoom.playerAttack();
        } else if (choice.equals("s")) {
           player.searchPot();
           if(player.hasPot()){
               System.out.println(Colors.YELLOW + "Would you like to use your health potion?: y/n" + Colors.RESET);
               String pot = SCANNER.nextLine().toLowerCase();
               if(pot.equals("y")){
                   player.usePot();
               }
           }
        } else if (choice.equals("u")) {
            player.usePot();
        } else {
            System.out.println("Yikes! That's an invalid option! Your turn has been wasted.");
        }
        if(currentRoom.getRoomsCleared() == 5){
            gameOver = true;
        }
        currentRoom.dragonAttack();
    }
}
