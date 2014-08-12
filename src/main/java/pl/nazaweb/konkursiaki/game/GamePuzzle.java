package pl.nazaweb.konkursiaki.game;

import java.awt.AWTException;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.nazaweb.konkursiaki.callbacks.MouseClick;

/**
 *
 * @author naza
 */
public class GamePuzzle {

    private final Point postitionOnArea;
    private final int type;
    private final int x;
    private final int y;

    public GamePuzzle(Point positionOnArea, int type, int x, int y) {
        this.postitionOnArea = positionOnArea;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void click() {
        try {
            new MouseClick(postitionOnArea).execute();
        } catch (AWTException ex) {
            Logger.getLogger(GamePuzzle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Point getPosition() {
        return postitionOnArea;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s] = %s", x, y, type);
    }

}
