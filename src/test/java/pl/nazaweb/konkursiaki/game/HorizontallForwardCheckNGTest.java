package pl.nazaweb.konkursiaki.game;

import java.awt.AWTException;
import java.io.IOException;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.GamePuzzle;
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

}
