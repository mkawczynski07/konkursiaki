package pl.nazaweb.konkursiaki.game.checkers.vertical;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 *
 * UPPER LEFT RIGHT LOWER
 */
public class VerticalMiddleCheck extends AbstractChecker {

    public VerticalMiddleCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    public VerticalMiddleCheck(GamePuzzle[][] gameArea, int j, int i, boolean executeClick) {
        super(gameArea, j, i);
        this.executeClick = executeClick;
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
        if (isLowerExists() == false) {
            return false;
        }
        if (isUpperExists() == false) {
            return false;
        }
        if (isUpperEqualsLower() == false) {
            return false;
        }
        if (shouldSwitchLeft()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getCurrent().click();
            getLeft().click();
            return true;
        }
        if (shouldSwitchRight()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getCurrent().click();
            getRight().click();
            return true;
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

    private boolean isLowerExists() {
        if (x + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private GamePuzzle getLower() {
        return gameArea[x + 1][y];
    }

    private boolean isUpperEqualsLower() {
        return getUpper().getType() == getLower().getType();
    }

    private boolean shouldSwitchLeft() {
        if (isLeftExists()) {
            return getLeft().getType() == getUpper().getType();
        }
        return false;
    }

    private boolean isLeftExists() {
        if (y - 1 >= 0) {
            return getLeft() != null;
        }
        return false;
    }

    private GamePuzzle getLeft() {
        return gameArea[x][y - 1];
    }

    private GamePuzzle getCurrent() {
        return gameArea[x][y];
    }

    private boolean shouldSwitchRight() {
        if (isRightExists()) {
            return getRight().getType() == getUpper().getType();
        }
        return false;
    }

    private boolean isRightExists() {
        if (y + 1 < 6) {
            return getRight() != null;
        }
        return false;
    }

    private GamePuzzle getRight() {
        return gameArea[x][y + 1];
    }
}
