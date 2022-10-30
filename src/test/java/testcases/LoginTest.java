package testcases;

import data.UserData;
import function.LoginFunction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void prepare() {
        loginFunction = new LoginFunction(common);
        userData = loginFunction.getUserList();
    }

    @Test()
    public void verifyLoginWithStandardUserAndLogoutSuccessfully() {
        loginFunction.login(userData[0].getUsername(),userData[0].getPassword());
        loginFunction.verifyUserLoginSuccessfully();
        homePageFunction.logout();
        loginFunction.verifyUserLogoutSuccessfully();
    }

    @Test()
    public void verifyLoginWithLockedOutUser() {
        loginFunction.login(userData[1].getUsername(),userData[1].getPassword());
        loginFunction.verifyUserUnableLoginWithLockedOutAccount();
    }

    @Test()
    public void verifyLoginWithProblemUserAndLogoutSuccessfully() {
        loginFunction.login(userData[2].getUsername(),userData[2].getPassword());
        loginFunction.verifyUserLoginSuccessfully();
        homePageFunction.logout();
        loginFunction.verifyUserLogoutSuccessfully();
    }

    @Test()
    public void verifyLoginWithPerformanceGlitchUserAndLogoutSuccessfully() {
        loginFunction.login(userData[3].getUsername(),userData[3].getPassword());
        loginFunction.verifyUserLoginSuccessfully();
        homePageFunction.logout();
        loginFunction.verifyUserLogoutSuccessfully();
    }

    @Test()
    public void verifyLoginWithInvalidUsername(){
        loginFunction.login(userData[4].getUsername(),userData[4].getPassword());
        loginFunction.verifyUserLoginWithInvalidUsernameAndPassword();
    }

    @Test()
    public void verifyLoginWithInvalidPassword(){
        loginFunction.login(userData[5].getUsername(),userData[5].getPassword());
        loginFunction.verifyUserLoginWithInvalidUsernameAndPassword();
    }

    @Test()
    public void verifyLoginWithEmptyUsername(){
        loginFunction.login(userData[6].getUsername(),userData[6].getPassword());
        loginFunction.verifyUserLoginWithEmptyUsernameAndPassword("Username");
    }

    @Test()
    public void verifyLoginWithEmptyPassword(){
        loginFunction.login(userData[7].getUsername(),userData[7].getPassword());
        loginFunction.verifyUserLoginWithEmptyUsernameAndPassword("Password");
    }
}
