package pl.nazaweb.konkursiaki.game;

import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallBackwardCheck;
import java.awt.AWTException;
import java.io.IOException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.screen.GameImage;
import pl.nazaweb.konkursiaki.screen.GameImageReader;

/**
 *
 * @author naza
 */
public class HorizontallBackwardCheckNGTest extends AbstractTest {

    @Test
    public void shouldCorrectFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallBackwardCheck(gameArea, 5, 2).check());
    }

    @Test
    public void shouldCorrectFindBackward() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallBackwardCheck(gameArea, 2, 2).check());
    }

    @Test
    public void shouldDontThrowExceptionOnSecondElement() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest6GameImage());
        new HorizontallBackwardCheck(gameArea, 0, 1).check();
    }

    @Test
    public void shouldDontFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new HorizontallBackwardCheck(gameArea, 1, 1).check() == false);
    }

    @Test
    public void shouldDontFind2() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest9GameImage());
        assertTrue(new HorizontallBackwardCheck(gameArea, 3, 2).check() == false);
    }

    private GameImage getTest2GameImage() throws IOException, AWTException {
        return getTestGameImage("test2.png");
    }

    private GameImage getTest6GameImage() throws IOException, AWTException {
        return getTestGameImage("test6.png");
    }

    private GameImage getTest9GameImage() throws IOException, AWTException {
        return getTestGameImage("test9.png");
    }
}
