package pl.nazaweb.konkursiaki.game.checkers.horizontal;

import java.awt.AWTException;
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
public class HorizontalFourCheckNGTest extends AbstractTest {

    @Test
    public void shouldFindFourIn2Row() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest10GameImage());
        assertTrue(new HorizontalFourCheck(gameArea, 2, 1).check());
    }

    @Test
    public void shouldFindFourIn1Row() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest11GameImage());
        assertTrue(new HorizontalFourCheck(gameArea, 1, 0).check());
    }

    private GameImage getTest10GameImage() throws IOException, AWTException {
        return getTestGameImage("test10.png");
    }

    private GameImage getTest11GameImage() throws IOException, AWTException {
        return getTestGameImage("test11.png");
    }

}
