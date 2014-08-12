package pl.nazaweb.konkursiaki;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import pl.nazaweb.konkursiaki.screen.GameImage;

/**
 *
 * @author naza
 */
public abstract class AbstractTest {

    protected GameImage getTestGameImage() throws IOException, AWTException {
        BufferedImage image = ImageIO.read(new File(getFileAbsolutePath("test.png")));
        GameImage gameImage = new GameImage();
        gameImage.setImage(image);
        return gameImage;
    }

    public String getFileAbsolutePath(String file) {
        return getBasePath()
                + getClassResourcePath(this.getClass())
                + File.separator
                + file;
    }

    private String getBasePath() {
        return System.getProperty("basedir", ".") + File.separator + "src" + File.separator + "test" + File.separator + "java" + File.separator;
    }

    public String getClassResourcePath(Class<?> clazz) {
        return clazz.getPackage().getName().replace(".", File.separator);
    }
}
