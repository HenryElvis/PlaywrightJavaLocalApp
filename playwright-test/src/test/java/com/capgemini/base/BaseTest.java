package com.capgemini.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {
    
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;

    @BeforeAll
    public static void setupBrowser()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    } 

    @BeforeEach
    public void launchBrowser()
    {
        this.page = browser.newPage();
        this.page.navigate("http://localhost:4200/pages/iot-dashboard");
    }

    @AfterAll
    public static void afterAll()
    {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }

    @AfterEach
    public void AfterEach()
    {
        this.page.close();
    }

    public Page getPage()
    {
        return page;
    }
}
