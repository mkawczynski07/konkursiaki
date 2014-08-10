package pl.nazaweb.konkursiaki;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import pl.nazaweb.konkursiaki.game.HorizontallForwardCheck;
import pl.nazaweb.konkursiaki.listeners.EscapeKeyListener;
import pl.nazaweb.konkursiaki.listeners.MouseListener;
import pl.nazaweb.konkursiaki.screen.GameImage;

/**
 *
 * @author naza
 */
public class Main {

    public final static Point MAIN_GAME_POS = new Point(311, 113);
    public final static Rectangle MAIN_GAME_RECT
            = new Rectangle(MAIN_GAME_POS.x, MAIN_GAME_POS.y, 642, 641);
    public final static int X_GAME_AREA_POSITION_ON_SCREEN = 310;
    public final static int Y_GAME_AREA_POSITION_ON_SCREEN = 312;

    public static void main(String[] args) throws NativeHookException, AWTException, InterruptedException {
        GlobalScreen.registerNativeHook();
        GlobalScreen.getInstance().addNativeKeyListener(new EscapeKeyListener());

        if ("_capture".equals(args[0])) {
            runMouseListener();
        }

        GameImage gameImage = new GameImage();
        gameImage.capture(MAIN_GAME_RECT);
        BufferedImage image = gameImage.getImage();

        saveImage(image, new File("/tmp/test.png"));

        Map<String, Integer> result = new HashMap();
        int counter = 0;
        GamePuzzle[][] gameArea = new GamePuzzle[6][6];

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int x = 33 + (j == 1 ? 0 : ((j - 1) * 108));
                int y = 33 + (i == 1 ? 0 : ((i - 1) * 108));
                Point position = new Point(x + X_GAME_AREA_POSITION_ON_SCREEN,
                        y + Y_GAME_AREA_POSITION_ON_SCREEN);

                Rectangle rectangle = new Rectangle(x, y, 40, 40);

                String hash = gameImage.getSumbImageHash(rectangle);
                saveImage(gameImage.getSubImage(rectangle), new File("/tmp/" + i + "_" + j + ".png"));

                if (result.containsKey(hash) == false) {
                    counter++;
                    result.put(hash, counter);
                }

                gameArea[j - 1][i - 1] = new GamePuzzle(position, result.get(hash), j - 1, i - 1);
                System.out.println(gameArea[j - 1][i - 1]);
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (new HorizontallForwardCheck(gameArea, j, i).check()) {
                    System.out.println("break on : [" + j + ", " + i + "].");
                    break;
                }
            }
        }

        saveImage(image, new File("/tmp/test.png"));

    }

    private static void saveImage(BufferedImage image, File file) {
        try (FileImageOutputStream outputStream = new FileImageOutputStream(file)) {
            ImageIO.write(image, "png", outputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void runMouseListener() throws NativeHookException {
        GlobalScreen.registerNativeHook();
        MouseListener example = new MouseListener();
        GlobalScreen.getInstance().addNativeMouseListener(example);
        GlobalScreen.getInstance().addNativeMouseMotionListener(example);
    }

}
