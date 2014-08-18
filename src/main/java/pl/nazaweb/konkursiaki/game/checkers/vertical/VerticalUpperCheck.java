package pl.nazaweb.konkursiaki.game.checkers.vertical;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 *
 * UPPER LEFT RIGHT LOWER
 */
public class VerticalUpperCheck extends AbstractChecker {

    public VerticalUpperCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
        if (isLowerExists() == false) {
            return false;
        }
        if (isLowerEqualsCurrent() == false) {
            return false;
        }
        if (isUpperExists() == false) {
            return false;
        }
        if (shoulSwitchUpperRight()) {
            getUpper(1).click();
            getUpperRight().click();
            return true;
        }
        if (shouldSwitchUpperLeft()) {
            getUpper(1).click();
            getUpperLeft().click();
            return true;
        }
        if (shouldSwitchUpper()) {
            getUpper(1).click();
            getUpper(2).click();
            return true;
        }
        return false;
    }

    private boolean isLowerExists() {
        if (x + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private boolean isLowerEqualsCurrent() {
        return getLower().getType() == getCurrent().getType();
    }

    private GamePuzzle getLower() {
        return gameArea[x + 1][y];
    }

    private GamePuzzle getCurrent() {
        return gameArea[x][y];
    }

    private boolean shoulSwitchUpperRight() {
        if (isUpperRightExists()) {
            return getUpperRight().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperExists() {
        return x - 1 >= 0;
    }

    private boolean isUpperRightExists() {
        if (isUpperExists() && y + 1 < 6) {
            return getUpperRight() != null;
        }
        return false;
    }

    private GamePuzzle getUpperRight() {
        return gameArea[x - 1][y + 1];
    }

    private boolean shouldSwitchUpperLeft() {
        if (isUpperLeftExists()) {
            return getUpperLeft().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperLeftExists() {
        if (isUpperExists() && y - 1 >= 0) {
            return getUpperLeft() != null;
        }
        return false;
    }

    private GamePuzzle getUpperLeft() {
        return gameArea[x - 1][y - 1];
    }

    private boolean shouldSwitchUpper() {
        if (isUpperNextExists()) {
            return getUpper(2).getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperNextExists() {
        if (x - 2 >= 0) {
            return getUpper(2) != null;
        }
        return false;
    }

    private GamePuzzle getUpper(int interval) {
        return gameArea[x - interval][y];
    }

}
