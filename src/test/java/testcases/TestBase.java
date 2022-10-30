package testcases;

import configuration.BrowserType;
import configuration.Configuration;
import data.CheckoutData;
import data.UserData;
import function.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public Common common;
    public HomePageFunction homePageFunction;
    public CartFunction cartFunction;
    public CheckoutInformationFunction checkoutInformationFunction;
    public CheckoutData[] checkoutData;
    public LoginFunction loginFunction;
    public UserData[] userData;
    public CheckoutOverviewFunction checkoutOverviewFunction;
    public CheckoutCompleteFunction checkoutCompleteFunction;

    @BeforeMethod
    public void setup() {
        common = new Common();
        loginFunction = new LoginFunction(common);
        homePageFunction = new HomePageFunction(common);
        cartFunction = new CartFunction(common);
        checkoutInformationFunction = new CheckoutInformationFunction(common);
        checkoutOverviewFunction = new CheckoutOverviewFunction(common);
        checkoutCompleteFunction = new CheckoutCompleteFunction(common);

        common.launchBrowser(BrowserType.chrome);
        common.navigate(Configuration.getUrl());
        common.maximumWindow();
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        common.closeBrowser();
    }
}
