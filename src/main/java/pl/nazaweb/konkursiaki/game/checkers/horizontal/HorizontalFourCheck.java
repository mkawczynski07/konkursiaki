package pl.nazaweb.konkursiaki.game.checkers.horizontal;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.AbstractChecker;

/**
 *
 * @author naza
 */
public class HorizontalFourCheck extends AbstractChecker {

    public HorizontalFourCheck(GamePuzzle[][] gameArea, int j, int i) {
        super(gameArea, j, i);
    }

    @Override
    public boolean check() {
        System.out.println(this.getClass().getSimpleName());
        if (isMoreThenThreeTypesInRow() == false) {
            return false;
        }
        Point first = getFirstTwooEualsPuzzleNextTo();
        if (first == null) {
            return false;
        }
        if (shouldCheckBackward(first)) {
            if (shouldSwitchBackwardUpper(first)) {
                System.out.println("shouldCheckBackward.shouldSwitchBackwardUpper");
                gameArea[x][first.y - 1].click();
                gameArea[x - 1][first.y - 1].click();
                return true;
            }
            if (shouldSwitchBackwardLower(first)) {
                System.out.println("shouldCheckBackward.shouldSwitchBackwardLower");
                gameArea[x][first.y - 1].click();
                gameArea[x + 1][first.y - 1].click();
                return true;
            }
        }
        first = new Point(x, first.y + 1);
        if (shouldCheckForward(first)) {
            if (shouldSwitchForwardUpper(first)) {
                System.out.println("shouldCheckForward.shouldSwitchForwardUpper");
                gameArea[x][first.y + 1].click();
                gameArea[x - 1][first.y + 1].click();
                return true;
            }
            if (shouldSwitchForwardLower(first)) {
                System.out.println("shouldCheckForward.shouldSwitchForwardLower");
                gameArea[x][first.y + 1].click();
                gameArea[x + 1][first.y + 1].click();
                return true;
            }
        }

        return false;
    }

    private boolean isMoreThenThreeTypesInRow() {
        Map<Integer, Integer> typeCounter = new HashMap();
        for (int j = 0; j < 6; j++) {
            int type = gameArea[x][j].getType();
            if (typeCounter.containsKey(type) == false) {
                typeCounter.put(type, 0);
            }
            typeCounter.put(type, typeCounter.get(type) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : typeCounter.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        return max >= 3;
    }

    private Point getFirstTwooEualsPuzzleNextTo() {
        for (int j = 1; j < 6; j++) {
            if (gameArea[x][j - 1].getType() == gameArea[x][j].getType()) {
                return new Point(x, j - 1);
            }
        }
        return null;
    }

    private boolean shouldCheckBackward(Point first) {
        if (first.y - 2 >= 0) {
            return gameArea[x][first.y - 2].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

    private boolean shouldSwitchBackwardUpper(Point first) {
        if (first.x - 1 >= 0 && first.y - 1 >= 0) {
            return gameArea[x - 1][first.y - 1].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

    private boolean shouldSwitchBackwardLower(Point first) {
        if (first.x + 1 < 6 && first.y - 1 >= 0) {
            return gameArea[x + 1][first.y - 1].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

    private boolean shouldCheckForward(Point first) {
        if (first.y + 2 < 6) {
            return gameArea[x][first.y + 2].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

    private boolean shouldSwitchForwardUpper(Point first) {
        if (first.x - 1 >= 0 && first.y + 1 < 6) {
            return gameArea[x - 1][first.y + 1].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

    private boolean shouldSwitchForwardLower(Point first) {
        if (first.x + 1 < 6 && first.y + 1 >= 0) {
            return gameArea[x + 1][first.y + 1].getType() == gameArea[first.x][first.y].getType();
        }
        return false;
    }

}
