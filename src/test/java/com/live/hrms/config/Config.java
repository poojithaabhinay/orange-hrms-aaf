package com.live.hrms.config;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Config {

    public static Properties properties = null;

    static {
        properties = Config.init();
    }

    public static Properties init() {

        properties = new Properties();
        try {
            //File directory = new File (".");
            String rootFolderName = System.getProperty("user.dir");
            String configFilePath = rootFolderName + "/src/test/resources/config";
            FileInputStream fis = new FileInputStream(configFilePath + "/System.properties");
            properties.load(fis);
            fis.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return properties;

    }


}
