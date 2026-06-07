package com.capgemini.tests;

import org.junit.jupiter.api.Test;

import com.capgemini.base.BaseTest;
import com.capgemini.tools.PageManager;

public class FormLayoutTest extends BaseTest {

    @Test
    void testFillingForm()
    {
        PageManager pageManager = new PageManager(getPage());

        pageManager.GetNavPage().navToformLayoutPage();
        pageManager.GetFormLayoutPage().fillingFormWithEmailAndPassword("test@test.com", "password13", "Option 1");
    }

    @Test
    void testFillingInlineForm()
    {
        PageManager pageManager = new PageManager(getPage());

        pageManager.GetNavPage().navToformLayoutPage();
        pageManager.GetFormLayoutPage().fillingInlineFormWithEmailAndPassword("Anakin Skywalker", "test@test.com", true);
    }
}
