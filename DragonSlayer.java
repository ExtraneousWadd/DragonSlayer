import java.util.Scanner;

/**
 * This class is responsible for controlling the Treasure Hunter game.<p>
 * It handles the display of the menu and the processing of the player's choices.<p>
 * It handles all the display based on the messages it receives from the Town object. <p>
 *
 * This code has been adapted from Ivan Turner's original program -- thank you Mr. Turner!
 */

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

    /**
     * Creates a new town and adds the Hunter to it.
     */
    private void enterRoom() {

    }

    /**
     * Displays the menu and receives the choice from the user.<p>
     * The choice is sent to the processChoice() method for parsing.<p>
     * This method will loop until the user chooses to exit.
     */
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
            System.out.println("(L)ook for trouble!");
            System.out.println("Give up the hunt and e(X)it.");
            System.out.println();
            if(player.gameOver){
                choice = "x";
                    System.out.println("You have been killed by the dragon.");
                }
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
            if (player.hasPot()) {
                System.out.println("You already have a health potion.");
            } else {
                player.searchPot;
            }
        } else if (choice.equals("l")) {
            currentTown.lookForTrouble();
        } else if (choice.equals("h")){
            currentTown.treasureHunt();
        } else if (choice.equals("x")) {
            System.out.println("Fare thee well, " + hunter.getHunterName() + "!");
        }else if(choice.equals("d")){
            currentTown.diggingForGold();
        }else {
            System.out.println("Yikes! That's an invalid option! Try again.");
        }
    }



}
