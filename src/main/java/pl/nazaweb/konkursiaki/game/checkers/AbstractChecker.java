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
    protected boolean executeClick = true;

    public AbstractChecker(GamePuzzle[][] gameArea, int j, int i) {
        this.gameArea = gameArea;
        this.x = j;
        this.y = i;
    }

    public boolean isExecuteClick() {
        return executeClick;
    }

    public boolean isExecuteNotClick() {
        return executeClick == false;
    }

    public void setExecuteClick(boolean executeClick) {
        this.executeClick = executeClick;
    }

}
