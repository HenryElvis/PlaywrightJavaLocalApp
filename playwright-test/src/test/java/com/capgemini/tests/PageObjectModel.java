package com.capgemini.tests;

import org.junit.jupiter.api.Test;

import com.capgemini.base.BaseTest;
import com.capgemini.pages.NavigationPage;

public class PageObjectModel extends BaseTest {

    private NavigationPage navPage;

    @Test
    void testFormLayout()
    {
        navPage = new NavigationPage(getPage());

        navPage.formLayoutPage();
    }
}
