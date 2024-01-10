import java.util.Scanner;

public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Room currentRoom;
    private Player player;
    private boolean gameOver;

    public DragonSlayer() {
        currentRoom = null;
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

    }

    private void showMenu() {
        String choice = "";

        while (!choice.equals("x")) {
            System.out.println();
            System.out.println(currentRoom.getInfo());
            System.out.println("***");
            System.out.println(player);
            System.out.println(currentRoom);
            System.out.println("(A)ttack the dragon.");
            System.out.println("(S)earch for health potions.");
            System.out.println("(M)ove on to a different town.");
            System.out.println();
            if(player.gameOver){
                choice = "x";
                    System.out.println("You have been killed by the dragon.");
            } else {
                System.out.print("What's your next move? ");
                choice = SCANNER.nextLine().toLowerCase();
                processChoice(choice);
            }
        }
    }

    /**
     * Takes the choice received from the menu and calls the appropriate method to carry out the instructions.
     * @param choice The action to process.
     */
    private void processChoice(String choice) {
        if (choice.equals("a")) {
            player.attack();
        } else if (choice.equals("s")) {
           player.searchPot();
        } else if (choice.equals("l")) {
            currentRoom.lookForTrouble();
        }else {
            System.out.println("Yikes! That's an invalid option! Try again.");
        }
    }
}
