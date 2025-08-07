package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import core.Dice;

public class DiceTest {

    private Dice dice;

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
        dice = new Dice();
    }

    @After
    public void tearDown() throws Exception {
        dice = null;
    }

    @Test
    public void testRoll() {
        int result = dice.rollDice();
        assertTrue(result >= 1 && result <= 6);
    }

}
