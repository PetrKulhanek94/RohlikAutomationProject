package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private static String userName;
    private static String password;
    private static String url;
    private static String urlRohlicek;

    private ConfigurationManager() {
        readConfigFile();
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }

        return instance;
    }

    private void readConfigFile() {
        var file = new File("src/test/java/resources/configuration.properties");
        var prop = new Properties();

        try {
            prop.load(new FileInputStream(file));
        } catch (IOException e) {
            System.out.println("Error in ConfigurationManager. Config file not found!");
        }

        userName = prop.getProperty("userName");
        password = prop.getProperty("password");
        url = prop.getProperty("url");
        urlRohlicek = prop.getProperty("urlRohlicek");
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return  url;
    }

    public String getUrlRohlicek() {
        return  urlRohlicek;
    }
}
