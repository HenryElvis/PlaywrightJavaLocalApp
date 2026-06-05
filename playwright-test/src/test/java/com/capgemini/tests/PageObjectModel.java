package com.capgemini.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.pages.NavigationPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageObjectModel {

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
        this.page.navigate("http://localhost:4200/pages/iot-dashboard");
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

    @Test
    void testFormLayout()
    {
        NavigationPage navPage = new NavigationPage(page);
        navPage.formLayoutPage();
    }
}
