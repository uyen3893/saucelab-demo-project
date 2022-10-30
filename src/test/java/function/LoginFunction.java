package function;

import data.UserData;
import org.testng.Assert;
import page.LoginPage;

import java.util.HashMap;

public class LoginFunction extends LoginPage {

    private Common common;

    public LoginFunction(Common common) {
        this.common = common;
    }

    public void login(String username, String password) {
        common.sendkey(usernameInputSel, username);
        common.sendkey(passwordInputSel, password);
        common.click(loginBtnSel);
    }

    public void verifyUserLoginSuccessfully() {
        Assert.assertTrue(common.isElementDisplayed(burgerMenuIconSel));
    }

    public void verifyUserUnableLoginWithLockedOutAccount(){
        String expectedError = "Epic sadface: Sorry, this user has been locked out.";
        String actualError = common.getText(errorMessageSel);
        Assert.assertEquals(actualError,expectedError);
    }

    public void verifyUserLoginWithInvalidUsernameAndPassword() {
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = common.getText(errorMessageSel);
        Assert.assertEquals(actualError,expectedError);
    }

    public void verifyUserLoginWithEmptyUsernameAndPassword(String emptyType) {
        String expectedError = "Epic sadface: " + emptyType + " is required";
        String actualError = common.getText(errorMessageSel);
        Assert.assertEquals(actualError,expectedError);
    }

    public void verifyUserLogoutSuccessfully() {
        Assert.assertTrue(common.isElementDisplayed(loginContainerSel), "[ERR] Cannot log out successfully!");
    }

    public UserData[] getUserList() {
        String fileLocation = "/src/test/java/data/UserList.json";
        return common.buildDataObjectFrom(fileLocation, UserData[].class);
    }



}
