package pl.nazaweb.konkursiaki.callbacks;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 *
 * @author user
 */
public class MouseClick implements Callback {

    private final Point point;
    private final Robot robot;

    public MouseClick(Point point) throws AWTException {
        this.point = point;
        robot = new Robot();
    }

    @Override
    public void execute() {
        robot.mouseMove(point.x, point.y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
