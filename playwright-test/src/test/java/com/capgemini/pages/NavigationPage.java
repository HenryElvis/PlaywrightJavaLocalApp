package com.capgemini.pages;

import com.capgemini.tools.BaseTools;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class NavigationPage {

    private final Page page;
    private final BaseTools tools;

    public NavigationPage(Page _page) 
    {
        page = _page;
        tools = new BaseTools(page);
    }

    public void formLayoutPage()
    {
        selectMenuItem("Forms");
        tools.clickOnText("Form Layout");
    }

    public void datepicker()
    {
        selectMenuItem("Forms");
        tools.clickOnText("Datepicker");
    }

    private void selectMenuItem(String _menuItem)
    {
        Locator item = page.getByTitle(_menuItem);

        if (item.getAttribute("aria-expanded").equals("false"))
            tools.clickOnText("Forms");
    }
}
