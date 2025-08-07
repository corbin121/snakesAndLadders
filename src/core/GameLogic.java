package core;

import java.util.HashMap;

/**
 * GameLogic is a class that represents the game logic for the game.
 * It handles the game rules, player turns, and dice rolls.
 * @author Corbin Gilliam
 * @version 03/19/2025
 */
public class GameLogic {
    /**
     * Player 1 object.
     */
    private Player player1;
    /**
     * Player 2 object.
     */
    private Player player2;
    /**
     * Dice object.
     */
    private Dice dice;
    /**
     * Boolean to check if it is player 1's turn.
     */
    private boolean isPlayer1Turn;

    /**
     * Constructor for the GameLogic class.
     * Initializes the players and the dice.
     */
    public GameLogic() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.dice = new Dice();
        this.isPlayer1Turn = true;
    }

    /**
     * Rolls the dice and moves the current player forward by the number of spaces rolled.
     * If the player lands on a snake, they are moved back to the snake's tail.
     * If the player lands on a ladder, they are moved up to the ladder's top.
     * @param snakes HashMap of snakes
     * @param ladders HashMap of ladders
     */
    public void rollDice(HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders) {
        int roll = dice.rollDice();
        // Get the current player and move them forward by the number of spaces rolled
        // If isPlayer1Turn is true, move player1, otherwise move player2
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.move(roll);

        // Check for snakes
        if (snakes.containsKey(currentPlayer.getPosition())) {
            // If the player lands on a snake, move them back to the snake's tail
            currentPlayer.setPosition(snakes.get(currentPlayer.getPosition()));
            System.out.println(currentPlayer.getName() + " landed on a snake! Sliding down to " + currentPlayer.getPosition());
        }

        // Check for ladders
        if (ladders.containsKey(currentPlayer.getPosition())) {
            // If the player lands on a ladder, move them up to the ladder's top
            currentPlayer.setPosition(ladders.get(currentPlayer.getPosition()));
            System.out.println(currentPlayer.getName() + " landed on a ladder! Climbing up to " + currentPlayer.getPosition());
        }

        // Print the result of the roll
        System.out.println(currentPlayer.getName() + " rolled a " + roll + " and is now on square " + currentPlayer.getPosition());
    }

    /**
     * Checks if the game is over.
     * The game is over if either player has reached the end of the board.
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        // Check if either player has reached the end of the board
        return player1.getPosition() == 100 || player2.getPosition() == 100;
    }

    /**
     * Switches the turn to the other player.
     */
    public void switchTurn() {
        // Switch the turn to the other player
        isPlayer1Turn = !isPlayer1Turn;
    }

    /**
     * Gets the current player.
     * @return the current player
     */
    public Player getCurrentPlayer() {
        // Return the current player
        return isPlayer1Turn ? player1 : player2;
    }

    /**
     * Gets player 1.
     * @return player1 object
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Gets player 2.
     * @return player2 object
     */
    public Player getPlayer2() {
        return player2;
    }
}
