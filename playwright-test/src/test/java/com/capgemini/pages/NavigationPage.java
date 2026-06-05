import com.microsoft.playwright.Page;

public class NavigationPage {

    private final Page page;

    public NavigationPage(Page _page) 
    {
        page = _page;
    }

    public void formLayoutPage()
    {
        clickOnText("Forms");
        clickOnText("Form Layout");
    }

    public void clickOnText(String text)
    {
        page.click("text=" + text);
    }
}
