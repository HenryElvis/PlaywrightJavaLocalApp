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
import com.microsoft.playwright.options.AriaRole;

public class AppLocalTest 
{
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

    // ### UTILS ###

    void clickOnText(String _text)
    {
        page.getByText(_text).click();
    }

    // ### TESTS ###

    @Test
    void testTitle() {
        String title = page.title();
        assertThat(page).hasTitle(title);
    }

    @Test
    void headerVisible() {
        assertTrue(true);
    }

    @Test
    void clickOnForms()
    {
        clickOnText("Forms");
    }

    @Test
    void clickOnFormLayout()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");
    }

    @Test
    void testChildElement()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");
        page.locator("nb-card nb-radio :text-is('Option 2')").click();

        assertTrue(true);

        page.locator("nb-card").nth(3).getByRole(AriaRole.BUTTON).click();

        assertTrue(true);
    }

    @Test
    void testParentElement()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");

        Locator siblingTitle = page.locator("nb-card:has-text('Using the Grid')");

        siblingTitle.getByPlaceholder("Email").click();

        assertTrue(true);

        Locator anotherSiblingTitle = page.locator("nb-card").filter(new Locator.FilterOptions().setHasText("Basic form"));

        anotherSiblingTitle.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Password")).click();

        assertTrue(true);

        Locator statusDanger = page.locator("nb-card").filter(new Locator.FilterOptions().setHas(page.locator(".status-danger")));

        statusDanger.click();

        statusDanger.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Email")).click();

        assertTrue(true);

        Locator checkBoxLocator = page.locator("nb-card").filter(new Locator.FilterOptions().setHas(page.locator("nb-checkbox").filter(new Locator.FilterOptions().setHasText("Remember me")))).nth(1);

        checkBoxLocator.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Password")).click();

        assertTrue(true);
    }
}
