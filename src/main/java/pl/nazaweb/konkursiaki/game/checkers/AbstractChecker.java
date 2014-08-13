package pl.nazaweb.konkursiaki.game.checkers;

import pl.nazaweb.konkursiaki.game.GamePuzzle;

/**
 *
 * @author naza
 */
public abstract class AbstractChecker implements Checker {

    protected final GamePuzzle[][] gameArea;
    protected final int x;
    protected final int y;

    public AbstractChecker(GamePuzzle[][] gameArea, int j, int i) {
        this.gameArea = gameArea;
        this.x = j;
        this.y = i;
    }
}
