package Lisnr.Project.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private Properties property;

    public void initProperty(String propFileName) {
        try {
            FileInputStream fis;
            this.property = new Properties();
            fis =
                    new FileInputStream(
                            System.getProperty("user.dir")
                                    + File.separator
                                    + ""
                                    + "src"
                                    + File.separator
                                    + "main"
                                    + File.separator
                                    + "resources"
                                    + File.separator
                                    + propFileName);
            property.load(fis);
        } catch (IOException e) {
            System.err.println("Error: properties file is absent");
        }
    }

    public String getPropValue(String propName) {
        return property.getProperty(propName);
    }
}
