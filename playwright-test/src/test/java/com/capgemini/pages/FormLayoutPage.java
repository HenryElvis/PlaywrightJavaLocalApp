package com.capgemini.pages;

import com.capgemini.tools.BaseTools;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.CheckOptions;
import com.microsoft.playwright.options.AriaRole;

public class FormLayoutPage {

    private final Page page;

    Locator containerGridCard;

    public FormLayoutPage(Page _page) 
    {
        this.page = _page;

        containerGridCard = page.locator("nb-card").filter(new Locator.FilterOptions().setHasText("Using the Grid"));
    }

    public void fillingFormWithEmailAndPassword(String _email, String _password, String option)
    {
        containerGridCard.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Email")).fill(_email);

        containerGridCard.getByRole(AriaRole.TEXTBOX, new Locator.GetByRoleOptions().setName("Password")).fill(_password);

        containerGridCard.getByRole(AriaRole.RADIO, new Locator.GetByRoleOptions().setName(option)).check(new CheckOptions().setForce(true));
    }
}
