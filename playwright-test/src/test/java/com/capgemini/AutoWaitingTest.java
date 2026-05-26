package com.capgemini;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AutoWaitingTest {
    
    private static Playwright playwright;
    private static Browser browser;
    private Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void createContextAndPage() {
        this.page = browser.newPage();
        this.page.navigate("http://uitestingplayground.com/ajax");
    }

    @AfterEach
    void closeContext() {
        this.page.close();
    }

    @AfterAll
    static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }

    // ## TESTS ##
    
    @Test
    void testAutoWait()
    {
        // Locator buttonAjaxElement = page.getByRole(AriaRole.BUTTON).filter(new FilterOptions().setHasText("Button Triggering AJAX Request"));

        Locator buttonAjaxElement = page.locator("#ajaxButton");

        buttonAjaxElement.click();

        Locator waitingElement = page.locator(".bg-success");

        waitingElement.waitFor();

        assertThat(waitingElement).isVisible();
        
        assertTrue(true);
    }
}
