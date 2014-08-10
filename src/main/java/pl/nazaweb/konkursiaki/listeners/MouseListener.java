package pl.nazaweb.konkursiaki.listeners;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 *
 * @author Marek Kawczyński
 */
public class MouseListener implements NativeMouseInputListener {

    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        System.out.println("Mosue Clicked: " + e.getClickCount());
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {
        System.out.println("Mosue Pressed: " + e.getButton());
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {
        System.out.println("Mosue Released: " + e.getButton());
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent e) {
        System.out.println("Mosue Moved: " + e.getX() + ", " + e.getY());
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent e) {
        System.out.println("Mosue Dragged: " + e.getX() + ", " + e.getY());
    }
}
