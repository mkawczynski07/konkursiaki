package pl.nazaweb.konkursiaki.game;

/**
 *
 * @author naza
 */
public class HorizontallMiddleCheck {

    private final GamePuzzle[][] gameArea;
    private final int x;
    private final int y;

    public HorizontallMiddleCheck(GamePuzzle[][] gameArea, int j, int i) {
        this.gameArea = gameArea;
        this.x = j;
        this.y = i;
    }

    public boolean check() {
        if (isPreviousExists() == false) {
            return false;
        }
        if (isPreviousEqualsCurrent() == false) {
            return false;
        }
        if (isNextExists() == false) {
            return false;
        }
        if (isNextEqualsCurrent() == false) {
            return false;
        }

    }

    private boolean isPreviousExists() {
        if (y - 1 < 0) {
            return false;
        }
        return getPrevious() != null;
    }

    private boolean isPreviousEqualsCurrent() {
        return getPrevious().getType() == getCurrent().getType();
    }

    private GamePuzzle getPrevious() {
        return gameArea[x][y - 1];
    }

    private GamePuzzle getCurrent() {
        return gameArea[x][y];
    }

    private boolean isNextExists() {
        if (y + 1 >= 6) {
            return false;
        }
        return getNext() != null;
    }

    private GamePuzzle getNext() {
        return gameArea[x][y + 1];
    }

}
