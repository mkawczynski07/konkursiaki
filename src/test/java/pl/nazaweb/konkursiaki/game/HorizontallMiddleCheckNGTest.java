package pl.nazaweb.konkursiaki.game;

import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallMiddleCheck;
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
public class HorizontallMiddleCheckNGTest extends AbstractTest {

    @Test
    public void shouldFindMiddle() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallMiddleCheck(gameArea, 0, 4).check());
    }

    @Test
    public void shouldDontFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest5GameImage());
        assertTrue(new HorizontallMiddleCheck(gameArea, 2, 2).check() == false);
    }

    @Test
    public void shouldDontFindBackward() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new HorizontallMiddleCheck(gameArea, 1, 1).check() == false);
    }

    @Test
    public void shouldDontFindForward() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallMiddleCheck(gameArea, 5, 2).check() == false);
    }

    private GameImage getTest2GameImage() throws IOException, AWTException {
        return getTestGameImage("test2.png");
    }

    private GameImage getTest5GameImage() throws IOException, AWTException {
        return getTestGameImage("test5.png");
    }

}
