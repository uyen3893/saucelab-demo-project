package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    protected static By usernameInputSel = By.cssSelector("#user-name");
    protected static By passwordInputSel = By.cssSelector("#password");
    protected static By loginBtnSel = By.cssSelector("#login-button");
    protected static By loginContainerSel = By.cssSelector("#login_button_container");
    protected static By errorMessageSel = By.cssSelector("h3[data-test='error']");
    protected static By errorBtnSel = By.cssSelector(".error-button");

}
