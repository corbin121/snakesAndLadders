package core;
import java.util.Random;

/**
 * Dice is a class that represents a dice in the game.
 * It handles the rolling of the dice and returns a random number between 1 and 6.
 * @author Corbin Gilliam
 * @version 03/19/2025
 */
public class Dice {
    /**
     * Rolls the dice and returns a random number between 1 and 6.
     * @return a random number between 1 and 6
     */
    public int rollDice() {
        // Create new random object
        Random roll = new Random();
        // Return a random number between 1 and 6
        return roll.nextInt(6) + 1;
    }
}
