package pl.nazaweb.konkursiaki.listeners;

import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import pl.nazaweb.konkursiaki.Boot;

/**
 *
 * @author naza
 */
public class BootListener implements NativeKeyListener {

    private final Boot boot = new Boot();

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VK_A) {
            System.out.println("Boot ... ");
            try {
                boot.run();
            } catch (AWTException ex) {
                Logger.getLogger(BootListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(" ... Boot end.");
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    }

}
