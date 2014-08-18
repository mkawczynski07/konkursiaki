package pl.nazaweb.konkursiaki.game.checkers.horizontal;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 */
public class HorizontallForwardCheck extends AbstractChecker {

    public HorizontallForwardCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
        if (isPreviousExists() == false) {
            return false;
        }
        if (isPreviousEqualsCurrent() == false) {
            return false;
        }
        if (shouldSwitchNext()) {
            getNext(1).click();
            getNext(2).click();
            return true;
        }
        if (shouldSwitchUpper()) {
            getNext(1).click();
            getUpper().click();
            return true;
        }
        if (shouldSwitchLower()) {
            getNext(1).click();
            getLower().click();
            return true;
        }
        return false;
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

    private boolean shouldSwitchNext() {
        if (isNextExists(1) && isNextExists(2)) {
            return getNext(2).getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isNextExists(int interval) {
        if (y + interval >= 6) {
            return false;
        }
        return getNext(interval) != null;
    }

    private GamePuzzle getNext(int interval) {
        return gameArea[x][y + interval];
    }

    private boolean shouldSwitchUpper() {
        if (isUpperExists()) {
            return getUpper().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperExists() {
        if (x - 1 >= 0 && y + 1 < 6) {
            return getUpper() != null;
        }
        return false;
    }

    private GamePuzzle getUpper() {
        return gameArea[x - 1][y + 1];
    }

    private boolean shouldSwitchLower() {
        if (isLowerExists()) {
            return getLower().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isLowerExists() {
        if (x + 1 < 6 && y + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private GamePuzzle getLower() {
        return gameArea[x + 1][y + 1];
    }
}
