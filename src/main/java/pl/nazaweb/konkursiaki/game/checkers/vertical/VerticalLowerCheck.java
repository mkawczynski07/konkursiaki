package pl.nazaweb.konkursiaki.game.checkers.vertical;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 *
 * UPPER LEFT RIGHT LOWER
 */
public class VerticalLowerCheck extends AbstractChecker {

    public VerticalLowerCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    @Override
    public boolean check() {
        if (isUpperExists() == false) {
            return false;
        }
        if (isCurrentEqualsUpper() == false) {
            return false;
        }
        if (isLowerExists(1) == false) {
            return false;
        }
        if (shouldSwitchLower()) {
            getCurrent().click();
            getLower(2).click();
            return true;
        }
        if (shouldSwitchLowerLeft()) {
            getCurrent().click();
            getLowerLeft().click();
        }
        if (shouldSwitchLowerRight()) {
            getCurrent().click();
            getLowerRight().click();
        }
        return false;
    }

    private GamePuzzle getCurrent() {
        return gameArea[x][y];
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

    private boolean isCurrentEqualsUpper() {
        return getUpper().getType() == getCurrent().getType();
    }

    private boolean isLowerExists(int i) {
        if (x + i < 6) {
            return getLower(i) != null;
        }
        return false;
    }

    private GamePuzzle getLower(int i) {
        return gameArea[x + i][y];
    }

}
