package configuration;

/*
    A resource file with preparing configuration
 */

public class Configuration {

    private final static String URL = "https://www.saucedemo.com/";
    private final static String DRIVER_MAC_PATH = "/src/test/resources/drivers";
    private final static String DRIVER_WIN_PATH = "\\src\\test\\resources\\drivers";
    private final static int EXPLICIT_WAIT = 10;

    public static String getUrl() {
        return URL;
    }

    public static String getDriverMacPath() {
        return DRIVER_MAC_PATH;
    }

    public static String getDriverWinPath() {
        return DRIVER_WIN_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
}
