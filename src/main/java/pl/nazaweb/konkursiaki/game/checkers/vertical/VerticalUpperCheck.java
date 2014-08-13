package pl.nazaweb.konkursiaki.game.checkers.vertical;

import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 * 
 *            UPPER
 *           ________    
 *          |        |
 *  LEFT    |        |   RIGHT
 *          |        |
 *          |        |
 *           --------    
 *            LOWER
 */
public class VerticalUpperCheck extends AbstractChecker {

    public VerticalUpperCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    @Override
    public boolean check() {
        if (isLowerExists() == false) {
            return false;
        }
        if (isLowerEqualsCurrent() == false) {
            return false;
        }
        if (shoulSwitchUpperRight()) {
            getCurrent().click();
            getUpperRight().click();
            return true;
        }
        if (shouldSwitchUpperLeft()) {
            getCurrent().click();
            getUpperLeft().click();
            return true;
        }
        if (shouldSwitchUpper()) {
            getCuurent().click();
            getUpper().click();
            return true;
        }
        return false;
    }

}
