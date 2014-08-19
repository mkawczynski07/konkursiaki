package pl.nazaweb.konkursiaki.game.checkers;

import pl.nazaweb.konkursiaki.game.checkers.simulator.GameImageCheckCounter;
import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.screen.GameImage;
import pl.nazaweb.konkursiaki.screen.GameImageReader;

/**
 *
 * @author naza
 */
public class GameImageCheckCounterNGTest extends AbstractTest {

    @Test
    public void shouldCountAllImageChecks() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest5GameImage());
        gameArea[0][2] = new GamePuzzle(new Point(1, 1), 0, 0, 2);
        gameArea[2][4] = new GamePuzzle(new Point(1, 1), 2, 0, 2);
        gameArea[4][3] = new GamePuzzle(new Point(1, 1), 4, 0, 2);
        GameImageCheckCounter instance = new GameImageCheckCounter(gameArea);
        assertEquals(instance.count(), 3);
    }

    private GameImage getTest5GameImage() throws IOException, AWTException {
        return getTestGameImage("test5.png");
    }

}
