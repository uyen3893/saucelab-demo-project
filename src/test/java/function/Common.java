package function;

/*
* A resource file with custom methods to replace the existing one due to effectively purpose.
*/

import com.google.gson.Gson;
import configuration.BrowserType;
import configuration.Configuration;
import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class Common {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver launchBrowser(BrowserType browserType) {
        switch (browserType) {
            case chrome:
                System.setProperty("webdriver.chrome.driver", getChromeDriver());
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case firefox:
                System.setProperty("webdriver.chrome.driver", getFirefoxDriver());
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(Configuration.getExplicitWait()));
        return driver;
    }

    private String getChromeDriver () {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if(OS.isFamilyMac()) {
            chromeDriverLocation = currentProjectLocation.concat(Configuration.getDriverMacPath()) + "/chromedriver";
        }

        if (OS.isFamilyWindows()) {
            chromeDriverLocation = currentProjectLocation.concat(Configuration.getDriverWinPath()) + "\\chromedriver.exe";
        }

        if (chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS type!");
        }

        return chromeDriverLocation;
    }

    private String getFirefoxDriver() {
        String currentProjectLocation = System.getProperty("user.dir");
        String firefoxDriverLocation = "";
        if(OS.isFamilyMac()) {
            firefoxDriverLocation = currentProjectLocation.concat(Configuration.getDriverMacPath()) + "/geckodriver";
        }

        if (OS.isFamilyWindows()) {
            firefoxDriverLocation = currentProjectLocation.concat(Configuration.getDriverWinPath()) + "\\geckodriver.exe";
        }

        if (firefoxDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS type!");
        }

        return firefoxDriverLocation;
    }

    public void maximumWindow() {
        driver.manage().window().maximize();
    }

    public void navigate(String url) {
        if (url == null) {
            throw new IllegalArgumentException("Can't detect the URL");
        } else {
            driver.get(url);
        }
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void waitForElementClickable(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            throw new RuntimeException("Cannot detect " + by + " in 15 seconds");
        }

    }

    public void waitForElementPresented(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new RuntimeException("Cannot detect " + by + " in 15 seconds");
        }
    }

    public void waitForElementDisappeared(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public boolean isElementDisplayed(By by) {
        waitForElementPresented(by);
        return findElement(by).isDisplayed();
    }

    public void click(By by) {
        waitForElementClickable(by);
        findElement(by).click();
    }

    public void click(WebElement element) {
        element.click();
    }


    public void sendkey(By by, String keyword) {
        findElement(by).clear();
        findElement(by).sendKeys(keyword);
    }

    public String getText(By by) {
        waitForElementClickable(by);
        return findElement(by).getText().trim();
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public <T> T buildDataObjectFrom(String fileLocation, Class<T> dataType) {
        T data;
        String currentProjectLocation = System.getProperty("user.dir");
        String absolutePath = currentProjectLocation + fileLocation;
        try(
                Reader jsonContentReader = Files.newBufferedReader(Paths.get(absolutePath));
        ) {
            Gson gson = new Gson();
            data = gson.fromJson(jsonContentReader, dataType);

        }catch (Exception e) {
            throw new RuntimeException("[ERR] Error while reading the file " + absolutePath);
        }
        return data;
    }

    public void scrollUpElement (WebElement element) {
        scrollToElement("false", element);
    }

    public void scrollDownElement (WebElement element) {
        scrollToElement("true", element);
    }

    private void scrollToElement(String position, WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(" + position + ");", element);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}
