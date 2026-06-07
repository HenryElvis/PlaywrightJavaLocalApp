package com.capgemini.tests;

import org.junit.jupiter.api.Test;

import com.capgemini.base.BaseTest;
import com.capgemini.pages.FormLayoutPage;
import com.capgemini.pages.NavigationPage;

public class FormLayoutTest extends BaseTest {

    private NavigationPage navPage;
    
    FormLayoutPage formPage;

    @Test
    void testFillingForm()
    {
        navPage = new NavigationPage(getPage());
        navPage.navToformLayoutPage();

        formPage = new FormLayoutPage(getPage());

        formPage.fillingFormWithEmailAndPassword("test@test.com", "password13", "Option 1");
    }

    @Test
    void testFillingInlineForm()
    {
        navPage = new NavigationPage(getPage());
        navPage.navToformLayoutPage();

        formPage = new FormLayoutPage(getPage());

        formPage.fillingInlineFormWithEmailAndPassword("Anakin Skywalker", "test@test.com", true);
    }
}
