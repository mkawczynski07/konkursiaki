package pl.nazaweb.konkursiaki.game;

import pl.nazaweb.konkursiaki.GamePuzzle;

/**
 *
 * @author naza
 */
public class HorizontallForwardCheck {

    private final GamePuzzle[][] gameArea;
    private final int x;
    private final int y;

    public HorizontallForwardCheck(GamePuzzle[][] gameArea, int j, int i) {
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
        if (shouldSwitchNext()) {
            System.out.println("shouldSwitchNext");
            getNext(1).click();
            getNext(2).click();
            return true;
        }
        if (shouldSwitchUpper()) {
            System.out.println("shouldSwitchUpper");
            getNext(1).click();
            getUpper().click();
            return true;
        }
        if (shouldSwitchLower()) {
            System.out.println("");
            getNext(1).click();
            getLower().click();
            return true;
        }
        return false;
    }

    private boolean isPreviousExists() {
        if (x - 1 < 0) {
            return false;
        }
        return getPrevious() != null;
    }

    private boolean isPreviousEqualsCurrent() {
        return getPrevious().getType() == getCurrent().getType();
    }

    private GamePuzzle getPrevious() {
        return gameArea[x - 1][y];
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
        if (x + interval >= 6) {
            return false;
        }
        return getNext(interval) == null;
    }

    private GamePuzzle getNext(int interval) {
        return gameArea[x + interval][y];
    }

    private boolean shouldSwitchUpper() {
        if (isUpperExists()) {
            return getUpper().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isUpperExists() {
        if (y - 1 >= 0 && x + 1 < 6) {
            return getUpper() != null;
        }
        return false;
    }

    private GamePuzzle getUpper() {
        return gameArea[x + 1][y - 1];
    }

    private boolean shouldSwitchLower() {
        if (isLowerExists()) {
            return getLower().getType() == getCurrent().getType();
        }
        return false;
    }

    private boolean isLowerExists() {
        if (y + 1 < 6 && x + 1 < 6) {
            return getLower() != null;
        }
        return false;
    }

    private GamePuzzle getLower() {
        return gameArea[x + 1][y + 1];
    }
}
//przeszly mnie dreszcze. wiec  w domu bedzimy to robic? a co bedzie hardcoreowym akcentem?
/*
 żeby raz. Ja tam cał czas marze o nocy do upadłego 5, 8, 10 razy? Więcej? Może zacznijmy od 3
 hardcorowym ... co możemy nazwać hardcorem?
    
 */
