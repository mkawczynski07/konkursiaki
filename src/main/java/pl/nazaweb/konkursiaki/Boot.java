package pl.nazaweb.konkursiaki;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import static pl.nazaweb.konkursiaki.Main.MAIN_GAME_RECT;
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
import pl.nazaweb.konkursiaki.screen.Utils;

/**
 *
 * @author naza
 */
public class Boot {

    public void run() throws AWTException {
        GameImage gameImage = new GameImage();
        gameImage.capture(MAIN_GAME_RECT);
        BufferedImage image = gameImage.getImage();

        Utils.saveImage(image, new File("/tmp/test.png"));

        GamePuzzle[][] gameArea = new GameImageReader().read(gameImage);

        loopOverGameArea(gameArea);
    }

    protected void loopOverGameArea(GamePuzzle[][] gameArea) {
        for (int i = 5; i >= 0; i--) {
            if (new HorizontalFourCheck(gameArea, 0, i).check()) {
                return;
            }
            if (checkRow(i, gameArea)) {
                return;
            }
        }
    }

    protected boolean checkRow(int y, GamePuzzle[][] gameArea) {
        for (int j = 0; j < 6; j++) {
            System.out.println("[" + y + "][" + j + "]");
            if (new HorizontallForwardCheck(gameArea, y, j).check()) {
                return true;
            }
            if (new HorizontallBackwardCheck(gameArea, y, j).check()) {
                return true;
            }
            if (new HorizontallMiddleCheck(gameArea, y, j).check()) {
                return true;
            }
            if (new VerticalUpperCheck(gameArea, y, j).check()) {
                return true;
            }
            if (new VerticalLowerCheck(gameArea, y, j).check()) {
                return true;
            }
            if (new VerticalMiddleCheck(gameArea, y, j).check()) {
                return true;
            }
        }
        return false;
    }

}
