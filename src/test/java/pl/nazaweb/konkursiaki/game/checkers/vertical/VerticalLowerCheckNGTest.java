package pl.nazaweb.konkursiaki.game.checkers.vertical;

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
public class VerticalLowerCheckNGTest extends AbstractTest {

    @Test
    public void shouldFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest3GameImage());
        assertTrue(new VerticalLowerCheck(gameArea, 4, 0).check() == false);
    }

    @Test
    public void shouldDontFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new VerticalLowerCheck(gameArea, 3, 1).check() == false);
    }

    @Test
    public void shouldDontFind1() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new VerticalLowerCheck(gameArea, 1, 1).check() == false);
    }

    @Test
    public void shouldDontFind2() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest2GameImage());
        assertTrue(new VerticalLowerCheck(gameArea, 3, 3).check() == false);
    }

    private GameImage getTest2GameImage() throws IOException, AWTException {
        return getTestGameImage("test2.png");
    }

    private GameImage getTest3GameImage() throws IOException, AWTException {
        return getTestGameImage("test3.png");
    }

}
