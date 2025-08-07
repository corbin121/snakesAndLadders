package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import core.Player;

public class PlayerTest {
    private Player player;

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
        player = new Player("Test Player");
    }

    @After
    public void tearDown() throws Exception {
        player = null;
    }

    @Test
    public void testGetName() {
        assertEquals("Test Player", player.getName());
    }

    @Test
    public void testGetPosition() {
        assertEquals(1, player.getPosition());
    }

    @Test
    public void testSetPosition() {
        player.setPosition(10);
        assertEquals(10, player.getPosition());
    }

    @Test
    public void testMove() {
        player.move(5);
        assertEquals(6, player.getPosition());
        player.move(94);
        assertEquals(100, player.getPosition());
    }

    @Test
    public void testMoveOver100() {
        player.move(150);
        assertEquals(100, player.getPosition());
    }

    @Test
    public void testGetPositionFlase() {
        player.setPosition(50);
        assertNotEquals(1, player.getPosition());
    }

    @Test
    public void testGetNameFalse() {
        assertNotEquals("Player 1", player.getName());
    }

    @Test
    public void testSetPositionFalse() {
        player.setPosition(20);
        assertNotEquals(10, player.getPosition());
    }

    @Test
    public void testMoveFalse() {
        player.move(5);
        assertNotEquals(1, player.getPosition());
    }

}
