package pl.nazaweb.konkursiaki.screen;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import pl.nazaweb.konkursiaki.GamePuzzle;
import static pl.nazaweb.konkursiaki.game.Main.X_GAME_AREA_POSITION_ON_SCREEN;
import static pl.nazaweb.konkursiaki.game.Main.Y_GAME_AREA_POSITION_ON_SCREEN;

/**
 *
 * @author naza
 */
public class GameImageReader {

    private GameImage image;
    private Map<String, Integer> hashs;
    private GamePuzzle[][] gameArea;
    private int counter;

    public GamePuzzle[][] read(GameImage image) {
        init(image);
        for (int i = 1; i <= 6; i++) {
            readColumnsInRow(i);
        }

        return gameArea;
    }

    private void readColumnsInRow(int i) {
        for (int j = 1; j <= 6; j++) {
            int x = getRowColumnX(j);
            int y = getRowColumnY(i);

            Point position = getPuzzlePositionOnScreen(x, y);

            String puzzleHash = getPuzzleHash(x, y);

            incrementHashCounter(puzzleHash);

            gameArea[i - 1][j - 1] = new GamePuzzle(position, hashs.get(puzzleHash), i - 1, j - 1);
        }
    }

    private int getRowColumnX(int j) {
        return getRowColumnCoordinate(j);
    }

    private int getRowColumnY(int i) {
        return getRowColumnCoordinate(i);
    }

    private int getRowColumnCoordinate(int coordinate) {
        return 33 + (coordinate == 1 ? 0 : ((coordinate - 1) * 108));
    }

    private Point getPuzzlePositionOnScreen(int x, int y) {
        return new Point(x + X_GAME_AREA_POSITION_ON_SCREEN,
                y + Y_GAME_AREA_POSITION_ON_SCREEN);
    }

    private void init(GameImage image) {
        this.image = image;
        hashs = new HashMap();
        gameArea = new GamePuzzle[6][6];
        counter = -1;
    }

    private String getPuzzleHash(int x, int y) {
        Rectangle rectangle = new Rectangle(x, y, 40, 40);
        String hash = image.getSumbImageHash(rectangle);
        Utils.saveImage(image.getSubImage(rectangle), new File("/tmp/" + x + "_" + y + ".png"));
        return hash;
    }

    private void incrementHashCounter(String puzzleHash) {
        if (hashs.containsKey(puzzleHash) == false) {
            counter++;
            hashs.put(puzzleHash, counter);
        }
    }

}
