package pl.nazaweb.konkursiaki.game.checkers.simulator;

import java.awt.Point;
import java.util.List;
import pl.nazaweb.konkursiaki.game.GamePuzzle;
import pl.nazaweb.konkursiaki.game.checkers.GameClick;

/**
 *
 * @author naza
 */
public class GameAreaSimulator {

    private List<GameClick> clicks;
    private GamePuzzle[][] gameArea;
    int emptyCounter = -1;
//zainicjalizowac game area dla kazdego przejscia po klikach na nowo

    public GameClick simulate(List<GameClick> clicks, GamePuzzle[][] area) {
        init(clicks, area);
        for (GameClick click : clicks) {
            initGameArea(area);
            for (Point puzzle : click.getPuzzles()) {
                movePuzzle(puzzle);
                //symulacja i zapis wynikow
            }

        }

        //wybranie najlepszego wyniku
        
        return null;
    }

    private void init(List<GameClick> clicks, GamePuzzle[][] area) {
        this.clicks = clicks;

    }

    private void movePuzzle(Point puzzle) {
        for (int x = puzzle.x; x < 6; x++) {
            if (x - 1 >= 0) {
                gameArea[x][puzzle.y] = gameArea[x - 1][puzzle.y];
            }
        }
        gameArea[0][puzzle.y] = new GamePuzzle(new Point(1, 1), emptyCounter, puzzle.x, puzzle.y);
        emptyCounter--;
    }

    private void initGameArea(GamePuzzle[][] area) {
        this.gameArea = new GamePuzzle[6][6];
        for (int i = 0; i < 6; i++) {
            System.arraycopy(area[i], 0, gameArea[i], 0, 6);
        }
    }

}
