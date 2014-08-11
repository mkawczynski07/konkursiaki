package pl.nazaweb.konkursiaki.screen;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 *
 * @author naza
 */
public class Utils {

    public static void saveImage(BufferedImage image, File file) {
        try (FileImageOutputStream outputStream = new FileImageOutputStream(file)) {
            ImageIO.write(image, "png", outputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
