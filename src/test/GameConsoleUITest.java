package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import ui.GameConsoleUI;

public class GameConsoleUITest {
    private GameConsoleUI gameConsoleUI;

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
        gameConsoleUI = new GameConsoleUI();
    }

    @After
    public void tearDown() throws Exception {
        gameConsoleUI = null;
    }

    @Test
    public void testDisplayBoard() {
        gameConsoleUI.displayBoard();
    }

    @Test
public void testAddSnakesAndLadders() {
    gameConsoleUI.addSnakesAndLadders();
    assertNotNull(gameConsoleUI.snakes);
    assertNotNull(gameConsoleUI.ladders);
    assertEquals(8, gameConsoleUI.snakes.size());
    assertEquals(8, gameConsoleUI.ladders.size());
}

@Test
public void testIsSnakeOrLadderTrue() {
    assertTrue(gameConsoleUI.isSnakeOrLadder(16)); // snake head
    assertTrue(gameConsoleUI.isSnakeOrLadder(6));  // snake tail
    assertTrue(gameConsoleUI.isSnakeOrLadder(2));  // ladder bottom
    assertTrue(gameConsoleUI.isSnakeOrLadder(38)); // ladder top
}

@Test
public void testIsSnakeOrLadderFalse() {
    assertFalse(gameConsoleUI.isSnakeOrLadder(1));
    assertFalse(gameConsoleUI.isSnakeOrLadder(100));
    assertFalse(gameConsoleUI.isSnakeOrLadder(50)); // not in any list
}
}
