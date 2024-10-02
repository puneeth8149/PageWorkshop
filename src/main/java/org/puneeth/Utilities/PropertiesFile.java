package org.puneeth.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {

    public static Properties prop;
    private static String configPath = "C:\\Users\\punee\\AquaProjects\\TestAutomationFramework\\PropertiesFile\\InputData.properties";

    public static void propertiesFile() {
        try {
            prop = new Properties();
            FileInputStream file = new FileInputStream(configPath);
            prop.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
