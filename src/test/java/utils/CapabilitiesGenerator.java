package utils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class CapabilitiesGenerator {

    public static final String RESOURCE_PATH = "src/test/resources/win/chromedriver.exe";
    public static final File RESOURCE_PATH_FILE = new File(RESOURCE_PATH);
    public static final String ABSOLUTE_RESOURCE_PATH = RESOURCE_PATH_FILE.getAbsolutePath();

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operational system: " + os + "; Driver path: " + RESOURCE_PATH);
        System.setProperty("webdriver.chrome.driver", PropertiesUtils.getEnv("driver_path"));
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