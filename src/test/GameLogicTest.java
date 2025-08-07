package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import java.util.HashMap;

import core.GameLogic;

public class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // This method is executed once before all test methods in the class
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // This method is executed once after all test methods in the class
    }

    @Before
    public void setUp() throws Exception {
        gameLogic = new GameLogic();
    }

    @After
    public void tearDown() throws Exception {
        gameLogic = null;
    }

    @Test
    public void testGameLogic() {
        assertNotNull(gameLogic);
    }

    @Test
    public void testGetCurrentPlayer() {
        assertEquals("Player 1", gameLogic.getCurrentPlayer().getName());
    }

    @Test
    public void testSwitchPlayer() {
        gameLogic.switchTurn();
        assertEquals("Player 2", gameLogic.getCurrentPlayer().getName());
        gameLogic.switchTurn();
        assertEquals("Player 1", gameLogic.getCurrentPlayer().getName());
    }

    @Test
    public void testRollDice() {
        // Create a HashMap of snakes and ladders
        HashMap<Integer, Integer> snakes = new HashMap<>();
        HashMap<Integer, Integer> ladders = new HashMap<>();
        snakes.put(16, 6);
        ladders.put(2, 38);

        // Roll the dice and move the current player
        gameLogic.rollDice(snakes, ladders);

        // Check if the current player's position is updated correctly
        int position = gameLogic.getCurrentPlayer().getPosition();
        assertTrue(position >= 1 && position <= 100);
    }

    @Test
    public void testIsGameOver() {
        // Set the position of player 1 to 100
        gameLogic.getCurrentPlayer().setPosition(100);
        assertTrue(gameLogic.isGameOver());

        // Set the position of player 2 to 50
        gameLogic.getCurrentPlayer().setPosition(50);
        assertFalse(gameLogic.isGameOver());
    }

    @Test
    public void testGetPlayer1() {
        assertEquals("Player 1", gameLogic.getPlayer1().getName());
    }

    @Test
    public void testGetPlayer2() {
        assertEquals("Player 2", gameLogic.getPlayer2().getName());
    }
}
