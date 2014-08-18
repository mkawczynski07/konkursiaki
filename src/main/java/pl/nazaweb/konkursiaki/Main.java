package pl.nazaweb.konkursiaki;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import pl.nazaweb.konkursiaki.listeners.BootListener;
import pl.nazaweb.konkursiaki.listeners.EscapeKeyListener;
import pl.nazaweb.konkursiaki.listeners.MouseListener;

/**
 *
 * @author naza
 */
public class Main {

    public final static Point MAIN_GAME_POS = new Point(311, 113);
    public final static Rectangle MAIN_GAME_RECT
            = new Rectangle(MAIN_GAME_POS.x, MAIN_GAME_POS.y, 642, 641);
    public final static int X_GAME_AREA_POSITION_ON_SCREEN = 311;
    public final static int Y_GAME_AREA_POSITION_ON_SCREEN = 112;

    public static void main(String[] args) throws NativeHookException, AWTException, InterruptedException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.getInstance().addNativeKeyListener(new EscapeKeyListener());

        if ("_capture".equals(args[0])) {
            runMouseListener();
        } else {
             GlobalScreen.getInstance().addNativeKeyListener(new BootListener());
        }

    }

    public static void runMouseListener() throws NativeHookException {
        GlobalScreen.registerNativeHook();
        MouseListener example = new MouseListener();
        GlobalScreen.getInstance().addNativeMouseListener(example);
        GlobalScreen.getInstance().addNativeMouseMotionListener(example);
    }

}
