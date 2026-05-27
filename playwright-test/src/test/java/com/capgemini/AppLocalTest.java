package com.capgemini;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

public class AppLocalTest {

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
    void clickOnText(String _text) {
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
    void clickOnForms() {
        clickOnText("Forms");
    }

    @Test
    void clickOnFormLayout() {
        clickOnText("Forms");
        clickOnText("Form Layout");
    }

    @Test
    void testChildElement() {
        clickOnText("Forms");
        clickOnText("Form Layout");
        page.locator("nb-card nb-radio :text-is('Option 2')").click();

        assertTrue(true);

        page.locator("nb-card").nth(3).getByRole(AriaRole.BUTTON).click();

        assertTrue(true);
    }

    @Test
    void testParentElement() {
        clickOnText("Forms");
        clickOnText("Form Layout");

        Locator siblingTitle = page.locator("nb-card:has-text('Using the Grid')");

        siblingTitle.getByPlaceholder("Email").click();

        assertTrue(true);

        Locator anotherSiblingTitle = page.locator("nb-card")
                .filter(new Locator.FilterOptions().setHasText("Basic form"));

        anotherSiblingTitle.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Password")).click();

        assertTrue(true);

        Locator statusDanger = page.locator("nb-card")
                .filter(new Locator.FilterOptions().setHas(page.locator(".status-danger")));

        statusDanger.click();

        statusDanger.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Email")).click();

        assertTrue(true);

        Locator checkBoxLocator = page.locator("nb-card")
                .filter(new Locator.FilterOptions().setHas(
                        page.locator("nb-checkbox").filter(new Locator.FilterOptions().setHasText("Remember me"))))
                .nth(1);

        checkBoxLocator.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Password")).fill("Test");

        assertTrue(true);
    }

    @Test
    void extractingValue() {
        clickOnText("Forms");
        clickOnText("Form Layout");

        Locator elementLocator = page.locator("nb-card").filter(new Locator.FilterOptions().setHasText("Block form")).locator("button");

        assertTrue(elementLocator.textContent().equals("Submit"));

        List<String> allRadio = page.locator("nb-card").filter(new FilterOptions().setHasText("Using the Grid")).locator("nb-radio").allTextContents();

        assertTrue(!allRadio.contains("Option"));
    }

    @Test
    void inputText()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");

        Locator input = page.locator("nb-card").filter(new FilterOptions().setHasText("Using the Grid")).getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Email"));

        input.fill("test@test.com");

        assertTrue(true);
    }

    @Test
    void radioButton()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");

        Locator radios = page.locator("nb-card").filter(new FilterOptions().setHasText("Using the Grid")).getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName("Option 1"));

        radios.check();

        assertTrue(radios.isChecked());
    }

    @Test
    void checkboxes()
    {
        clickOnText("Modal & Overlays");
        clickOnText("Toastr");

        Locator checkbox = page.locator("nb-card").filter(new FilterOptions().setHasText("Toaster configuration")).getByRole(AriaRole.CHECKBOX, new Locator.GetByRoleOptions().setName("Hide on click"));

        checkbox.setChecked(false, new Locator.SetCheckedOptions().setForce(true));

        assertTrue(!checkbox.isChecked());
    }

    @Test
    void listAndDropdown()
    {
        Locator dropdown = page.locator("ngx-header nb-select");

        dropdown.click();

        Locator optionList = page.locator("nb-option-list nb-option");
        optionList.filter(new FilterOptions().setHasText("Cosmic")).click();

        assertTrue(true);
    }

    @Test
    void tooltip()
    {
        clickOnText("Modal & Overlays");
        clickOnText("Tooltip");

        page.locator("nb-card").filter(new FilterOptions().setHasText("Tooltip Placements")).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("TOP")).hover();

        assertTrue(true);
    }
}
