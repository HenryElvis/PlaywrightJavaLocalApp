package com.capgemini.pages;

import com.capgemini.tools.BaseTools;
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
        tools.clickOnText("Forms");
        tools.clickOnText("Form Layout");
    }
}
