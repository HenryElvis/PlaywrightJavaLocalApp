package com.capgemini.tools;

import com.microsoft.playwright.Page;

public class BaseTools {

    public final Page page;

    public BaseTools(Page _page) 
    {
        this.page = _page;
    }

    public void clickOnText(String _text) {
        page.getByText(_text).click();
    }
}
