package pl.nazaweb.konkursiaki.screen;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import javax.imageio.ImageIO;

/**
 *
 * @author Marek Kawczyński
 */
public class GameImage extends Thread {

    private final Robot robot;
    private BufferedImage image;

    public GameImage() throws AWTException {
        this.robot = new Robot();
    }

    public void capture(Rectangle captureSpace) {
        image = robot.createScreenCapture(captureSpace);
    }

    public BufferedImage getSubImage(Rectangle rect) {
        return image.getSubimage(rect.x, rect.y, rect.width, rect.height);
    }

    public String getHash() {
        return getHash(image);
    }

    public String getSumbImageHash(Rectangle rect) {
        return getHash(getSubImage(rect));
    }

    private String getHash(BufferedImage image) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", outputStream);
            byte[] data = outputStream.toByteArray();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data);
            byte[] hash = md.digest();
            return returnHex(hash);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private String returnHex(byte[] inBytes) throws Exception {
        String hexString = null;
        for (int i = 0; i < inBytes.length; i++) {
            hexString += Integer.toString((inBytes[i] & 0xff) + 0x100, 16).substring(1);
        }
        return hexString;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

}
