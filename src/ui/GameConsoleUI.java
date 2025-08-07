package ui;

import core.GameLogic;
import core.Player;
import java.util.HashMap;
import java.util.Scanner;

/**
 * GameConsoleUI is a class that represents the user interface for the game.
 * It handles the display of the game board, player positions, and user input.
 * @author Corbin Gilliam
 * @version 03/19/2025
 */
public class GameConsoleUI {    
    /**
     * GameLogic object.
     */
    private final GameLogic gameLogic;
    /**
     * Scanner object for user input.
     */
    private final Scanner scanner;

    /**
     * HashMap of snakes
     */
    public HashMap<Integer, Integer> snakes;
    /**
     * HashMap of ladders
     */
    public HashMap<Integer, Integer> ladders;
    /**
     * Array of snakeKeys
     */
    public int[] snakeKeys = {16, 47, 49, 56, 64, 87, 95, 98};
    /**
     * Array of snakeValues
     */
    public int[] snakeValues = {6, 26, 11, 53, 60, 24, 75, 78};
    /**
     * Array of ladderKeys
     */
    public int[] ladderKeys = {2, 14, 19, 21, 28, 36, 51, 71};
    /**
     * Array of ladderValues
     */
    public int[] ladderValues = {38, 25, 31, 42, 84, 44, 67, 91};

    /**
     * Snake head count
     */
    public int snakeHeadCount = snakeKeys.length;
    /**
     * Snake tail count
     */
    public int snakeTailCount = snakeValues.length;
    /**
     * Ladder bottom count
     */
    public int ladderBottomCount = ladderKeys.length;
    /**
     * Ladder top count
     */
    public int ladderTopCount = ladderValues.length;
    
    /**
     * Main method to start the game.
     * @author Corbin Gilliam
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new game
        GameConsoleUI gameConsoleUI = new GameConsoleUI();
        // Start the game
        gameConsoleUI.startGame();
    }

    /**
     * Constructor for the GameConsoleUI class.
     * Initializes the game logic and scanner.
     * Adds snakes and ladders to the game.
     */
    public GameConsoleUI() {
        this.gameLogic = new GameLogic();
        this.scanner = new Scanner(System.in);
        addSnakesAndLadders();
    }

    /**
     * Adds snakes and ladders to the game.
     * Creates a HashMap for snakes and ladders using the predefined keys and values.
     */
    public void addSnakesAndLadders() {
        // Add snakes
        snakes = new HashMap<>();
        for (int i = 0; i < snakeKeys.length; i++) {
            snakes.put(snakeKeys[i], snakeValues[i]);
        }
        
        // Add ladders
        ladders = new HashMap<>();
        for (int i = 0; i < ladderKeys.length; i++) {
            ladders.put(ladderKeys[i], ladderValues[i]);
        }
    }
    
    /**
     * Displays the game board.
     * Prints the current state of the board, including player positions, snakes, and ladders.
     */
    public void displayBoard() {
        // Reset the snake and ladder counts
        snakeHeadCount = 8;
        snakeTailCount = 8;
        ladderBottomCount = 8;
        ladderTopCount = 8;

        // Print the board
        System.out.println("\nCurrent Board:");
        for (int row = 10; row >= 1; row--) { // Start from row 10 (100-91)
            // Equation for the left column
            int start = (row - 1) * 10 + 1;
            // Equation for the right column
            int end = row * 10;

            if (row % 2 == 1) { // Start Odd rows (left to right)
                for (int i = start; i <= end; i++) {
                    printCell(i);
                }
            } else { // Start Even rows (right to left)
                for (int i = end; i >= start; i--) {
                    printCell(i);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the cell at the given position.
     * If a player is on the position, prints "P1" or "P2".
     * If both players are on the position, prints "P1P2".
     * If the position is a snake head or tail, prints "S" or "T".
     * If the position is a ladder bottom or top, prints "L" or "H".
     * Otherwise, prints the position number with padding.
     * @param position the position to print
     */
    public void printCell(int position) {
        Player p1 = gameLogic.getPlayer1();
        Player p2 = gameLogic.getPlayer2();

        // If both players are on the same position, print "P1P2"
        if (p1.getPosition() == position && p2.getPosition() == position) {
            System.out.print("|P1P2|");
            // If only one player is on the position, print "P1" or "P2"
        } else if (p1.getPosition() == position) {
            System.out.print("| P1 |");
        } else if (p2.getPosition() == position) {
            System.out.print("| P2 |");
        } else if (isSnakeOrLadder(position)) {
            // If the position is a snake head or tail, print "S"
            for (int i = 0; i < snakeKeys.length; i++) {
                if (snakeKeys[i] == position) {
                    System.out.print("| S" + snakeHeadCount-- + " |");
                } else if (snakeValues[i] == position) {
                    System.out.print("| T" + snakeTailCount-- + " |");
                }
            }
            // If the position is a ladder bottom or top, print "L"
            for (int i = 0; i < ladderKeys.length; i++) {
                if (ladderKeys[i] == position) {
                    System.out.print("| L" + ladderBottomCount-- + " |");
                } else if (ladderValues[i] == position) {
                    System.out.print("| H" + ladderTopCount-- + " |");
                }
            }
        } else {
            // If no player is on the position, print the position number with padding
            System.out.printf("|%3d |", position);
        }
    }

    /**
     * Checks if the given position is a snake or ladder.
     * @param position the position to check
     * @return true if the position is a snake or ladder, false otherwise
     */
    public boolean isSnakeOrLadder(int position) {
        for (int i = 0; i < snakeKeys.length; i++) {
            if (snakeKeys[i] == position || snakeValues[i] == position) {
                return true;
            }
        }
        for (int i = 0; i < ladderKeys.length; i++) {
            if (ladderKeys[i] == position || ladderValues[i] == position) {
                return true;
            }
        }
        return false;
    }

    /**
     * Starts the game.
     * Displays the game board and prompts the players to roll the dice.
     * Checks if the game is over and switches turns if not.
     */
    public void startGame() {
        System.out.println("Begin Game.");
        // Loop until the game is over
        while (!gameLogic.isGameOver()) {
            displayBoard();
            // Get the current player
            Player currentPlayer = gameLogic.getCurrentPlayer();
            // Prompt the player to roll the dice
            System.out.println(currentPlayer.getName() + "— your turn. Press the <<Enter>> key to Roll the dice.");
            // Wait for the player to press enter
            scanner.nextLine();
            // Roll the dice
            gameLogic.rollDice(snakes, ladders);
            // Check if the game is over
            if (gameLogic.isGameOver()) {
                System.out.println(currentPlayer.getName() + " wins!");
            } else {
                // Switch turns
                gameLogic.switchTurn();
            }
        }
    }

}
