package pl.nazaweb.konkursiaki.game.checkers;

import java.util.ArrayList;
import java.util.List;
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
    protected List<GameClick> clicks = new ArrayList();

    public AbstractChecker(GamePuzzle[][] gameArea, int j, int i) {
        this.gameArea = gameArea;
        this.x = j;
        this.y = i;
    }

    protected GameClick addClick(GamePuzzle first, GamePuzzle second) {
        GameClick gameClick = new GameClick(first, second);
        clicks.add(gameClick);
        return gameClick;
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

    public List<GameClick> getClicks() {
        return clicks;
    }

}
