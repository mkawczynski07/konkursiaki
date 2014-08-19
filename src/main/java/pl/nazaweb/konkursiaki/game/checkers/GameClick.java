package pl.nazaweb.konkursiaki.game.checkers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import pl.nazaweb.konkursiaki.game.GamePuzzle;

/**
 *
 * @author Marek Kawczyński (marekka@mikronika.com.pl)
 */
public class GameClick {

    private final GamePuzzle first;
    private final GamePuzzle second;
    protected List<Point> puzzles = new ArrayList();

    public GameClick(GamePuzzle first, GamePuzzle second) {
        this.first = first;
        this.second = second;
    }

    public void click() {
        first.click();
        second.click();
    }

    public GameClick addPuzzle(int a, int b) {
        puzzles.add(new Point(a, b));
        return this;
    }

    public List<Point> getPuzzles() {
        return puzzles;
    }

}
