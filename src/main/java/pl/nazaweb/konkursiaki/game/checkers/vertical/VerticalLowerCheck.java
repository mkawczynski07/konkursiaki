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

    public VerticalLowerCheck(GamePuzzle[][] gameArea, int j, int i, boolean executeClick) {
        super(gameArea, j, i);
        this.executeClick = executeClick;
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
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
            if (isExecuteNotClick()) {
                return true;
            }
            getLower(1).click();
            getLower(2).click();
            return true;
        }
        if (shouldSwitchLowerLeft()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getLower(1).click();
            getLowerLeft().click();
            return true;
        }
        if (shouldSwitchLowerRight()) {
            if (isExecuteNotClick()) {
                return true;
            }
            getLower(1).click();
            getLowerRight().click();
            return true;
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

    private boolean shouldSwitchLower() {
        if (isLowerExists(2)) {
            return getLower(2).getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean shouldSwitchLowerLeft() {
        if (isLowerExists(1) && y - 1 > 0) {
            return getLowerLeft().getType() == getCurrent().getType();
        }
        return false;
    }

    private GamePuzzle getLowerLeft() {
        return gameArea[x + 1][y - 1];
    }

    private boolean shouldSwitchLowerRight() {
        if (isLowerExists(1) && y + 1 < 6) {
            return getLowerRight().getType() == getCurrent().getType();
        }
        return false;
    }

    private GamePuzzle getLowerRight() {
        return gameArea[x + 1][y + 1];
    }

}
