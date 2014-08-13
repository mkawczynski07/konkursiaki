package pl.nazaweb.konkursiaki.game;

/**
 *
 * @author naza
 */
public class HorizontallBackwardCheck {

    private final GamePuzzle[][] gameArea;
    private final int x;
    private final int y;

    public HorizontallBackwardCheck(GamePuzzle[][] gameArea, int j, int i) {
        this.gameArea = gameArea;
        this.x = j;
        this.y = i;
    }

    public boolean check() {
        if (isNextExists() == false) {
            return false;
        }
        if (isNextEqualsCurrent() == false) {
            return false;
        }
        if (shouldSwitchPrevious()) {
            getPrevious(1).click();
            getPrevious(2).click();
            return true;
        }
        if (shouldSwitchUpper()) {
            getPrevious(1).click();
            getUpper().click();
            return true;
        }
        if (shuldSwitchLower()) {
            getPrevious(1).click();
            getLower().click();
        }
        return false;
    }

    private boolean isNextExists() {
        if (y + 1 >= 6) {
            return false;
        }
        return getNext() != null;
    }

    private boolean isNextEqualsCurrent() {
        return getNext().getType() == getCurrent().getType();
    }

    private GamePuzzle getNext() {
        return gameArea[x][y + 1];
    }

    private GamePuzzle getCurrent() {
        return gameArea[x][y];
    }

    private boolean shouldSwitchPrevious() {
        if (isPreviousExists(1) && isPreviousExists(2)) {
            return getPrevious(2).getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isPreviousExists(int i) {
        if (y - i < 0) {
            return false;
        }
        return getPrevious(i) != null;
    }

    private GamePuzzle getPrevious(int i) {
        return gameArea[x][y - i];
    }

    private boolean shouldSwitchUpper() {
        if (isPreviousExists(1) && isUpperExists()) {
            return getUpper().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperExists() {
        if (y - 1 >= 0 && x - 1 >= 0) {
            return getUpper() != null;
        }
        return false;
    }

    private GamePuzzle getUpper() {
        return gameArea[x - 1][y - 1];
    }

    private boolean shuldSwitchLower() {
        if (isPreviousExists(1) && isLowerExists()) {
            return getLower().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isLowerExists() {
        if (y - 1 >= 0 && x + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private GamePuzzle getLower() {
        return gameArea[x - 1][y + 1];
    }

}
