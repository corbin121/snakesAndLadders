package core;

/**
 * Player is a class that represents a player in the game.
 * @author Corbin Gilliam
 * @version 03/19/2025
 */
public class Player {
    /**
     * The name of the player.
     */
    private String name;
    /**
     * The position of the player on the board.
     */
    private int position;

    /**
     * Constructor for the Player class.
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.position = 1;
    }

    /**
     * Gets the name of the player.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the position of the player.
     * @return the position of the player
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of the player.
     * @param position the position of the player
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Moves the player forward by the number of spaces rolled.
     * @param spaces the number of spaces rolled
     */
    public void move(int spaces) {
        // Move the player forward by the number of spaces rolled
        this.position += spaces;
        if (this.position > 100) {
            // If the player goes over 100, set their position to 100
            this.position = 100;
        }
    }
}
