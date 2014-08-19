package pl.nazaweb.konkursiaki;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontalFourCheck;
import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallBackwardCheck;
import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallForwardCheck;
import pl.nazaweb.konkursiaki.game.checkers.horizontal.HorizontallMiddleCheck;
import pl.nazaweb.konkursiaki.game.checkers.vertical.VerticalLowerCheck;
import pl.nazaweb.konkursiaki.game.checkers.vertical.VerticalMiddleCheck;
import pl.nazaweb.konkursiaki.game.checkers.vertical.VerticalUpperCheck;
import pl.nazaweb.konkursiaki.screen.GameImage;
import pl.nazaweb.konkursiaki.screen.GameImageReader;

/**
 *
 * @author naza
 */
public abstract class AbstractTest {

    protected GameImage getTestGameImage() throws IOException, AWTException {
        return getTestGameImage("test.png");
    }

    protected GameImage getTestGameImage(String imageFile) throws IOException, AWTException {
        BufferedImage image = ImageIO.read(new File(getFileAbsolutePath(imageFile)));
        GameImage gameImage = new GameImage();
        gameImage.setImage(image);
        testImageForException(gameImage);
        return gameImage;
    }

    protected String getFileAbsolutePath(String file) {
        return getBasePath()
                + getClassResourcePath(this.getClass())
                + File.separator
                + file;
    }

    protected String getBasePath() {
        return System.getProperty("basedir", ".") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator;
    }

    protected String getClassResourcePath(Class<?> clazz) {
        return clazz.getPackage().getName().replace(".", File.separator);
    }

    protected void loopOverGameArea(GamePuzzle[][] gameArea) {
        for (int i = 5; i >= 0; i--) {
            new HorizontalFourCheck(gameArea, 0, i, false).check();
            checkRow(i, gameArea);
        }
    }

    protected boolean checkRow(int i, GamePuzzle[][] gameArea) {
        for (int j = 0; j < 6; j++) {
            System.out.println("[" + i + "][" + j + "]");
            new HorizontallForwardCheck(gameArea, i, j, false).check();
            new HorizontallBackwardCheck(gameArea, i, j, false).check();
            new HorizontallMiddleCheck(gameArea, i, j, false).check();
            new VerticalUpperCheck(gameArea, i, j, false).check();
            new VerticalLowerCheck(gameArea, i, j, false).check();
            new VerticalMiddleCheck(gameArea, i, j, false).check();
        }
        return false;
    }

    private void testImageForException(GameImage image) {
        GamePuzzle[][] gameArea = new GameImageReader().read(image);
        loopOverGameArea(gameArea);
    }
}
