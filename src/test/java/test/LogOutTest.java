package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPage;

public class LogOutTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void tryToLogOut() {
        loginPage.logOut();
        Assertions.assertEquals("You are now logged out. Any automatic login has also been stopped.", loginPage.getLogOutMessageText());
    }

    @AfterEach
    public void exitWindow() {
        loginPage.quitDriver();
    }
}
