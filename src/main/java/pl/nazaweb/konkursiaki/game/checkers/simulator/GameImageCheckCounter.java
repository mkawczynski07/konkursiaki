package pl.nazaweb.konkursiaki.game.checkers.simulator;

import pl.nazaweb.konkursiaki.game.GamePuzzle;

/**
 *
 * @author naza
 */
public class GameImageCheckCounter {

    private final GamePuzzle[][] gameArea;

    public GameImageCheckCounter(GamePuzzle[][] gameArea) {
        this.gameArea = gameArea;
    }

    public int count() {
        int sum = 0;
        for (int x = 0; x < 6; x++) {
            sum += getHorizontalRowCheckSum(x);
        }
        for (int y = 0; y < 6; y++) {
            sum += getVerticalColumnCheckSum(y);
        }
        return sum;
    }

    private int getHorizontalRowCheckSum(int x) {
        int sum = 0;
        for (int y = 0; y < 6; y++) {
            if (isCellBeginOfHorizontalCheck(x, y)) {
                sum++;
                y += 3;
            }
        }
        return sum;
    }

    private int getVerticalColumnCheckSum(int y) {
        int sum = 0;
        for (int x = 0; x < 6; x++) {
            if (isCellBeginOfVerticalCheck(x, y)) {
                sum++;
                x += 3;
            }
        }
        return sum;
    }

    private boolean isCellBeginOfVerticalCheck(int x, int y) {
        if (isPuzzleExists(x, y) && isPuzzleExists(x + 1, y) && isPuzzleExists(x + 2, y)) {
            return gameArea[x][y].getType() == gameArea[x + 1][y].getType()
                    && gameArea[x][y].getType() == gameArea[x + 2][y].getType();
        }
        return false;
    }

    private boolean isCellBeginOfHorizontalCheck(int x, int y) {
        if (isPuzzleExists(x, y)
                && isPuzzleExists(x, y + 1)
                && isPuzzleExists(x, y + 2)) {
            if (gameArea[x][y].getType() == gameArea[x][y + 1].getType()
                    && gameArea[x][y + 2].getType() == gameArea[x][y].getType()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPuzzleExists(int x, int y) {
        if (x < 6 && x >= 0 && y < 6 && y >= 0) {
            return gameArea[x][y] != null;
        }
        return false;
    }

}
