package pl.nazaweb.konkursiaki.game;

import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallForwardCheck;
import java.awt.AWTException;
import java.io.IOException;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.screen.GameImage;
import pl.nazaweb.konkursiaki.screen.GameImageReader;

/**
 *
 * @author naza
 */
public class HorizontallForwardCheckNGTest extends AbstractTest {

    @Test
    public void shouldCorrectFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new HorizontallForwardCheck(gameArea, 1, 1).check());
    }

    @Test
    public void shouldCorrectFindForward() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallForwardCheck(gameArea, 4, 1).check());
    }
    
        @Test
    public void shouldCorrectFindForward2() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallForwardCheck(gameArea, 2, 3).check());
    }

    @Test
    public void shouldDontFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new HorizontallForwardCheck(gameArea, 5, 2).check() == false);
    }

    private GameImage getTest2GameImage() throws IOException, AWTException {
        return getTestGameImage("test2.png");
    }

}
