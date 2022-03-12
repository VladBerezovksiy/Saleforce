package utils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class CapabilitiesGenerator {

    public static final String RESOURCE_PATH = "src/test/resources";
    public static final File RESOURCE_PATH_FILE = new File(RESOURCE_PATH);
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            String win_driver_path = PropertiesUtils.getEnv("win_driver_path");
            System.out.println("Operational System: " + os + "; Driver path: " + win_driver_path);
            System.setProperty("webdriver.chrome.driver", win_driver_path);
        } else if (os.contains("lin")) {
            String linux_driver_path = PropertiesUtils.getEnv("linux_driver_path");
            System.out.println("Operational System: " + os + "; Driver path: " + linux_driver_path);
            System.setProperty("webdriver.chrome.driver", linux_driver_path);
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", ABSOLUTE_RESOURCE_PATH);
        options.setExperimentalOption("prefs", chromePrefs);

        return options;
    }

}