package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import page.CreateIssueModalPage;
import page.HomePage;

public class CreateGeneralProjectIssueTest {

    CreateIssueModalPage createIssueModalPage = new CreateIssueModalPage();

    @Test
    public void createIssueGeneral() {
       createIssueModalPage.createIssueToProject();
    }


    @AfterEach
    public void exitWindow() {
        createIssueModalPage.quitDriver();
    }

}
