package pl.nazaweb.konkursiaki.game;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pl.nazaweb.konkursiaki.GamePuzzle;
import static pl.nazaweb.konkursiaki.Main.X_GAME_AREA_POSITION_ON_SCREEN;
import static pl.nazaweb.konkursiaki.Main.Y_GAME_AREA_POSITION_ON_SCREEN;
import pl.nazaweb.konkursiaki.screen.GameImage;

/**
 *
 * @author naza
 */
public class HorizontallForwardCheckNGTest {

    @Test
    public void shouldCorrectFind() throws IOException, AWTException {

        BufferedImage image = ImageIO.read(new File(getFileAbsolutePath("test.png")));
        GameImage gameImage = new GameImage();
        gameImage.setImage(image);

        Map<String, Integer> result = new HashMap();
        int counter = 0;
        GamePuzzle[][] gameArea = new GamePuzzle[6][6];

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int x = 33 + (j == 1 ? 0 : ((j - 1) * 108));
                int y = 33 + (i == 1 ? 0 : ((i - 1) * 108));
                Point position = new Point(x + X_GAME_AREA_POSITION_ON_SCREEN,
                        y + Y_GAME_AREA_POSITION_ON_SCREEN);

                Rectangle rectangle = new Rectangle(x, y, 40, 40);

                String hash = gameImage.getSumbImageHash(rectangle);

                if (result.containsKey(hash) == false) {
                    counter++;
                    result.put(hash, counter);
                }

                gameArea[j - 1][i - 1] = new GamePuzzle(position, result.get(hash), j - 1, i - 1);
            }
        }

        assertTrue(new HorizontallForwardCheck(gameArea, 1, 1).check());

    }

    public String getFileAbsolutePath(String file) {
        return getBasePath()
                + getClassResourcePath(this.getClass())
                + File.separator
                + file;
    }

    private String getBasePath() {
        return System.getProperty("basedir", ".") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator;
    }

    public String getClassResourcePath(Class<?> clazz) {
        return clazz.getPackage().getName().replace(".", File.separator);
    }

}
