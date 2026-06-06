package com.capgemini.tests;

import org.junit.jupiter.api.Test;

import com.capgemini.base.BaseTest;
import com.capgemini.pages.FormLayoutPage;
import com.capgemini.pages.NavigationPage;

public class FormLayoutTest extends BaseTest {

    private NavigationPage navPage;

    @Test
    void testFillingForm()
    {
        FormLayoutPage formPage = new FormLayoutPage(getPage());

        navPage = new NavigationPage(getPage());
        navPage.navToformLayoutPage();

        formPage.fillingFormWithEmailAndPassword("test@test.com", "password13", "Option 1");
    }
}
