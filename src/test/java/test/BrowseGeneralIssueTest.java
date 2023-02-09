package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.issuePage;

public class BrowseGeneralIssueTest {
    page.issuePage issuePage = new issuePage();

    @Test
    public void BrowseExistingIssue() {
        issuePage.browseExistingIssue();
        Assertions.assertEquals("MTP-2363", issuePage.getIssueKeyValText());
    }

    @Test
    public void BrowseNonExistingIssue() {
        issuePage.browseNonExistingIssue();
        Assertions.assertEquals("You can't view this issue", issuePage.getIssueErrorMessageText());
    }

    @AfterEach
    public void exitWindow() {
        issuePage.quitDriver();
    }

}
