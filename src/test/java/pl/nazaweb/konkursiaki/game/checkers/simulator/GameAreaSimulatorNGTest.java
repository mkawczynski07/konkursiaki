package pl.nazaweb.konkursiaki.game.checkers.simulator;

import java.awt.AWTException;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.GameClick;
import pl.nazaweb.konkursiaki.screen.GameImage;
import pl.nazaweb.konkursiaki.screen.GameImageReader;

/**
 *
 * @author naza
 */
public class GameAreaSimulatorNGTest extends AbstractTest {

    @Test
    public void shouldPickClickWithMoreGameWinAfterClick() throws IOException, AWTException {
        GamePuzzle[][] gameArea = new GameImageReader().read(getTest9GameImage());
        GameAreaSimulator simulator = new GameAreaSimulator();
        GameClick click = simulator.simulate(getTest9GameImageClick(), gameArea);
        assertEquals(click.getFirst().getX(), 4);
        assertEquals(click.getFirst().getY(), 3);
        assertEquals(click.getSecond().getX(), 5);
        assertEquals(click.getSecond().getY(), 3);
    }

    private GameImage getTest9GameImage() throws IOException, AWTException {
        return getTestGameImage("test9.png");
    }

    private List<GameClick> getTest9GameImageClick() {
        List<GameClick> result = new ArrayList();
        result.add(new GameClick(
                new GamePuzzle(new Point(), -1, 2, 1),
                new GamePuzzle(new Point(), -1, 2, 0)));
        result.add(new GameClick(
                new GamePuzzle(new Point(), -1, 4, 3),
                new GamePuzzle(new Point(), -1, 3, 3)));
        result.add(new GameClick(
                new GamePuzzle(new Point(), -1, 4, 3),
                new GamePuzzle(new Point(), -1, 3, 3)));
        result.add(new GameClick(
                new GamePuzzle(new Point(), -1, 4, 0),
                new GamePuzzle(new Point(), -1, 5, 0)));
        result.add(new GameClick(
                new GamePuzzle(new Point(), -1, 4, 3),
                new GamePuzzle(new Point(), -1, 5, 3)));
        return result;
    }

}
