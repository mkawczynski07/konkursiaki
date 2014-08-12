package pl.nazaweb.konkursiaki.screen;

import java.awt.AWTException;
import java.io.IOException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.AbstractTest;
import pl.nazaweb.konkursiaki.GamePuzzle;

/**
 *
 * @author naza
 */
public class GameImageReaderNGTest extends AbstractTest {

    private final static int[][] GAME_IMAGE_TYPES = new int[6][6];

    static {
        GAME_IMAGE_TYPES[0][0] = 0;
        GAME_IMAGE_TYPES[0][1] = 1;
        GAME_IMAGE_TYPES[0][2] = 1;
        GAME_IMAGE_TYPES[0][3] = 2;
        GAME_IMAGE_TYPES[0][4] = 0;
        GAME_IMAGE_TYPES[0][5] = 1;

        GAME_IMAGE_TYPES[1][0] = 3;
        GAME_IMAGE_TYPES[1][1] = 3;
        GAME_IMAGE_TYPES[1][2] = 4;
        GAME_IMAGE_TYPES[1][3] = 3;
        GAME_IMAGE_TYPES[1][4] = 1;
        GAME_IMAGE_TYPES[1][5] = 0;

        GAME_IMAGE_TYPES[2][0] = 2;
        GAME_IMAGE_TYPES[2][1] = 0;
        GAME_IMAGE_TYPES[2][2] = 1;
        GAME_IMAGE_TYPES[2][3] = 5;
        GAME_IMAGE_TYPES[2][4] = 3;
        GAME_IMAGE_TYPES[2][5] = 5;

        GAME_IMAGE_TYPES[3][0] = 1;
        GAME_IMAGE_TYPES[3][1] = 3;
        GAME_IMAGE_TYPES[3][2] = 4;
        GAME_IMAGE_TYPES[3][3] = 3;
        GAME_IMAGE_TYPES[3][4] = 2;
        GAME_IMAGE_TYPES[3][5] = 4;

        GAME_IMAGE_TYPES[4][0] = 4;
        GAME_IMAGE_TYPES[4][1] = 3;
        GAME_IMAGE_TYPES[4][2] = 0;
        GAME_IMAGE_TYPES[4][3] = 0;
        GAME_IMAGE_TYPES[4][4] = 5;
        GAME_IMAGE_TYPES[4][5] = 3;

        GAME_IMAGE_TYPES[5][0] = 0;
        GAME_IMAGE_TYPES[5][1] = 5;
        GAME_IMAGE_TYPES[5][2] = 4;
        GAME_IMAGE_TYPES[5][3] = 2;
        GAME_IMAGE_TYPES[5][4] = 4;
        GAME_IMAGE_TYPES[5][5] = 2;
    }

    @Test
    public void shouldCorrectlyReadGameImageAndTranslateItToTypeTable() throws IOException, AWTException {
        GameImageReader reader = new GameImageReader();
        GamePuzzle[][] gameArea = reader.read(getTestGameImage());

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println(i + ", " + j + " : "
                        + gameArea[i][j].getType() + " = " + GAME_IMAGE_TYPES[i][j]);
                assertEquals(gameArea[i][j].getType(), GAME_IMAGE_TYPES[i][j]);
            }
        }
    }

}
