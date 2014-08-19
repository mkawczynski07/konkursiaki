package pl.nazaweb.konkursiaki.game.checkers.horizontal;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 */
public class HorizontallMiddleCheck extends AbstractChecker {

    public HorizontallMiddleCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    public HorizontallMiddleCheck(GamePuzzle[][] gameArea, int j, int i, boolean executeClick) {
        super(gameArea, j, i);
        this.executeClick = executeClick;
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
        if (isPreviousExists() == false) {
            return false;
        }
        if (isNextExists() == false) {
            return false;
        }
        if (isPreviousEqualsNext() == false) {
            return false;
        }
        if (shouldSwitchUpper()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getCurrent().click();
            getUpper().click();
            return true;
        }
        if (shouldSwitchLower()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getCurrent().click();
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

    private boolean isPreviousEqualsNext() {
        return getPrevious().getType() == getNext().getType();
    }

    private boolean shouldSwitchUpper() {
        if (isUpperExists()) {
            return getUpper().getType() == getNext().getType();
        }
        return false;
    }

    private boolean isUpperExists() {
        if (x - 1 >= 0) {
            return getUpper() != null;
        }
        return false;
    }

    private GamePuzzle getUpper() {
        return gameArea[x - 1][y];
    }

    private boolean shouldSwitchLower() {
        if (isLowerExists()) {
            return getLower().getType() == getNext().getType();
        }
        return false;
    }

    private boolean isLowerExists() {
        if (x + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private GamePuzzle getLower() {
        return gameArea[x + 1][y];
    }

}
