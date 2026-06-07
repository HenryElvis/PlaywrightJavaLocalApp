package com.capgemini.tools;

import com.microsoft.playwright.Page;

import com.capgemini.pages.FormLayoutPage;
import com.capgemini.pages.NavigationPage;

public class PageManager {

    private final Page page;
    private final FormLayoutPage formLayoutPage;
    private final NavigationPage navPage;

    public PageManager(Page _page) 
    {
        this.page = _page;
        
        this.formLayoutPage = new FormLayoutPage(_page);
        this.navPage = new NavigationPage(_page);

    }

    public FormLayoutPage GetFormLayoutPage()
    {
        return formLayoutPage;
    }

    public NavigationPage GetNavPage()
    {
        return navPage;
    }
}
