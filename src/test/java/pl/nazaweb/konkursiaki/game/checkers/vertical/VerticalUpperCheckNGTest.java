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
public class VerticalUpperCheckNGTest extends AbstractTest {

    @Test
    public void shouldFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new VerticalUpperCheck(gameArea, 3, 1).check());
    }

    @Test
    public void shouldDontFind() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTestGameImage());
        assertTrue(new VerticalUpperCheck(gameArea, 1, 1).check() == false);
    }

    private GameImage getTest2GameImage() throws IOException, AWTException {
        return getTestGameImage("test2.png");
    }

}
