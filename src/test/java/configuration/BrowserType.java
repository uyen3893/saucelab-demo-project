package configuration;

/*
 * A enum file declare different browser types
 */
public enum BrowserType {

    chrome("chrome"),
    firefox("firefox");

    private String name;

    BrowserType(String name) {
    }

    public String getName() {
        return name;
    }
}
