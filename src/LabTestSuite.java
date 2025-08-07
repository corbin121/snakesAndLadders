import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.DiceTest;
import test.GameConsoleUITest;
import test.GameLogicTest;
import test.PlayerTest;

@RunWith(Suite.class)
@SuiteClasses({DiceTest.class, GameConsoleUITest.class, GameLogicTest.class, PlayerTest.class})

public class LabTestSuite {
    // This class remains empty. It is used only as a holder for the above annotations.
}