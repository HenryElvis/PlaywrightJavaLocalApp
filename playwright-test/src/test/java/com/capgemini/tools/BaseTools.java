
import com.microsoft.playwright.Page;

public class BaseTools {

    Page page;

    public BaseTools(Page _page) 
    {
        this.page = _page;
    }

    void clickOnText(String _text) {
        page.getByText(_text).click();
    }
}
