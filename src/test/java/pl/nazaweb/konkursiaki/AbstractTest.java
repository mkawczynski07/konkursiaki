package pl.nazaweb.konkursiaki;

import java.io.File;

/**
 *
 * @author naza
 */
public abstract class AbstractTest {

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
